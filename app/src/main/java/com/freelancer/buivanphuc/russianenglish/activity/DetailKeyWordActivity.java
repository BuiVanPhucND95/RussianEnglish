package com.freelancer.buivanphuc.russianenglish.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.freelancer.buivanphuc.russianenglish.R;
import com.freelancer.buivanphuc.russianenglish.dao.HistoryDAO;
import com.freelancer.buivanphuc.russianenglish.dto.HistoryDTO;

import java.util.Locale;

public class DetailKeyWordActivity extends AppCompatActivity {
    private TextView txtKeyDetail, txtDetail;
    private Toolbar toolbar;
    private ImageView imgListen;
    private TextToSpeech tts;
    private String sKey;
    private String sDefinition;
    private int iID;
    private HistoryDAO mHistoryDAO;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtKeyDetail = findViewById(R.id.txtKeyDetail);
        txtDetail = findViewById(R.id.txtDetail);
        toolbar = findViewById(R.id.toolbar);
        imgListen = findViewById(R.id.imgListen);


        sKey = getIntent().getStringExtra("key");
        sDefinition = getIntent().getStringExtra("definition");
        iID = getIntent().getIntExtra("ID", 0);

        txtDetail.setText(sDefinition);
        txtKeyDetail.setText(sKey);
        toolbar.setTitle(sKey);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });
        imgListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(sKey, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        mHistoryDAO = new HistoryDAO(this);
        HistoryDTO mHistoryDTO = new HistoryDTO();
        mHistoryDTO.setId(iID);
        mHistoryDTO.setWord(sKey);
        mHistoryDTO.setDefinition(sDefinition);
        boolean kt = mHistoryDAO.addHistory(mHistoryDTO);
        if (kt) {
            Toast.makeText(this, "thêm thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "thất bại", Toast.LENGTH_SHORT).show();
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
