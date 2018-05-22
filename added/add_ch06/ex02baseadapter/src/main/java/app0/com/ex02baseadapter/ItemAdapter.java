package app0.com.ex02baseadapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/5/22.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater inflater;

    Context context;

    ItemAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);


    }
    @Override
    public int getCount() {
        return 5;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_layout, null);
            final Button button = convertView.findViewById(R.id.button);
            button.setText("按键" + position);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context
                            , button.getText() + "被点击"
                            , Toast.LENGTH_SHORT).show();
                }
            });

        }

        return convertView;
    }
}
