package com.example.caritakira.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.caritakira.DetailActivity;
import com.example.caritakira.Model.Komentar;
import com.example.caritakira.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class KomentarAdapter extends RecyclerView.Adapter<KomentarAdapter.MyViewHolder>{
    List<Komentar> mKomentar;

    public KomentarAdapter(List<Komentar> komentar) {
        this.mKomentar = komentar;
    }

    @Override
    public KomentarAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.komentar_list, parent, false);
        KomentarAdapter.MyViewHolder mViewHolder = new KomentarAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(KomentarAdapter.MyViewHolder holder, final int position) {
        holder.mTextViewNama.setText(mKomentar.get(position).getPenulis().getUser().getNama());
        holder.mTextViewKomentar.setText(mKomentar.get(position).getIsi());
    }

    @Override
    public int getItemCount () {
        return mKomentar.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewNama, mTextViewKomentar;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNamaPenulis);
            mTextViewKomentar = (TextView) itemView.findViewById(R.id.tvIsiKomentar);
        }
    }
}
