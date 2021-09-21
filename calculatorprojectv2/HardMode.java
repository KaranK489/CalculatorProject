package com.example.calculatorprojectv2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;

public class HardMode extends AppCompatActivity {
    TextView txtViewDisplay, txtViewGoal, txtViewClickCounter, txtViewLevel, txtViewPoints, txtViewTimer, txtViewEndDisplay, txtViewOperation; //add a TextView for the number that the use has to reach
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSubtract, btnMultiply, btnDivide, btnCalculate, btn0, btnDecimal, btnNegative, btnClear, btnShop, btnMenu;

    private int clickCounter = 0;
    private int totalClicks = 0;
    private String displayLabel = "";

    private int points = 10;


    //FROM 0-4, TO MATCH WITH ALLSTAGES ARRAYLIST (CHANGE LATER MAYBE IDK, BUT EASIER TO MATCH WITH ARRAYLIST FOR NOW)
    private int currentStage = -1;

    private ArrayList<Stage> allStages = new ArrayList<>();


    private Context context;
    ;
    private int numSymbolsClicked = 0;

    private long timeLeftMS = 80000;


    private int pointMultiplier = 1;


    private boolean endLessModeOn;

    private String highScoreText;

    CountDownTimer timer;

    ArrayList<String> operations = new ArrayList<>();

    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);

        operations.add("Addition");
        operations.add("Subtraction");
        operations.add("Multiplication");
        operations.add("Division");


        Intent highScore = getIntent();
        highScoreText = (highScore.getStringExtra("High Score"));

        context = getApplicationContext();

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
        btnClear = (Button) findViewById(R.id.buttonClear);
        btnShop = (Button) findViewById(R.id.buttonShop);
        btnMenu = (Button) findViewById(R.id.buttonMenu);

        btnClear.setEnabled(false);
        btnClear.setAlpha(.3f);

        //^^ The numerical calculator buttons
        btnDecimal.setAlpha(0f);
        btnNegative.setAlpha(0f);

        //^^ For the Click Listener for the Button

        txtViewDisplay = (TextView) findViewById(R.id.display);
        txtViewGoal = (TextView) findViewById((R.id.goalDisplay));
        txtViewClickCounter = (TextView) findViewById(R.id.buttonClickCounter);

        txtViewLevel = (TextView) findViewById(R.id.levelLabel);
        txtViewPoints = (TextView) findViewById(R.id.pointsDisplay);
        txtViewTimer = (TextView) findViewById(R.id.timerDisplay);
        txtViewEndDisplay = (TextView) findViewById(R.id.endDisplay);
        txtViewOperation = (TextView) findViewById(R.id.operationDisplay);
        //^^ Sets the Displays

        txtViewPoints.setText("Points: " + points);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("0");

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("1");

            }
        });


//        btn1.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View view, MotionEvent event) {
//                if(event.getAction() == MotionEvent.ACTION_UP) {
//                    btn1.setBackgroundColor(Color.RED);
//                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
//                    btn1.setBackgroundColor(Color.BLUE);
//                }
//                return false;
//            }
//
//        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("2");

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("3");

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("4");

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("5");

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("6");

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("7");

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("8");

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("9");

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("+");

            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("-");

            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("×");

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("÷");

            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayLabel = "";
                txtViewDisplay.setText(displayLabel);
                totalClicks = allStages.get(currentStage).getClicks();
                clickCounter = 0;
