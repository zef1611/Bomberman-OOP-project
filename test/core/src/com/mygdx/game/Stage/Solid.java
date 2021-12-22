package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Observer.SolidObserve;

public class Solid extends Image implements SolidObserve {
    Sprite solid;
    float borderX, borderY, borderWidth, borderHeight;
    public Solid(float x, float y){
        solid = new Sprite(new Texture(Gdx.files.internal("sprite/stage/stage_01/solid_01.png")));
        setBounds(x, y, solid.getWidth(), solid.getHeight());
        borderX = x;
        borderY = y;
        borderWidth = solid.getWidth();
        borderHeight = solid.getHeight();
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        solid.draw(batch);
    }


    public void update() {

    }
}
