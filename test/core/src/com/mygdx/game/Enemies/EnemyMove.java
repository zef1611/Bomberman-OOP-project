package com.mygdx.game.Enemies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Stage.Soft;

public class EnemyMove {
    Enemy enemy;
    GameStage gameStage;
    EnemyAnimation enemyAnimation;

    public EnemyMove(Enemy enemy, TextureAtlas enemyAtlas,GameStage gameStage){
        this.enemy = enemy;
        this.gameStage = gameStage;
        enemyAnimation = new EnemyAnimation(enemy, enemyAtlas);
        movement();
    }

    public void movement(){
        System.out.println(enemy.getCurrentAction().isComplete());
        while(enemy.isAlive() && enemy.getCurrentAction().isComplete()){
            switch (enemy.getDirection()){
                case LEFT:
                case RIGHT:
                    horizontalMove();
                    break;
                case UP:
                case DOWN:
                    verticalMove();
                    break;
            }
        }
    }

    public void horizontalMove(){
        for (Soft s: gameStage.getListSoft()){
            if(enemy.getDirection() == DirectionEnum.LEFT){
                if(enemy.getX() - 1 < (s.getBorderX() + s.getBorderWidth())) {
                    enemy.setDirection(DirectionEnum.RIGHT);
                }
            }
            if(enemy.getDirection() == DirectionEnum.RIGHT){
                if(enemy.getX() - 1 < (s.getBorderX() + s.getBorderWidth())){
                    enemy.setDirection(DirectionEnum.RIGHT);
                }
            }
        }
//        System.out.println(enemy.currentAction.isComplete());
        if(enemy.currentAction.isComplete()){
            MoveByAction action = new MoveByAction();

            if(enemy.getDirection() == DirectionEnum.LEFT){
                action.setAmount(-64f, 0f);
            }
            if(enemy.getDirection() == DirectionEnum.LEFT){
                action.setAmount(64f, 0f);
            }

            action.setDuration(1f/2f);
            enemy.setCurrentAction(action);
            enemy.addAction(action);
            System.out.println(enemy.getX());
            System.out.println(enemy.getDirection());
            enemyAnimation.updateAni();
        }
    }

    public void verticalMove(){

    }
}
