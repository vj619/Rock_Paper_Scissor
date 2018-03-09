package com.vijay.rockpaperscissor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends Activity {


    private TextView RockTV,PaperTV,ScissorTV,ChangeTV;

    //String Array For Print Random Comments
    String rule[]={"Rock Smash Scissor","Scissor Cuts Paper","Paper Wraps Rock","Don’t play the same object every time","Try to predict your opponent's next move"};

    private ImageView LogoIV;

    //TypeFacce Change Splash Screen TextView
    private Typeface rockfont,paperfont,scissorfont;

    //Animation For Splash Screen Logo And TextView
    private Animation RotaionAnimation,TranslationAnimation;

    //Splash Screen Timer
    int splash_time =3500;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //code that displays the content in full screen mode

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //Initialize Splash Screen TextView
        RockTV=findViewById(R.id.RockTextView);
        PaperTV=findViewById(R.id.PaperTextView);
        ScissorTV=findViewById(R.id.ScissorTextView);
        ChangeTV=findViewById(R.id.RandomTextView);

        //Initialize Splash Screen Logo
        LogoIV=findViewById(R.id.SplashLogoImageView);

        // Load Animation For Logo And TextView
        RotaionAnimation=AnimationUtils.loadAnimation(this,R.anim.rotaional);
        LogoIV.setAnimation(RotaionAnimation);

        TranslationAnimation=AnimationUtils.loadAnimation(this,R.anim.left_to_right);
        RockTV.setAnimation(TranslationAnimation);

        TranslationAnimation=AnimationUtils.loadAnimation(this,R.anim.paerright);
        PaperTV.setAnimation(TranslationAnimation);

        TranslationAnimation=AnimationUtils.loadAnimation(this,R.anim.scissorright);
        ScissorTV.setAnimation(TranslationAnimation);

        //Custome Fonts Changes
        rockfont=Typeface.createFromAsset(getAssets(),"BRICK.TTF");
        RockTV.setTypeface(rockfont);

        paperfont=Typeface.createFromAsset(getAssets(),"HVD_Peace.ttf");
        PaperTV.setTypeface(paperfont);

        scissorfont=Typeface.createFromAsset(getAssets(),"Babalusa-cut-font.ttf");
        ScissorTV.setTypeface(scissorfont);

        //Random Comments Code
        Random r=new Random();
        final int i=r.nextInt(5);
        ChangeTV.setText(rule[i]);

        //Splash Screen Handler Method
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent(MainActivity.this,FirstPage.class);
                startActivity(i);
                finish();

            }
        },splash_time);
    }
}
