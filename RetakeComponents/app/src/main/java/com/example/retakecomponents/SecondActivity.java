package com.example.retakecomponents;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

    // 下面的代码对应按钮 弹出一个 "简单对话框"
    public void simpleDialog(View view){
        // 注意一下一些列的操作都没有";"冒号，原则上全是"连在一起"的，竖着写只是为了好看
        new AlertDialog.Builder(this)
        .setCancelable(true)
        .setTitle("这是对话框标题")
        .setMessage("我是对话框里的内容")
        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(SecondActivity.this,"你点击了取消按钮",Toast.LENGTH_SHORT).show();
            }
        })
        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(SecondActivity.this,"我是确认按钮",Toast.LENGTH_SHORT).show();
            }
        })
        .create().show(); //创建这个AlertDialog.Builder对象 并进行展示
    }

    /* 下面的代码对应按钮 弹出一个 "单选"对话框 */

    // 提前用数组定义好 "选项" 和 "对应的值"
    private String[] options = {"小", "中", "大"};
    private int[] values = {10,23,35};

    private int index; // 存储单选"选中的下标"

    public void ratioDialog(View view) {
        TextView paraDisplay = findViewById(R.id.paraDisplay);
        new AlertDialog.Builder(this)
        .setCancelable(false)
        .setTitle("这是一个单选对话框")
        .setSingleChoiceItems(options, 1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                //在单选框的情况下，这里的i是"选中的选项的index"
                  index = i;
                }
            })
        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                        paraDisplay.setTextSize(values[index]);
                        Toast.makeText(SecondActivity.this,"已将字体大小设置为"+values[index],Toast.LENGTH_SHORT).show();
                    }
                })
        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(SecondActivity.this,"你取消了操作",Toast.LENGTH_SHORT).show();
                    }
                })
        .create().show();
    }

    /* 下面的代码对应按钮 弹出一个 "多选"对话框 */

    // 提前用数组定义好 "选项" 和 "对应的值"，但"对应的值"将会是布尔 (对应多选的isChecked()属性)
    private String[] options2 = {"Cirno","Omori","Niko","YumiNikki","PikuNiku","HollowKnight"};
    private boolean[] checkedValues = {false,false,false,false,false,false};

    public void checkboxDialog(View view) {
        AlertDialog.Builder checkboxDg =  new AlertDialog.Builder(this);
        checkboxDg.setCancelable(false);
        checkboxDg.setTitle("勾选你的旅行伙伴们!");
        checkboxDg.setMultiChoiceItems(options2, checkedValues, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                checkedValues[i] = b;
            }
        });
        checkboxDg.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // 此时创建一个"动态数组"ArrayList, 用来动态的展示"选中true项的内容" (输出列表)
                ArrayList<String> friendList = new ArrayList<>();
                for(int j = 0; j < checkedValues.length ; j++){ // 遍历checkedValues数组, 看看哪些为true的，加到"输出列表"中
                    if(checkedValues[j]==true){
                        friendList.add(options2[j]);
                    }
                }
                if(friendList.isEmpty()){
                    Toast.makeText(SecondActivity.this, "你没有选择任何伙伴QAQ", Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(SecondActivity.this, "你的伙伴有: "+ friendList.toString(), Toast.LENGTH_LONG).show();
            }
        });
        checkboxDg.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(SecondActivity.this, "你取消了选择伙伴", Toast.LENGTH_LONG).show();
            }
        });
// group assignment
       AlertDialog formalCheckbox = checkboxDg.create();
       formalCheckbox.show();
    }

}