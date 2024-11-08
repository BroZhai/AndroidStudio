package com.example.retakecomponents;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;


public class ThirdActivity extends Activity {

    private String[] titles = {"Mp3","电子词典","GPRS通信设备","mp4","台式电脑","GPS定位仪","声呐雷达","核能手电"};
    private String[] prices = {"100元","80元","230元","120元","2300元","333元","9999元","Undefinded"};
    protected void onCreate(Bundle savedInstanceState){
        // 复习一下'新建Activity'，好久没动了QAQ...
        // 准备在这里实现一下'listView' + 'Adapter'的内容
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        //获取布局中的listView
        ListView lv = findViewById(R.id.dpListView);
        MyAdapter createdAdapter = new MyAdapter();
        lv.setAdapter(createdAdapter);
    }





    // 准备一个'数据中间容器' Adapter (介于前台 和 后台的'中间商', 这里直接用了最基础的BaseAdapter)
    class MyAdapter extends BaseAdapter{


        // 既然继承了BaseAdapter，那么我们就必须要实现(完善)以下的4个函数
        @Override
        public int getCount() {
            // 获取数据的'个数'
            return titles.length;
        }

        @Override
        public Object getItem(int i) {
            // 获取具体某个'元素'item，上面会传入'下标'进来给你定位
            return titles[i];
        }

        @Override
        public long getItemId(int i) {
            //获取每一个item的唯一标识符"id"(偷懒可直接用下标)
            return i;
        }

        @Override
        /*public View getView(int i, View view, ViewGroup viewGroup) {
            //重点: 获取每一个item的'展示样式' (单独开个layout文件设置每个Item的样式)
            //参数说明: i (item的下标位置)， view (缓存着'划出视野'的item, 优化listView用), viewGroup(listView对象本身)


            //1. 使用View.inflate()加载布局 inflate(Activity对象，布局文件，不知道就填null);
            View item_view = view.inflate(ThirdActivity.this, R.layout.item_layout, null);

            //2. 从取得的View对象中，获取里面 要进行'动态设置'的'小组件' (注意要指定为上面的inflate()的view对象来找[不然默认就会去找'全局的View']XD)
//            ImageView img = (ImageView) item_view.findViewById(R.id.item_image); //统一用'仙布'代替
            TextView name = (TextView) item_view.findViewById(R.id.item_title);
            TextView price = (TextView) item_view.findViewById(R.id.item_price);
            //Tips: priceLable不用动(设置)，它就是放在那里展示的

            //3. 根据"原数据"设置各个控件的'展示数据'
            name.setText(titles[i]);
            price.setText(prices[i]);

            //4. 返回该View对象 (这样以后，这个Adapter就算建立好了，接下来将这个"格式"应用到listView控件中去)
            return item_view;
        }*/

        //EXTRA: 创建一个viewHolder类，这个类专门对划出屏幕的item进行缓存，从而优化ListView性能
        // TODO: 搞明白这里view对象的setTag()和getTag()方法
        public View getView(int i, View view, ViewGroup viewGroup) {
            MyViewHolder holder;
            if(view == null){
                view = view.inflate(ThirdActivity.this, R.layout.item_layout, null);
                holder = new MyViewHolder();
                holder.name = view.findViewById(R.id.item_title);
                holder.price = view.findViewById(R.id.item_price);
                view.setTag(holder);
            }else{
                holder = (MyViewHolder) view.getTag();
            }

            //3. 根据"原数据"设置各个控件的'展示数据'
            holder.name.setText(titles[i]);
            holder.price.setText(prices[i]);

            //4. 返回该View对象 (这样以后，这个Adapter就算建立好了，接下来将这个"格式"应用到listView控件中去)
            return view;
        }
        class MyViewHolder{
            TextView name;
            TextView price;
        }
    }

    // 跳回Activity2的方法
    public void jumpBack(View view){
        finish();
    }
}
