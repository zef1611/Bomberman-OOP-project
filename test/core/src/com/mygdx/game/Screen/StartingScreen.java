package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class StartingScreen extends AbstractScreen {

    @Override
    public void buildStage() {
//    Background of the starting screen
        Texture txBackground = new Texture(Gdx.files.internal("sprite/starting_screen/New Background.png"));
        Image background = new Image(txBackground);
        background.setPosition(0,0);
        addActor(background);

//    Start button construction
        Texture txStart = new Texture(Gdx.files.internal("sprite/character_choosing_screen/start.png"));
        ImageButton start =
                new ImageButton(new TextureRegionDrawable(new TextureRegion(txStart)));
        start.setPosition(200.f, 150.f, Align.center);

//    Start button implementation
        start.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y){
               ScreenManager.getInstance().showScreen(ScreenEnum.CHAR_SELECT_SCREEN);
               System.out.println("hello");
           }
        });
        addActor(start);

    }

    @Override
    public void dispose(){
        super.dispose();
    }
}
