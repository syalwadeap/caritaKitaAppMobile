package com.example.caritakira.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailPost extends Post {
    @SerializedName("komentar")
    private List<Komentar> komentar;

    public List<Komentar> getKomentar() {
        return komentar;
    }
}
