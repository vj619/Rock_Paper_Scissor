package com.vijay.rockpaperscissor;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private TextView YourScoreTv,CpuScooreTV,YouZeroTv,CpuzeroTV,WinTV,PlayMsgTv;

    private ImageView HomeIV,ResetIV,PlayerHandIV,CpuHandV,RockHandIV,PaperHandIV,ScissorHandIV;

    private Typeface tf,tf2;

    private int your_score,cpu_score;

     private Animation HandsZoomAnimation,WinnerMsgAnimation;
   // private Animation Fade_In_Animation,animation;


    int timer=400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        YourScoreTv=findViewById(R.id.YourScoreTextView);
        CpuScooreTV=findViewById(R.id.CpuScoreTextView);
        YouZeroTv=findViewById(R.id.YourPoints);
        CpuzeroTV=findViewById(R.id.CpuPoints);
        WinTV=findViewById(R.id.WinnerDeciderTextView);
        PlayMsgTv=findViewById(R.id.PlayMsgTv);

        HomeIV=findViewById(R.id.HomeImage);
        ResetIV=findViewById(R.id.ResetImage);
        PlayerHandIV=findViewById(R.id.PlayImg1);
        CpuHandV=findViewById(R.id.PlayImg2);
        RockHandIV=findViewById(R.id.RockButtonImg);
        PaperHandIV=findViewById(R.id.PaperButtonImg);
        ScissorHandIV=findViewById(R.id.ScissorButtonImg);

        //Animation For Winner Message
        WinnerMsgAnimation=AnimationUtils.loadAnimation(this,R.anim.winner_msg_zoom);


        //Animation for Moving Hands
        HandsZoomAnimation=AnimationUtils.loadAnimation(this,R.anim.hands_move_animation);
        RockHandIV.setAnimation(HandsZoomAnimation);
        PaperHandIV.setAnimation(HandsZoomAnimation);
        ScissorHandIV.setAnimation(HandsZoomAnimation);


       /* Fade_In_Animation=AnimationUtils.loadAnimation(this,R.anim.fade_in);
        animation=AnimationUtils.loadAnimation(this,R.anim.up_down_both);
*/
        tf=Typeface.createFromAsset(getAssets(),"SFSpeedwaystarItalic.ttf");
        YourScoreTv.setTypeface(tf);
        CpuScooreTV.setTypeface(tf);
        YouZeroTv.setTypeface(tf);
        CpuzeroTV.setTypeface(tf);

        tf2=Typeface.createFromAsset(getAssets(),"musicals.ttf");
        WinTV.setTypeface(tf2);

        //listener to go back home
        HomeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PlayActivity.this,FirstPage.class);
                //startActivity(i);
                finish();
            }
        });

        //listener to reset the game
        ResetIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //   WinTV.setAnimation(Fade_In_Animation);
                YouZeroTv.setText(Integer.toString(your_score=0));
                CpuzeroTV.setText(Integer.toString(cpu_score=0));
                PlayerHandIV.setImageResource(R.drawable.imgrock);
                CpuHandV.setImageResource(R.drawable.leftredrockimg);
                WinTV.setText("");
            }
        });

        //listener for Rock
        RockHandIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WinTV.startAnimation(WinnerMsgAnimation);
               // WinTV.setAnimation(Fade_In_Animation);
                PlayerHandIV.setImageResource(R.drawable.imgrock);
                String msg= play_turn("Rock");
                WinTV.setText(msg);
                YouZeroTv.setText(Integer.toString(your_score));
                CpuzeroTV.setText(Integer.toString(cpu_score));
                PlayMsgTv.setText("");

            }
        });

        //listener for Paper
        PaperHandIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WinTV.startAnimation(WinnerMsgAnimation);
                //WinTV.setAnimation(Fade_In_Animation);
                PlayerHandIV.setImageResource(R.drawable.yellowpaperimg);
                String msg= play_turn("Paper");
                WinTV.setText(msg);
                YouZeroTv.setText(Integer.toString(your_score));
                CpuzeroTV.setText(Integer.toString(cpu_score));
                PlayMsgTv.setText("");

            }
        });

        //listener for Scissor
        ScissorHandIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WinTV.startAnimation(WinnerMsgAnimation);
                PlayerHandIV.setImageResource(R.drawable.imgscisor);
                String msg= play_turn("Scissor");
                WinTV.setText(msg);
                YouZeroTv.setText(Integer.toString(your_score));
                CpuzeroTV.setText(Integer.toString(cpu_score));
                PlayMsgTv.setText("");

            }
        });
    }

    public String play_turn(String player_choice)
    {
        String computer_choice ="";
        Random r=new Random();

        int computer_choice_number=r.nextInt(3) +1;
        if(computer_choice_number == 1)
        {
            computer_choice="Rock";
        }
        else if(computer_choice_number == 2)
        {
            computer_choice="Paper";
        }
        else if(computer_choice_number == 3)
        {
            computer_choice="Scissor";
        }

        if(computer_choice == "Rock")
        {
            CpuHandV.setImageResource(R.drawable.leftredrockimg);
        }
        else if(computer_choice == "Paper")
        {
            CpuHandV.setImageResource(R.drawable.leftyellowpaperimg);
        }
        else if(computer_choice == "Scissor")
        {
            CpuHandV.setImageResource(R.drawable.leftblueimgscisor);
        }


        //Who wins The Game

        if(computer_choice == player_choice)
        {
            return"TIE";
        }
        else if(player_choice =="Rock" && computer_choice =="Scissor")
        {
            your_score++;
            return"You Win";
        }
        else if(player_choice =="Rock" && computer_choice =="Paper")
        {
            cpu_score++;
            return "Cpu Win";
        }
        else if(player_choice =="Paper" && computer_choice =="Rock")
        {
            your_score++;
            return"You Win";
        }
        else if(player_choice =="Paper" && computer_choice =="Scissor")
        {
            cpu_score++;
            return "Cpu Win";
        }
        else if(player_choice =="Scissor" && computer_choice =="Paper")
        {
            your_score++;
            return"You Win";
        }
        else if(player_choice =="Scissor" && computer_choice =="Rock")
        {
            cpu_score++;
            return "Cpu Win";
        }

        else return "Not Sure";
    }
}
