package com.mygdx.game.PowerUps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Stage.HUD;

public class IncreaseSpeed extends PowerUps {

    public IncreaseSpeed(int tileX, int tileY, GameStage gameStage, Stage stage) {
        super(tileX, tileY, gameStage, stage);
    }

    public void setUpSprite() {
        atlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/hud/hud.txt"));
        sprite = new TextureAtlas.AtlasSprite(atlas.findRegion("accelerator"));

    }

    public void execute(Player player) {
        this.player = player;
        player.setSpeed(-0.25F);
        HUD.setSpeedVal(convertSpeedtoVis(player.getSpeed()));
        this.del();

    }

    private int convertSpeedtoVis(float speed) {
        if (speed == 0) return 3;
        if (speed == 0.25) return 2;
        return 1;
    }
}
