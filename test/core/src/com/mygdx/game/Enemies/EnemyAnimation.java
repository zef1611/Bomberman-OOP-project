package com.mygdx.game.Enemies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.StateEnum;

public class EnemyAnimation {
    private Enemy enemy;
    private TextureAtlas enemyAtlas;

    public EnemyAnimation(Enemy enemy, TextureAtlas enemyAtlas){
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
        enemy.setCurrentAni(new Animation<>(1f/3f,
                enemyAtlas.findRegions(region)));
    }
    public void updateDeathAni(){
        enemy.setElapsedTime(0.5f);
        DirectionEnum directionEnum = enemy.getDirection();
        StateEnum stateEnum  = enemy.getState();
        String direction = (enemy.getDirection() == DirectionEnum.RIGHT)
                ? DirectionEnum.LEFT.toString() : directionEnum.toString();
        String state = stateEnum.toString();
        String region = state+"_"+direction;
        System.out.println(region);

        enemy.setCurrentAni( new Animation<>(1f,
                enemyAtlas.findRegion("defeat_down"),
                enemyAtlas.findRegion("defeat_up"),
                enemyAtlas.findRegion("defeat_left")

        ));
        enemy.setDeadth();
        System.out.println("dead");
    }
}
