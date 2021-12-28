package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class CharSelectScreen extends AbstractScreen{

    @Override
    public void buildStage() {
//    Background of the CharSelect Screen
        Texture txBackground = new Texture(Gdx.files.internal("sprite/raw_asset/bomberman_start_background.jpg"));
        Image background = new Image(txBackground);
        addActor(background);

//    Start 1 player button construction
        Texture txOne = new Texture(Gdx.files.internal("sprite/character_choosing_screen/1P.png"));
        final ImageButton OneP =
                new ImageButton(new TextureRegionDrawable(new TextureRegion(txOne)));
        OneP.setPosition(0,0,Align.center);


        OneP.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                ScreenManager.getInstance().showScreen(ScreenEnum.CHAR_SELECT_SCREEN);
                System.out.println("hello");
            }
        });
        addActor(OneP);

//    Start 2 players button construction
        Texture txTwo = new Texture(Gdx.files.internal("sprite/character_choosing_screen/2P RE.png"));
        final ImageButton TwoP =
                new ImageButton(new TextureRegionDrawable(new TextureRegion(txTwo)));
        TwoP.setPosition(160.f, 200.f);
        TwoP.setHeight(TwoP.getHeight()/2);
        TwoP.setWidth(TwoP.getWidth()/2);
//        TwoP.setSize(TwoP.getWidth()/2,TwoP.getHeight()/2);
        TwoP.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                final ImageButton mugshot1 = new ImageButton(new TextureRegionDrawable(
                        new TextureRegion( new Texture(
                                Gdx.files.internal("sprite/character_choosing_screen/bomberman_black.PNG")))));
                mugshot1.setPosition(20,500);
                mugshot1.setWidth(240);
                mugshot1.setHeight(240);
                System.out.println(mugshot1.getWidth());

                addActor(mugshot1);
                TwoP.remove();
                OneP.remove();
//                ScreenManager.getInstance().showScreen(ScreenEnum.CHAR_SELECT_SCREEN);

                System.out.println("hello");
            }
        });
        addActor(TwoP);

    }

    @Override
    public void dispose(){
        super.dispose();
    }
}
