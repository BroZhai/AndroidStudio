package com.example.retakecomponents;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        // 复习一下'新建Activity'，好久没动了QAQ...
        // 准备在这里实现一下'listView' + 'Adapter'的内容
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
    }

    public void jumpBack(View view){
        finish();
    }
}
