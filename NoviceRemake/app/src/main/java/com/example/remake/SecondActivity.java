package com.example.remake;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
// 手动导入Intent包
import android.content.Intent;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 获取'启动这个Activity'的Intent 对象 (前面不是startActivity(Intent对象)了嘛，获取的就是这个)
        Intent intent=getIntent();
        /*使用intent对象的.getXXXExtra()方法来获得不同传递过来的参数
        * 如获取'字符串'键值对的值就用 getStringExtra("键名");
        * 如获取'整数'键值对的值就用 getIntExtra("键名")
        * */
        String incomingPara=intent.getStringExtra("A1_input_data");
        String modifiedText= incomingPara + ", welcome to activity 2!";
        // 现在去定位找到Activity2中的TextView控件

        TextView a2text=(TextView) findViewById(R.id.textview2);
        a2text.setText(modifiedText);
    }
}