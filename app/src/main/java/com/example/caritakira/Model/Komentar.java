package com.example.caritakira.Model;

import com.google.gson.annotations.SerializedName;

public class Komentar {
    @SerializedName("idkomentar")
    private int idkomentar;
    @SerializedName("idpost")
    private int idpost;
    @SerializedName("idpenulis")
    private int idpenulis;
    @SerializedName("isi")
    private String isi;
    @SerializedName("tgl_update")
    private String tgl_update;
    @SerializedName("penulis")
    private Penulis penulis;

    public Penulis getPenulis() {
        return penulis;
    }

    public String getIsi() {
        return isi;
    }

    public String getTgl_update() {
        return tgl_update;
    }
}
