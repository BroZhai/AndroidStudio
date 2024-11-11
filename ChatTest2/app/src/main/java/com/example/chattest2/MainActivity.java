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

import org.json.JSONException;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

   /* private void setupWebSocket() {
            try {
                URI serverURI = new URI("ws://localhost:8080/backend-api");
                client = new FrontendAPIProvider(serverURI);
                if (client == null){
                    Toast.makeText(MainActivity.this, "client是空的！", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "有client", Toast.LENGTH_LONG).show();
                }

            } catch (URISyntaxException e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "无法连接到服务器", Toast.LENGTH_LONG).show());
            }
    }*/

    /*private void setupEdgeInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }*/

    public void reg(View view) throws URISyntaxException {
//        start();
        FrontendAPIProvider client = new FrontendAPIProvider(new URI("ws://192.168.6.212:8080/backend-api"));
        client.onOpen(null);
        username = findViewById(R.id.userIn);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passIn);

        String usernameStr = username.getText().toString();
        String emailStr = email.getText().toString();
        String passwordStr = password.getText().toString();

//        setupWebSocket();
//        setupEdgeInsets();

        // 检查 WebSocket 连接是否建立
        if (client == null) {
            Toast.makeText(this, "client不存在", Toast.LENGTH_SHORT).show();
            return;
        }else{
            Toast.makeText(this, "有client", Toast.LENGTH_SHORT).show();
        }

        // 发送注册请求
            try {
                    client.sendRegisterRequest(usernameStr, emailStr, passwordStr);
                    // 确保 Toast 在主线程显示
                    runOnUiThread(() -> {
                        if (client.isSuccessful) {
                            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    });
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(this, "发送请求时发生异常", Toast.LENGTH_SHORT).show());
            }
    }

  /*  public static void start() {
        try {
            // 创建 WebSocket 客户端并连接到 WebSocket 服务器
            URI serverURI = new URI("ws://localhost:8080/backend-api");
            client = new FrontendAPIProvider(serverURI);//onOpen会被执行
            client.connectBlocking();  // 阻塞，直到连接建立

            // 示例：发送注册请求
            client.sendRegisterRequest("ABC", "ABC@exaample.com", "ABCABC");
            Thread.sleep(1000);
////            client.sendStartConversationRequest("d96f962d-f8c0-4c8f-b986-b87e9c877462", "1ac162a4-5a24-4058-a3de-5eb0d639a3fb", "hello");
//            client.sendNewMessage("d96f962d-f8c0-4c8f-b986-b87e9c877462", "1ac162a4-5a24-4058-a3de-5eb0d639a3fb", "add");

        } catch (URISyntaxException | InterruptedException | JSONException e) {
            e.printStackTrace();
        }
    }*/
}