package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mainButton, buttonEasy, buttonHard, buttonEndless;
    TextView instructionsLabel, highScoreLabel;

    //0,1,2
    private int difficulty = -1;
    private Context context;
    private int points;
    private static final String FILE_NAME = "highscores.txt";

    private String highScoreTxt;

    private int mode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        Intent getPts = getIntent();
        points = (getPts.getIntExtra("Points", 0));
        highScoreTxt = getPts.getStringExtra("High Score");
        mode = getPts.getIntExtra("Mode", 0);
        String m = "";

        if (mode == 1){
            m = "Easy Mode";
        } else if (mode == 2){
            m = "Hard Mode";
        } else if (mode == 3){
            m = "Endless Mode";
        }

//        Animation animationIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
//        Animation animationOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        //^^Fade in and Fade out animation through XML files

        mainButton = (Button) findViewById(R.id.mainButton);
        buttonEndless = (Button) findViewById(R.id.buttonEndless);
        buttonEasy = (Button) findViewById(R.id.buttonEasy);
        buttonHard = (Button) findViewById(R.id.buttonHard);

        instructionsLabel = (TextView) findViewById(R.id.instructionLabelOne);
        highScoreLabel= (TextView) findViewById(R.id.highScoreLabel);

        if (points>0 && !highScoreTxt.contains(points+"")){
            highScoreLabel.setText(highScoreTxt + " \n•" + m + ": " + points);
        } else{
            highScoreLabel.setText(highScoreTxt);
        }

        if (highScoreTxt == null){
            highScoreLabel.setText("Scores:");
        }

        mainButton.setAlpha(.3f);


        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (difficulty == 0){
                    openEasyMode();
                } else if (difficulty == 1){
                    openHardMode();
                } else if (difficulty == 2){
                    openEndlessMode();
                }
            }
        });

        buttonEasy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                difficulty = 0;
                instructionsLabel.setText("Easy mode selected");
                mainButton.setAlpha(1f);
                mainButton.setEnabled(true);
            }
        });

        buttonHard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                difficulty = 1;
                instructionsLabel.setText("Hard mode selected");
                mainButton.setAlpha(1f);
                mainButton.setEnabled(true);
            }
        });

        buttonEndless.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                difficulty = 2;
                instructionsLabel.setText("Endless mode selected");
                mainButton.setAlpha(1f);
                mainButton.setEnabled(true);
            }
        });
    }

    protected AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
    protected AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);


//    public void saveScores(View v){
//        String score = Math.random()*10 + "";
//        FileOutputStream fos = null;
//
//        try {
//            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
//            fos.write(score.getBytes());
//
//            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fos != null){
//                try {
//                    fos.close();
//                } catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//
//
//    public void load(View v){
//        FileInputStream fis = null;
//
//        try {
//            fis = openFileInput(FILE_NAME);
//            InputStreamReader isr = new InputStreamReader(fis);
//            BufferedReader br = new BufferedReader(isr);
//            StringBuilder sb = new StringBuilder();
//            String text;
//
//            while ((text = br.readLine()) != null) {
//                sb.append(text).append("\n");
//            }
//
//            instructionsLabel.setText(sb.toString());
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null){
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }



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
        intent.putExtra("High Score", highScoreLabel.getText());
        startActivity(intent);
    }

    public void openHardMode(){
        Intent intent = new Intent(this, HardMode.class);
        intent.putExtra("High Score", highScoreLabel.getText());
        startActivity(intent);
    }

    public void openEndlessMode(){
        Intent intent = new Intent(this, EndlessMode.class);
        intent.putExtra("High Score", highScoreLabel.getText());
        startActivity(intent);
    }


    public int getDifficulty(){
        return difficulty;
    }

}