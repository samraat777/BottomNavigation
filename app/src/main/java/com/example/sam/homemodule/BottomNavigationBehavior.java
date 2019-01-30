package com.example.sam.homemodule;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class BottomNavigationBehavior extends CoordinatorLayout.Behavior<BottomNavigationView> {

    int var;


    public BottomNavigationBehavior() {
        super();
    }

    public BottomNavigationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, BottomNavigationView child, View dependency) {
        boolean dependsOn = dependency instanceof FrameLayout;
        return dependsOn;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomNavigationView child, View directTargetChild, View target, int nestedScrollAxes) {
        var =10;
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;

    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, BottomNavigationView child, View target, int dx, int dy, int[] consumed) {
        if (dy < 0) {
            showBottomNavigationView(child);
        } else if (dy > 0) {
            hideBottomNavigationView(child);
        }
    }



//    @Override
//    public boolean onTouchEvent(@NonNull CoordinatorLayout parent, @NonNull BottomNavigationView child, @NonNull MotionEvent ev) {
//
//        if(var == 10)
//        {
//            hideBottomNavigationView(child);
//        }
//        return super.onTouchEvent(parent, child, ev);
//    }
//    @Override
//    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomNavigationView child, @NonNull View target, int type) {
//        showBottomNavigationView(child);
//        super.onStopNestedScroll(coordinatorLayout, child, target, type);
//    }

    private void hideBottomNavigationView(final BottomNavigationView view) {
        view.animate().translationY(view.getHeight()).setDuration(150).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {


            }

            @Override
            public void onAnimationCancel(Animator animation) {
                view.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
           // view.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void showBottomNavigationView(final BottomNavigationView view) {
        view.animate().translationY(0).setDuration(150).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                view.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

             //   view.setVisibility(View.INVISIBLE);


            }
        });
    }


}