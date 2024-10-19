package com.example.retakecomponents;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.second_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //获取从mainActivity传过来的"参数信息"
        String receiveStr = getIntent().getStringExtra("inputFromA1");
        TextView tv = findViewById(R.id.paraDisplay);
        tv.setText("从mainActivity传过来的信息: "+receiveStr);

        // 下面开始有关"单选框"的内容，首先找到"单选组"RadioGroup
        RadioGroup rdp = findViewById(R.id.dxGroup);
        TextView radioResult = findViewById(R.id.dxDisplay);

        // 重写单选组的监听器
        rdp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = findViewById(i); // 根据"i"(响应的单选框id)找到对应的单选框对象
                switch(i){
                    case R.id.dx1:
                        // 根据"i"(响应的单选框id)找到对应的单选框对象，然后更改"单选显示文本"
                        radioResult.setText("你在RadioGroup中选择了: "+rb.getText().toString());
                        radioResult.setTextColor(getResources().getColor(R.color.fox));
                        break;
                    //以下同理
                    case R.id.dx2:
                        // 根据"i"(响应的单选框id)找到对应的单选框对象，然后更改"单选显示文本"
                        radioResult.setText("你在RadioGroup中选择了: "+rb.getText().toString());
                        radioResult.setTextColor(getResources().getColor(R.color.pinkcandy));
                        break;
                    case R.id.dx3:
                        // 根据"i"(响应的单选框id)找到对应的单选框对象，然后更改"单选显示文本"
                        radioResult.setText("你在RadioGroup中选择了: "+rb.getText().toString());
                        radioResult.setTextColor(getResources().getColor(R.color.black));
                        break;
                }
            }
        });
    }

    public void jumpBack(View view){
        finish();
    }



}