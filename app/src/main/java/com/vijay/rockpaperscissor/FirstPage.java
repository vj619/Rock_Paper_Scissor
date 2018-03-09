package com.vijay.rockpaperscissor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class FirstPage extends AppCompatActivity {

    private ImageView Logo1,Logo2;   //Images for Logos

    private Button playbtn,Instructionsbtn,aboutbtn,exitbtn;    //Menu Buttons

    private Animation BlinkAnimation,ZoomInAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        //Initialize ImageView
        Logo1=findViewById(R.id.LogoImageView);
        Logo2=findViewById(R.id.Logo2ImageView);

        //Initialize Buttons
        playbtn=findViewById(R.id.PlayButton);
        Instructionsbtn=findViewById(R.id.HowToPlayButton);
        aboutbtn=findViewById(R.id.AboutButton);
        exitbtn=findViewById(R.id.ExitButton);

        //Intiialize Animation
        BlinkAnimation= AnimationUtils.loadAnimation(this,R.anim.blink);
        playbtn.setAnimation(BlinkAnimation);

        ZoomInAnimation= AnimationUtils.loadAnimation(this,R.anim.zoomin);
        Logo1.setAnimation(ZoomInAnimation);

        ZoomInAnimation= AnimationUtils.loadAnimation(this,R.anim.zoomin);
        Logo2.setAnimation(ZoomInAnimation);

        //set OnClick Listeners On Buttons

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent playintent=new Intent(FirstPage.this,PlayActivity.class);
                startActivity(playintent);
            }
        });


        Instructionsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent howintent=new Intent(FirstPage.this,HowToPlayActivity.class);
                startActivity(howintent);
            }
        });


        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent aboutintent=new Intent(FirstPage.this,AboutActivity.class);
                startActivity(aboutintent);
            }
        });


        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ab=new AlertDialog.Builder(FirstPage.this);
                ab.setTitle("Rock Paper Scissor")
                        .setMessage("Are you sure you want to quit this App?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setNegativeButton("NO",null);
                AlertDialog alert=ab.create();
                alert.show();
            }
        });

    }

    public void onBackPressed()
    {
        AlertDialog.Builder ab=new AlertDialog.Builder(FirstPage.this);
        ab.setTitle("Rock Paper Scissor")
                .setMessage("Are you sure you want to quit this App?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirstPage.super.onBackPressed();
                    }
                }).setNegativeButton("NO",null).setCancelable(false);
        AlertDialog alert=ab.create();
        alert.show();
    }
}
