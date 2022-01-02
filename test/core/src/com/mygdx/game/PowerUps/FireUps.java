package com.mygdx.game.PowerUps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Stage.GameStage;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class FireUps extends PowerUps {
    private float elapsedTime;
    boolean vis;

    public FireUps(int tileX, int tileY, GameStage gameStage, Stage stage) {
        super(tileX, tileY, gameStage, stage);
        elapsedTime = 0;
        vis = true;
    }

    @Override
    public void setUpSprite() {
        atlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/hud/hud.txt"));
        sprite = new TextureAtlas.AtlasSprite(atlas.findRegion("fire_up"));
    }

    @Override
    public void execute(Player player) {
        this.player = player;
        player.setBombRange(1);
        vis = false;
    }

    //    @Override
    public void draw(Batch batch, float parentAlpha) {

        if (vis == true) sprite.draw(batch);
        else {
            elapsedTime += Gdx.graphics.getDeltaTime();
            if (elapsedTime > 15) {
                player.setBombRange(-1);
                this.del();
            }

        }
    }
}
