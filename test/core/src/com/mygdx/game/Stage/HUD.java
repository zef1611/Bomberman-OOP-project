package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class HUD extends Image {
    private final int hudX, hudY;
    private Sprite bomb;
    private Sprite currentBomb;
    private static int bombVal = 0;

    private Sprite life;
    private Sprite currentLife;
    private static int lifeVal = 3;

    private Sprite range;
    private Sprite currentRange;
    private static int rangeVal = 0;

    private Sprite speed;
    private Sprite currentSpeed;
    private static int speedVal = 0;

    private final TextureAtlas hudAtlas;
    private static boolean isUpdated = false;

    public HUD(){
        hudAtlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/hud/hud.txt"));

        hudX = 0;
        hudY = 833;
        initializeSprite();
        setPositionSprite();
        setScaleSprite();
    }

    private void setPositionSprite(){
        bomb.setPosition(hudX + 214,hudY + 19);
        currentBomb.setPosition(hudX + 262,hudY + 19);

        life.setPosition(hudX + 22,hudY + 19);
        currentLife.setPosition(hudX + 70,hudY + 19);

        range.setPosition(hudX + 406,hudY + 19);
        currentRange.setPosition(hudX + 454, hudY + 19);

        speed.setPosition(hudX + 598, hudY + 19);
        currentSpeed.setPosition(hudX + 646, hudY + 19);
    }

    private void initializeSprite(){
        //      Number of Bombs
        bomb = new TextureAtlas.AtlasSprite(hudAtlas.findRegion("bomb_up"));
        currentBomb = new TextureAtlas.AtlasSprite(hudAtlas.findRegion("number",bombVal));

//      Number of Lives
        life = new TextureAtlas.AtlasSprite(hudAtlas.findRegion("bomberman_icon"));
        currentLife = new TextureAtlas.AtlasSprite(hudAtlas.findRegion("number",lifeVal));

//      Number of range increase
        range = new TextureAtlas.AtlasSprite(hudAtlas.findRegion("fire_up"));
        currentRange = new TextureAtlas.AtlasSprite(hudAtlas.findRegion("number",rangeVal));

//      Number of speed increase
        speed = new TextureAtlas.AtlasSprite(hudAtlas.findRegion("accelerator"));
        currentSpeed = new TextureAtlas.AtlasSprite(hudAtlas.findRegion("number",speedVal));
    }

    private void setScaleSprite(){
        bomb.setOrigin(0,0);
        bomb.setScale(48f/64, 48f/64);
        life.setOrigin(0,0);
        life.setScale(48f/512,48f/512);
        range.setOrigin(0,0);
        range.setScale(48f/64, 48f/64);
        speed.setOrigin(0,0);
        speed.setScale(48f/64, 48f/64);

        currentBomb.setOrigin(0,0);
        currentBomb.setScale(3,3);
        currentLife.setOrigin(0,0);
        currentLife.setScale(3,3);
        currentRange.setOrigin(0,0);
        currentRange.setScale(3,3);
        currentSpeed.setOrigin(0,0);
        currentSpeed.setScale(3,3);
    }

    private void updateCurrentVal(){
        currentBomb = hudAtlas.createSprite("number", bombVal);
        currentLife = hudAtlas.createSprite("number", lifeVal);
        currentRange = hudAtlas.createSprite("number", rangeVal);
        currentSpeed = hudAtlas.createSprite("number", speedVal);
        setScaleSprite();
        setPositionSprite();
    }


    @Override
    public void draw(Batch batch, float parentAlpha){
        if(isUpdated){
            updateCurrentVal();
            isUpdated = false;
        }
        bomb.draw(batch);
        currentBomb.draw(batch);

        life.draw(batch);
        currentLife.draw(batch);

        range.draw(batch);
        currentRange.draw(batch);

        speed.draw(batch);
        currentSpeed.draw(batch);
    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }

//    ----------------------------SETTERS/GETTERS-------------------------------
    public static void setBombVal(int bombVal){
        HUD.bombVal = bombVal;
        isUpdated = true;
    }
    public static void setLifeVal(int lifeVal){
        HUD.lifeVal = lifeVal;
        isUpdated = true;
    }
    public static void setRangeVal(int rangeVal){
        HUD.rangeVal = rangeVal;
        isUpdated = true;
    }
    public static void setSpeedVal(int speedVal){
        HUD.speedVal = speedVal;
        isUpdated = true;
    }
    public static void updateHUD(int speedVal, int lifeVal, int rangeVal, int bombVal) {
        setRangeVal(rangeVal);
        setSpeedVal(speedVal);
        setBombVal(bombVal);
        setLifeVal(lifeVal);
    }
}
