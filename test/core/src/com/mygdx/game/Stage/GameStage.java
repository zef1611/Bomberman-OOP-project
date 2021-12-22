package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Observer.BorderObserve;
import com.mygdx.game.Observer.SoftObserve;
import com.mygdx.game.Observer.SolidObserve;

import java.util.ArrayList;

//This class define the stage background, status bar, border size
public class GameStage extends Image  {
    ArrayList <BorderObserve> listPlayer = new ArrayList<BorderObserve>();
    ArrayList <SoftObserve> listSoft = new ArrayList<SoftObserve>();
    ArrayList <SolidObserve> listSolid = new ArrayList<SolidObserve>();
    TextureAtlas stageAtlas;
    float borderX, borderY, borderWidth, borderHeight;
    Sprite txStatusBar, txBackground;

    public GameStage(int stageNum){

        txStatusBar = new Sprite(new Texture(Gdx.files.internal("sprite/stage/status_bar.png")));
        txBackground = new Sprite(new Texture(Gdx.files.internal("sprite/raw_asset/stage/stage_01/stage_01_sheet.png")));
        txBackground = switchBackground(stageNum);
//        txBackground = new Sprite(new Texture(Gdx.files.internal("sprite/stage/stage_01/stage_blank_01.png")));
        txStatusBar.setPosition(0,
                Gdx.graphics.getHeight()-txStatusBar.getHeight());

        txBackground.setPosition(Gdx.graphics.getWidth()/2f - txBackground.getWidth()/2f,
                (Gdx.graphics.getHeight()-txStatusBar.getHeight())/2f - txBackground.getHeight()/2f );
        txBackground.setScale(4,4);

        borderX = 96;
        borderY = 64;
        borderWidth = 13*64;
        borderHeight = 11*64;

//        Soft.placeSoft();
    }

    public Sprite switchBackground(int stageNum){
//        stageAtlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/stage/stage.txt"));
//        txBackground = new TextureAtlas.AtlasSprite(stageAtlas.findRegion("stage", stageNum));
        txBackground = new Sprite(new Texture(Gdx.files.internal("sprite_sheet/stage/stage_"+stageNum+".png")));
        return txBackground;
    }

    public void attachObserver(BorderObserve observer){
        listPlayer.add(observer);
    }
    public void detachObserver(BorderObserve observer){listPlayer.remove(observer);}

    public void borderNotify(){
        for (BorderObserve observer: listPlayer){
            observer.update();
        }
    }
    public void attachSoft(Soft soft) {listSoft.add(soft);}
    public void detachSoft(Soft soft) {listSoft.remove(soft);}
    public void attachSolid(Solid solid) {listSolid.add(solid);}

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
