package com.example.appnhaconline.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Playlist implements Serializable {

    @SerializedName("IDplaylist")
    @Expose
    private String iDplaylist;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("hinhNen")
    @Expose
    private String hinhNen;
    @SerializedName("hinhIcon")
    @Expose
    private String hinhIcon;

    public String getIDplaylist() {
    return iDplaylist;
    }

    public void setIDplaylist(String iDplaylist) {
    this.iDplaylist = iDplaylist;
    }

    public String getTen() {
    return ten;
    }

    public void setTen(String ten) {
    this.ten = ten;
    }

    public String getHinhNen() {
    return hinhNen;
    }

    public void setHinhNen(String hinhNen) {
    this.hinhNen = hinhNen;
    }

    public String getHinhIcon() {
    return hinhIcon;
    }

    public void setHinhIcon(String hinhIcon) {
    this.hinhIcon = hinhIcon;
    }

}