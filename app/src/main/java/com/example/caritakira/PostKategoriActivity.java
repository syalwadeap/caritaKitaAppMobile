package com.example.caritakira;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.caritakira.Adapter.PostAdapter;
import com.example.caritakira.Model.Post;
import com.example.caritakira.Rest.ApiClient;
import com.example.caritakira.Rest.ApiInterface;

import java.util.List;

public class PostKategoriActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private PostAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static PostKategoriActivity pk;
    private TextView kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_kategori);;
        int katId = getIntent().getIntExtra("Id",1);
        String namaKategori = getIntent().getStringExtra("nama");
        kategori = (TextView) findViewById(R.id.tvNamaKategori);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        pk=this;
        kategori.setText("Kategori "+namaKategori);
        refresh(katId);
    }

    public void refresh(int katId) {
        Call<List<Post>> kontakCall = mApiInterface.getPostPerKategori(katId);
        kontakCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> PostList = response.body();
                Log.d("Retrofit Get", "Jumlah data : " +
                        String.valueOf(PostList.size()));
                mAdapter = new PostAdapter(PostList,PostKategoriActivity.this);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }

        });
    }
}