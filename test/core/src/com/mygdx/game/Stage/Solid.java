package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Screen.MainGameScreen;

public class Solid extends Image {
    Sprite solid;
    int borderX, borderY, borderWidth, borderHeight;

//    tileX ~ 0 - 12
//    tileY ~ 0 - 10
//    this is according to the 13x11 grid of the game stage
    public Solid(int tileX, int tileY, int stageNum, GameStage gameStage, Stage stage){
        int x = MainGameScreen.playerX +64 * tileX;
        int y = MainGameScreen.playerY +64 * tileY;

        solid = switchSprite(stageNum);
        solid.setPosition(x,y);
        setBounds(x, y, solid.getWidth(), solid.getHeight());
        borderX = x;
        borderY = y;
        borderWidth = 64;
        borderHeight = 64;

        gameStage.attachSolid(this);
        stage.addActor(this);
    }

    //    Switch soft block sprite according to stage
    protected Sprite switchSprite(int stageNum) {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/soft_solid/soft_solid.txt"));
        return new Sprite(new TextureAtlas.AtlasSprite(atlas.findRegion("solid",stageNum)));
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        solid.draw(batch);
    }


    public void update() {

    }

//    ----------------------------SETTERS/GETTERS-----------------------------
    public int getBorderY(){return borderY;}
    public int getBorderX(){return borderX;}
    public int getBorderHeight(){return borderHeight;}
    public int getBorderWidth(){return borderWidth;}
}
