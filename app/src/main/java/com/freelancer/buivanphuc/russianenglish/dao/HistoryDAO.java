package com.freelancer.buivanphuc.russianenglish.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.freelancer.buivanphuc.russianenglish.dto.HistoryDTO;
import com.freelancer.buivanphuc.russianenglish.database.createDatabase;

import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {
    SQLiteDatabase database;

    public HistoryDAO(Context context) {
        createDatabase coppyDatabase = new createDatabase(context);
        database = coppyDatabase.open();
    }

    public boolean addHistory(HistoryDTO historyDTO) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(createDatabase.TB_HISTORY_ID, historyDTO.getId());
        contentValues.put(createDatabase.TB_HISTORY_WORD, historyDTO.getWord());
        contentValues.put(createDatabase.TB_HISTORY_DEFINITION, historyDTO.getDefinition());

        long kiemTra = database.insert(createDatabase.TB_HISTORY, null, contentValues);
        if (kiemTra != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<HistoryDTO> listHistory() {
        List<HistoryDTO> historyDTOList = new ArrayList<>();
        String query = "select * from " + createDatabase.TB_HISTORY;
        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            HistoryDTO historyDTO = new HistoryDTO();
            historyDTO.setId(cursor.getInt(cursor.getColumnIndex(createDatabase.TB_HISTORY_ID)));
            historyDTO.setWord(cursor.getString(cursor.getColumnIndex(createDatabase.TB_HISTORY_WORD)));
            historyDTO.setDefinition(cursor.getString(cursor.getColumnIndex(createDatabase.TB_HISTORY_DEFINITION)));
            historyDTOList.add(historyDTO);
            cursor.moveToNext();
        }
        return historyDTOList;
    }

    public boolean DeleteHistory(int ID) {
        long kiemTra = database.delete(createDatabase.TB_HISTORY, createDatabase.TB_HISTORY_ID + " = " + ID, null);
        if (kiemTra != 0) {
            return true;
        } else {
            return false;
        }
    }
}
