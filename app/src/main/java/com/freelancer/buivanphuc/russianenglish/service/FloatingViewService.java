package com.freelancer.buivanphuc.russianenglish.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.freelancer.buivanphuc.russianenglish.R;
import com.freelancer.buivanphuc.russianenglish.activity.MainActivity;
import com.freelancer.buivanphuc.russianenglish.dao.WordsDAO;

import java.util.Locale;

public class FloatingViewService extends Service implements View.OnClickListener {
    private WindowManager mWindowManager;
    private View mFloatingView;
    WordsDAO mWordsDAO;
    ImageView imgLeft, imgRight, imgDelete, imgListen, imgChange, img_close1, img_close2;
    TextView txtLeft, txtRight, txtDetail;
    EditText edtWord;
    boolean checkChange = true;
    LinearLayout expanded_container;
    RelativeLayout root_container;
    TextToSpeech tts;
    View collapsedView;
    View expandedView;
    Button btnHome;

    public FloatingViewService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Inflate the floating view layout we created
        mFloatingView = (View) LayoutInflater.from(this).inflate(R.layout.layout_floating_widget, null);
        //Add the view to the window.
        final WindowManager.LayoutParams params;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT
                    , WindowManager.LayoutParams.WRAP_CONTENT
                    , WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                    , WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                    PixelFormat.TRANSLUCENT);
        } else {
            params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT
                    , WindowManager.LayoutParams.WRAP_CONTENT
                    , WindowManager.LayoutParams.TYPE_PHONE
                    , WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                    PixelFormat.TRANSLUCENT);
        }
        //Specify the view position
        params.gravity = Gravity.TOP | Gravity.LEFT;        //Initially view will be added to top-left corner
        params.x = 0;
        params.y = 100;

        //Add the view to the window
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);
        collapsedView = mFloatingView.findViewById(R.id.collapse_view);
        expandedView = mFloatingView.findViewById(R.id.expanded_container);
        mWordsDAO = new WordsDAO(this);
        addControls();
        addEvents();


        //Set the close button
        ImageView closeButtonCollapsed = mFloatingView.findViewById(R.id.img_close1);
        closeButtonCollapsed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //close the service and remove the from from the window
                stopSelf();
            }
        });
        //Drag and move floating view using user's touch action.
        mFloatingView.findViewById(R.id.root_container).setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //remember the initial position.
                        initialX = params.x;
                        initialY = params.y;
                        //get the touch location
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int Xdiff = (int) (event.getRawX() - initialTouchX);
                        int Ydiff = (int) (event.getRawY() - initialTouchY);
                        if (Xdiff < 10 && Ydiff < 10) {
                            if (isViewCollapsed()) {
                                collapsedView.setVisibility(View.GONE);
                                expandedView.setVisibility(View.VISIBLE);
                                img_close2.setVisibility(View.VISIBLE);

                            }
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        //Calculate the X and Y coordinates of the view.
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);

                        //Update the layout with new X & Y coordinate
                        mWindowManager.updateViewLayout(mFloatingView, params);
                        return true;
                }
                return false;
            }
        });

    }

    private void addEvents() {
        imgChange.setOnClickListener(this);
        img_close2.setOnClickListener(this);
        imgDelete.setOnClickListener(this);
        imgListen.setOnClickListener(this);
        btnHome.setOnClickListener(this);
        edtWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String detail = edtWord.getText().toString();
                if (!detail.isEmpty()) {
                    if (checkChange) {
                        String res = mWordsDAO.translatorEngToRuss(detail);
                        txtDetail.setText(res);
                    } else {
                        String res = mWordsDAO.translatorRussToEng(detail);
                        txtDetail.setText(res);
                    }
                }
                if (detail.isEmpty()) {
                    txtDetail.setText("");
                }
            }
        });
    }

    private void addControls() {
        imgLeft = mFloatingView.findViewById(R.id.imgLeft);
        imgRight = mFloatingView.findViewById(R.id.imgRight);
        imgChange = mFloatingView.findViewById(R.id.imgchange);
        imgDelete = mFloatingView.findViewById(R.id.imgDelete);
        imgListen = mFloatingView.findViewById(R.id.imgListen);
        txtLeft = mFloatingView.findViewById(R.id.txtLeft);
        txtRight = mFloatingView.findViewById(R.id.txtRight);
        txtDetail = mFloatingView.findViewById(R.id.txtDetail);
        btnHome = mFloatingView.findViewById(R.id.btnHome);
        edtWord = mFloatingView.findViewById(R.id.edtWord);
        img_close1 = mFloatingView.findViewById(R.id.img_close1);
        img_close2 = mFloatingView.findViewById(R.id.img_close2);
        expanded_container = mFloatingView.findViewById(R.id.expanded_container);
        root_container = mFloatingView.findViewById(R.id.root_container);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });
    }

    private boolean isViewCollapsed() {
        return mFloatingView == null || (mFloatingView.findViewById(R.id.collapse_view).getVisibility() == View.VISIBLE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFloatingView != null) mWindowManager.removeView(mFloatingView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgchange:
                checkChange = !checkChange;
                if (checkChange) {
                    txtLeft.setText("English");
                    txtRight.setText("Russia");
                    imgLeft.setImageResource(R.drawable.ic_england);
                    imgRight.setImageResource(R.drawable.icon_russian);
                } else {
                    txtLeft.setText("Russia");
                    txtRight.setText("English");
                    imgRight.setImageResource(R.drawable.ic_england);
                    imgLeft.setImageResource(R.drawable.icon_russian);
                }
                break;
            case R.id.img_close2:
                collapsedView.setVisibility(View.VISIBLE);
                expandedView.setVisibility(View.GONE);
                img_close2.setVisibility(View.GONE);
                break;
            case R.id.imgDelete:
                edtWord.setText("");
                break;
            case R.id.btnHome:
//                Intent intent = new Intent(FloatingViewService.this, MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
                stopSelf();
                break;
            case R.id.imgListen:
                tts.speak(edtWord.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                break;

        }
    }
}
