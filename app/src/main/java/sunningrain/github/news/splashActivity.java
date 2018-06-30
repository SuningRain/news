package sunningrain.github.news;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

public class splashActivity extends Activity {

    private ConstraintLayout cl_splash_root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        cl_splash_root = (ConstraintLayout) findViewById(R.id.cl_splash_root);
        //渐变动画，缩放动画，旋转动画
        AlphaAnimation aa  = new AlphaAnimation(0,1);
//        aa.setDuration(500);//持续播放时间
        aa.setFillAfter(true);

        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,
                ScaleAnimation.RELATIVE_TO_SELF,0.5f);
//        sa.setDuration(500);
        sa.setFillAfter(true);

        RotateAnimation ra = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f);
//        ra.setDuration(500);
        ra.setFillAfter(true);

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(ra);
        animationSet.addAnimation(aa);
        animationSet.addAnimation(sa);
        animationSet.setDuration(2000);

        cl_splash_root.startAnimation(animationSet);

        animationSet.setAnimationListener(new MyAnimationListener());
    }
    class MyAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Toast.makeText(splashActivity.this,"动画完成",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
