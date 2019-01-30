package com.example.sam.homemodule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    BottomNavigationView navigation;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        //


        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        navigation.setOnTouchListener(new View.OnTouchListener() {
            private long startClickTime;

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    startClickTime = System.currentTimeMillis();

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    if (System.currentTimeMillis() - startClickTime < ViewConfiguration.getTapTimeout()) {

                        // Touch was a simple tap. Do whatever.

                    } else {

                        // Touch was a not a simple tap.
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            view.animate().translationY(view.getHeight()).setDuration(200);
                        } else if (event.getAction() == MotionEvent.ACTION_UP) {
                            view.animate().translationY(0).setDuration(150);
                        }
                        else
                        {
                            view.animate().translationY(0).setDuration(150);
                        }

                    }

                }

                return true;
            }

        });


    }

}
