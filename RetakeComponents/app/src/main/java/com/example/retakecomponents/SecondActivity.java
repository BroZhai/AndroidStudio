package com.example.retakecomponents;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

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

        // 获取所有的多选按钮
        CheckBox fire = findViewById(R.id.flareon);
        CheckBox water = findViewById(R.id.vaporeon);
        CheckBox leaf = findViewById(R.id.leafeon);
        CheckBox fairy = findViewById(R.id.sylveon);
        CheckBox ice = findViewById(R.id.glaceon);
        CheckBox moon = findViewById(R.id.umbreon);
        CheckBox sun = findViewById(R.id.espeon);

        Button checkEevee = findViewById(R.id.checkEevee); // 获取"检查按钮"

        // 为"检查按钮"设置监听器
        checkEevee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> eeveePack = new ArrayList<>();
                TextView eeveeResult = findViewById(R.id.eeveeDisplay);
                if (fire.isChecked()){
                    eeveePack.add(fire.getText().toString());
                }
                if (water.isChecked()){
                    eeveePack.add(water.getText().toString());
                }
                if (leaf.isChecked()){
                    eeveePack.add(leaf.getText().toString());
                }
                if (fairy.isChecked()){
                    eeveePack.add(fairy.getText().toString());
                }
                if (ice.isChecked()){
                    eeveePack.add(ice.getText().toString());
                }
                if (moon.isChecked()){
                    eeveePack.add(moon.getText().toString());
                }
                if (sun.isChecked()){
                    eeveePack.add(sun.getText().toString());
                }

                if(eeveePack.isEmpty()){
                    Toast.makeText(SecondActivity.this,"我的布布们呢QAQ...",Toast.LENGTH_LONG);
                    return;
                }
            eeveeResult.setText("你选择了: "+eeveePack.toString());
            }
        });


    }

    public void jumpBack(View view){
        finish();
    }

    public void simpleDialog(View view){
        // 注意一下一些列的操作都没有";"冒号，原则上全是"连在一起"的，竖着写只是为了好看
        new AlertDialog.Builder(this)
        .setCancelable(true)
        .setTitle("这是对话框标题")
        .setMessage("我是对话框里的内容")
        .setNegativeButton("取消",null)
        .setPositiveButton("确认",null)
        .create().show(); //创建这个AlertDialog.Builder对象 并进行展示
    }


}