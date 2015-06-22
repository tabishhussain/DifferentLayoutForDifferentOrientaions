package com.example.tabishhassan.differentlayoutfordifferentorientaions;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by tabishhassan on 6/18/15.
 */
public class Fragmentdetail extends Fragment {


    String str = "";
    static Fragmentdetail newinstance(String str){
        Fragmentdetail fr = new Fragmentdetail();
        fr.str = str;
        return fr;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_imagefragment, null);

        return  view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setimage(str);
    }

    public void setimage(String str)
    {
        ImageView imageView = (ImageView)getView().findViewById(R.id.imageView);
        if (str.equals("Tabish")) {
            imageView.setBackgroundResource(R.drawable.tabish);
        }
        else if (str.equals(""))
        {

        }
        else
        {
            imageView.setBackgroundResource(R.mipmap.ic_launcher);
        }
    }
}
