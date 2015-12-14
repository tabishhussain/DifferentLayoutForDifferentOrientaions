package com.example.tabishhassan.parceableObj;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

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
                Fragmentdetail fr1 = new Fragmentdetail();
                Bundle extra = new Bundle();
                extra.putParcelable("product",(Product)extras.getParcelable("product"));
                fr1.setArguments(extra);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fram2, fr1);
                fragmentTransaction.commit();
            }
        }

    }
}
