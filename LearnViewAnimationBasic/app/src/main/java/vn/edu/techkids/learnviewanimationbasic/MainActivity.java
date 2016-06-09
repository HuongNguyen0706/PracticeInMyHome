package vn.edu.techkids.learnviewanimationbasic;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button scale, rotate, btnAlpha, btnTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        imageView.setLayoutParams(layoutParams);

        scale = (Button)findViewById(R.id.scale);
        scale.setOnClickListener(this);
        rotate = (Button)findViewById(R.id.rotate);
        rotate.setOnClickListener(this);
        btnAlpha = (Button)findViewById(R.id.alpha);
        btnAlpha.setOnClickListener(this);
        btnTranslate = (Button)findViewById(R.id.translate);
        btnTranslate.setOnClickListener(this);
    }

    public void doScale(View view){

        imageView.setImageResource(R.drawable.eye);
        imageView.clearAnimation();

        //load animation from resource file
        Animation scaleAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_animation);
        imageView.startAnimation(scaleAnimation);
    }

    public void doRotate(View view){
        imageView.setImageResource(R.drawable.wheel);
        imageView.clearAnimation();

        Animation rotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_animation);
        imageView.startAnimation(rotateAnimation);
    }

    public void doAlpha(View view){
        imageView.setImageResource(R.drawable.car);
        imageView.clearAnimation();

        Animation alphaAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_animation);
        imageView.startAnimation(alphaAnimation);
    }

    public void doTranslate(View view){

        //set the parameters to place image in top - left corner
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        imageView.setLayoutParams(layoutParams);

        imageView.setImageResource(R.drawable.stairs);
        imageView.clearAnimation();

        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        int top = relativeLayout.getTop();
        int left = relativeLayout.getLeft();
        int bottom = relativeLayout.getBottom();
        int right = relativeLayout.getRight();

        //do the animation stuff
        TranslateAnimation translateAnimation = new TranslateAnimation(left, right, top, bottom);
        translateAnimation.setDuration(4000);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setInterpolator(new AccelerateInterpolator());


        imageView.startAnimation(translateAnimation);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.scale){
            doScale(v);
        }
        else if(id == R.id.rotate){
            doRotate(v);
        }else if(id == R.id.alpha){
            doAlpha(v);
        }else if(id == R.id.translate){
            doTranslate(v);
        }

    }
}
