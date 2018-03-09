package com.vijay.rockpaperscissor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HowToPlayActivity extends AppCompatActivity {

    private TextView Rule1TV,Rule2TV,Rule3TV,Rule4TV,Win1TV,Win2TV,Win3TV,DrawTV;
    private ImageView RedRock1IV,RedRock2IV,YellowPaper1IV,YellowPaper2IV,BlueScissor1IV,BlueScissor2IV,
    Draw1IV,Draw2IV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        //Rules TextView
        Rule1TV=findViewById(R.id.Rule1TV);
        Rule2TV=findViewById(R.id.Rule2TV);
        Rule3TV=findViewById(R.id.Rule3TV);

        //Winners TextView
        Win1TV=findViewById(R.id.RockWinnerTV);
        Win2TV=findViewById(R.id.PaperWinnerTV);
        Win3TV=findViewById(R.id.ScissorWinnerTV);

        //Draw TextView
        Rule4TV=findViewById(R.id.Rule4TV);
        DrawTV=findViewById(R.id.DrawTV);

        //Rules Left Side ImageView
        RedRock1IV=findViewById(R.id.Rule1RockIV);
        YellowPaper1IV=findViewById(R.id.Rule2PaperIV);
        BlueScissor1IV=findViewById(R.id.Rule3ScissorIV);

        //Rules Right Side ImageView
        BlueScissor2IV=findViewById(R.id.Rule1RightScissorIV);
        RedRock2IV=findViewById(R.id.Rule2RightRockIV);
        YellowPaper2IV=findViewById(R.id.Rule3RightPaperIV);

        //Draw ImageView
        Draw1IV=findViewById(R.id.Rule4SameIV);
        Draw2IV=findViewById(R.id.Rule4RightSameIV);

    }
}
