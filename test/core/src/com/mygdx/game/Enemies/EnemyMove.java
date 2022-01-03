package com.mygdx.game.Enemies;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.mygdx.game.ConstantValue;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Items;

import com.mygdx.game.Player.Player;
import com.mygdx.game.PowerUps.PowerUps;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Stage.Soft;

import java.util.ArrayList;

public class EnemyMove {
    private Enemy enemy;
    private GameStage gameStage;
    private EnemyAnimation enemyAnimation;

    public EnemyMove(Enemy enemy, TextureAtlas enemyAtlas, GameStage gameStage) {
        this.enemy = enemy;
        this.gameStage = gameStage;
        enemyAnimation = new EnemyAnimation(enemy, enemyAtlas);
    }

    public void movement() {
        if (enemy.getCurrentAction().isComplete()) {
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

    private void checkStatus() {
        checkBorder();
        checkExplosion();
        checkConflict(gameStage.getListSoft());
        checkConflict(gameStage.getListSolid());
        checkConflict(gameStage.getListBomb());
        checkEnemy(gameStage.getListEnemy());
        checkPowerUps(gameStage.getListPowerUps());
        checkPlayer(gameStage.getListPlayer());

    }

    public void horizontalMove() {
        checkStatus();
        if (enemy.currentAction.isComplete()) {
            MoveByAction action = new MoveByAction();

            if (enemy.getDirection() == DirectionEnum.LEFT) {
                action.setAmount(-64f, 0f);
            }
            if (enemy.getDirection() == DirectionEnum.RIGHT) {
                action.setAmount(64f, 0f);
            }
            action.setDuration(1f / 2f);
            enemy.setCurrentAction(action);
            enemy.addAction(action);
            enemyAnimation.updateAni();
        }
    }

    public void verticalMove() {
        checkStatus();
        if (enemy.currentAction.isComplete()) {
            MoveByAction action = new MoveByAction();

            if (enemy.getDirection() == DirectionEnum.DOWN) {
                action.setAmount(0f, -64f);
            }
            if (enemy.getDirection() == DirectionEnum.UP) {
                action.setAmount(0f, 64f);
            }
            action.setDuration(1f / 2f);
            enemy.setCurrentAction(action);
            enemy.addAction(action);
            enemyAnimation.updateAni();
        }
    }

    private void checkConflict(ArrayList<Items> arr) {
        for (Items s : arr) {
            float minY = s.getBorderY(), maxY = s.getBorderY() + s.getBorderHeight();
            float minX = s.getBorderX(), maxX = s.getBorderX() + s.getBorderWidth();

            if (enemy.getDirection() == DirectionEnum.DOWN) {
                if (inRange(enemy.getX() + 5, enemy.getY() - 30, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.UP);
                    break;
                }
            }
            if (enemy.getDirection() == DirectionEnum.UP) {
                if (inRange(enemy.getX() + 5, enemy.getY() + 70, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.DOWN);
                    break;
                }
            }
            if (enemy.getDirection() == DirectionEnum.LEFT) {
                if (inRange(enemy.getX() - 30, enemy.getY() + 5, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.RIGHT);
                    break;
                }
            }
            if (enemy.getDirection() == DirectionEnum.RIGHT) {
                if (inRange(enemy.getX() + 70, enemy.getY() + 5, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.LEFT);
                    break;
                }
            }
        }
    }

    private void checkEnemy(ArrayList<Enemy> arr) {
        for (Enemy s : arr) {
            if (enemy.getID() == s.getID()) continue;
            float minY = s.getY() - 5, maxY = s.getY() + 64;
            float minX = s.getX() - 5, maxX = s.getX() + 64;
            System.out.printf("MinX: %f maxX: %f, minY: %f maxY: %f\n", minX, maxX, minY, maxY);
            System.out.printf("X: %f, Y: %f\n", enemy.getX(), enemy.getY());

            if (enemy.getDirection() == DirectionEnum.DOWN) {
                if (inRange(enemy.getX() + 5, enemy.getY() - 30, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.UP);
                    System.out.println("yes");
                    break;
                }
            }
            if (enemy.getDirection() == DirectionEnum.UP) {
                if (inRange(enemy.getX() + 5, enemy.getY() + 70, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.DOWN);
                    System.out.println("yes");
                    break;

                }
            }
            if (enemy.getDirection() == DirectionEnum.LEFT) {
                if (inRange(enemy.getX() - 30, enemy.getY() + 5, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.RIGHT);
                    System.out.println("yes");
                    break;
                }
            }
            if (enemy.getDirection() == DirectionEnum.RIGHT) {
                if (inRange(enemy.getX() + 70, enemy.getY() + 5, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.LEFT);
                    System.out.println("yes");
                    break;
                }
            }
        }
    }

    private void checkPlayer(ArrayList<Player> arr) {
        for (Player s : arr) {

            float minY = s.getY() - 5, maxY = s.getY() + 64;
            float minX = s.getX() - 5, maxX = s.getX() + 64;
//            System.out.printf("MinX: %f maxX: %f, minY: %f maxY: %f\n",minX,maxX,minY,maxY);
//            System.out.printf("X: %f, Y: %f\n",enemy.getX(),enemy.getY());

            if (enemy.getDirection() == DirectionEnum.DOWN) {
                if (inRange(enemy.getX() + 5, enemy.getY() - 30, minX, maxX, minY, maxY)) {
                    System.out.println("Player is death");
                    s.death();
                    break;
                }
            }
            if (enemy.getDirection() == DirectionEnum.UP) {
                if (inRange(enemy.getX() + 5, enemy.getY() + 70, minX, maxX, minY, maxY)) {
                    System.out.println("Player is death");
                    s.death();
                    break;

                }
            }
            if (enemy.getDirection() == DirectionEnum.LEFT) {
                if (inRange(enemy.getX() - 30, enemy.getY() + 5, minX, maxX, minY, maxY)) {
                    System.out.println("Player is death");
                    s.death();
                    break;
                }
            }
            if (enemy.getDirection() == DirectionEnum.RIGHT) {
                if (inRange(enemy.getX() + 70, enemy.getY() + 5, minX, maxX, minY, maxY)) {
                    System.out.println("Player is death");
                    s.death();
                    break;
                }
            }
        }
    }

    private void checkPowerUps(ArrayList<PowerUps> arr) {
        for (PowerUps s : arr) {
            float minY = s.getBorderY(), maxY = s.getBorderY() + s.getBorderHeight();
            float minX = s.getBorderX(), maxX = s.getBorderX() + s.getBorderWidth();

            if (enemy.getDirection() == DirectionEnum.DOWN) {
                if (inRange(enemy.getX() + 5, enemy.getY() - 30, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.UP);
                    break;
                }
            }
            if (enemy.getDirection() == DirectionEnum.UP) {
                if (inRange(enemy.getX() + 5, enemy.getY() + 70, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.DOWN);
                    break;
                }
            }
            if (enemy.getDirection() == DirectionEnum.LEFT) {
                if (inRange(enemy.getX() - 30, enemy.getY() + 5, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.RIGHT);
                    break;
                }
            }
            if (enemy.getDirection() == DirectionEnum.RIGHT) {
                if (inRange(enemy.getX() + 70, enemy.getY() + 5, minX, maxX, minY, maxY)) {
                    enemy.setDirection(DirectionEnum.LEFT);
                    break;
                }
            }
        }
    }

    private boolean inRange(float x, float y, float minX, float maxX, float minY, float maxY) {
        if (minX < x && x < maxX && minY < y && y < maxY) return true;
        return false;
    }

    private void checkBorder() {
        if (enemy.getDirection() == DirectionEnum.DOWN) {
            if (enemy.getY() - 30 < gameStage.getBorderY()) {
                enemy.setDirection(DirectionEnum.UP);
            }
        }
        if (enemy.getDirection() == DirectionEnum.UP) {
            if (enemy.getY() + 70 >= gameStage.getBorderY() + gameStage.getBorderHeight()) {
                enemy.setDirection(DirectionEnum.DOWN);
            }
        }
        if (enemy.getDirection() == DirectionEnum.LEFT) {
            if (enemy.getX() - 30 < gameStage.getBorderX()) {
                enemy.setDirection(DirectionEnum.RIGHT);
            }
        }
        if (enemy.getDirection() == DirectionEnum.RIGHT) {
            if (enemy.getX() + 70 >= gameStage.getBorderX() + gameStage.getBorderWidth()) {
                enemy.setDirection(DirectionEnum.LEFT);
            }
        }
    }

    private void checkExplosion() {
        int x = (int) enemy.getX(), y = (int) enemy.getY();
        if (enemy.getDirection() == DirectionEnum.DOWN) {
            if (gameStage.getDeath(x / 64, (y - 30) / 64) > 0) {
                enemy.setDirection(DirectionEnum.UP);
            }
        }
        if (enemy.getDirection() == DirectionEnum.UP) {
            if (gameStage.getDeath(x / 64, (y + 70) / 64) > 0) {
                enemy.setDirection(DirectionEnum.DOWN);
            }
        }
        if (enemy.getDirection() == DirectionEnum.LEFT) {
            if (gameStage.getDeath((x - 30) / 64, y / 64) > 0) {
                enemy.setDirection(DirectionEnum.RIGHT);
            }
        }
        if (enemy.getDirection() == DirectionEnum.RIGHT) {
            if (gameStage.getDeath((x + 70) / 64, y / 64) > 0) {
                enemy.setDirection(DirectionEnum.LEFT);
            }
        }
    }
}
