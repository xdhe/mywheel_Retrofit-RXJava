package com.wheel.xiaodong.mywheel.retrofithelp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.wheel.xiaodong.mywheel.R;
import com.wheel.xiaodong.mywheel.databinding.ItmeListBinding;

import java.util.ArrayList;

/**
 * Created by xiaodong on 17/3/29.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {


    private final Context context;
    private TheatersMoive data;

    public UserAdapter(Context context, TheatersMoive user) {
        this.context = context;
        this.data = user;
        if (data.getSubjects() == null){
            this.data.setSubjects(new ArrayList<>());
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItmeListBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.itme_list, parent, false);
        MyViewHolder mMyViewHolder = new MyViewHolder(mBinding.getRoot());
        mMyViewHolder.setBinding(mBinding);
        return mMyViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.binding.tvMovieName.setText(data.getSubjects().get(position).getTitle());
        holder.binding.tvMovieDate.setText("上映日期:"+data.getSubjects().get(position).getYear());
        holder.binding.tvMovieScore.setText(data.getSubjects().get(position).getGenres().toString());
        Glide.with(context).load(data.getSubjects().get(position).getImages().getLarge()).placeholder(android.R.color.white).into(holder.binding.ivMovieIcon);

    }

    @Override
    public int getItemCount() {
        return data.getSubjects().size();
    }

    public void myNotifyDataSetChanged(TheatersMoive datas) {
        data = datas;
        if (data.getSubjects() == null){
            this.data.setSubjects(new ArrayList<>());
        }
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItmeListBinding binding;

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        public void setBinding(ItmeListBinding binding) {
            this.binding = binding;
        }
    }
}
