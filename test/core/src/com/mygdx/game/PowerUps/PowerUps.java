package com.mygdx.game.PowerUps;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.mygdx.game.Items;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Screen.MainGameScreen;
import com.mygdx.game.Stage.GameStage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.awt.*;

public abstract class PowerUps extends Image {
    protected int borderX, borderY, borderWidth, borderHeight;
    public Sprite sprite;
    TextureAtlas atlas;
    GameStage gameStage;
    Player player;
    Stage stage;

    public PowerUps(int tileX, int tileY, GameStage gameStage, Stage stage) {
        int x = MainGameScreen.playerX + 64 * tileX;
        int y = MainGameScreen.playerY + 64 * tileY;
        setUpSprite();
        sprite.setPosition(x, y);
        setBounds(x, y, sprite.getWidth(), sprite.getHeight());
        borderX = x;
        borderY = y;
        borderWidth = (int) sprite.getWidth();
        borderHeight = (int) sprite.getHeight();
        stage.addActor(this);
        this.stage = stage;

        this.gameStage = gameStage;
        gameStage.attachPowerUps(this);
    }

    public abstract void setUpSprite();


    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    public abstract void execute(Player player);

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void del() {
        this.addAction(Actions.removeActor());
    }

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
