package com.example.retakecomponents;
// 大致的逻辑是: 写一个接口，里面有个抽象方法'发送'item的下标出去 (当一个'发信员')
public interface ItemClickListener {
    void itemOnclick(int position);
}
