package com.example.retakecomponents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class firstActivity extends AppCompatActivity {

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

    }

    // 按钮的onclick就会触发下面的 jumpSec 方法
    public void jumpSec(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    // 再来一个"带参数"的跳转
    public void jumpSecWithPara(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("pokemon", "仙子伊布");
        intent.putExtra("lv",23);
        intent.putExtra("isShiny", false);
        startActivity(intent);
    }
}