package com.mygdx.game.Enemies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.DirectionEnum;

public class EnemyAnimation {
    Enemy enemy;
    TextureAtlas enemyAtlas;

    EnemyAnimation(Enemy enemy){
        this.enemy = enemy;
        enemyAtlas = enemy.getEnemyAtlas();
        updateAni();
    }

    public void updateAni(){
        enemy.setElapsedTime(0);
        String direction = (enemy.getDirection() == DirectionEnum.RIGHT)
                ? DirectionEnum.LEFT.toString() : enemy.getDirection().toString();
        String state = enemy.getState().toString();
        String region = state+"_"+direction;
        enemy.setCurrentAni(new Animation<>(1f/8f, enemyAtlas.findRegions(region)));
    }
}
