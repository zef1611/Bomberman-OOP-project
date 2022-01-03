package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Player.ColorEnum;

public class CharSelectScreen extends AbstractScreen{

    static ColorEnum colorEnum;
    @Override
    public void buildStage() {
//    Background of the CharSelect Screen
        Texture txBackground = new Texture(Gdx.files.internal("sprite/raw_asset/bomberman_start_background.jpg"));
        Image background = new Image(txBackground);
        addActor(background);

        // Player Black
        final ImageButton mugshot1 = new ImageButton(new TextureRegionDrawable(
                new TextureRegion(new Texture(
                        Gdx.files.internal("sprite/character_choosing_screen/bomberman_black.PNG")))));
        mugshot1.setWidth(200);
        mugshot1.setHeight(200);
        mugshot1.setPosition(30, 500);
        mugshot1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setColorEnum(ColorEnum.BLACK);
                ScreenManager.getInstance().showScreen(ScreenEnum.STAGE_SELECT_SCREEN);
            }
        });
        // Player Blue
        final ImageButton mugshot2 = new ImageButton(new TextureRegionDrawable(
                new TextureRegion(new Texture(
                        Gdx.files.internal("sprite/character_choosing_screen/bomberman_blue.PNG")))));
        mugshot2.setWidth(200);
        mugshot2.setHeight(200);
        mugshot2.setPosition((1024 - mugshot2.getWidth()) / 2, 500);
        mugshot2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setColorEnum(ColorEnum.BLUE);
                ScreenManager.getInstance().showScreen(ScreenEnum.STAGE_SELECT_SCREEN);
            }
        });

        // Player Green
        final ImageButton mugshot3 = new ImageButton(new TextureRegionDrawable(
                new TextureRegion(new Texture(
                        Gdx.files.internal("sprite/character_choosing_screen/bomberman_green.PNG")))));
        mugshot3.setWidth(200);
        mugshot3.setHeight(200);
        mugshot3.setPosition(824 - 30, 500);

        mugshot3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setColorEnum(ColorEnum.GREEN);
                ScreenManager.getInstance().showScreen(ScreenEnum.STAGE_SELECT_SCREEN);
            }
        });

        // Player Red
        final ImageButton mugshot4 = new ImageButton(new TextureRegionDrawable(
                new TextureRegion(new Texture(
                        Gdx.files.internal("sprite/character_choosing_screen/bomberman_red.PNG")))));
        mugshot4.setWidth(200);
        mugshot4.setHeight(200);
        mugshot4.setPosition(((1024 - mugshot4.getWidth()) / 2 - 30) / 2 + 20, 200);
        mugshot4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setColorEnum(ColorEnum.RED);
                ScreenManager.getInstance().showScreen(ScreenEnum.STAGE_SELECT_SCREEN);
            }
        });
        // Player White
        final ImageButton mugshot5 = new ImageButton(new TextureRegionDrawable(
                new TextureRegion(new Texture(
                        Gdx.files.internal("sprite/character_choosing_screen/bomberman_white.PNG")))));
        mugshot5.setWidth(200);
        mugshot5.setHeight(200);
        mugshot5.setPosition((1024 - mugshot5.getWidth()) / 2 + 200, 200);
        mugshot5.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setColorEnum(ColorEnum.WHITE);
                ScreenManager.getInstance().showScreen(ScreenEnum.STAGE_SELECT_SCREEN);
            }
        });
        addActor(mugshot1);
        addActor(mugshot2);
        addActor(mugshot3);
        addActor(mugshot4);
        addActor(mugshot5);
    }
    private void setColorEnum(ColorEnum color){CharSelectScreen.colorEnum = color;}

    @Override
    public void dispose(){
        super.dispose();
    }
}
