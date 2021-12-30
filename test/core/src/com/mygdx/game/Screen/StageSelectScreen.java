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
        Texture txTable = new Texture(Gdx.files.internal("sprite/stage/stage_01/Table.png"));
        Image table = new Image(txTable);
        table.setHeight(700);
        table.setWidth(900);
        table.setPosition((1024- table.getWidth())/2, 150);
        addActor(background);
        addActor(table);
//    Stage 1 Button
        final ImageButton stage1 = new ImageButton(new TextureRegionDrawable(
                new TextureRegion( new Texture(
                        Gdx.files.internal("sprite/stage/stage_01/stage1.png")))));
        stage1.setHeight(476);
        stage1.setWidth(364);
        stage1.setPosition(100,430);
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
                        Gdx.files.internal("sprite/stage/stage_02/stage2.png")))));
        stage2.setHeight(476);
        stage2.setWidth(364);
        stage2.setPosition(555,430);
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
                        Gdx.files.internal("sprite/stage/stage_03/stage3.png")))));
        stage3.setHeight(476);
        stage3.setWidth(364);
        stage3.setPosition(100,115);
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
                        Gdx.files.internal("sprite/stage/stage_04/stage4.png")))));
        stage4.setHeight(476);
        stage4.setWidth(364);
        stage4.setPosition(555,115);
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
