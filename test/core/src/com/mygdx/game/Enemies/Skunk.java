package com.mygdx.game.Enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Stage.GameStage;

public class Skunk extends Enemy{
    Sprite skunk;
    Skunk(GameStage gameStage, int x, int y) {
        super(gameStage);
        super.setName(EnemyEnum.SKUNK);
        switchAtlas();
        Array<TextureAtlas.AtlasRegion> walkLeft = getEnemyAtlas().findRegions("walk_left");
        currentAni = new Animation<>(1f/15f,walkLeft.get(0));
        skunk = new Sprite(new TextureAtlas.AtlasSprite(walkLeft.get(0)));
        setBounds(x, y, skunk.getRegionWidth(), skunk.getRegionHeight());
        super.setBorder(x,y);
    }
    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch,parentAlpha);
    }

}
