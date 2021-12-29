package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class StageSelectScreen extends AbstractScreen{
    static int stageNum = 4;
    @Override
    public void buildStage() {
//    Background of the CharSelect Screen
        Texture txBackground = new Texture(Gdx.files.internal("sprite/raw_asset/bomberman_start_background.jpg"));
        Image background = new Image(txBackground);
        addActor(background);
//    Stage 1 Button
        final ImageButton stage1 = new ImageButton(new TextureRegionDrawable(
                new TextureRegion( new Texture(
                        Gdx.files.internal("sprite/stage/stage_01/stage_01.png")))));
        stage1.setPosition(100,500);
        stage1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                setStageNum(1);
                ScreenManager.getInstance().showScreen(ScreenEnum.MAIN_GAME);
            }
        });

//    Stage 2 Button
        final ImageButton stage2 = new ImageButton(new TextureRegionDrawable(
                new TextureRegion( new Texture(
                        Gdx.files.internal("sprite/stage/stage_02/stage_02.png")))));
        stage2.setPosition(650,500);
        stage2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                setStageNum(2);
                ScreenManager.getInstance().showScreen(ScreenEnum.MAIN_GAME);
            }
        });

        //    Stage 3 Button
        final ImageButton stage3 = new ImageButton(new TextureRegionDrawable(
                new TextureRegion( new Texture(
                        Gdx.files.internal("sprite/stage/stage_03/stage_03.png")))));
        stage3.setPosition(100,200);
        stage3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                setStageNum(3);
                ScreenManager.getInstance().showScreen(ScreenEnum.MAIN_GAME);
            }
        });

        //    Stage 4 Button
        final ImageButton stage4 = new ImageButton(new TextureRegionDrawable(
                new TextureRegion( new Texture(
                        Gdx.files.internal("sprite/stage/stage_04/stage_04.png")))));
        stage4.setPosition(650,200);
        stage4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                setStageNum(4);
                ScreenManager.getInstance().showScreen(ScreenEnum.MAIN_GAME);
            }
        });

        addActor(stage1);
        addActor(stage2);
        addActor(stage3);
        addActor(stage4);
    }
    public void setStageNum(int stageNum){StageSelectScreen.stageNum = stageNum;}
}
