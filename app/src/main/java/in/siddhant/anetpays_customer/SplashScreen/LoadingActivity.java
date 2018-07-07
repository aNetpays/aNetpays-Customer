package in.siddhant.anetpays_customer.SplashScreen;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;

import com.jaredrummler.android.widget.AnimatedSvgView;

import butterknife.BindViews;
import butterknife.ButterKnife;
import in.siddhant.anetpays_customer.Login.LoginActivity;
import in.siddhant.anetpays_customer.R;

public class LoadingActivity extends AppCompatActivity {
    @BindViews({R.id.dynamic_background_progress})
    ProgressBar[] ProgressBar;
    private ValueAnimator ProgressBarAnimator;
    AnimatedSvgView svgView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_activity);
        ButterKnife.bind(this);
        ProgressBarAnimator = Animators.makeDeterminateCircularPrimaryAndSecondaryProgressAnimator(ProgressBar);


        svgView = (AnimatedSvgView)findViewById(R.id.animated_svg_view);
        svgView.postDelayed(new Runnable() {
            @Override
            public void run() {
                svgView.start();
            }
        }, 1000);
        svgView.setOnStateChangeListener(new AnimatedSvgView.OnStateChangeListener() {
            @Override
            public void onStateChange(@AnimatedSvgView.State int state) {
                if (state == AnimatedSvgView.STATE_TRACE_STARTED){
                    ProgressBarAnimator.start();
                }
                else if (state == AnimatedSvgView.STATE_FINISHED){
                    ProgressBarAnimator.end();
                    Intent intent = new Intent(LoadingActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Log.d("Error", "Error in ProgressBar");
                }
            }
        });
    }
}
