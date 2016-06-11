package vn.edu.techkids.colorbuttonchange;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn, test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btnChangeColor);
        test = (Button)findViewById(R.id.btnTest);

        final ValueAnimator groundAnimator = ObjectAnimator.ofInt
                (btn, "backgroundColor",
                        Color.GREEN, Color.RED);
        //set same duration and animation properties as others
        groundAnimator.setDuration(3000);
        groundAnimator.setEvaluator(new ArgbEvaluator());
        groundAnimator.setRepeatCount(ValueAnimator.INFINITE);
        groundAnimator.setRepeatMode(ValueAnimator.REVERSE);


        groundAnimator.start();


        doTranslate();



    }

    public void doTranslate(){
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) test.getLayoutParams();
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        test.setLayoutParams(layoutParams);
        test.clearAnimation();

        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.layout);
        int top = relativeLayout.getTop();
        int left = relativeLayout.getLeft();
        int bottom = relativeLayout.getBottom();
        int right = relativeLayout.getRight();

        //do the animation stuff
        TranslateAnimation translateAnimation = new TranslateAnimation(left, right, top, bottom);
        translateAnimation.setDuration(4000);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setInterpolator(new AccelerateInterpolator());


        test.startAnimation(translateAnimation);
    }

}
