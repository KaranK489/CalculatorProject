package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;

import java.util.ArrayList;

public class LevelOneActivity extends AppCompatActivity implements View.OnClickListener{
    TextView display, goalDisplay, buttonClickCounter, constraintDisplay, levelDisplay; //add a TextView for the number that the use has to reach
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSubtract, btnMultiply, btnDivide, btnCalculate, btn0, btnDecimal, btnNegative;

    private int clickCounter = 0;
    private int totalClicks = 0;
    private String displayLabel = "";


    //FROM 0-4, TO MATCH WITH ALLSTAGES ARRAYLIST (CHANGE LATER MAYBE IDK, BUT EASIER TO MATCH WITH ARRAYLIST FOR NOW)
    private int currentStage = -1;

    ArrayList<Stage> allStages = new ArrayList<>();

    Context context;;
    CharSequence keystrokeOver;
    CharSequence sillyGoose;
    int duration;
    Toast toast;
    Toast fgd;
    Context contextTwo;
    CharSequence textOver;
    CharSequence textUnder;
    int durationTwo;
    Toast underShot;
    Toast overShot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        context = getApplicationContext();
        keystrokeOver = "Too many Button Presses!";
        sillyGoose = "I said Addition you silly goose :)";
        duration = Toast.LENGTH_SHORT;

        toast = Toast.makeText(context, keystrokeOver, duration);
        fgd = Toast.makeText(context, sillyGoose, duration);

        contextTwo = getApplicationContext();
        textOver = "Goal Overshot!";
        textUnder = "Goal Undershot!";
        durationTwo = Toast.LENGTH_SHORT;

        underShot = Toast.makeText(contextTwo, textUnder, durationTwo);
        overShot = Toast.makeText(contextTwo, textOver, durationTwo);

        btn1 = (Button) findViewById(R.id.buttonOne);
        btn2 = (Button) findViewById(R.id.buttonTwo);
        btn3 = (Button) findViewById(R.id.buttonThree);
        btn4 = (Button) findViewById(R.id.buttonFour);
        btn5 = (Button) findViewById(R.id.buttonFive);
        btn6 = (Button) findViewById(R.id.buttonSix);
        btn7 = (Button) findViewById(R.id.buttonSeven);
        btn8 = (Button) findViewById(R.id.buttonEight);
        btn9 = (Button) findViewById(R.id.buttonNine);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnSubtract = (Button) findViewById(R.id.buttonSubtract);
        btnMultiply = (Button) findViewById(R.id.buttonMultiply);
        btnDivide = (Button) findViewById(R.id.buttonDivide);
        btnCalculate = (Button) findViewById(R.id.buttonCalculate);
        btn0 = (Button) findViewById(R.id.buttonZero);
        btnDecimal = (Button) findViewById(R.id.buttonDecimal);
        btnNegative = (Button) findViewById(R.id.buttonNegative);

        //^^ The numerical calculator buttons

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnCalculate.setOnClickListener(this);
        //^^ For the Click Listener for the Button

        display = (TextView) findViewById(R.id.display);
        goalDisplay = (TextView) findViewById((R.id.goalDisplay));
        buttonClickCounter = (TextView) findViewById(R.id.buttonClickCounter);
        constraintDisplay = (TextView) findViewById(R.id.constraintDisplay);
        levelDisplay = (TextView) findViewById(R.id.levelLabel);
        //^^ Sets the Displays


        allStages.add(new Stage(64, 3));
        allStages.add(new Stage(55, 4));
        allStages.add(new Stage(169, 5));
        allStages.add(new Stage(267, 6));
        allStages.add(new Stage(12, 3));

        System.out.println(allStages.size() + "AKKAKAKAKAK");

        setStuff();
    }

    private void setStuff(){
        clickCounter = 0;
        currentStage++;
        levelDisplay.setText("Stage: " + currentStage);
        totalClicks = allStages.get(currentStage).getClicks();
        goalDisplay.setText("Goal: " + allStages.get(currentStage).getGoal());
        displayLabel = "";
        constraintDisplay.setText("Total Clicks: " + clickCounter);
        buttonClickCounter.setText("Clicks Left: " + totalClicks);
    }

    private void finishScreen(){
        displayLabel = "";
        display.setText("You Beat the Game!");
        constraintDisplay.setVisibility(View.GONE);
        goalDisplay.setVisibility(View.GONE);
        buttonClickCounter.setVisibility(View.GONE);
        levelDisplay.setVisibility(View.GONE);

        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
        btn5.setVisibility(View.GONE);
        btn6.setVisibility(View.GONE);
        btn7.setVisibility(View.GONE);
        btn8.setVisibility(View.GONE);
        btn9.setVisibility(View.GONE);
        btnAdd.setVisibility(View.GONE);
        btnSubtract.setVisibility(View.GONE);
        btnMultiply.setVisibility(View.GONE);
        btnDivide.setVisibility(View.GONE);
        btnCalculate.setVisibility(View.GONE);
        btn0.setVisibility(View.GONE);
        btnDecimal.setVisibility(View.GONE);
        btnNegative.setVisibility(View.GONE);
    }

    public void buttonClick(String symbol){
        clickCounter++;
        buttonClickCounter.setText("Clicks Left: " + (totalClicks - clickCounter));
        displayLabel = displayLabel.concat(symbol);
        display.setText(displayLabel);

        if (clickCounter > allStages.get(currentStage).getClicks()){
            toast.show();
            displayLabel = "";
            display.setText(displayLabel);
            clickCounter = 0;
            buttonClickCounter.setText("Button Clicks: " + clickCounter);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.buttonOne:
                buttonClick("1");
                break;

            case R.id.buttonTwo:
                buttonClick("2");
                break;

            case R.id.buttonThree:
                buttonClick("3");
                break;

            case R.id.buttonFour:
                buttonClick("4");
                break;

            case R.id.buttonFive:
                buttonClick("5");
                break;

            case R.id.buttonSix:
                buttonClick("6");
                break;

            case R.id.buttonSeven:
                buttonClick("7");
                break;

            case R.id.buttonEight:
                buttonClick("8");
                break;

            case R.id.buttonNine:
                buttonClick("9");
                break;

            case R.id.buttonAdd:
                buttonClick("+");

                break;
            case R.id.buttonSubtract:
                buttonClick("-");

                break;
            case R.id.buttonMultiply:
                buttonClick("×");

                break;
            case R.id.buttonDivide:
                buttonClick("÷");

                break;
            case R.id.buttonCalculate:
                calculateResult();
        }
    }


    public void calculateResult(){

        String expEval = display.getText().toString();

        expEval = expEval.replaceAll("×", "*");
        expEval = expEval.replaceAll("÷", "/");

        Expression exp = new Expression(expEval);

        String resultS = String.valueOf(exp.calculate());
        double result = Double.parseDouble(resultS);

            if (result == allStages.get(currentStage).getGoal()){
                allStages.get(currentStage).setAchievedGoal(true);
                if (currentStage<4){
                    setStuff();
                } else {
                    finishScreen();

                }

            } else {
                if (result > allStages.get(currentStage).getGoal()){
                    overShot.show();
                } else {
                    underShot.show();
                }

                displayLabel = "";
                clickCounter = 0;

            }

            if (!allStages.get(4).getAchievedGoal()){
                display.setText(displayLabel);
                buttonClickCounter.setText("Clicks Left: " + (totalClicks - clickCounter));

            }
    }
}