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

public class Shop extends AppCompatActivity {

    Button shopBackBtn, moreTimeBtn, pointDoublerBtn, moreBtnClicksBtn;
    TextView shopPoints;
    private int points, currentStage;
    private boolean moreTime, moreBtnClicks, pointDoubler;
    private Context context;
    private long timeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        context = getApplicationContext();

        moreTime = false;
        moreBtnClicks = false;
        pointDoubler = false;
        Intent getPts = getIntent();
        points = (getPts.getIntExtra("Points", 0));
        currentStage = (getPts.getIntExtra("Current Stage", 0));
        timeLeft = (getPts.getLongExtra("Timer Time", 0));

        shopBackBtn = findViewById(R.id.shopBack);
        moreTimeBtn = findViewById(R.id.moreTime);
        pointDoublerBtn = findViewById(R.id.pointDoubler);
        moreBtnClicksBtn = findViewById(R.id.moreBtnClicks);

        shopPoints = findViewById(R.id.shopPoints);
        shopPoints.setText("Points: " + points);

        moreTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (points >= 3) {
                    moreTime = true;
                    updatePoints();
                } else {
                    Toast.makeText(context, "Not enough points!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        pointDoublerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (points >= 3) {
                    pointDoubler = true;
                    updatePoints();
                } else {
                    Toast.makeText(context, "Not enough points!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        moreBtnClicksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (points >= 3) {
                    moreBtnClicks = true;
                    updatePoints();
                } else {
                    Toast.makeText(context, "Not enough points!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        shopBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent(Shop.this, EasyMode.class);
                goBack.putExtra("Points", points);
                goBack.putExtra("Current Stage", currentStage);
                goBack.putExtra("More Time", moreTime);
                goBack.putExtra("Point Doubler", pointDoubler);
                goBack.putExtra("More Btn Clicks", moreBtnClicks);
                goBack.putExtra("More Time", moreTime);
                goBack.putExtra("Timer Time", timeLeft);
                System.out.println(timeLeft + "JERE ");
                startActivity(goBack);
            }
        });

    }
    private void updatePoints(){
        Toast.makeText(context, "Purchased item!", Toast.LENGTH_SHORT).show();
        points-=3;
        shopPoints.setText("Points: " + points);
    }
}