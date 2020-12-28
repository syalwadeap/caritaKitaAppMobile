package com.example.caritakira.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caritakira.DetailActivity;
import com.example.caritakira.MainActivity;
import com.example.caritakira.Model.Kategori;
import com.example.caritakira.Model.Post;
import com.example.caritakira.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> implements Filterable {
    List<Post> mPostList;
    List<Post> mPostListFull;
    Context context;
    String urlImg;
    public PostAdapter(List<Post> postList,Context context) {
        this.context = context;
        this.mPostList = postList;
        mPostListFull = new ArrayList<>(postList);
    }

    @Override
    public PostAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list, parent, false);
        PostAdapter.MyViewHolder mViewHolder = new PostAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        urlImg =  mPostList.get(position).getFile_gambar();
        urlImg = urlImg.replaceAll("public\\/post\\/","http://caritakita.my.id/storage/post/");
        Picasso.with(context).load(urlImg).into(holder.mImageViewArtikel);
        holder.mTextViewJudul.setText(mPostList.get(position).getJudul());
        holder.mTextViewKategori.setText(mPostList.get(position).getKategori().getNama());
        holder.mTextViewPenulis.setText(mPostList.get(position).getPenulis().getUser().getNama());
        holder.mTextViewDate.setText(mPostList.get(position).getTgl_update());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), DetailActivity.class);
                mIntent.putExtra("EXTRA_POST_ID", mPostList.get(position).getIdpost());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mPostList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageViewArtikel;
        public TextView mTextViewJudul;
        public TextView mTextViewKategori;
        public TextView mTextViewPenulis;
        public TextView mTextViewDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImageViewArtikel = (ImageView) itemView.findViewById(R.id.artikelIcon);
            mTextViewJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            mTextViewKategori = (TextView) itemView.findViewById(R.id.tvKategori);
            mTextViewPenulis = (TextView) itemView.findViewById(R.id.tvPenulis);
            mTextViewDate = (TextView) itemView.findViewById(R.id.tvTanggal);
        }
    }
    @Override
    public Filter getFilter() {
        return postFilter;
    }

    private Filter postFilter = new Filter(){
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Post> filteredPost = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredPost.addAll(mPostListFull);
            }else{
                String filter = constraint.toString().toLowerCase().trim();

                for(Post post : mPostListFull){
                    if(post.getJudul().toLowerCase().contains(filter)){
                        filteredPost.add(post);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredPost;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                mPostList.clear();
                mPostList.addAll((List) results.values);
                notifyDataSetChanged();
        }
    };

}
