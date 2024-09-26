package comp4342.android.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HelloAndroid extends AppCompatActivity {
//这里的HelloAndroid即为manifest中 Activity绑定的类名
    //  AppCompatActivity 是 Activity 的子类 Activity是一个基类)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 这里的setContentView()方法为当前活动"引用了布局"
    }
}