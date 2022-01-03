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
        player.updateHud();
        this.del();

    }


}
