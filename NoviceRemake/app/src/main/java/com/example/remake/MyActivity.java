package com.example.remake;

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

public class MyActivity extends AppCompatActivity {

    private EditText iText; // 声明一个EditText对象，准备用于接收<ExitText>控件的内容
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);

        Button mybtn1=(Button)findViewById(R.id.mybtn1);
        mybtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyActivity.this,"按钮被点击啦！",Toast.LENGTH_SHORT).show();
            }
        });

        // 下面是那个"submit"的按钮
        Button submitBtn=(Button) findViewById(R.id.submitText);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 通过id找到对应的EditText控件，并存储到本地的EditText 对象iText中
                iText=(EditText)findViewById(R.id.inputText);
                // iText对象里面存的东西，我们还需要.getText().toString()之后才能转成Java里面的String
                String textContent=iText.getText().toString();

                // 最后在Toast中悬浮展示
                Toast.makeText(MyActivity.this,"Hello "+textContent +"!",Toast.LENGTH_LONG).show();

                // 接下来，我们追加一个新Activity(页面)，一个新"Intent"实现 从MyActvity跳转到SecondActivity
                // 并尝试将输入框的值当成参数传递过去，并在那边对应的TextView控件中渲染

                //  这里实现了一种'明显的跳转'
                // Intent(当前class.this, 要跳转到的'新页面'.class)
                Intent intobj=new Intent(MyActivity.this, SecondActivity.class);
                // 使用Intent对象的putExtra()给另一个Activity传递参数
                // "()"里面放 '键，值'对，到时候在另一个Activity里面就考这个'键名'来抓值
                intobj.putExtra("A1_input_data",textContent);
                startActivity(intobj);
            }
        });
    }
}