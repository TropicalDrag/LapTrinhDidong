package com.example.appnhaconline.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Chude implements Serializable {

        @SerializedName("IDchude")
        @Expose
        private String iDchude;
        @SerializedName("Tenchude")
        @Expose
        private String tenchude;
        @SerializedName("Hinhchude")
        @Expose
        private String hinhchude;

        public String getIDchude() {
            return iDchude;
        }

        public void setIDchude(String iDchude) {
            this.iDchude = iDchude;
        }

        public String getTenchude() {
            return tenchude;
        }

        public void setTenchude(String tenchude) {
            this.tenchude = tenchude;
        }

        public String getHinhchude() {
            return hinhchude;
        }

        public void setHinhchude(String hinhchude) {
            this.hinhchude = hinhchude;
        }

}