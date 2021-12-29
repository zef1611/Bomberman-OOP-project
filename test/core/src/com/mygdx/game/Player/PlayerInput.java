package com.mygdx.game.Player;

import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Stage.Soft;
import com.mygdx.game.Stage.Solid;
import com.mygdx.game.StateEnum;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

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
    protected void inputContent(int keycode) {
        if(keycode == Input.Keys.D
                && player.getCurrentAction().isComplete()
                && checkBorder(keycode)
                && checkSoft(keycode)
                && checkSolid(keycode)){
            MoveByAction right = new MoveByAction();
            right.setAmount(64f, 0f);
            right.setDuration(1f/2f);
            player.setCurrentAction(right);
            player.addAction(right);
            // For animations
            if(player.getDirection() != DirectionEnum.RIGHT){
                player.setStepCount(0);
            }
            player.setStepCount(1+player.getStepCount());
            player.setDirection(DirectionEnum.RIGHT);
            player.setState(StateEnum.WALK);
            playerAni.updateAni();
        }
        if(keycode ==Input.Keys.W
                && player.getCurrentAction().isComplete()
                && checkBorder(keycode)
                && checkSoft(keycode)
                && checkSolid(keycode)){
            MoveByAction up = new MoveByAction();
            up.setAmount(0f,64f);
            up.setDuration(1f/2f);
            player.setCurrentAction(up);
            player.addAction(up);

            // For animations
            if(player.getDirection() != DirectionEnum.UP) {
                player.setStepCount(0);
            }
            player.setStepCount(1+player.getStepCount());
            player.setDirection(DirectionEnum.UP);
            player.setState(StateEnum.WALK);
            playerAni.updateAni();

}
        if(keycode == Input.Keys.S
                && player.getCurrentAction().isComplete()
                && checkBorder(keycode)
                && checkSoft(keycode)
                && checkSolid(keycode)){
            MoveByAction down = new MoveByAction();
            down.setAmount(0f,-64f);
            down.setDuration(1f/2f);
            player.setCurrentAction(down);
            player.addAction(down);

            //For animations
            if(player.getDirection() != DirectionEnum.DOWN) {
                player.setStepCount(0);
            }
            player.setStepCount(1+player.getStepCount());
            player.setDirection(DirectionEnum.DOWN);
            player.setState(StateEnum.WALK);
            playerAni.updateAni();

        }
        if(keycode == Input.Keys.A
                && player.getCurrentAction().isComplete()
                && checkBorder(keycode)
                && checkSoft(keycode)
                && checkSolid(keycode)){

            MoveByAction left = new MoveByAction();
            left.setAmount(-64f, 0f);
            left.setDuration(1f/2f);
            player.setCurrentAction(left);
            player.addAction(left);

            // For animations
            if(player.getDirection() != DirectionEnum.LEFT) {
                player.setStepCount(0);
            }
            player.setStepCount(1+player.getStepCount());
            player.setDirection(DirectionEnum.LEFT);
            player.setState(StateEnum.WALK);
            playerAni.updateAni();

        }
        if(keycode == Input.Keys.E){
            stage.addActor(new Bomb(player));
        }
    }

//    Check game stage border
    private boolean checkBorder(int keycode){
        switch (keycode){
            case Input.Keys.W:
                if(player.getY() + 65 >= gameStage.getBorderY() + gameStage.getBorderHeight()){
                    return false;
                }
                break;
            case Input.Keys.A:
                if(player.getX() - 1 < gameStage.getBorderX()){
                    return false;
                }
                break;
            case Input.Keys.S:
                if(player.getY() - 1 < gameStage.getBorderY()){
                    return false;
                }
                break;
            case Input.Keys.D:
                if(player.getX() + 65 >= gameStage.getBorderX() + gameStage.getBorderWidth()){
                    return false;
                }
                break;
        }
        return true;
    }
//    Check soft blocks border
    private boolean checkSoft(int keycode){
        for (Soft s: gameStage.getListSoft()){
            switch (keycode){
                case Input.Keys.W:
                    if(Math.round(player.getY()) + 65 < (s.getBorderY() + s.getBorderHeight())
                            && Math.round(player.getY()) + 65 > s.getBorderY()
                            && Math.round(player.getX()) == s.getBorderX()){
                        return false;
                    }
                    break;
                case Input.Keys.A:
                    if(Math.round(player.getX()) - 63 < (s.getBorderX() + s.getBorderWidth())
                            && Math.round(player.getX()) - 63 > s.getBorderX()
                            && Math.round(player.getY()) == s.getBorderY()) {
                        return false;
                    }
                    break;
                case Input.Keys.S:
                    if(Math.round(player.getY()) - 63 < (s.getBorderY() + s.getBorderHeight())
                            && Math.round(player.getY()) - 63 > s.getBorderY()
                            && Math.round(player.getX()) == s.getBorderX()) {
                        return false;
                    }
                    break;
                case Input.Keys.D:
                    if(Math.round(player.getX()) + 65 < (s.getBorderX() + s.getBorderWidth())
                            && Math.round(player.getX()) + 65 > s.getBorderX()
                            && Math.round(player.getY()) == s.getBorderY()){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
//    Check solid block border
    private boolean checkSolid(int keycode){
        for (Solid s: gameStage.getListSolid()){
            switch (keycode){
                case Input.Keys.W:
                    if(Math.round(player.getY()) + 65 < (s.getBorderY() + s.getBorderHeight())
                            && Math.round(player.getY()) + 65 > s.getBorderY()
                            && Math.round(player.getX()) == s.getBorderX()){
                        return false;
                    }
                    break;
                case Input.Keys.A:
                    if(Math.round(player.getX()) - 63 < (s.getBorderX() + s.getBorderWidth())
                            && Math.round(player.getX()) - 63 > s.getBorderX()
                            && Math.round(player.getY()) == s.getBorderY()) {
                        return false;
                    }
                    break;
                case Input.Keys.S:
                    if(Math.round(player.getY()) - 63 < (s.getBorderY() + s.getBorderHeight())
                            && Math.round(player.getY()) - 63 > s.getBorderY()
                            && Math.round(player.getX()) == s.getBorderX()) {
                        return false;
                    }
                    break;
                case Input.Keys.D:
                    if(Math.round(player.getX()) + 65 < (s.getBorderX() + s.getBorderWidth())
                            && Math.round(player.getX()) + 65 > s.getBorderX()
                            && Math.round(player.getY()) == s.getBorderY()){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
