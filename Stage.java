package com.example.calculatorprojectv2;

public class Stage {

    double goal;
    boolean achievedGoal = false;
    int clicks;

    public Stage(double n, int c){
        goal = n;
        clicks = c;
    }

    public int getClicks(){
        return clicks;
    }

    public double getGoal(){
        return goal;
    }

    public void setAchievedGoal(boolean a){
        achievedGoal = a;
    }

    public boolean getAchievedGoal(){
        return achievedGoal;
    }
}
