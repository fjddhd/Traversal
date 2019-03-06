package com.duoduo.isgood.traversal;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 允许使用transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //transitions设置
        Explode explode = new Explode();
        explode.setDuration(300);
        Slide slide = new Slide();
        slide.setDuration(300);
        slide.setSlideEdge(Gravity.END);
        getWindow().setEnterTransition(slide);
        getWindow().setReturnTransition(explode);

    }

    public void InitToolbar(int toolbarId, int drawerLayoutId, int NavagationViewId, String toolbarTitle){
        mToolbar = findViewById(toolbarId);//视活动而定
        mToolbar.setTitle(toolbarTitle);//customize the title,个性化设置title
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));//设置title颜色
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//show back button and make it enabled

        mDrawerLayout = findViewById(drawerLayoutId);
        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_layout_open, R.string.drawer_layout_close);
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mActionBarDrawerToggle.setHomeAsUpIndicator(R.mipmap.ic_launcher);//channge the icon,改变图标
        mActionBarDrawerToggle.syncState();////show the default icon and sync the DrawerToggle state,如果你想改变图标的话，这句话要去掉。这个会使用默认的三杠图标
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mDrawerLayout.setStatusBarBackgroundColor(ContextCompat.getColor(this, R.color.green));//设置状态栏颜色

        //设置navigationview的menu监听
        mNavigationView = findViewById(NavagationViewId);
        mNavigationView.setNavigationItemSelectedListener(this);



    }
    /**
     * 加载导航菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_navigation,menu);//启用菜单
        return false;//设为true后，toolbar右边会有开启menu的三点图形
    }
    /**
     * 设置导航项目选项
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        switch (id){
            case R.id.menu_tree:{
                Intent intent=new Intent(this,MainActivity.class);
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
                startActivity(intent, transitionActivityOptions.toBundle());
//                overridePendingTransition(0,0);//去掉活动切换动画
                break;
            }
            case R.id.menu_stack:{
                Intent intent=new Intent(this,StackActivity.class);
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
                startActivity(intent, transitionActivityOptions.toBundle());
                break;
            }
            case R.id.menu_quicksort:{
                Intent intent=new Intent(this,QuickSortActivity.class);
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
                startActivity(intent, transitionActivityOptions.toBundle());
                break;
            }
            case R.id.menu_heap:{
                Intent intent=new Intent(this,HeapActivity.class);
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
                startActivity(intent, transitionActivityOptions.toBundle());
                break;
            }


        }
        return false;
    }

    @Override
    public void onBackPressed() {
        //不要用super的onBackPressed方法
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            finish();
        }
    }


}
