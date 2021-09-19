package com.example.calculatorprojectv2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mainButton, buttonEasy, buttonMedium, buttonHard, buttonEndless;
    TextView instructionsLabel;

    //0,1,2
    int difficulty = -1;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

//        Animation animationIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
//        Animation animationOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        //^^Fade in and Fade out animation through XML files

        mainButton = (Button) findViewById(R.id.mainButton);
        buttonEndless = (Button) findViewById(R.id.endlessButton);
        buttonEasy = (Button) findViewById(R.id.buttonEasy);
        buttonMedium = (Button) findViewById(R.id.buttonMedium);
        buttonHard = (Button) findViewById(R.id.buttonHard);

        instructionsLabel = (TextView) findViewById(R.id.instructionLabelOne);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (difficulty==-1){
                    instructionsLabel.setText("Please select a difficulty");
                } else if (difficulty == 0){
                    openEasyMode();
                } else if (difficulty == 1){
                    openMediumMode();
                } else if (difficulty == 2){
                    openHardMode();
                } else {
                    openEndlessMode();
                }
            }
        });



        buttonEasy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                difficulty = 0;
                instructionsLabel.setText("Easy mode selected");
            }
        });

        buttonMedium.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                difficulty = 1;
                instructionsLabel.setText("Medium mode selected");
            }
        });

        buttonHard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                difficulty = 2;
                instructionsLabel.setText("Hard mode selected");
            }
        });

        buttonEndless.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                difficulty = 3;
                instructionsLabel.setText("Endless mode selected");
            }
        });
    }

    protected AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
    protected AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);

    private void fadeAnimation(TextView input){
        input.startAnimation(fadeIn);
        input.startAnimation(fadeOut);
        fadeIn.setDuration(1000);
        fadeOut.setDuration(1000);
        fadeIn.setFillAfter(true);
        fadeOut.setFillAfter(true);
        fadeOut.setStartOffset(4200 + fadeIn.getStartOffset());
    }
    //^^ Fade animation (play around with later)

    public void openEasyMode(){
        Intent intent = new Intent(this, EasyMode.class);
        startActivity(intent);
    }

    public void openMediumMode(){
        Intent intent = new Intent(this, MediumMode.class);
        startActivity(intent);
    }

    public void openHardMode(){
//        Intent intent = new Intent(this, HardMode.class);
//        startActivity(intent);
    }

    public void openEndlessMode(){
        Intent intent = new Intent(this, EndlessMode.class);
        startActivity(intent);
    }


    public int getDifficulty(){
        return difficulty;
    }

}