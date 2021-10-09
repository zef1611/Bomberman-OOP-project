package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Null;


import java.awt.*;

public class StartingScreen extends AbstractScreen{

    @Override
    public void buildStage() {
        Texture txBackground = new Texture(Gdx.files.internal("sprite" +
                "/starting_screen/starting_screen.png"));
        Image background = new Image(txBackground);
        addActor(background);

        Texture txStart = new Texture(Gdx.files.internal("sprite/starting_screen" +
                "/bomberman_icon.png"));
        ImageButton start =
                new ImageButton(new TextureRegionDrawable(new TextureRegion(txStart)));
        start.setPosition(160.f, 500.f, Align.center);
        start.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y){
               System.out.println("hello");
           }
        });
        addActor(start);

    }

    @Override
    public dispose(){

    }
}
