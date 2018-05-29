package app0.com.ex02baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


// *步骤-1.在xml上添加一个listview
// *步骤-2.在loyout目录上新建一个[xml,具有button、textview]
// *步骤-3.新建一个继承于BaseAdapter类的ItemAdapter类
// *步骤-4.overide ItemAdapter的getCount、getItem、getItemId、getView及构造函数
// *步骤-5.getCount设定列表项的个数 5
// *步骤-6.getItem、getItemId用默认代码就好
// *步骤-7.[xml,具有button、textview]--LayoutInflater-->view getView
// --设置好监听器
// *步骤-绑定UI ListView
// *步骤-setAdapter

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ItemAdapter(MainActivity.this));

    }

}
