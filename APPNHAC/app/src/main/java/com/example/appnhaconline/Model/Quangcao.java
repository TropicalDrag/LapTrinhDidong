package com.example.appnhaconline.Model;




import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Quangcao implements Serializable {
        @SerializedName("idquangcao")
        @Expose
        private String idquangcao;
        @SerializedName("hinhAnh")
        @Expose
        private String hinhAnh;
        @SerializedName("noiDung")
        @Expose
        private String noiDung;
        @SerializedName("idbaihat")
        @Expose
        private String idbaihat;
        @SerializedName("tenBaiHat")
        @Expose
        private String tenBaiHat;
        @SerializedName("hinhBaiHat")
        @Expose
        private String hinhBaiHat;

        public String getIdquangcao() {
                return idquangcao;
        }

        public void setIdquangcao(String idquangcao) {
                this.idquangcao = idquangcao;
        }

        public String getHinhAnh() {
                return hinhAnh;
        }

        public void setHinhAnh(String hinhAnh) {
                this.hinhAnh = hinhAnh;
        }

        public String getNoiDung() {
                return noiDung;
        }

        public void setNoiDung(String noiDung) {
                this.noiDung = noiDung;
        }

        public String getIdbaihat() {
                return idbaihat;
        }

        public void setIdbaihat(String idbaihat) {
                this.idbaihat = idbaihat;
        }

        public String getTenBaiHat() {
                return tenBaiHat;
        }

        public void setTenBaiHat(String tenBaiHat) {
                this.tenBaiHat = tenBaiHat;
        }

        public String getHinhBaiHat() {
                return hinhBaiHat;
        }

        public void setHinhBaiHat(String hinhBaiHat) {
                this.hinhBaiHat = hinhBaiHat;
        }

}