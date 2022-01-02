package com.mygdx.game.PowerUps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.Items;
import com.mygdx.game.Screen.MainGameScreen;
import com.mygdx.game.Stage.GameStage;

public class IncreaseBombs extends PowerUps {

    public IncreaseBombs(int tileX, int tileY, GameStage gameStage, Stage stage) {
        super(tileX,tileY, gameStage, stage);
    }
    public void setUpSprite() {
        atlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/hud/hud.txt"));
        sprite = new  TextureAtlas.AtlasSprite(atlas.findRegion("bomb_up"));

    }

}
