package com.example.monkey.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    private Button toDialog;
    private AlertDialog.Builder builder;
    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPage);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item){
                        switch (item.getItemId()){
                            case R.id.navigation_home:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.navigation_dashboard:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.navigation_monkey:
                                viewPager.setCurrentItem(2);
                                break;
                        }

                        return false;
                    }
                });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                }
                else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);

//        Button toWebView = (Button) findViewById(R.id.btn);
//        toWebView.setOnClickListener(this);
//        toDialog = (Button) findViewById(R.id.dialog);
//        toDialog.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(BaseFragment.newInstance("home"));
        adapter.addFragment(BaseFragment.newInstance("dashBord"));
        adapter.addFragment(BaseFragment.newInstance("monkey"));
        viewPager.setAdapter(adapter);
    }


//    @Override
//    public void onClick(View view) {
//        switch(view.getId()) {
//            case R.id.dialog:
//                builder = new AlertDialog.Builder(this);
//                builder.setTitle("monkey");
//                builder.setCancelable(true);
//                AlertDialog dg = builder.create();
//                dg.show();
//                break;
//            case R.id.btn:
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, Main2Activity.class);
//                startActivity(intent);
//                break;
//        }
//    }
}
