package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameStage extends Image {
    float borderX, borderY, borderWidth, borderHeight;
    Sprite txStatusBar, txBackground, txGameStage;

    public GameStage(){
        txStatusBar = new Sprite(new Texture(Gdx.files.internal("sprite/stage/status_bar.png")));
        txBackground = new Sprite(new Texture(Gdx.files.internal("sprite/stage/stage_02/stage_02.png")));
        txStatusBar.setPosition(0,
                Gdx.graphics.getHeight()-txStatusBar.getHeight());
        txBackground.setPosition(Gdx.graphics.getWidth()/2f - txBackground.getWidth()/2f,
                (Gdx.graphics.getHeight()-txStatusBar.getHeight())/2f - txBackground.getHeight()/2f );
        setPosition(0,0);
//        setBounds();
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        txStatusBar.draw(batch);
        txBackground.draw(batch);
    }
    @Override
    public void act(float delta){
        super.act(delta);
    }
}
