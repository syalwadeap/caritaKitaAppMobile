package com.example.caritakira;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import com.example.caritakira.Adapter.KategoriAdapter;
import com.example.caritakira.Model.Kategori;
import com.example.caritakira.Rest.ApiClient;
import com.example.caritakira.Rest.ApiInterface;

import java.util.List;

public class KategoriActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static KategoriActivity ka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ka=this;
        refresh();
    }

    public void refresh() {
        Call<List<Kategori>> kontakCall = mApiInterface.getKategori();
        kontakCall.enqueue(new Callback<List<Kategori>>() {
            @Override
            public void onResponse(Call<List<Kategori>> call, Response<List<Kategori>> response) {
                List<Kategori> KategoriList = response.body();
                Log.d("Retrofit Get", "Jumlah data Kategori: " +
                        String.valueOf(KategoriList.size()));
                mAdapter = new KategoriAdapter(KategoriList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Kategori>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}