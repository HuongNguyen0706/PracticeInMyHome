package vn.edu.techkids.drawableanimation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button move, stop;
    private AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.image);
        move = (Button)findViewById(R.id.btnMove);
        stop = (Button)findViewById(R.id.btnStop);

        if(imageView != null){
            imageView.setBackgroundResource(R.drawable.frame_animation_list);
            imageView.setVisibility(View.VISIBLE);
            drawable = (AnimationDrawable)imageView.getBackground();
            drawable.setOneShot(false);
        }

        move.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnMove){
            drawable.start();
        }
        else drawable.stop();
    }
}
