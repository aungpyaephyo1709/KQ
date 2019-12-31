package com.app.aungpyaephyo.ucs_patheinvoting;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Card> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, rno;
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            name =view.findViewById(R.id.tv_name);
            rno =  view.findViewById(R.id.tv_rno);
            img =  view.findViewById(R.id.img);
        }
    }


    public CardsAdapter(Context mContext, List<Card> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.selection_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Card card = albumList.get(position);
        holder.name.setText(card.getName());
        holder.rno.setText(card.getRno());

        // loading album cover using Glide library
        Glide.with(mContext).load(card.getThumbnail()).into(holder.img);


        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            cardToFragment(card.getName());

            }
        });
        holder.rno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardToFragment(card.getName());
            }
        });
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardToFragment(card.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
    public void cardToFragment(String name){
        Intent i=new Intent(mContext,DetailSelectionActivity.class);
        i.putExtra("name",name);
        mContext.startActivity(i);
    }



}
