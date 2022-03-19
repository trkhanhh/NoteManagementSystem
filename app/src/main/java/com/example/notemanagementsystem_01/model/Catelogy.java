package com.example.notemanagementsystem_01.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "catelogy")
public class Catelogy {
    @PrimaryKey(autoGenerate = true)
    private int idCtl;
    private String tenCtl;

    public Catelogy(String tenCtl) {
        this.tenCtl = tenCtl;
    }

    public int getIdCtl() {
        return idCtl;
    }

    public void setIdCtl(int idCtl) {
        this.idCtl = idCtl;
    }

    public String getTenCtl() {
        return tenCtl;
    }

    public void setTenCtl(String tenCtl) {
        this.tenCtl = tenCtl;
    }

}