//                if (!timerRunning) {
//                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
//                    chronometer.start();
//                    timerRunning = true;
//                }
                txtViewClickCounter.setText("Clicks Left: " + totalClicks);
            }
        });

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickCounter == 0) {
                    timer.cancel();
                    Intent shop = new Intent(HardMode.this, Shop.class);
                    shop.putExtra("Points", points);
                    shop.putExtra("Current Stage", currentStage);
                    shop.putExtra("Timer Time", timeLeftMS);
                    shop.putExtra("Goal Num", allStages.get(currentStage).getGoal());
                    shop.putExtra("High Score", highScoreText);
                    shop.putExtra("Mode", 2);
                    startActivity(shop);

                } else {
                    Toast.makeText(context, "Finish the stage!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                Intent menu = new Intent(HardMode.this, MainActivity.class);
                menu.putExtra("Points", points);
                menu.putExtra("High Score", highScoreText);
                menu.putExtra("Mode", 2);
                startActivity(menu);


            }
        });



        allStages.add(new Stage(100 + Math.floor(Math.random() * 899), 5));
        allStages.add(new Stage(1000 + Math.floor(Math.random() * 8999), 6));
        allStages.add(new Stage(1000 + Math.floor(Math.random() * 8999), 6));
        allStages.add(new Stage(10000 + Math.floor(Math.random() * 89999), 7));
        allStages.add(new Stage(10000 + Math.floor(Math.random() * 89999), 7));
        allStages.add(new Stage(100000 + Math.floor(Math.random() * 899999), 8));

        System.out.println("Original" + timeLeftMS);

        currentStage++;
        setStuff();
        Intent getShopValues = getIntent();
        reSetUIValues(getShopValues.getIntExtra("Points", 10), getShopValues.getIntExtra("Current Stage", 0),  getShopValues.getDoubleExtra("Goal Num", 0));
        applyPowerups(getShopValues.getBooleanExtra("Point Doubler", false), getShopValues.getBooleanExtra("More Btn Clicks", false), getShopValues.getBooleanExtra("More Time", false));
        timeLeftMS = getShopValues.getLongExtra("Timer Time", 80000);

        boolean moreTime = getShopValues.getBooleanExtra("More Time", false);

        if (moreTime){
            timeLeftMS+=30000;
        }

        txtViewTimer.setTextColor(Color.GREEN);

        timer = new CountDownTimer(timeLeftMS, 1000) {

            public void onTick(long millisUntilFinished) {


                String v = String.format("%02d", millisUntilFinished / 60000);
                int va = (int) ((millisUntilFinished % 60000) / 1000);
                txtViewTimer.setText(v + ":" + String.format("%02d", va));

                timeLeftMS -= 1000;
                System.out.println(timeLeftMS);

                if (timeLeftMS<=30000){
                    txtViewTimer.setTextColor(Color.parseColor("#e5e80c"));
                }

                if (timeLeftMS<=20000){
                    txtViewTimer.setTextColor(Color.parseColor("#ff8c00"));
                }
                if (timeLeftMS<=10000){
                    txtViewTimer.setTextColor(Color.parseColor("#ff0d00"));
                }
            }

            public void onFinish() {
                failScreen();
            }
        };

        timer.start();


    }

    private void failScreen(){
        timer.cancel();
        displayLabel = "";
        txtViewEndDisplay.setText("You Lost!");
        txtViewGoal.setVisibility(View.GONE);
        txtViewClickCounter.setVisibility(View.GONE);
        txtViewLevel.setVisibility(View.GONE);

        btnMenu.setX(420);
        btnMenu.setY(900);
        btnClear.setVisibility(View.GONE);
        btnShop.setVisibility(View.GONE);

        txtViewTimer.setVisibility(View.GONE);
        txtViewPoints.setVisibility(View.GONE);
        txtViewOperation.setVisibility(View.GONE);

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


    private void reSetUIValues(int Points, int curStage, double goalNum) {
        points = Points;
        currentStage = curStage;
        txtViewPoints.setText("Points: " + points);
        clickCounter = 0;
        txtViewLevel.setText("Stage: " + (currentStage + 1));
        totalClicks = allStages.get(currentStage).getClicks();
        if (goalNum!=0) {
            allStages.get(currentStage).setGoal(goalNum);
            txtViewGoal.setText("Goal: " + (int) goalNum);
        } else {
            txtViewGoal.setText("Goal: " + (int) allStages.get(currentStage).getGoal());
        }
        displayLabel = "";
        txtViewClickCounter.setText("Clicks Left: " + totalClicks);
    }

    private void applyPowerups(boolean pointDoubler, boolean moreBtnClicks, boolean moreTime) {
        if (pointDoubler) {
            pointMultiplier = 2;
        }

        if (moreBtnClicks) {
            allStages.get(currentStage).setClicks(allStages.get(currentStage).getClicks() + 2);
            totalClicks = allStages.get(currentStage).getClicks();

            txtViewClickCounter.setText("Clicks Left: " + totalClicks);

        }

        if (moreTime) {
            timeLeftMS += 30000;
        }

    }

    private void setStuff() {

        btnMultiply.setAlpha(1f);
        btnAdd.setAlpha(1f);
        btnSubtract.setAlpha(1f);
        btnDivide.setAlpha(1f);
        btnMultiply.setEnabled(true);
        btnAdd.setEnabled(true);
        btnSubtract.setEnabled(true);
        btnDivide.setEnabled(true);


        clickCounter = 0;
        txtViewLevel.setText("Stage: " + (currentStage + 1));
        totalClicks = allStages.get(currentStage).getClicks();
        txtViewGoal.setText("Goal: " + (int) allStages.get(currentStage).getGoal());
        displayLabel = "";


        txtViewClickCounter.setText("Clicks Left: " + totalClicks);



        if (allStages.get(currentStage).getGoal()%2==0){
            operation = operations.get((int)(Math.random()*4));
        } else {
            operation = operations.get((int)(Math.random()*2));
        }


        txtViewOperation.setText(operation+ " only");

        if ((!operation.equals("Addition"))){
            btnAdd.setAlpha(.4f);
            btnAdd.setEnabled(false);
        }
        if ((!operation.equals("Subtraction"))){
            btnSubtract.setAlpha(.4f);
            btnSubtract.setEnabled(false);
        }
        if ((!operation.equals("Multiplication"))){
            btnMultiply.setAlpha(.4f);
            btnMultiply.setEnabled(false);
        }
        if ((!operation.equals("Division"))){
            btnDivide.setAlpha(.4f);
            btnDivide.setEnabled(false);
        }
    }

    private void finishScreen() {
        timer.cancel();
        displayLabel = "";
        txtViewEndDisplay.setText("You Won!");
        txtViewGoal.setVisibility(View.GONE);
        txtViewClickCounter.setVisibility(View.GONE);
        txtViewLevel.setVisibility(View.GONE);

        btnMenu.setX(420);
        btnMenu.setY(900);
        btnClear.setVisibility(View.GONE);
        btnShop.setVisibility(View.GONE);
        txtViewTimer.setVisibility(View.GONE);
        txtViewPoints.setVisibility(View.GONE);
        txtViewOperation.setVisibility(View.GONE);


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

    public void buttonClick(String symbol) {

        boolean symbolClicked = symbol.equals("÷") || symbol.equals("×") || symbol.equals("+") || symbol.equals("-");

        if (clickCounter >= totalClicks) {
            Toast.makeText(context, "Out of Clicks!", Toast.LENGTH_SHORT).show();

        } else {

            if (symbolClicked && displayLabel.equals("")) {
                Toast.makeText(context, "Enter a digit first!", Toast.LENGTH_SHORT).show();
            } else if (symbolClicked && numSymbolsClicked == 1) {
                Toast.makeText(context, "Enter a digit!", Toast.LENGTH_SHORT).show();
            } else {

                clickCounter++;
                txtViewClickCounter.setText("Clicks Left: " + (totalClicks - clickCounter));
                displayLabel = displayLabel.concat(symbol);
                txtViewDisplay.setText(displayLabel);

                if (symbolClicked) {
                    numSymbolsClicked++;
                } else {
                    numSymbolsClicked = 0;
                }
            }
        }
    }


    public void calculateResult() {

        String expEval = txtViewDisplay.getText().toString();

        expEval = expEval.replaceAll("×", "*");
        expEval = expEval.replaceAll("÷", "/");

        String onlyDigits = expEval;
        onlyDigits = onlyDigits.replaceAll("\\+", "");
        onlyDigits = onlyDigits.replaceAll("-", "");
        onlyDigits = onlyDigits.replaceAll("\\*", "");
        onlyDigits = onlyDigits.replaceAll("/", "");

        Expression exp = new Expression(expEval);

        String resultS = String.valueOf(exp.calculate());

        double result = Double.parseDouble(resultS);


        if (result == allStages.get(currentStage).getGoal() && result != Double.parseDouble(onlyDigits)) {
            allStages.get(currentStage).setAchievedGoal(true);
            if (currentStage < allStages.size()-1) {
                currentStage++;
                setStuff();
                Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show();
                points += currentStage * pointMultiplier;
                txtViewPoints.setText("Points: " + points);
            } else {
                finishScreen();
            }

        } else {
            if (result > allStages.get(currentStage).getGoal()) {
                Toast.makeText(context, "Goal Overshot!", Toast.LENGTH_SHORT).show();
            } else if (result < allStages.get(currentStage).getGoal()) {
                Toast.makeText(context, "Goal Undershot!", Toast.LENGTH_SHORT).show();
            } else if (Double.parseDouble(onlyDigits) > allStages.get(currentStage).getGoal()){
                Toast.makeText(context, "Goal Overshot!", Toast.LENGTH_SHORT).show();
            } else if (Double.parseDouble(onlyDigits) < allStages.get(currentStage).getGoal()){
                Toast.makeText(context, "Goal Undershot!", Toast.LENGTH_SHORT).show();
            } else  {

                Toast.makeText(context, "That's the same number!", Toast.LENGTH_SHORT).show();
            }


            displayLabel = "";
            clickCounter = 0;
            points--;
            txtViewPoints.setText("Points: " + points);

        }

        if (!allStages.get(allStages.size()-1).getAchievedGoal()) {
            txtViewDisplay.setText(displayLabel);
            txtViewClickCounter.setText("Clicks Left: " + (totalClicks - clickCounter));

        }
    }
}