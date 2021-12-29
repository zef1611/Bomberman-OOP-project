package com.mygdx.game.Enemies;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Screen.MainGameScreen;
import com.mygdx.game.Stage.GameStage;

public class Alien extends Enemy{
    Sprite alien;

    Alien(int tileX, int tileY, DirectionEnum directionEnum, GameStage gameStage, Stage stage) {
        super(directionEnum, gameStage, stage);
        super.setName(EnemyEnum.ALIEN);

//        Set coordinate
        int x = MainGameScreen.playerX + 64 * tileX;
        int y = MainGameScreen.playerY + 64 * tileY;

//        Set enemy atlas and sprite
        switchAtlas();
        Array<TextureAtlas.AtlasRegion> walkLeft = getEnemyAtlas().findRegions("walk_left");
        currentAni = new Animation<>(1f/15f,walkLeft.get(0));
        alien = new Sprite(new TextureAtlas.AtlasSprite(walkLeft.get(0)));

//        Set enemy's initial position
        setBounds(x, y, alien.getRegionWidth(), alien.getRegionHeight());
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
