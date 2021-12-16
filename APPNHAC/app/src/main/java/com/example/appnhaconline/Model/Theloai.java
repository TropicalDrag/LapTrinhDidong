package com.example.appnhaconline.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Theloai implements Serializable{

    @SerializedName("IDtheloai")
    @Expose
    private String iDtheloai;
    @SerializedName("IDkeychude")
    @Expose
    private String iDkeychude;
    @SerializedName("Tentheloai")
    @Expose
    private String tentheloai;
    @SerializedName("Hinhtheloai")
    @Expose
    private String hinhtheloai;

    public String getIDtheloai() {
        return iDtheloai;
    }

    public void setIDtheloai(String iDtheloai) {
        this.iDtheloai = iDtheloai;
    }

    public String getIDkeychude() {
        return iDkeychude;
    }

    public void setIDkeychude(String iDkeychude) {
        this.iDkeychude = iDkeychude;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public String getHinhtheloai() {
        return hinhtheloai;
    }

    public void setHinhtheloai(String hinhtheloai) {
        this.hinhtheloai = hinhtheloai;
    }

}