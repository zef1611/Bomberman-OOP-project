package com.mygdx.game.Player;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

//This class is in charge of the logic of the player input (including the border)
public class PlayerInput {
    private Player player;
    private Stage stage;
    private PlayerAnimation playerAni;

    protected PlayerInput(Player player) {
        this.player = player;
        this.stage = player.getStage();
        playerAni = new PlayerAnimation(player, player.getAtlas());
    }

//    Logic of input
    protected void inputContent(int keycode) {
        if(keycode == Input.Keys.D && player.getCurrentAction().isComplete() && checkBorder(keycode)){
            MoveByAction right = new MoveByAction();
            right.setAmount(64f, 0f);
            right.setDuration(1f/2f);
            player.setCurrentAction(right);
            player.addAction(right);
            // For animations
            if(player.getDirection() != Player.DirectionEnum.RIGHT){
                player.setStepCount(0);
            }
            player.setStepCount(1+player.getStepCount());
            player.setDirection(Player.DirectionEnum.RIGHT);
            player.setState(Player.StateEnum.WALK);
            playerAni.updateAni();
        }
        if(keycode ==Input.Keys.W && player.getCurrentAction().isComplete() && checkBorder(keycode)){
            MoveByAction up = new MoveByAction();
            up.setAmount(0f,64f);
            up.setDuration(1f/2f);
            player.setCurrentAction(up);
            player.addAction(up);

            // For animations
            if(player.getDirection() != Player.DirectionEnum.UP) {
                player.setStepCount(0);
            }
            player.setStepCount(1+player.getStepCount());
            player.setDirection(Player.DirectionEnum.UP);
            player.setState(Player.StateEnum.WALK);
            playerAni.updateAni();

}
        if(keycode == Input.Keys.S && player.getCurrentAction().isComplete() && checkBorder(keycode)){
            MoveByAction down = new MoveByAction();
            down.setAmount(0f,-64f);
            down.setDuration(1f/2f);
            player.setCurrentAction(down);
            player.addAction(down);

//                 For animations
            if(player.getDirection() != Player.DirectionEnum.DOWN) {
                player.setStepCount(0);
            }
            player.setStepCount(1+player.getStepCount());
            player.setDirection(Player.DirectionEnum.DOWN);
            player.setState(Player.StateEnum.WALK);
            playerAni.updateAni();

        }
        if(keycode == Input.Keys.A && player.getCurrentAction().isComplete() && checkBorder(keycode)){

            MoveByAction left = new MoveByAction();
            left.setAmount(-64f, 0f);
            left.setDuration(1f/2f);
            player.setCurrentAction(left);
            player.addAction(left);

            // For animations
            if(player.getDirection() != Player.DirectionEnum.LEFT) {
                player.setStepCount(0);
            }
            player.setStepCount(1+player.getStepCount());
            player.setDirection(Player.DirectionEnum.LEFT);
            player.setState(Player.StateEnum.WALK);
            playerAni.updateAni();

        }
        if(keycode == Input.Keys.E){
            stage.addActor(new Bomb(player));
        }
    }

//   Border and stuffs
    private boolean checkBorder(int keycode){
        switch (keycode){
            case Input.Keys.W:
                if(player.getY() + 65 >= player.getBorderY() + player.getBorderHeight()){
                    return false;
                }
                break;
            case Input.Keys.A:
                if(player.getX() - 1 < player.getBorderX()){
                    return false;
                }
                break;
            case Input.Keys.S:
                if(player.getY() - 1 < player.getBorderY()){
                    return false;
                }
                break;
            case Input.Keys.D:
                if(player.getX() + 65 >= player.getBorderX() + player.getBorderWidth()){
                    return false;
                }
                break;
        }
        return true;
    }
}
