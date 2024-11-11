package com.example.basicstorage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // 向内部存储写入数据
    public void innerWrite(View view) throws IOException {
        inputText = findViewById(R.id.inputText);
        String content = inputText.getText().toString(); // 获取输入框内容

        FileOutputStream fout = openFileOutput("stored_text.txt", MODE_PRIVATE); //
        fout.write(content.getBytes()); // 将字符串 转换为 字节数组, 写入文件
        Toast.makeText(MainActivity.this,"已将\""+content+"\"写入到内部存储",Toast.LENGTH_SHORT).show();
        fout.close(); // 记得关闭文件流 (和C语言一样)
    };

    // 从内部存储读数据
    public void innerRead(View view) throws IOException{
            FileInputStream fin = openFileInput("stored_text.txt"); // 从内部存储打开对应文件
            int length = fin.available(); // 获取文件长度
            byte[] buffer = new byte[length]; // 创建一个接收缓存区 (和C语言一样)
            fin.read(buffer); // 读取文件内容到缓存区
            String content = new String(buffer);  // 将缓存区的'byte内容' 转换为 字符串
            Toast.makeText(this, "从内部存储读取到的stored_text: "+content, Toast.LENGTH_SHORT).show();
    }

    public void goExternal(View view) {
        // 跳转到外部存储操作界面
        Intent intent = new Intent(MainActivity.this, ExternalStorage.class);
        startActivity(intent);
    }
}

