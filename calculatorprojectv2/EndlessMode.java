package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;

import java.util.ArrayList;

public class EndlessMode extends AppCompatActivity {
    TextView txtViewDisplay, txtViewGoal, txtViewClickCounter, txtViewLevel, txtViewPoints, txtViewEndDisplay, txtViewTimer, txtViewOperation; //add a TextView for the number that the use has to reach
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSubtract, btnMultiply, btnDivide, btnCalculate, btn0, btnDecimal, btnNegative, btnClear, btnShop, btnMenu, btnEndless;

    private int clickCounter = 0;
    private int totalClicks = 0;
    private String displayLabel = "";

    private int points = 10;


    //FROM 0-4, TO MATCH WITH ALLSTAGES ARRAYLIST (CHANGE LATER MAYBE IDK, BUT EASIER TO MATCH WITH ARRAYLIST FOR NOW)
    private int currentStage = -1;

    private String highScoreText;

    private ArrayList<Stage> allStages = new ArrayList<>();

    private Context context;
    ;
    private int numSymbolsClicked = 0;




    private int pointMultiplier = 1;

    private boolean endLessModeOn;

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
        context = getApplicationContext();

        Intent highScore = getIntent();
        highScoreText = (highScore.getStringExtra("High Score"));

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

        //^^ The numerical calculator buttons

        btnDecimal.setAlpha(0f);
        btnNegative.setAlpha(0f);
        //^^ For the Click Listener for the Button

        txtViewDisplay = (TextView) findViewById(R.id.display);
        txtViewGoal = (TextView) findViewById((R.id.goalDisplay));
        txtViewClickCounter = (TextView) findViewById(R.id.buttonClickCounter);

        txtViewLevel = (TextView) findViewById(R.id.levelLabel);
        txtViewPoints = (TextView) findViewById(R.id.pointsDisplay);
        txtViewEndDisplay = (TextView) findViewById(R.id.endDisplay);
        txtViewTimer = (TextView) findViewById(R.id.timerDisplay);
        txtViewTimer.setText("");
        //^^ Sets the Displays
        txtViewOperation = (TextView) findViewById(R.id.operationDisplay);
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

                txtViewClickCounter.setText("Clicks Left: " + totalClicks);
            }
        });

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickCounter == 0) {
                    Intent shop = new Intent(EndlessMode.this, Shop.class);
                    shop.putExtra("Points", points);
                    shop.putExtra("Current Stage", currentStage);
                    shop.putExtra("Goal Num", allStages.get(currentStage).getGoal());
                    shop.putExtra("High Score", highScoreText);
                    shop.putExtra("Mode", 3);

                    startActivity(shop);

                } else {
                    Toast.makeText(context, "Finish the stage!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu = new Intent(EndlessMode.this, MainActivity.class);
                menu.putExtra("Points", points);
                menu.putExtra("High Score", highScoreText);
                menu.putExtra("Mode", 3);
                startActivity(menu);


            }
        });

        for (int i=0;i<1000;i++){
            int rand = ((int)(Math.random()*4));

            if (rand == 0){
                allStages.add(new Stage(10 + Math.floor(Math.random() * 89), 5));
            } else if (rand == 1){
                allStages.add(new Stage(100 + Math.floor(Math.random() * 899), 6));
            } else if (rand == 2){
                allStages.add(new Stage(1000 + Math.floor(Math.random() * 8999), 7));
            } else {
                allStages.add(new Stage(10000 + Math.floor(Math.random() * 89999), 8));
            }
        }




        currentStage++;
        setStuff();
        Intent getShopValues = getIntent();
        reSetUIValues(getShopValues.getIntExtra("Points", 10), getShopValues.getIntExtra("Current Stage", 0),  getShopValues.getDoubleExtra("Goal Num", 0));
        applyPowerups(getShopValues.getBooleanExtra("Point Doubler", false), getShopValues.getBooleanExtra("More Btn Clicks", false));


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

    private void applyPowerups(boolean pointDoubler, boolean moreBtnClicks ) {
        if (pointDoubler) {
            pointMultiplier = 2;
        }

        if (moreBtnClicks) {
            allStages.get(currentStage).setClicks(allStages.get(currentStage).getClicks() + 2);
            totalClicks = allStages.get(currentStage).getClicks();

            txtViewClickCounter.setText("Clicks Left: " + totalClicks);

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


        operation = operations.get((int)(Math.random()*4));

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
            currentStage++;
            setStuff();
            Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show();
            points += currentStage * pointMultiplier;
            txtViewPoints.setText("Points: " + points);
        } else {
            System.out.println(result + "RESULT");
            if (result > allStages.get(currentStage).getGoal()) {
                Toast.makeText(context, "Goal Overshot!", Toast.LENGTH_SHORT).show();
            } else if (result < allStages.get(currentStage).getGoal()) {
                Toast.makeText(context, "Goal Undershot!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "That's the same number!", Toast.LENGTH_SHORT).show();
            }

            displayLabel = "";
            clickCounter = 0;
            points--;
            txtViewPoints.setText("Points: " + points);

        }

        if (!allStages.get(4).getAchievedGoal()) {
            txtViewDisplay.setText(displayLabel);
            txtViewClickCounter.setText("Clicks Left: " + (totalClicks - clickCounter));

        }
    }
}