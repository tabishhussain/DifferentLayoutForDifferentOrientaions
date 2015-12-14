package com.example.tabishhassan.parceableObj;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tabishhassan on 6/17/15.
 */
public class Recycleradapter extends RecyclerView.Adapter<Recycleradapter.mholder>{
    List<Product> record;
    LayoutInflater mInflater;
    Activity activity;
    Recycleradapter(List<Product> record, Activity act)
    {
        this.record = record;
        this.activity = act;
        mInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemCount() {
        return record.size();
    }

    @Override
    public mholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.list_items,parent, false);
        mholder mh = new mholder(v);
        return  mh;
    }
    @Override
    public void onBindViewHolder(mholder holder, int position) {
        holder.personName.setText(record.get(position).getProduct_name());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class mholder extends RecyclerView.ViewHolder{
        public TextView personName;
        mholder(View itemView) {
            super(itemView);
            personName = (TextView)itemView.findViewById(R.id.textView2);
        }
    }
}
