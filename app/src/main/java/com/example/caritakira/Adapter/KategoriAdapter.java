package com.example.caritakira.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.caritakira.Model.Kategori;
import com.example.caritakira.PostKategoriActivity;
import com.example.caritakira.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.MyViewHolder> {

    List<Kategori> mKategoriList;

    public KategoriAdapter(List <Kategori> KategoriList) {
        this.mKategoriList = KategoriList;
    }

    public KategoriAdapter(View mView) {

    }

    @Override
    public KategoriAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_list, parent, false);
        KategoriAdapter.MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (KategoriAdapter.MyViewHolder holder, final int position){
        holder.mTextViewNama.setText(mKategoriList.get(position).getNama());
        holder.mTextViewPostCount.setText(mKategoriList.get(position).getPost_count() + " Artikel");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), PostKategoriActivity.class);
                mIntent.putExtra("Id", mKategoriList.get(position).getIdkategori());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mKategoriList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewPostCount;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewPostCount = (TextView) itemView.findViewById(R.id.tvCount);
        }
    }
}