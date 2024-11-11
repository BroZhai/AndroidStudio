package com.example.basicstorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SharedPreference extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sharedp_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void goOuterStorage(View view) {
        // 跳回OuterStorage
        finish();
    }


    public void SPWrite(View view) {
        // 创建SharedPreferences对象，用方法getSharedPreferences("存储文件名", 模式[一般用MODE_PRIVATE])
        // MODE_PRIVATE: 只有当前应用程序才能访问这个SharedPreferences文件
        SharedPreferences sp = getSharedPreferences("userdata", MODE_PRIVATE);

        // 获取SharedPreferences.Editor'专用编辑对象'，用于'编辑'(写入)数据
        SharedPreferences.Editor editor = sp.edit();

        // 通过editor对象写入数据 [editor对象.put各数据类型("键名",值);]
        editor.putString("username", "admin");
        editor.putInt("phone", 123456);

        // 保存'写入的'数据
        editor.apply();
        Log.d("TAG","已成功向SharedPreferences写入数据");
        Toast.makeText(SharedPreference.this,"写入成功, 请去LogCat查看",Toast.LENGTH_SHORT).show();
    }

    public void SPRead(View view) {
        // 和写数据一样，先获取SharedPreferences对象
        SharedPreferences sp = getSharedPreferences("userdata", MODE_PRIVATE);

        // 现在可以直接通过这个SharedPreferences对象.get各数据类型("键名",没读到返回的默认值); 读取数据
        String username = sp.getString("username", "null"); // 读取键名为"username"的数据，如果没有则返回"null"
        int phone = sp.getInt("phone", 0); // 读取键名为"phone"的数据，如果没有则返回0

        // 读到数据之后，该干啥干啥 (这里选择了在控制台打印)
        Log.d("TAG","用户名:"+username+" 电话:"+phone);
        Toast.makeText(SharedPreference.this,"已在LogCat打印控制台信息",Toast.LENGTH_SHORT).show();
    }
}