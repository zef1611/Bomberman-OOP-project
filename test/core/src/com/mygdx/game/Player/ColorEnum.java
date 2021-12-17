package com.mygdx.game.Player;

public enum ColorEnum {
    BLACK("black"), BLUE("blue"), GREEN("green"), RED("red"), WHITE("white");
    String colorName;
    ColorEnum(String colorName){
        this.colorName = colorName;
    }
    @Override
    public String toString(){
        return colorName;
    }
}
