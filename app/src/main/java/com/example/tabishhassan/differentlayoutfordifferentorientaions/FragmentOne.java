package com.example.tabishhassan.differentlayoutfordifferentorientaions;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tabishhassan on 6/16/15.
 */
public class FragmentOne extends ListFragment {

    private CustomAdapter adapter;
    public List<String> softhouse;
    private OnItemSelectedListener listener;;

    static FragmentOne newInstance(Activity context) {
        FragmentOne f = new FragmentOne();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        softhouse = new ArrayList<String>();
        softhouse.add("Tabish");
        softhouse.add("Ashas");
        softhouse.add("Zohaib");
        softhouse.add("Hammad");
        softhouse.add("Adeel");
        softhouse.add("Razi");
        softhouse.add("Muneeb");
        softhouse.add("Fawad");
        softhouse.add("Salman");
        softhouse.add("Faraz");
        adapter = new CustomAdapter(getActivity(), softhouse);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(adapter);
        getListView().setDividerHeight(0);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    update(softhouse.get(position));
            }
        });
    }

    public ListView getlist(){
        return getListView();
    }

    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);
    }

    public void setListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    public int rand(int low,int high) {
        Random r = new Random();
        int Low = low;
        int High = high;
        int R = r.nextInt(High - Low) + Low;
        return R;
    }

    public void update(String str)
    {
        listener.onRssItemSelected(str);
    }

    class CustomAdapter extends BaseAdapter {

        Activity activity;
        List<String> softwerehouses;
        LayoutInflater mInflater;

        public CustomAdapter(Activity activity, List<String> softwerehouses) {
            this.activity = activity;
            this.softwerehouses = softwerehouses;
            mInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return softwerehouses.size();
        }

        @Override
        public Object getItem(int location) {
            return softwerehouses.get(location);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            mytext_imagehandler holder = null;
            int type = getItemViewType(position);
            if (convertView == null) {
                holder = new mytext_imagehandler();
                convertView = mInflater.inflate(R.layout.list_items, null);
                holder.mtextview = (TextView) convertView.findViewById(R.id.textView);
                convertView.setTag(holder);
            } else {
                holder = (mytext_imagehandler) convertView.getTag();
            }
            holder.mtextview.setText(softwerehouses.get(position));
            return convertView;
        }
    }

    static class mytext_imagehandler {
        TextView mtextview;

    }
}
