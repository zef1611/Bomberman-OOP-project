package com.mygdx.game.Enemies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.StateEnum;

public class EnemyAnimation {
    Enemy enemy;
    TextureAtlas enemyAtlas;

    EnemyAnimation(Enemy enemy, TextureAtlas enemyAtlas){
        this.enemy = enemy;
        this.enemyAtlas = enemyAtlas;
    }

    public void updateAni(){
        enemy.setElapsedTime(0);
        DirectionEnum directionEnum = enemy.getDirection();
        StateEnum stateEnum  = enemy.getState();
        String direction = (enemy.getDirection() == DirectionEnum.RIGHT)
                ? DirectionEnum.LEFT.toString() : directionEnum.toString();
        String state = stateEnum.toString();
        String region = state+"_"+direction;
        System.out.println(region);
        enemy.setCurrentAni(new Animation<>(1f/6f,
                enemyAtlas.findRegions(region)));
    }
}
