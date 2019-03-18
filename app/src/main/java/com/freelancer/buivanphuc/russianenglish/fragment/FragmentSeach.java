package com.freelancer.buivanphuc.russianenglish.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.freelancer.buivanphuc.russianenglish.adapter.SearchAdapter;
import com.freelancer.buivanphuc.russianenglish.dao.WordsDAO;
import com.freelancer.buivanphuc.russianenglish.dto.WordsDTO;
import com.freelancer.buivanphuc.russianenglish.R;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class FragmentSeach extends Fragment {
    EditText edtInput;
    ListView lvSearch;
    WordsDAO mWordsDAO;
    SearchAdapter mSearchAdapter;
    ImageView imgSpeech;
    protected static final int RESULT_SPEECH = 111;
    String sChuoi = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_search, container, false);
        edtInput = view.findViewById(R.id.edtInput);
        lvSearch = view.findViewById(R.id.lvSearch);
        imgSpeech = view.findViewById(R.id.imgSpeech);
        mWordsDAO = new WordsDAO(getContext());
        edtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                search();
            }
        });

        edtInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtInput.setFocusableInTouchMode(true);
                return false;
            }
        });
        imgSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
                startActivityForResult(intent, RESULT_SPEECH);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_SPEECH:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> txt = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    sChuoi = txt.get(0);
                    edtInput.setText(sChuoi);
                }
        }
    }

    private void search() {
        lvSearch.setFocusable(false);
        String sKey = edtInput.getText().toString();
        if (!sKey.isEmpty()) {
            List<WordsDTO> wordsDTOList = mWordsDAO.search(sKey);
            mSearchAdapter = new SearchAdapter(getContext(), R.layout.item_search, wordsDTOList);
            lvSearch.setAdapter(mSearchAdapter);
            mSearchAdapter.notifyDataSetChanged();
        } else {
            mSearchAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        edtInput.clearFocus();
        edtInput.setFocusableInTouchMode(false);
        lvSearch.setFocusable(true);
    }
}
