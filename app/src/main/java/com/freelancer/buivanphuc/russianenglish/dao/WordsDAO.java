package com.freelancer.buivanphuc.russianenglish.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.freelancer.buivanphuc.russianenglish.dto.WordsDTO;
import com.freelancer.buivanphuc.russianenglish.database.CoppyDatabase;

import java.util.ArrayList;
import java.util.List;

public class WordsDAO {
    SQLiteDatabase database;

    public WordsDAO(Context context) {
        CoppyDatabase coppyDatabase = new CoppyDatabase(context);
        database = coppyDatabase.openDB();
    }

    public List<WordsDTO> search(String key) {
        List<WordsDTO> wordsDTOList = new ArrayList<>();
        String query = "select * from words where word like" + "'" + key + "%'";
        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            WordsDTO wordsDTO = new WordsDTO();
            wordsDTO.setDefinition(cursor.getString(cursor.getColumnIndex("definition")));
            wordsDTO.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            wordsDTO.setWord(cursor.getString(cursor.getColumnIndex("word")));

            wordsDTOList.add(wordsDTO);
            cursor.moveToNext();
        }
        return wordsDTOList;
    }

    public String translatorEngToRuss(String sWord) {
        String sDefinition = "";
        String query = "select * from words where word like" + "'" + sWord + "%'";
        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            sDefinition = cursor.getString(cursor.getColumnIndex("definition"));
            cursor.moveToNext();
        }
        return sDefinition;
    }

    public String translatorRussToEng(String sDefinition) {
        String sWord = "";
        String query = "select * from words where word like" + "'" + sDefinition + "%'";
        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            sWord = cursor.getString(cursor.getColumnIndex("word"));
            cursor.moveToNext();
        }
        return sWord;
    }

}
