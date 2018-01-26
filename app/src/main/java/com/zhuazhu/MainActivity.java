package com.zhuazhu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import conm.zhuazhu.common.utils.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            NetworkUtils.openWifiSettings();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
