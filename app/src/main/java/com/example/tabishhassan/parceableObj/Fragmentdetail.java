package com.example.tabishhassan.parceableObj;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tabishhassan on 6/18/15.
 */
public class Fragmentdetail extends Fragment {


    Product str;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_imagefragment, null);
        return  view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView p_id = (TextView) getView().findViewById(R.id.textView5);
        TextView p_name = (TextView) getView().findViewById(R.id.textView6);
        TextView p_prize = (TextView) getView().findViewById(R.id.textView8);
        TextView p_des = (TextView) getView().findViewById(R.id.textView10);
        str = (Product)getArguments().getParcelable("product");
        if (str != null) {
            p_id.setText(str.getProduct_id() + "");
            p_name.setText(str.getProduct_name());
            p_prize.setText(str.getProduct_prize() + "");
            p_des.setText(str.getDescricption());
        }
    }

}
