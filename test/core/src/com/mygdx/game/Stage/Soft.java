package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Observer.SoftObserve;

public class Soft extends Image implements SoftObserve {
    Sprite soft;
    public static GameStage gameStage;
    float borderX, borderY, borderWidth, borderHeight;
    float playerX, playerY, playerWidth, playerHeight;
    public Soft(float x, float y, GameStage gameStage){
        gameStage = gameStage;
        soft = new Sprite(new Texture(Gdx.files.internal("sprite/stage/stage_01/soft_01.png")));
        setBounds(x, y, soft.getWidth(), soft.getHeight());
        borderX = x;
        borderY = y;
        borderWidth = soft.getWidth();
        borderHeight = soft.getHeight();
    }



    @Override
    public void draw(Batch batch, float parentAlpha){
        soft.draw(batch);
    }

//    public static void placeSoft() {
//        gameStage.attachSoft(new Soft(96+ 64, 64 ));
//    }
}
