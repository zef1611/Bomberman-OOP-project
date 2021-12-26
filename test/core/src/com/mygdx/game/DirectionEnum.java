package com.mygdx.game;

public enum DirectionEnum {
    LEFT("left"), RIGHT("right"), UP("up"), DOWN("down"), NONE("none");
    String directionName;
    DirectionEnum(String directionName){
        this.directionName = directionName;
    }
    @Override
    public String toString(){
        return directionName;
    }
}
