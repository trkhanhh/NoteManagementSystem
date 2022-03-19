package com.example.notemanagementsystem_01.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notemanagementsystem_01.model.Catelogy;

import java.util.List;

@Dao
public interface CatelogyDAO {

    @Insert
    void insertCatelogy(Catelogy catelogy);

    @Query("SELECT * FROM catelogy")
    List<Catelogy> getListCatelogy();
}
