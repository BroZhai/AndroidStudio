package com.example.retakecomponents;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FourthActivity extends AppCompatActivity {



    // 准备'原数据'
    private String[] eeveeFamily={"火伊布","水伊布","叶伊布","冰伊布","仙子伊布","月伊布","太阳伊布"};
    private int[] levels={23,31,25,26,32,44,33};
    // Tips: 图片是R.drawable里面的资源，会在编译时自动转成"整数"，因此用整数数组int[]来存
    private int[] imgs={R.drawable.flareon,R.drawable.vaporeon,R.drawable.leafeon,R.drawable.glaceon,R.drawable.sylveon,R.drawable.umbreon,R.drawable.espeon};

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fourth_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rv = findViewById(R.id.RecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        // 单独为该RecyclerView'通过代码设置布局'(垂直布局: LinearLayoutManager)
        // 这个不能直接在xml中设置，只能在这里'用代码设置' (还有其他的布局如GridLayoutManager网格布局等，要用的时候自己去查)

        // 应用Adapter
        EeveeAdapter adp = new EeveeAdapter();
        rv.setAdapter(adp);

    }

    // 准备RecyclerView的Adapter (需继承自RecyclerView.Adapter)
    // 后面还要传入一个泛型 (将我们自定的'ViewHolder'传进去)
    class EeveeAdapter extends RecyclerView.Adapter<EeveeAdapter.ViewHolder>{

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // 创建ViewHolder(应用单个item的'布局样式') [注意用的是R.layout.xxx]
            View item_view = View.inflate(FourthActivity.this,R.layout.eevee_layout,null);
            // 通过上面的item_view对象，创建一个ViewHolder对象 (见下面ViewHolder的构造函数
            ViewHolder vh = new ViewHolder(item_view);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            // 绑定(设置)数据
            holder.eeveeImage.setImageResource(imgs[position]); // setImageResource(R.drawable.图片);
            holder.eeveeName.setText(eeveeFamily[position]);
            holder.eeveeLv.setText(String.valueOf(levels[position]));

        }

        @Override
        public int getItemCount() {
            // 返回item的总数量
            return eeveeFamily.length;
        }

        // 在该Adapter里面同时创建ViewHolder类 (缓存'划出视野'item)
        class ViewHolder extends RecyclerView.ViewHolder{
            // 在这里定义该Viewholder(item的'要修改现实'的属性)
            ImageView eeveeImage;
            TextView eeveeName;
            TextView eeveeLv;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                eeveeImage = itemView.findViewById(R.id.eevee_image);
                eeveeName = itemView.findViewById(R.id.eevee_name);
                eeveeLv = itemView.findViewById(R.id.eevee_level);
            }
        }
    }

    // 跳回Activity3
    public void jumpBack(View view){
        finish();
    }
}