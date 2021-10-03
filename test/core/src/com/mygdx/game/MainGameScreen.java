package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Bomberman;

public class MainGameScreen implements Screen {
    private Texture background, statusBar, player;
    private int stageNum = 1;
    private Sprite backgroundSprite;
    private final Sprite statusBarSprite = new Sprite(new Texture(Gdx.files.internal("sprite/stage/status_bar.png")));
    Stage mainScreen = new Stage();
    Bomberman bomber;

    public MainGameScreen(Bomberman bomber){
        this.bomber = bomber;
        mainScreen.addActor(new Player("black"));
//        Gdx.input.setInputProcessor(mainScreen);
        mainScreen.setKeyboardFocus(mainScreen.getActors().first());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        statusBarSprite.setPosition(0, 832);

        backgroundSprite = new Sprite(setBackgroundTexture(stageNum));
        backgroundSprite.setPosition(Gdx.graphics.getWidth()/2f - backgroundSprite.getWidth()/2,
                Gdx.graphics.getHeight()/2f - (backgroundSprite.getHeight()/2 + statusBarSprite.getHeight()/2));

        mainScreen.act(Gdx.graphics.getDeltaTime());
        mainScreen.draw();
//        bomber.batch.begin();
//        bomber.batch.draw(statusBarSprite, statusBarSprite.getX(), statusBarSprite.getY());
//        bomber.batch.draw(backgroundSprite, backgroundSprite.getX(), backgroundSprite.getY());
//        bomber.batch.draw(playerSprite,playerSprite.getX(),playerSprite.getY());
//        bomber.batch.end();


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void getBackgroundTexture(int stageNum){
        this.stageNum = stageNum;
    }
    public Texture setBackgroundTexture(int stageNum){
        if(stageNum == 1){
            background = new Texture(Gdx.files.internal("sprite/stage/stage_01/stage_01.png"));
        }
        if(stageNum == 2){
            background = new Texture(Gdx.files.internal("sprite/stage/stage_02/stage_02.png"));
        }
        if(stageNum == 3){
            background = new Texture(Gdx.files.internal("sprite/stage/stage_03/stage_03.png"));
        }
        if(stageNum == 4){
            background = new Texture(Gdx.files.internal("sprite/stage/stage_04/stage_04.png"));
        }
        if(stageNum == 5){
            background = new Texture(Gdx.files.internal("sprite/stage/stage_05/stage_05.png"));
        }
        if(stageNum == 6){
            background = new Texture(Gdx.files.internal("sprite/stage/stage_06/stage_06.png"));
        }

        return background;
    }

    public void setPlayer(String color){

    }

}
