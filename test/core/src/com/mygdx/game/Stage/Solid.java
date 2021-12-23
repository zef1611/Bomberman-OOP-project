package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Solid extends Image {
    Sprite solid;
    int borderX, borderY, borderWidth, borderHeight;
    public Solid(int x, int y){
        solid = new Sprite(new Texture(Gdx.files.internal("sprite/stage/stage_01/solid_01.png")));
        setBounds(x, y, solid.getWidth(), solid.getHeight());
        borderX = x;
        borderY = y;
        borderWidth = 64;
        borderHeight = 64;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        solid.draw(batch);
    }


    public void update() {

    }

//    ----------------------------SETTERS/GETTERS-----------------------------
    public int getBorderY(){return borderY;}
    public int getBorderX(){return borderX;}
    public int getBorderHeight(){return borderHeight;}
    public int getBorderWidth(){return borderWidth;}
}
