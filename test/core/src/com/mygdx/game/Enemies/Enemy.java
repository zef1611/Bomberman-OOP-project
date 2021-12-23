package com.mygdx.game.Enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Player.Player;

//Responsible for position, bounds, animation, movement
//Spawning the enemies will be taken care of by other class
public abstract class Enemy extends Image {
    int stageNum;
    EnemyEnum enemy;
    TextureAtlas enemyAtlas;
    Animation<TextureAtlas.AtlasRegion> currentAni;
    private float elapsedTime = 0;
    DirectionEnum direction;

    Enemy(int stageNum){
        this.stageNum = stageNum;
    }
    protected void switchAtlas(){
        String enemyName = enemy.toString();
        String fileName = "sprite_sheet/enemies/"+enemyName+"/"+enemyName+".txt";
        this.enemyAtlas = new TextureAtlas(Gdx.files.internal(fileName));
    }

    @Override
    public void draw(Batch batch,float parentAlpha){
        elapsedTime += Gdx.graphics.getDeltaTime();
        boolean flip = (direction == DirectionEnum.LEFT);
        elapsedTime += Gdx.graphics.getDeltaTime();
        if(flip){
            batch.draw(currentAni.getKeyFrame(elapsedTime), getX()+getWidth(), getY(),-getWidth(),getHeight());
        }
        else{
            batch.draw(currentAni.getKeyFrame(elapsedTime), getX(), getY(),getWidth(),getHeight());
        }
    }
//    ---------------------SETTERS/GETTERS-------------------
    public void setName(EnemyEnum enemy){
        this.enemy = enemy;
    }
    public TextureAtlas getEnemyAtlas() {
        return enemyAtlas;
    }
}
