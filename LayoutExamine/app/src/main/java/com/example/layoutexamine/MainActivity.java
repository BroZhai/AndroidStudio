package com.example.layoutexamine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter; // 要extends BaseAdapter，就要现在这里导入
import android.widget.ListView;

// Activity 里面的 name 就指向了这里的 MainActivity.class 作为处理逻辑
// 我们就在对应的java目录下新建这个类
// 这里的活动类要extends以下两个class之一

// Activity: 不兼容旧安卓系统
// AppCompactActivity: 兼容旧安卓系统

public class MainActivity extends Activity {
    // 准备需要给Adapter的数据
    String[] fruit={"Apple","Banana","Orange","Watermelon",
            "Pear","Grape","Pineapple","Strawberry","Cherry","Mango"};

    // 按照惯例，首先重写onCreate方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 调用父类的onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout); // 设置"当前活动"布局文件

        /*有关Adapter，我们既可以用'现成的'，也可以自己重新去写
        Adapter即是 ListView(视图区) 和 数据源 之间的桥梁，可以把它形象的理解成一个 "中间数据包"
        因为今天没多少时间了，所以这里就先用现成的ArrayAdapter先顶着，哪天再有空了再回来看看怎么自己去实现
        */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, fruit);
        // 后面传入的三个东西分别是：'当前活动'对象、'布局文件'(上面的simple_list_item_1为一个"内置的")、传递"数据源"
        ListView lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(adapter); // 将视图区的ListView和"数据包"Adapter绑定起来


    }


    // 以下的部分的内容为自己尝试去实现的一个Adapter (继承自BaseAdapter)
   /* class myAdapter extends BaseAdapter {
        //对于每个Adapter，我们都要去重写以下四个方法 (必须重写！)
        @Override
        public int getCount() { // 返回这个Adapter的数据量
            return fruit.length;
        }

        @Override
        public Object getItem(int i) { // 获取Adapter中某个具体的数据item(根据传入下标)
            return fruit[i];
        }

        @Overridex
        public long getItemId(int i) { // 获取每一个item的唯一标识符"id" ()
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return ;
        }

    } */

}
