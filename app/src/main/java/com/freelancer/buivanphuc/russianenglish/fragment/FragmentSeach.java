package com.freelancer.buivanphuc.russianenglish.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.freelancer.buivanphuc.russianenglish.R;
import com.freelancer.buivanphuc.russianenglish.adapter.SearchAdapter;
import com.freelancer.buivanphuc.russianenglish.dao.WordsDAO;
import com.freelancer.buivanphuc.russianenglish.dto.WordsDTO;
import com.freelancer.buivanphuc.russianenglish.interfaces.OnClickItemWord;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class FragmentSeach extends Fragment implements View.OnClickListener , OnClickItemWord {
    EditText edtInput;
    RecyclerView lvSearch;
    WordsDAO mWordsDAO;
    SearchAdapter mSearchAdapter;
    ImageView imgSpeech, imgClear;
    protected static final int RESULT_SPEECH = 111;
    String sChuoi = "";
    List<WordsDTO> wordsDTOList;
    static String mBackData="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_search, container, false);
        edtInput = view.findViewById(R.id.edtInput);
        lvSearch = view.findViewById(R.id.lvSearch);
        imgSpeech = view.findViewById(R.id.imgSpeech);
        imgClear = view.findViewById(R.id.imgClear);
        mWordsDAO = new WordsDAO(getContext());
        imgClear.setVisibility(View.GONE);
        addEvents();
        imgClear.setOnClickListener(this);
        imgSpeech.setOnClickListener(this);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (sChuoi.isEmpty()) {
            edtInput.setFocusableInTouchMode(false);
        } else {
            edtInput.setFocusableInTouchMode(true);
            edtInput.setFocusable(true);
            edtInput.setText(sChuoi);
        }
        if(!mBackData.isEmpty())
        {
            edtInput.setText(mBackData);
        }
    }

    private void addEvents() {
        edtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    imgClear.setVisibility(View.VISIBLE);
                } else if (count == 0) {
                    imgClear.setVisibility(View.GONE);
                    wordsDTOList.clear();
                    updateListView();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                String sKey = edtInput.getText().toString();
                if (!sKey.isEmpty()) {
                    wordsDTOList = mWordsDAO.search(sKey);
                    updateListView();
                } else {
                    wordsDTOList.clear();
                    updateListView();
                }
                mBackData = edtInput.getText().toString();
            }
        });
        edtInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtInput.setFocusableInTouchMode(true);
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgClear:
                edtInput.setText("");
                break;
            case R.id.imgSpeech:
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
                startActivityForResult(intent, RESULT_SPEECH);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_SPEECH:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> txt = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    sChuoi = txt.get(0);
                }
        }
    }

    private void updateListView() {
        Log.d("KiemTra",wordsDTOList.size()+"");
        mSearchAdapter = new SearchAdapter(getContext(), R.layout.item_search, wordsDTOList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        lvSearch.setLayoutManager(layoutManager);
        lvSearch.setAdapter(mSearchAdapter);
        mSearchAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(WordsDTO word) {

    }
}
