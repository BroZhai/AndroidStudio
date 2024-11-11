package com.example.chattest2;

import static java.lang.Thread.sleep;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText email;
    EditText password;
    // 创建 WebSocket 客户端并连接到 WebSocket 服务器
    FrontendAPIProvider client;

    public MainActivity() throws URISyntaxException, InterruptedException {
        URI serverURI = new URI("ws://localhost:8080/backend-api");
        client = new FrontendAPIProvider(serverURI);//onOpen会被执行
//        client.connectBlocking();  // 阻塞，直到连接建立
    }


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

    public void reg(View view) {
        username = (EditText) findViewById(R.id.userIn);
        email = (EditText) findViewById(R.id.emailInput);
        password = (EditText) findViewById(R.id.passIn);

        String usernameStr = username.getText().toString();
        String emailStr = email.getText().toString();
        String passwordStr = password.getText().toString();

        try {
            client.sendRegisterRequest(usernameStr, emailStr, passwordStr);
            sleep(1000);
            if (client.isSuccessful) {
                Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}