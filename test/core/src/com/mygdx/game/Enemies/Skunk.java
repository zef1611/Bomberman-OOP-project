package com.mygdx.game.Enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Screen.MainGameScreen;
import com.mygdx.game.Stage.GameStage;

//This enemy is spawned in stage 3
public class Skunk extends Enemy{
    private Sprite skunk;

//    tileX and tileY are for easier spawning system on a grid of size 13x11
    public Skunk(int tileX, int tileY, DirectionEnum directionEnum, GameStage gameStage, Stage stage, int ID) {
        super(directionEnum, gameStage, stage, ID);
        super.setName(EnemyEnum.SKUNK);

//        Set coordinate
        int x = MainGameScreen.playerX + 64 * tileX;
        int y = MainGameScreen.playerY + 64 * tileY;

//        Set enemy atlas and sprite
        switchAtlas();
        Array<TextureAtlas.AtlasRegion> walkLeft = getEnemyAtlas().findRegions("walk_left");
        currentAni = new Animation<>(1f/15f,walkLeft.get(0));
        skunk = new Sprite(new TextureAtlas.AtlasSprite(walkLeft.get(0)));

//        Set enemy's initial position
        setBounds(x, y, skunk.getRegionWidth(), skunk.getRegionHeight());
        super.setBorder(x,y);

//        Movement
        enemyMove = new EnemyMove(this, enemyAtlas,gameStage);
    }

//    Draw the enemy
    @Override
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch,parentAlpha);
    }

}
