package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class LevelOneActivity extends AppCompatActivity implements View.OnClickListener{
    TextView display, goalDisplay, buttonClickCounter, constraintDisplay, levelDisplay; //add a TextView for the number that the use has to reach
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSubtract, btnMultiply, btnDivide, btnCalculate;

    private int clickCounter = 0;
    private String displayLabel = "";
    private int level = 1;



    private double goalOne = 64.0;
    private double goalTwo = 55.0;
    private double goalThree = 169.0;
    private double goalFour = 267.0;
    private double goalFive = 12.0;

    private boolean goalOneA = false;
    private boolean goalTwoA = false;
    private boolean goalThreeA = false;
    private boolean goalFourA = false;
    private boolean goalFiveA = false;

    private int goalOneClick = 3;
    private int goalTwoClick = 4;
    private int goalThreeClick = 5;
    private int goalFourClick = 6;
    private int goalFiveClick = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

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

        goalOneRun();
    }

    private void goalOneRun(){
        clickCounter = 0;
        goalDisplay.setText("Goal: " + goalOne);
        constraintDisplay.setText("Three Buttons");
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
    }

    private void goalTwoRun(){
        clickCounter = 0;
        displayLabel = "";
        goalDisplay.setText("Goal: " + goalTwo);
        constraintDisplay.setText("Four Buttons");
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
        level++;
        levelDisplay.setText("Level: " + level);
    }

    private void goalThreeRun(){
        clickCounter = 0;
        displayLabel = "";
        goalDisplay.setText("Goal: " + goalThree);
        constraintDisplay.setText("5 Buttons");
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
        level++;
        levelDisplay.setText("Level: " + level);
    }

    private void goalFourRun(){
        clickCounter = 0;
        displayLabel = "";
        goalDisplay.setText("Goal: " + goalFour);
        constraintDisplay.setText("Use Addition with 5 Button Presses");
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
        level++;
        levelDisplay.setText("Level: " + level);
    }

    private void goalFiveRun(){
        clickCounter = 0;
        displayLabel = "";
        goalDisplay.setText("Goal: " + goalFive);
        constraintDisplay.setText("3 Buttons");
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
        level++;
        levelDisplay.setText("Level: " + level);
    }

    private void finishScreen(){
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
    }

    @Override
    public void onClick(View view) {
        Context context = getApplicationContext();
        CharSequence keystrokeOver = "Too many Button Presses!";
        CharSequence sillyGoose = "I said Addition you silly goose :)";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, keystrokeOver, duration);
        Toast fgd = Toast.makeText(context, sillyGoose, duration);

        Context contextTwo = getApplicationContext();
        CharSequence textOver = "Goal Overshot!";
        CharSequence textUnder = "Goal Undershot!";
        int durationTwo = Toast.LENGTH_SHORT;

        Toast underShot = Toast.makeText(contextTwo, textUnder, durationTwo);
        Toast overShot = Toast.makeText(contextTwo, textOver, durationTwo);

        switch (view.getId()){
            case R.id.buttonOne:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("1");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonTwo:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("2");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonThree:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("3");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonFour:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("4");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonFive:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("5");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonSix:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("6");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonSeven:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("7");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonEight:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("8");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonNine:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("9");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonAdd:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("+");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    if (clickCounter > goalFourClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonSubtract:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("-");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    fgd.show();
                    displayLabel = "";
                    display.setText(displayLabel);
                    clickCounter = 0;
                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonMultiply:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("×");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    fgd.show();
                    displayLabel = "";
                    display.setText(displayLabel);
                    clickCounter = 0;
                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonDivide:
                clickCounter++;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
                displayLabel = displayLabel.concat("÷");
                display.setText(displayLabel);

                if (!goalOneA){
                    if (clickCounter > goalOneClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalTwoA){
                    if (clickCounter > goalTwoClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalThreeA){
                    if (clickCounter > goalThreeClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                } else if (!goalFourA){
                    fgd.show();
                    displayLabel = "";
                    display.setText(displayLabel);
                    clickCounter = 0;
                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
                } else if (!goalFiveA){
                    if (clickCounter > goalFiveClick){
                        toast.show();
                        displayLabel = "";
                        display.setText(displayLabel);
                        clickCounter = 0;
                        buttonClickCounter.setText("Button Clicks: " + clickCounter);
                    }
                }

                break;
            case R.id.buttonCalculate:
                String expEval = display.getText().toString();

                expEval = expEval.replaceAll("×", "*");
                expEval = expEval.replaceAll("÷", "/");

                Expression exp = new Expression(expEval);

                String resultS = String.valueOf(exp.calculate());
                double result = Double.parseDouble(resultS);

                if (!goalOneA){
                    if (result == goalOne){
                        goalOneA = true;
                        goalTwoRun();
                    } else {
                        if (result > goalOne){
                            overShot.show();
                        } else {
                            underShot.show();
                        }

                        displayLabel = "";
                        clickCounter = 0;
                    }

                    display.setText(displayLabel);
                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
                } else if (!goalTwoA){
                    if (result == goalTwo){
                        goalTwoA = true;
                        goalThreeRun();
                    } else {
                        if (result > goalTwo){
                            overShot.show();
                        } else {
                            underShot.show();
                        }

                        displayLabel = "";
                        clickCounter = 0;
                    }

                    display.setText(displayLabel);
                    buttonClickCounter.setText("Button clicks: " + clickCounter);
                } else if (!goalThreeA){
                    if (result == goalThree){
                        goalThreeA = true;
                        goalFourRun();
                    } else {
                        if (result > goalThree){
                            overShot.show();
                        } else {
                            underShot.show();
                        }

                        displayLabel = "";
                        clickCounter = 0;
                    }

                    display.setText(displayLabel);
                    buttonClickCounter.setText("Button clicks: " + clickCounter);
                } else if (!goalFourA){
                    if (result == goalFour){
                        goalFourA = true;
                        goalFiveRun();
                    } else {
                        if (result > goalFour){
                            overShot.show();
                        } else {
                            underShot.show();
                        }

                        displayLabel = "";
                        clickCounter = 0;
                    }

                    display.setText(displayLabel);
                    buttonClickCounter.setText("Button Clicks: " + clickCounter);
                } else if (!goalFiveA){
                    if (result == goalFive){
                        goalFiveA = true;
                        finishScreen();
                    } else {
                        if (result > goalFive){
                            overShot.show();
                        } else {
                            underShot.show();
                        }
                    }
                }

                break;
        }
    }
}