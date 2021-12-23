package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Soft extends Image {
    Sprite soft;
    public GameStage gameStage;
    private int borderX, borderY, borderWidth, borderHeight;

    public Soft(int x, int y, GameStage gameStage){
        this.gameStage = gameStage;
        soft = new Sprite(new Texture(Gdx.files.internal("sprite/stage/stage_01/soft_01.png")));
        soft.setPosition(x,y);
        setBounds(x, y, soft.getWidth(), soft.getHeight());
        borderX = x;
        borderY = y;
        borderWidth = 64;
        borderHeight = 64;
        gameStage.attachSoft(this);
    }



    @Override
    public void draw(Batch batch, float parentAlpha){
        soft.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
//    public static void placeSoft() {
//        gameStage.attachSoft(new Soft(96+ 64, 64 ));
//    }

//    ------------------------------SETTERS/GETTERS---------------------------
    public int getBorderX(){return borderX;}
    public int getBorderY(){return borderY;}
    public int getBorderWidth(){return borderWidth;}
    public int getBorderHeight(){return borderHeight;}
}
