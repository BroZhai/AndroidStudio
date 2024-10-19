package com.example.retakecomponents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class firstActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.first_layout); // 这里是模版自动生成的"引用布局"，省得自己再去引用了
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 找到"按钮2"对象(第二个按钮的设置)
        Button btn2 = findViewById(R.id.btn2);

        // 为按钮2设置监听器
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(firstActivity.this,"btn2设置了setOnclickListener监听器" +
                        "，重写了里面的onClick方法哦",Toast.LENGTH_SHORT).show();
            }
        });

        // 为按钮3绑定"该Activity"实现的监听器的onClick方法
        findViewById(R.id.btn3).setOnClickListener(this);
        // 之后就对应下面在"该Activity"重写的onClick()方法

    }

    // 对应第一个按钮的onclick"直接响应"
    public void makeToast(View view) {
        Toast.makeText(this,"按钮1直接android:onclick被点击力",Toast.LENGTH_SHORT).show();
    }

    // 第三个按钮的监听，但这下我们直接套在了class上，implements View.OnClickListener
    //在下面重写onClick方法
    @Override
    public void onClick(View view) { // 这个适用于 "多个按钮"监听 的情况
        switch (view.getId()){
            case R.id.btn3:
                Toast.makeText(this,"按钮3为class设置了监听器(并绑定)" +
                        "，重写了onClick方法哦",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // 按钮的onclick就会触发下面的 jumpSec 方法
    public void jumpSec(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    // 再来一个"带参数"的跳转
    public void jumpSecWithPara(View view){
        //先去获取文字输入框的内容 (先找对象，后取内容)
        EditText input = findViewById(R.id.editMe);
        String inputdata = input.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("inputFromA1",inputdata);
        startActivity(intent);
    }


}