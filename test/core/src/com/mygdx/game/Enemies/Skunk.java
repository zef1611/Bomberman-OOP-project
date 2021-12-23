package com.mygdx.game.Enemies;

public class Skunk extends Enemy{

    Skunk(int stageNum, int x, int y) {
        super(stageNum);
        super.setName(EnemyEnum.SKUNK);
        switchAtlas();
    }
}
