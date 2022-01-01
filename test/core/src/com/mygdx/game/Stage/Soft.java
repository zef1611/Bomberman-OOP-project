package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Player.ColorEnum;
import com.mygdx.game.Screen.MainGameScreen;

public class Soft extends Image {
    Sprite soft;
    public GameStage gameStage;
    private int borderX, borderY, borderWidth, borderHeight;

    //    tileX ~ 0 - 12
//    tileY ~ 0 - 10
//    this is according to the 13x11 grid of the game stage
    public Soft(int tileX, int tileY, int stageNum, GameStage gameStage, Stage stage) {
        int x = MainGameScreen.playerX + 64 * tileX;
        int y = MainGameScreen.playerY + 64 * tileY;

        soft = switchSprite(stageNum);
        soft.setPosition(x, y);

        setBounds(x, y, soft.getWidth(), soft.getHeight());
        borderX = x;
        borderY = y;
        borderWidth = 64;
        borderHeight = 64;
        this.gameStage = gameStage;
        gameStage.attachSoft(this);
        stage.addActor(this);
    }

    //    Switch soft block sprite according to stage
    protected Sprite switchSprite(int stageNum) {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/soft_solid/soft_solid.txt"));
        return new Sprite(new TextureAtlas.AtlasSprite(atlas.findRegion("soft", stageNum)));
    }

    //    Draw the sprite
    @Override
    public void draw(Batch batch, float parentAlpha) {
        soft.draw(batch);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void delSoft() {
        this.addAction(Actions.removeActor());
//        this.gameStage.detachSoft(this);
    }

    //    ------------------------------SETTERS/GETTERS---------------------------
    public int getBorderX() {
        return borderX;
    }

    public int getBorderY() {
        return borderY;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public int getBorderHeight() {
        return borderHeight;
    }
}
