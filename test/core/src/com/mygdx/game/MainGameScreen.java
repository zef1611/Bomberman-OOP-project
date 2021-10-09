package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Bomberman;

public class MainGameScreen extends AbstractScreen {


    public MainGameScreen(){}

    @Override
    public void buildStage() {
        Player black = new Player("black");
        addActor(black);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}

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

    public void setPlayer(String color){

    }

}
