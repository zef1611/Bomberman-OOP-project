package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Player.ColorEnum;
import com.mygdx.game.Player.Player;

public class MainGameScreen extends AbstractScreen {


    public MainGameScreen(){}

    @Override
    public void buildStage() {
//        Add status bar
        Texture txStatusBar = new Texture(Gdx.files.internal("sprite/stage/status_bar.png"));
        Image statusBar = new Image(txStatusBar);
        statusBar.setPosition(0,
                Gdx.graphics.getHeight()-statusBar.getHeight());
        addActor(statusBar);

//        Background placeholder
        Texture txBackground = new Texture(Gdx.files.internal("sprite/stage/stage_02" +
                "/stage_02.png"));
        Image background = new Image(txBackground);
        background.setPosition(Gdx.graphics.getWidth()/2f - background.getWidth()/2f,
                (Gdx.graphics.getHeight()-statusBar.getHeight())/2f - background.getHeight()/2f );
        addActor(background);

//      Create player
        Player black = new Player(ColorEnum.BLUE);
        black.position(96,64);


        System.out.println(String.format("%f %f",black.getX(),black.getY()));
        setKeyboardFocus(black);
        addActor(black);

//
    }


    @Override
    public void dispose() {super.dispose();}

//    public void getBackgroundTexture(int stageNum){
//        this.stageNum = stageNum;
//    }
//    public Texture setBackgroundTexture(int stageNum){
//        if(stageNum == 1){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_01/stage_01.png"));
//        }
//        if(stageNum == 2){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_02/stage_02.png"));
//        }
//        if(stageNum == 3){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_03/stage_03.png"));
//        }
//        if(stageNum == 4){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_04/stage_04.png"));
//        }
//        if(stageNum == 5){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_05/stage_05.png"));
//        }
//        if(stageNum == 6){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_06/stage_06.png"));
//        }
//
//        return background;
//    }

//    public void setPlayer(String color){
//
//    }

}
