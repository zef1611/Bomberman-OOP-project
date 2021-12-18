package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Observer.BorderObserve;

import java.util.ArrayList;

public class GameStage extends Image  {
    ArrayList <BorderObserve> listBorObserve = new ArrayList<BorderObserve>();
    float borderX, borderY, borderWidth, borderHeight;
    Sprite txStatusBar, txBackground;

    public GameStage(){
        txStatusBar = new Sprite(new Texture(Gdx.files.internal("sprite/stage/status_bar.png")));
        txBackground = new Sprite(new Texture(Gdx.files.internal("sprite/stage/stage_02/stage_02.png")));
        txStatusBar.setPosition(0,
                Gdx.graphics.getHeight()-txStatusBar.getHeight());
        txBackground.setPosition(Gdx.graphics.getWidth()/2f - txBackground.getWidth()/2f,
                (Gdx.graphics.getHeight()-txStatusBar.getHeight())/2f - txBackground.getHeight()/2f );
        setPosition(0,0);
        borderX = 96;
        borderY = 64;
        borderWidth = 13*64;
        borderHeight = 11*64;
//        setBounds();
    }

    public void attachObserver(BorderObserve observer){
        listBorObserve.add(observer);
    }
    public void detachObserver(BorderObserve observer){
        listBorObserve.remove(observer);
    }
    public void borderNotify(){
        for (BorderObserve observer: listBorObserve){
            observer.update();
        }
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
    //---------------------------GETTER/SETTERS------------------------
    public float getBorderX(){return borderX;}
    public float getBorderY(){return borderY;}
    public float getBorderWidth(){return borderWidth;}
    public float getBorderHeight(){return borderHeight;}

}
