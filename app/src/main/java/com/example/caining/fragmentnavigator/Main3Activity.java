package com.example.caining.fragmentnavigator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private List<Fragment> fragments;
    private int position = 0;// TODO: 16/4/7 当前位置
    private List<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        views.add(findViewById(R.id.text1));
        views.add(findViewById(R.id.text2));
        views.add(findViewById(R.id.text3));
        views.add(findViewById(R.id.text4));
        for (View v : views) {// TODO: 16/4/7 设置监听
            v.setOnClickListener(this);
        }

        fragments = new ArrayList<>();
        fragments.add(new TextFragment(1));
        fragments.add(new TextFragment(2));
        fragments.add(new TextFragment(3));
        fragments.add(new TextFragment(4));


        getSupportFragmentManager().beginTransaction().add(R.id.fragmentcontainer, fragments.get(0)).commit();// TODO: 16/4/7 默认加载第一页
        views.get(position).setBackgroundResource(R.drawable.platymate_tab_bg);// TODO: 16/4/7 第一页的背景图
    }


    // TODO: 16/4/7 监听 替换fragment
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text1:
                repleasefragment(fragments, 0, getSupportFragmentManager().beginTransaction(), R.id.fragmentcontainer, position);
                break;
            case R.id.text2:
                repleasefragment(fragments, 1, getSupportFragmentManager().beginTransaction(), R.id.fragmentcontainer, position);
                break;
            case R.id.text3:
                repleasefragment(fragments, 2, getSupportFragmentManager().beginTransaction(), R.id.fragmentcontainer, position);
                break;
            case R.id.text4:
                repleasefragment(fragments, 3, getSupportFragmentManager().beginTransaction(), R.id.fragmentcontainer, position);
                break;

        }
    }

    /**
     * 设置背景方法
     *
     * @param posision
     * @param bfposition
     */
    private void settext(int posision, int bfposition) {
        views.get(bfposition).setBackgroundColor(Color.argb(0, 0, 0, 0));// TODO: 16/4/7 设置为透明
        views.get(posision).setBackgroundResource(R.drawable.platymate_tab_bg);// TODO: 16/4/7 设置为9图
    }

    /**
     * 方法替换fragment
     *
     * @param fragments
     * @param posision
     * @param ft
     * @param fragmentContentId
     * @param bfposision
     */
    private void repleasefragment(List<Fragment> fragments, int posision, FragmentTransaction ft, int fragmentContentId, int bfposision) {
        position = posision;
        if (bfposision == posision) return;
        settext(posision, bfposision);

        Fragment fragment = fragments.get(posision);
        fragments.get(bfposision).onStop();
        ft.hide(fragments.get(bfposision));
        if (fragment.isAdded()) {
            fragment.onStart();
            ft.show(fragment);
        } else {
            ft.add(fragmentContentId, fragment);
            ft.show(fragment);
        }
        ft.commit();
    }




}
