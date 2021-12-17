package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PlayerAnimation {
    Player player;
    TextureAtlas atlas;
    public PlayerAnimation(Player player, TextureAtlas atlas){
        this.player = player;
        this.atlas = atlas;
    }
//    public void updateAni(){
//        player.setElapsedTime(0);
//        if(player.getState() == Player.StateEnum.WALK){
//            switch (player.getDirection()){
//                case RIGHT:
//                case LEFT:
//                    if(player.getStepCount()%2==0){
////                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
////                                "bomberman_walk_right_e")));
////                        player.setCurrentAni(getAni());
//                    } else {
////                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
////                                "bomberman_walk_right_o")));
////                        player.setCurrentAni(getAni());
//                    }
//                    break;
//                case UP:
//                    if(player.getStepCount()%2==0){
//                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
//                                "bomberman_walk_up_e")));
//                    } else {
//                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
//                                "bomberman_walk_up_o")));
//                    }
//                    break;
//                case DOWN:
//                    if(player.getStepCount()%2==0){
//                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
//                                "bomberman_walk_down_e")));
//                    } else {
//                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
//                                "bomberman_walk_down_o")));
//                    }
//                    break;
//                case NONE:
//                    break;
//            }
//        }
//        if(player.getState() == Player.StateEnum.HWALK){
//            switch (player.getDirection()){
//                case RIGHT:
//                case LEFT:
//                    if(player.getStepCount()%2==0){
//                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
//                                "bomberman_hwalk_right_e")));
////                        player.setCurrentAni(getAni());
//                    } else {
//                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
//                                "bomberman_hwalk_right_o")));
////                        player.setCurrentAni(getAni());
//                    }
//                    break;
//                case UP:
//                    if(player.getStepCount()%2==0){
//                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
//                                "bomberman_hwalk_up_e")));
//                    } else {
//                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
//                                "bomberman_hwalk_up_o")));
//                    }
//                    break;
//                case DOWN:
//                    if(player.getStepCount()%2==0){
//                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
//                                "bomberman_hwalk_down_e")));
//                    } else {
//                        player.setCurrentAni(new Animation<>(1f/8f,atlas.findRegions(
//                                "bomberman_hwalk_down_o")));
//                    }
//                    break;
//                case NONE:
//                    break;
//            }
//        }
//
//    }

    public void updateAni(){
        player.setElapsedTime(0);
        String direction = (player.getDirection() == Player.DirectionEnum.LEFT) ?
                Player.DirectionEnum.RIGHT.toString()
                :player.getDirection().toString();
        String state = player.getState().toString();
        String step = (player.getStepCount()%2==0)? "e":"o";
        String region = String.format("bomberman_"+state+"_"+direction+"_"+step);
        player.setCurrentAni(new Animation<>(1f/8f, atlas.findRegions(region)));
    }
}
