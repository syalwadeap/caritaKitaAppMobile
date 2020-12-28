package com.example.caritakira.Model;

import com.google.gson.annotations.SerializedName;

public class Kategori {
    @SerializedName("idkategori")
    private int idkategori;
    @SerializedName("nama")
    private String nama;
    @SerializedName("post_count")
    private int post_count;

    public Kategori(){}

    public Kategori(int idkategori, String nama, int post_count){
        this.idkategori = idkategori;
        this.nama = nama;
        this.post_count = post_count;
    }

    public int getIdkategori(){
        return this.idkategori;
    }

    public String getNama(){
        return this.nama;
    }

    public int getPost_count(){
        return this.post_count;
    }

}
