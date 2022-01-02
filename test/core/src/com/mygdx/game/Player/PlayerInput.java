package com.mygdx.game.Player;

import com.mygdx.game.ConstantValue;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Enemies.Enemy;
import com.mygdx.game.Items;
import com.mygdx.game.PowerUps.PowerUps;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.StateEnum;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

import java.awt.*;
import java.util.ArrayList;

//This class is in charge of the logic of the player input (including the border)
public class PlayerInput {
    private final Player player;
    private final GameStage gameStage;
    private final Stage stage;
    private final PlayerAnimation playerAni;
    private float temp = 0.25F;

    protected PlayerInput(Player player, GameStage gameStage) {
        this.player = player;
        this.gameStage = gameStage;
        this.stage = player.getStage();
        playerAni = new PlayerAnimation(player, player.getAtlas());
    }

    //    Logic of input
    private boolean isOk(int keycode) {
        boolean cond = true;
        cond &= checkBorder(keycode);
        cond &= checkConflict(keycode, gameStage.getListSoft());
        cond &= checkConflict(keycode, gameStage.getListSolid());
        cond &= checkConflict(keycode, gameStage.getListBomb());
        return cond;
    }

    protected void inputContent(int keycode) {
//        System.out.printf("%d %d\n", (int)player.getX(), (int)player.getY());
        if (keycode == Input.Keys.D && player.getCurrentAction().isComplete() && isOk(keycode)) {
            MoveByAction right = new MoveByAction();
            right.setAmount(64, 0f);
            right.setDuration(player.getSpeed());
            player.setCurrentAction(right);
            player.addAction(right);
            // For animations
            if (player.getDirection() != DirectionEnum.RIGHT) {
                player.setStepCount(0);
            }
            player.setStepCount(1 + player.getStepCount());
            player.setDirection(DirectionEnum.RIGHT);
            player.setState(StateEnum.WALK);
            playerAni.updateAni();
        }
        if (keycode == Input.Keys.W && player.getCurrentAction().isComplete() && isOk(keycode)) {
            MoveByAction up = new MoveByAction();
            up.setAmount(0f, 64);
            up.setDuration(player.getSpeed());
            player.setCurrentAction(up);
            player.addAction(up);

            // For animations
            if (player.getDirection() != DirectionEnum.UP) {
                player.setStepCount(0);
            }
            player.setStepCount(1 + player.getStepCount());
            player.setDirection(DirectionEnum.UP);
            player.setState(StateEnum.WALK);
            playerAni.updateAni();

        }
        if (keycode == Input.Keys.S && player.getCurrentAction().isComplete() && isOk(keycode)) {
            MoveByAction down = new MoveByAction();
            down.setAmount(0f, -64f);
            down.setDuration(player.getSpeed());
            player.setCurrentAction(down);
            player.addAction(down);

            if (player.getDirection() != DirectionEnum.DOWN) {
                player.setStepCount(0);
            }
            player.setStepCount(1 + player.getStepCount());
            player.setDirection(DirectionEnum.DOWN);
            player.setState(StateEnum.WALK);
            playerAni.updateAni();

        }
        if (keycode == Input.Keys.A && player.getCurrentAction().isComplete() && isOk(keycode)) {

            MoveByAction left = new MoveByAction();
            left.setAmount(-64f, 0f);
            left.setDuration(player.getSpeed());
            player.setCurrentAction(left);
            player.addAction(left);

            // For animations
            if (player.getDirection() != DirectionEnum.LEFT) {
                player.setStepCount(0);
            }
            player.setStepCount(1 + player.getStepCount());
            player.setDirection(DirectionEnum.LEFT);
            player.setState(StateEnum.WALK);
            playerAni.updateAni();

        }
        if (keycode == Input.Keys.E) {
            if (player.getRemainBomb() == player.getMaxBomb()) return;
            Bomb bomb = new Bomb(player, this.gameStage);
//            System.out.printf("ok");
            stage.addActor(bomb);
            gameStage.attachBomb(bomb);
        }
//        player.setX(ConstantValue.GetX(player.getX()));
//        player.setY(ConstantValue.GetY(player.getY()));
    }

    //    Check game stage border
    private boolean checkBorder(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                if (player.getY() + 65 >= gameStage.getBorderY() + gameStage.getBorderHeight()) {
                    return false;
                }
                break;
            case Input.Keys.A:
                if (player.getX() - 1 < gameStage.getBorderX()) {
                    return false;
                }
                break;
            case Input.Keys.S:
                if (player.getY() - 1 < gameStage.getBorderY()) {
                    return false;
                }
                break;
            case Input.Keys.D:
                if (player.getX() + 65 >= gameStage.getBorderX() + gameStage.getBorderWidth()) {
                    return false;
                }
                break;
        }
        return true;
    }

    private boolean inRange(float x, float y, float minX, float maxX, float minY, float maxY) {
        if (minX < x && x < maxX && minY < y && y < maxY) return true;
        return false;
    }

    private boolean checkConflict(int keycode, ArrayList<Items> arr) {
        boolean check = false;
        player.setX(ConstantValue.GetX(player.getX()));
        player.setY(ConstantValue.GetY(player.getY()));

//        System.out.printf("%.5f %.5f\n", player.getX(), player.getY() );
        for (Items s : arr) {
            float minY = s.getBorderY(), maxY = s.getBorderY() + s.getBorderHeight();
            float minX = s.getBorderX(), maxX = s.getBorderX() + s.getBorderWidth();
//            System.out.printf("MinX: %.5f,MaxX: %.5f,MinY: %.5f, MaxY: %.5f\n",minX,maxX, minY, maxY);
            switch (keycode) {
                case Input.Keys.W:
                    check = inRange(player.getX() + 5, player.getY() + 70, minX, maxX, minY, maxY);
                    if (check == true) {
                        int i = 1;
                    }
                    break;
                case Input.Keys.A:
                    check = inRange(player.getX() - 30, player.getY() + 5, minX, maxX, minY, maxY);
                    break;
                case Input.Keys.S:
                    check = inRange(player.getX() + 5, player.getY() - 30, minX, maxX, minY, maxY);
                    break;
                case Input.Keys.D:
                    check = inRange(player.getX() + 70, player.getY() + 5, minX, maxX, minY, maxY);
                    break;
            }
            if (check == true) return false;
        }
        return true;
    }

}
