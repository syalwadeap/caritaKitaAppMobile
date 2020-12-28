package com.example.caritakira;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caritakira.Adapter.KategoriAdapter;
import com.example.caritakira.Adapter.KomentarAdapter;
import com.example.caritakira.Adapter.PostAdapter;
import com.example.caritakira.Model.DetailPost;
import com.example.caritakira.Model.Post;
import com.example.caritakira.Rest.ApiClient;
import com.example.caritakira.Rest.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    public static DetailActivity da;
    private TextView mJudul;
    private TextView mPenulis;
    private TextView mIsi;
    private ImageView mImgArtikel;
    private String urlImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        int postId = getIntent().getIntExtra("EXTRA_POST_ID",1);
        mJudul = (TextView) findViewById(R.id.tvJudul);
        mImgArtikel = (ImageView) findViewById(R.id.tvImgArtrikel);
        mPenulis = (TextView) findViewById(R.id.tvPenulis);
        mIsi = (TextView) findViewById(R.id.tvIsi);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewKomentar);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        da=this;
        refresh(postId);
    }
    public void refresh(int postId) {
        Call<DetailPost> DetailPost = mApiInterface.getDetail(postId);
        DetailPost.enqueue(new Callback<DetailPost>() {
            @Override
            public void onResponse(Call<DetailPost> call, Response<DetailPost> response) {
                DetailPost Detail = response.body();
                Log.d("Retrofit Get", "berhasil komentar : " + Detail.getKomentar().size());
                mJudul.setText(Detail.getJudul());
                urlImg =  Detail.getFile_gambar();
                urlImg = urlImg.replaceAll("public\\/post\\/","http://caritakita.my.id/storage/post/");
                Picasso.with(DetailActivity.this).load(urlImg).into(mImgArtikel);
                mPenulis.setText(Detail.getPenulis().getUser().getNama());
                mIsi.setText(Detail.getIsipost());
                mAdapter = new KomentarAdapter(Detail.getKomentar());
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<DetailPost> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }

        });
    }
}