package com.freelancer.buivanphuc.russianenglish.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.freelancer.buivanphuc.russianenglish.dto.FavoretisDTO;
import com.freelancer.buivanphuc.russianenglish.database.createDatabase;

import java.util.ArrayList;
import java.util.List;

public class FavoretisDAO {

    SQLiteDatabase database;

    public FavoretisDAO(Context context) {
        createDatabase coppyDatabase = new createDatabase(context);
        database = coppyDatabase.open();
    }

    public boolean addFavoretis(FavoretisDTO favoretisDTO) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(createDatabase.TB_FAVORETIS_ID, favoretisDTO.getId());
        contentValues.put(createDatabase.TB_FAVORETIS_WORD, favoretisDTO.getWord());
        contentValues.put(createDatabase.TB_FAVORETIS_DEFINITION, favoretisDTO.getDefinition());

        long kiemtra = database.insert(createDatabase.TB_FAVORETIS, null, contentValues);
        if (kiemtra != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<FavoretisDTO> listFavo() {
        List<FavoretisDTO> favoretisDTOList = new ArrayList<>();
        String query = "select * from " + createDatabase.TB_FAVORETIS;
        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            FavoretisDTO favoretisDTO = new FavoretisDTO();
            favoretisDTO.setId(cursor.getInt(cursor.getColumnIndex(createDatabase.TB_FAVORETIS_ID)));
            favoretisDTO.setWord(cursor.getString(cursor.getColumnIndex(createDatabase.TB_FAVORETIS_WORD)));
            favoretisDTO.setDefinition(cursor.getString(cursor.getColumnIndex(createDatabase.TB_FAVORETIS_DEFINITION)));
            favoretisDTOList.add(favoretisDTO);
            cursor.moveToNext();
        }
        return favoretisDTOList;
    }
    public boolean DeleteFavo(int ID) {
        long kiemTra = database.delete(createDatabase.TB_FAVORETIS, createDatabase.TB_FAVORETIS_ID + " = " + ID, null);
        if (kiemTra != 0) {
            return true;
        } else {
            return false;
        }
    }
}
