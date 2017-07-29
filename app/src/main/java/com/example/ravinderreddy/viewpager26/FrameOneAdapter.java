package com.example.ravinderreddy.viewpager26;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;

/**
 * Created by Ravinder Reddy on 29-07-2017.
 */

public class FrameOneAdapter extends BaseAdapter {
    private Context  context;
    private List<String> tempList;
    private LayoutInflater layoutInflater;

    public FrameOneAdapter(Context context, List<String> param) {
        this.context = context;
        this.tempList = param;
        this.layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return tempList.size();
    }

    @Override
    public Object getItem(int i) {
        return tempList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
       ViewHolder  viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.inflator_button, null);
           viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.addedButton.setText(tempList.get(i));
        viewHolder.addedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempList.remove(i);
                notifyDataSetChanged();
            }
        });

        return view;
    }
    protected class ViewHolder {
        private Button addedButton;

        public ViewHolder(View view) {
            addedButton = (Button) view.findViewById(R.id.added_button);
        }
    }
}
