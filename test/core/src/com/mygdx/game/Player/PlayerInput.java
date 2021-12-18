package com.mygdx.game.Player;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

public class PlayerInput {
    Player player;
    Stage stage;
    PlayerAnimation playerAni;

    public PlayerInput(Player player) {
        this.player = player;
        this.stage = player.getStage();
        playerAni = new PlayerAnimation(player, player.getAtlas());
    }

    public void inputContent(int keycode) {
        if(keycode == Input.Keys.D && player.getCurrentAction().isComplete()){
            MoveByAction right = new MoveByAction();
            right.setAmount(64f, 0f);
            right.setDuration(1f/2f);
            player.setCurrentAction(right);
            System.out.println(right.isComplete());
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
        if(keycode ==Input.Keys.W && player.getCurrentAction().isComplete()){
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
            player.setStepCount(1+ player.getStepCount());
            player.setState(Player.StateEnum.WALK);
            playerAni.updateAni();

}
        if(keycode == Input.Keys.S && player.getCurrentAction().isComplete()){
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
        if(keycode == Input.Keys.A && player.getCurrentAction().isComplete()){

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
}
