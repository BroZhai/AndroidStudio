package com.example.basicstorage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorage extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.external_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Request permissions
        /*if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
        }*/

    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }*/

    public void outterWrite(View view) throws IOException {
        // 向外部存储写入数据
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) { // 如果外部存储可用
            File path = getExternalFilesDir(null); // 获取外部存储的目录
            File file = new File(path, "external.txt"); // 创建一个文件对象(存储路径，"文件名")
            // 写入数据('文件对象'的文件流FileOutputStream)
            FileOutputStream fout = new FileOutputStream(file);  // 这里和'内部存储'不一样,直接构建了一个'文件流'FileOutputStream对象
            fout.write("Hello External Storage!".getBytes());
            Toast.makeText(this, "已将\"Hello External Storage!\"写入到外部存储", Toast.LENGTH_SHORT).show();
            fout.close(); // 记得关闭文件流
        }
    }

    public void outterRead(View view) throws IOException{
        //从外部存储读数据
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){ // 外部存储可用
            File path = getExternalFilesDir(null); // 获取外部存储的目录
            File file = new File(path, "external.txt");  // 根据存储的路径和文件名 创建对应的"文件对象"，用于接下来的文件读取

            // 读取数据('文件对象'的文件流FileInputStream)
            FileInputStream fin = new FileInputStream(file);
            int length = fin.available(); // 获取文件长度
            byte[] buffer = new byte[length]; // 创建一个接收缓存区 (和C语言一样)
            fin.read(buffer); // 将读取的内从 存到 缓存区
            String content = new String(buffer);  // 直接将缓存去的'文件内容' 转为 String (这里也和'内部存储'不太一样)
            Toast.makeText(this, "从外部存储读取到的external_text: "+content, Toast.LENGTH_SHORT).show();

            fin.close();
        }
    }

    public void goInnerStorage(View view) {
        // 跳转到内部存储操作界面
        finish();
    }

    public void goSP(View view){
        // 跳转到SharedPreference操作界面
        Intent intent = new Intent(ExternalStorage.this, SharedPreference.class);
        startActivity(intent);
    }

}