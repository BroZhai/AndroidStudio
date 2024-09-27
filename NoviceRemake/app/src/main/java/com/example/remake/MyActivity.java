package com.example.remake;

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
                String textcontent=iText.getText().toString();

                // 最后在Toast中悬浮展示
                Toast.makeText(MyActivity.this,"Hello "+textcontent +"!",Toast.LENGTH_LONG).show();
            }
        });
    }
}