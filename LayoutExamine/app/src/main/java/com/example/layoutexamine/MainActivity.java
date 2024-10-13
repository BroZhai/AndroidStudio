package com.example.layoutexamine;

import android.app.Activity;
import android.os.Bundle;

// Activity 里面的 name 就指向了这里的 MainActivity.class 作为处理逻辑
// 我们就在对应的java目录下新建这个类
// 这里的活动类要extends以下两个class之一

// Activity: 不兼容旧安卓系统
// AppCompactActivity: 兼容旧安卓系统

public class MainActivity extends Activity {
    // 按照惯例，首先重写onCreate方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 调用父类的onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout); // 设置"当前活动"布局文件
    }
}
