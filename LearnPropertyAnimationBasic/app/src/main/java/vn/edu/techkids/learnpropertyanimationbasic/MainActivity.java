package vn.edu.techkids.learnpropertyanimationbasic;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private ImageView wheel, sun;
    private AnimatorSet wheelSet, sunSet;
    private ObjectAnimator cloudAnim1, cloudAnim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ValueAnimator skyAnim = ObjectAnimator.ofInt(
                findViewById(R.id.car_layout),
                "backgroundColor",
                Color.rgb(0x66, 0xcc, 0xff),
                Color.rgb(0x00, 0x66, 0x99));
        skyAnim.setDuration(3000);
        skyAnim.setRepeatCount(ValueAnimator.INFINITE);
        skyAnim.setRepeatMode(ValueAnimator.REVERSE);
        skyAnim.setEvaluator(new ArgbEvaluator());
        skyAnim.start();

        wheelSpin();
        flySun();
        flyCloud();

    }

    public void wheelSpin(){
        wheel = (ImageView)findViewById(R.id.wheel);
        wheelSet= (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.wheel_spin);
        wheelSet.setTarget(wheel);
        wheelSet.start();
    }
    public void flySun(){
        sun = (ImageView)findViewById(R.id.sun);
        sunSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.sun_swing);
        sunSet.setTarget(sun);
        sunSet.start();
    }


    public void flyCloud(){
        cloudAnim1 = ObjectAnimator.ofFloat(findViewById(R.id.cloud1), "x", -350);
        cloudAnim1.setDuration(3000);
        cloudAnim1.setRepeatCount(ObjectAnimator.INFINITE);
        cloudAnim1.setRepeatMode(ObjectAnimator.REVERSE);
        cloudAnim1.start();

        cloudAnim2 = ObjectAnimator.ofFloat(findViewById(R.id.cloud2), "x", -300);
        cloudAnim2.setDuration(3000);
        cloudAnim2.setRepeatCount(ObjectAnimator.INFINITE);
        cloudAnim2.setRepeatMode(ObjectAnimator.REVERSE);
        cloudAnim2.start();
    }
}
