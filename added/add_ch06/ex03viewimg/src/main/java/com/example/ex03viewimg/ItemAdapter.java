package com.example.ex03viewimg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/5/22.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context        context;
    int[]          resId;


    ItemAdapter(Context context, int[] resId) {
        this.context = context;
        inflater     = LayoutInflater.from(context);
        this.resId   = resId;


    }
    @Override
    public int getCount() {
        return resId.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_layout, null);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            imageView.setImageResource(resId[position]);


            final Button button = convertView.findViewById(R.id.button);
            button.setText("按键" + position);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context
                            , SecondActivity.class);

                    intent.putExtra("img", resId[position]);
                    context.startActivity(intent);

                }
            });

        }

        return convertView;
    }
}
