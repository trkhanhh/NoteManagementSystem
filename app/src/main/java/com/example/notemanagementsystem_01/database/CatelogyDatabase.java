package com.example.notemanagementsystem_01.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.notemanagementsystem_01.model.Catelogy;

@Database(entities = {Catelogy.class}, version = 1)
public abstract class CatelogyDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "catelogy.db";
    private static CatelogyDatabase instance;

    public static synchronized CatelogyDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),CatelogyDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract CatelogyDAO catelogyDAO();
}
