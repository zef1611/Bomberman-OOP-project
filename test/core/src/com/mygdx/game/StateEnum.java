package com.mygdx.game;

public enum StateEnum {
    WALK("walk"), STILL("still"), HWALK("hwalk"), HSTILL("hstill"), DEATH("defeat");
    String stateName;
    StateEnum(String stateName){
        this.stateName = stateName;
    }
    @Override
    public String toString(){
        return stateName;
    }
}
