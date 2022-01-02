package com.mygdx.game.Player;

import com.mygdx.game.DirectionEnum;
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
            right.setDuration(0);
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
            up.setDuration(0);
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
            down.setDuration(0);
            player.setCurrentAction(down);
            player.addAction(down);

            //For animations
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
            left.setDuration(0);
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


    private boolean checkConflict(int keycode, ArrayList<Items> arr) {
        for (Items s : arr) {
            switch (keycode) {
                case Input.Keys.W:
                    if (Math.round(player.getY()) + 65 < (s.getBorderY() + s.getBorderHeight())
                            && Math.round(player.getY()) + 65 > s.getBorderY()
                            && Math.round(player.getX()) == s.getBorderX()) {
                        return false;
                    }
                    break;
                case Input.Keys.A:
                    if (Math.round(player.getX()) - 63 < (s.getBorderX() + s.getBorderWidth())
                            && Math.round(player.getX()) - 63 > s.getBorderX()
                            && Math.round(player.getY()) == s.getBorderY()) {
                        return false;
                    }
                    break;
                case Input.Keys.S:
                    if (Math.round(player.getY()) - 63 < (s.getBorderY() + s.getBorderHeight())
                            && Math.round(player.getY()) - 63 > s.getBorderY()
                            && Math.round(player.getX()) == s.getBorderX()) {
                        return false;
                    }
                    break;
                case Input.Keys.D:
                    if (Math.round(player.getX()) + 65 < (s.getBorderX() + s.getBorderWidth())
                            && Math.round(player.getX()) + 65 > s.getBorderX()
                            && Math.round(player.getY()) == s.getBorderY()) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

}
