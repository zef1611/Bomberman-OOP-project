package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;

public class PlayerAnimation {
    Player player;
    public PlayerAnimation(Player player){
        this.player = player;
    }
    public void updateAni(){
        elapsedTime = 0;
        if(state == Player.StateEnum.WALK){
            switch (direction){
                case RIGHT:
                case LEFT:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_right_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_right_o"));
                    }
                    break;
                case UP:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_up_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_up_o"));
                    }
                    break;
                case DOWN:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_down_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_down_o"));
                    }
                    break;
                case NONE:
                    break;
            }
        }
        if(state == Player.StateEnum.HWALK){
            switch (direction){
                case RIGHT:
                case LEFT:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_right_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_right_o"));
                    }
                    break;
                case UP:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_up_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_up_o"));
                    }
                    break;
                case DOWN:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_down_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_down_o"));
                    }
                    break;
                case NONE:
                    break;
            }
        }

    }
}
