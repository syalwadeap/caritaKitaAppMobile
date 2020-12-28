package com.example.caritakira.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class User {
    @SerializedName("id")
    private int id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;
    @SerializedName("email_verified_at")
    private String email_verified_at;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("updated_at")
    private String updated_at;

    public String getNama(){
        return this.nama;
    }
}
