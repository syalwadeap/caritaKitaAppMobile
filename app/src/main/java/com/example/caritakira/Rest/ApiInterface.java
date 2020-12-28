package com.example.caritakira.Rest;

import com.example.caritakira.Model.DetailPost;
import com.example.caritakira.Model.Kategori;
import com.example.caritakira.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("kategori")
    Call<List<Kategori>> getKategori();

    @GET("post")
    Call<List<Post>> getAllPost();

    @GET("post/{id}")
    Call<DetailPost> getDetail(@Path("id") int id);

    @GET("post/kategori/{id}")
    Call<List<Post>> getPostPerKategori(@Path("id") int id);

    @GET("cari?pencarian={search}")
    Call<List<Post>> getSearch(@Path("search") String search);
}
