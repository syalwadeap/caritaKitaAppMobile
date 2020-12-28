package com.example.caritakira.Model;

import com.google.gson.annotations.SerializedName;

public class Penulis {
    @SerializedName("idpenulis")
    private int idpenulis;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("kota")
    private String kota;
    @SerializedName("no_telp")
    private String no_telp;
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("user")
    private User user;

    public User getUser(){
        return this.user;
    }
}
