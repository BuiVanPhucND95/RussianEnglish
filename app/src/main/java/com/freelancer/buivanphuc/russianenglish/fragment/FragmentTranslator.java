package com.freelancer.buivanphuc.russianenglish.fragment;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.freelancer.buivanphuc.russianenglish.dao.WordsDAO;
import com.freelancer.buivanphuc.russianenglish.R;

import java.util.Locale;

public class FragmentTranslator extends Fragment implements View.OnClickListener {
    WordsDAO mWordsDAO;
    ImageView imgLeft, imgRight, imgDelete, imgListen, imgChange;
    TextView txtLeft, txtRight, txtDetail;
    EditText edtWord;
    boolean checkChange = true;
    TextToSpeech tts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_translator, container, false);
        mWordsDAO = new WordsDAO(getContext());
        imgLeft = view.findViewById(R.id.imgLeft);
        imgRight = view.findViewById(R.id.imgRight);
        imgChange = view.findViewById(R.id.imgchange);
        imgDelete = view.findViewById(R.id.imgDelete);
        imgListen = view.findViewById(R.id.imgListen);
        txtLeft = view.findViewById(R.id.txtLeft);
        txtRight = view.findViewById(R.id.txtRight);
        txtDetail = view.findViewById(R.id.txtDetail);
        edtWord = view.findViewById(R.id.edtWord);
        imgLeft.setBackgroundResource(R.drawable.ic_england);
        imgRight.setBackgroundResource(R.drawable.icon_russian);
        imgChange.setOnClickListener(this);
        imgDelete.setOnClickListener(this);
        imgListen.setOnClickListener(this);


        tts = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

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
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.imgDelete:
                edtWord.setText("");
                break;
            case R.id.imgchange:
                checkChange = !checkChange;
                if (checkChange) {
                    txtLeft.setText("English");
                    txtRight.setText("Russia");
                    imgLeft.setBackgroundResource(R.drawable.ic_england);
                    imgRight.setBackgroundResource(R.drawable.icon_russian);
                } else {
                    txtLeft.setText("Russia");
                    txtRight.setText("English");
                    imgRight.setBackgroundResource(R.drawable.ic_england);
                    imgLeft.setBackgroundResource(R.drawable.icon_russian);
                }
                break;
            case R.id.imgListen:
                tts.speak(edtWord.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                break;
        }
    }
}
