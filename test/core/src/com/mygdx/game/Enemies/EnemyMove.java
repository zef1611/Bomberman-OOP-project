package com.mygdx.game.Enemies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Screen.MainGameScreen;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Stage.Soft;

public class EnemyMove {
    private Enemy enemy;
    private GameStage gameStage;
    private EnemyAnimation enemyAnimation;

    public EnemyMove(Enemy enemy, TextureAtlas enemyAtlas,GameStage gameStage){
        this.enemy = enemy;
        this.gameStage = gameStage;
        enemyAnimation = new EnemyAnimation(enemy, enemyAtlas);
    }

    public void movement(){
        if(enemy.getCurrentAction().isComplete()) {
            switch (enemy.getDirection()) {
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
        checkSoft();
        checkBorder();
        if(enemy.currentAction.isComplete()){
            MoveByAction action = new MoveByAction();

            if(enemy.getDirection() == DirectionEnum.LEFT){
                action.setAmount(-64f, 0f);
            }
            if(enemy.getDirection() == DirectionEnum.RIGHT){
                action.setAmount(64f, 0f);
            }
            action.setDuration(1f/2f);
            enemy.setCurrentAction(action);
            enemy.addAction(action);
            enemyAnimation.updateAni();
        }
    }

    public void verticalMove(){
        checkSoft();
        checkBorder();

        if(enemy.currentAction.isComplete()){
            MoveByAction action = new MoveByAction();

            if(enemy.getDirection() == DirectionEnum.DOWN){
                action.setAmount(0f, -64f);
            }
            if(enemy.getDirection() == DirectionEnum.UP){
                action.setAmount(0f, 64f);
            }
            action.setDuration(1f/2f);
            enemy.setCurrentAction(action);
            enemy.addAction(action);
            enemyAnimation.updateAni();
        }
    }

    private void checkSoft(){
        for (Soft s: gameStage.getListSoft()){
            if(enemy.getDirection() == DirectionEnum.DOWN){
                if(enemy.getY() - 63 < (s.getBorderY() + s.getBorderHeight())
                        && enemy.getY() - 63 > s.getBorderY()
                        && Math.round(enemy.getX()) == s.getBorderX()) {
                    enemy.setDirection(DirectionEnum.UP);
                    break;
                }
            }
            if(enemy.getDirection() == DirectionEnum.UP){
                if(enemy.getY() + 65 < (s.getBorderY() + s.getBorderHeight())
                        && enemy.getY() + 65 > s.getBorderY()
                        && Math.round(enemy.getX()) == s.getBorderX()){
                    enemy.setDirection(DirectionEnum.DOWN);
                    break;
                }
                System.out.println("************************");
            }
            if(enemy.getDirection() == DirectionEnum.LEFT){
                if(enemy.getX() - 63 < (s.getBorderX() + s.getBorderWidth())
                        && enemy.getX() - 63 > s.getBorderX()
                        && Math.round(enemy.getY()) == s.getBorderY()) {
                    enemy.setDirection(DirectionEnum.RIGHT);
                    break;
                }
            }
            if(enemy.getDirection() == DirectionEnum.RIGHT){
                if(enemy.getX() + 65 < (s.getBorderX() + s.getBorderWidth())
                        && enemy.getX() + 65 > s.getBorderX()
                        && Math.round(enemy.getY()) == s.getBorderY()){
                    enemy.setDirection(DirectionEnum.LEFT);
                    break;
                }
            }
        }
    }

    private void checkBorder(){
        if(enemy.getDirection() == DirectionEnum.DOWN){
            if(enemy.getY() - 1 < gameStage.getBorderY()) {
                enemy.setDirection(DirectionEnum.UP);
            }
        }
        if(enemy.getDirection() == DirectionEnum.UP){
            if(enemy.getY() + 65 >= gameStage.getBorderY() + gameStage.getBorderHeight()){
                enemy.setDirection(DirectionEnum.DOWN);
            }
        }
        if(enemy.getDirection() == DirectionEnum.LEFT){
            if(enemy.getX() - 1 < gameStage.getBorderX()) {
                enemy.setDirection(DirectionEnum.RIGHT);
            }
        }
        if(enemy.getDirection() == DirectionEnum.RIGHT){
            if(enemy.getX() + 65 >= gameStage.getBorderX() + gameStage.getBorderWidth()){
                enemy.setDirection(DirectionEnum.LEFT);
            }
        }
    }

}
