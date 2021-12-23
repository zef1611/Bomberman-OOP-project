package com.mygdx.game.Enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.DirectionEnum;

public class Skunk extends Enemy{
    Sprite skunk;
    Skunk(int x, int y) {
        super();
        super.setName(EnemyEnum.SKUNK);
        switchAtlas();
        Array<TextureAtlas.AtlasRegion> walkLeft = getEnemyAtlas().findRegions("walk_left");
        currentAni = new Animation<>(1f/15f,walkLeft.get(0));
        skunk = new Sprite(new TextureAtlas.AtlasSprite(walkLeft.get(0)));
        setBounds(x, y, skunk.getRegionWidth(), skunk.getRegionHeight());
    }
    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch,parentAlpha);
    }

}
