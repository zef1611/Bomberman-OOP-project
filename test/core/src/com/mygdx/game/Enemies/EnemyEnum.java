package com.mygdx.game.Enemies;

public enum EnemyEnum {
    NINJA_RED("ninja_red"),
    NINJA_BLUE("ninja_blue"),
    NINJA_GREEN("ninja_red"),
    ALIEN("alien"),
    SKUNK("skunk"),
    POLICE("police"),
    CAVEMAN("caveman");
    String enemyName;
    EnemyEnum(String enemyName){
        this.enemyName = enemyName;
    }
    @Override
    public String toString(){
        return enemyName;
    }
}
