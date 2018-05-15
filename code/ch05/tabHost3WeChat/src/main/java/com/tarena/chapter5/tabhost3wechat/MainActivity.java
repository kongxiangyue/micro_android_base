package com.tarena.chapter5.tabhost3wechat;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends TabActivity{ 
    public static TabHost mTabHost; 
    public static TabHost getmTabHost() { 
        return mTabHost; 
    } 
   
    private RadioGroup main_radio; 
    private RadioButton tab_icon_weixin, tab_icon_address, tab_icon_find,tab_icon_myself; 
   
    /** Called when the activity is first created. */ 
    @Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
        mTabHost = getTabHost(); 
        final TabWidget tabWidget = mTabHost.getTabWidget(); 
        tabWidget.setStripEnabled(false);// Բ�Ǳ��߲����� 
        //���n��tabѡ����������ǵ�tab����ָʾ����Ŀ������Ӧ���� 
        mTabHost.addTab(mTabHost.newTabSpec("TAG1").setIndicator("0").setContent(new Intent(this, WeixinActivity.class))); 
        mTabHost.addTab(mTabHost.newTabSpec("TAG2").setIndicator("1").setContent(new Intent(this, AddressActivity.class))); 
        mTabHost.addTab(mTabHost.newTabSpec("TAG3").setIndicator("2").setContent(new Intent(this, FindActivity.class))); 
        mTabHost.addTab(mTabHost.newTabSpec("TAG4").setIndicator("3").setContent(new Intent(this, MyselfActivity.class))); 
        // �Ӿ���,�õ�ѡ��ť���TabWidget 
        main_radio = (RadioGroup) findViewById(R.id.main_radio); 
        tab_icon_weixin = (RadioButton) findViewById(R.id.tab_icon_weixin); 
        tab_icon_address = (RadioButton) findViewById(R.id.tab_icon_address); 
        tab_icon_find = (RadioButton) findViewById(R.id.tab_icon_find); 
        tab_icon_myself = (RadioButton) findViewById(R.id.tab_icon_myself); 
        main_radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { 
                    @Override 
                    public void onCheckedChanged(RadioGroup group, int id) { 
                        if (id == tab_icon_weixin.getId()) { 
                            mTabHost.setCurrentTab(0); 
                             
                           Drawable d =  getResources().getDrawable(R.drawable.a2);
                           
                           d.setBounds(0, 0, 120, 104);
                            tab_icon_weixin.setCompoundDrawables(null, d, null, null);
                        } else if (id == tab_icon_address.getId()) { 
                            mTabHost.setCurrentTab(1); 
                        } else if (id == tab_icon_find.getId()) { 
                            mTabHost.setCurrentTab(2); 
                        } else if (id == tab_icon_myself.getId()) { 
                            mTabHost.setCurrentTab(3); 
                        } 
                    } 
                }); 
   
        // ���õ�ǰ��ʾ��һ����ǩ 
        mTabHost.setCurrentTab(0); 
        // ����tabWidgetÿ����ǩ�����ñ���ͼƬ �� 
        for (int i = 0; i < tabWidget.getChildCount(); i++) { 
            View vv = tabWidget.getChildAt(i); 
            vv.getLayoutParams().height = 45; 
            // vv.getLayoutParams().width = 65; 
            vv.setBackgroundDrawable(null); 
        } 
//      findViewById(R.id.tab_icon_brand).setOnClickListener(this); 
    } 
}