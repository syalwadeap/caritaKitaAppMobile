package com.example.caritakira.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Post {
    @SerializedName("idpost")
    private int idpost;
    @SerializedName("judul")
    private String judul;
    @SerializedName("idkategori")
    private int idkategori;
    @SerializedName("isipost")
    private String isipost;
    @SerializedName("file_gambar")
    private String file_gambar;
    @SerializedName("tgl_insert")
    private String tgl_insert;
    @SerializedName("tgl_update")
    private String tgl_update;
    @SerializedName("idpenulis")
    private int idpenulis;
    @SerializedName("tampilan")
    private int tampilan;
    @SerializedName("kategori")
    private Kategori kategori;
    @SerializedName("penulis")
    private Penulis penulis;

    public int getIdpost() {
        return idpost;
    }

    public String getJudul() {
        return judul;
    }

    public Penulis getPenulis() {
        return penulis;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public String getTgl_update() {
        return tgl_update;
    }

    public String getFile_gambar() {
        return file_gambar;
    }

    public String getIsipost() {
        return isipost;
    }
}
