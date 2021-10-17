package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import jdk.tools.jmod.Main;

public class pleb extends Actor {
    Sprite sprite;


    public pleb(){
        sprite = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_white/still/bomberman_still_1.png")));
        sprite.setPosition(96,64);
        sprite.setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        setTouchable(Touchable.enabled);

    }
    public void setPosition(int x, int y){
        sprite.setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }
}
