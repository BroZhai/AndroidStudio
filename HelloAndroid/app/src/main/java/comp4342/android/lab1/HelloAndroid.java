package comp4342.android.lab1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelloAndroid extends AppCompatActivity {
//这里的HelloAndroid即为manifest中 Activity绑定的类名
    //  AppCompatActivity 是 Activity 的子类 Activity是一个基类
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 这里的setContentView()方法为当前活动"引用了布局"

        // 呐呐呐，这里就用了'R.id.xxx' 来实现了对'按钮组件'的定位
        // 注册一个按钮，并为其添加一个'监听事件'(回调函数)
        Button b1= (Button)findViewById(R.id.my_firstButton);

        /*这里右边的findViewById的意思是'通过id'找一个"View对象"
        * 在Android开发中，文本标签、按钮、图片，还是复杂的列表、滚动区域 都算是'View的大类'
        * 故我们前面加的'(Button)'的意思就是 将这个'抽象'的View对象 具体声明为一个'按钮button'
        * 然后再在左边用一个Button对象 来存储右侧的东西
        * */

        b1.setOnClickListener(new View.OnClickListener() {
            /* View.OnClickListener是Android中的一个接口
            它定义了onClick(View v)方法，这个方法会在对应的View被点击时被调用

            */
            @Override
            public void onClick(View view) {
                // Toast: 安卓的'浮动消息窗'
                // makeText(活动对象[通常为该Java本身], "显示的文本内容", 显示时长的‘俩常量’): 显示文字，里面要传三个参数
                /*有关Toast的俩显示常量:
                * Toast.LENGTH_SHORT:  显示2秒
                * Toast.LENGTH_LONG: 显示3.5秒
                * */

                Toast.makeText(HelloAndroid.this,"你点我干什么owo?", Toast.LENGTH_SHORT).show(); //最后别忘了调用"show()"进行展示
            }
        });
    }

    //
    //  快捷键ctrl+o: 快捷搜索选择要重写的方法

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true; //true 将创建的菜单显示出来，false不显示
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.item1:
//                Toast.makeText(this,"item1被点击力",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.item2:
//                Toast.makeText(this,"点item2干什么?",Toast.LENGTH_SHORT).show();
//        }
//        return super.onOptionsItemSelected(item);
//    }
}