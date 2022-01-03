package com.mygdx.game.Player;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.DirectionEnum;

public class PlayerAnimation {
    private Player player;
    private TextureAtlas atlas;

    public PlayerAnimation(Player player, TextureAtlas atlas) {
        this.player = player;
        this.atlas = atlas;
    }

    public void updateWalkAni() {
        player.setElapsedTime(0);
        String direction = (player.getDirection() == DirectionEnum.LEFT) ?
                DirectionEnum.RIGHT.toString()
                : player.getDirection().toString();
        String state = player.getState().toString();
        String step = (player.getStepCount() % 2 == 0) ? "e" : "o";
        String region = String.format("bomberman_" + state + "_" + direction + "_" + step);
        player.setCurrentAni(new Animation<>(1f / 8f, atlas.findRegions(region)));
    }

    public void updateAni() {
        player.setElapsedTime(0.5F);
        player.setCurrentAni(new Animation<>(0.8f, atlas.findRegions("bomberman_defeat")));
    }


}
