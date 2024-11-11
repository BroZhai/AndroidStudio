package com.example.chattest2;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.URI;
import java.net.URISyntaxException;

public class aiTest extends AppCompatActivity {
    private WebSocketClient webSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化WebSocket连接
        connectWebSocket();
    }

    private void connectWebSocket() {
        URI uri;
        try {
            // 使用10.0.2.2来连接电脑上的服务器（针对模拟器）
            uri = new URI("ws://10.0.2.2:8080/backend-api");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        webSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake handshake) {
                runOnUiThread(() -> Toast.makeText(aiTest.this, "WebSocket Connected", Toast.LENGTH_SHORT).show());
                // 发送登录请求
                JSONObject register = new JSONObject();
                try {
                register.put("action", "register");
                register.put("uname", "TekonTester");
                register.put("password","123456");
                register.put("email", "technikoPancke@gmail.com");
//                    loginRequest.put("action", "login");
//                    loginRequest.put("email", "tester@gmail.com");
//                    loginRequest.put("password", "123456");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                webSocketClient.send(register.toString());
            }

            @Override
            public void onMessage(String message) {
                runOnUiThread(() -> {
                    Toast.makeText(aiTest.this, "Received: " + message, Toast.LENGTH_LONG).show();
                    System.out.println("Received message: " + message);
                });
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                runOnUiThread(() -> Toast.makeText(aiTest.this, "Disconnected: " + reason, Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onError(Exception ex) {
                runOnUiThread(() -> Toast.makeText(aiTest.this, "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show());
                ex.printStackTrace();
            }
        };

        webSocketClient.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webSocketClient != null) {
            webSocketClient.close();
        }
    }
}