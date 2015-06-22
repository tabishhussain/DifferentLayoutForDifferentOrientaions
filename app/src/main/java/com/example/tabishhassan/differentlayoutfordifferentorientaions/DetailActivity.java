package com.example.tabishhassan.differentlayoutfordifferentorientaions;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by tabishhassan on 6/18/15.
 */
public class DetailActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        else
        {
            setContentView(R.layout.activity_detail);
            Bundle extras = getIntent().getExtras();
            if (extras!=null)
            {
                Fragmentdetail fr1 = Fragmentdetail.newinstance(extras.getString("name"));
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fram2, fr1);
                fragmentTransaction.commit();
            }
        }

    }
}
