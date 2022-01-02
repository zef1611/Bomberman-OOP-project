package com.mygdx.game.Enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.StateEnum;

//Responsible for position, bounds, animation, movement
//Spawning the enemies will be taken care of by other class
public abstract class Enemy extends Image {
    private EnemyEnum enemy;
    protected TextureAtlas enemyAtlas;
    protected Animation<TextureAtlas.AtlasRegion> currentAni;
    protected MoveByAction currentAction = new MoveByAction();
    private float elapsedTime = 0;
    private DirectionEnum direction;
    private StateEnum state;
    private boolean isAlive = true;
    protected EnemyMove enemyMove;
    private int borderX, borderY, borderWidth, borderHeight;
    GameStage gameStage;

    protected Enemy(DirectionEnum directionEnum, GameStage gameStage, Stage stage){
//        Set the hitbox of enemy
        borderWidth = 64;
        borderHeight = 64;

//        Set enemy state (include: STILL, WALK)
        state = StateEnum.WALK;
        direction = directionEnum;

//        Preemptively set the current action
        Enemy.this.addAction(currentAction);
        currentAction.act(0.1f);

        this.gameStage = gameStage;
//        Add enemy into listEnemy
        gameStage.attachEnemy(this);
        stage.addActor(this);
    }
    protected void switchAtlas(){
        String enemyName = enemy.toString();
        String fileName = "sprite_sheet/enemies/"+enemyName+"/"+enemyName+".txt";
        this.enemyAtlas = new TextureAtlas(Gdx.files.internal(fileName));
    }

    protected void setBorder(int x, int y){
        setBorderX(x);
        setBorderY(y);
    }
    @Override
    public void draw(Batch batch,float parentAlpha){

        elapsedTime += Gdx.graphics.getDeltaTime();
        enemyMove.movement();
        boolean flip = (direction == DirectionEnum.RIGHT);
        elapsedTime += Gdx.graphics.getDeltaTime();
        int x = (int) getX(), y = (int) getY();
//        Sys
        if (this.gameStage.getDeath(x / 64, y/64) > 0) {
            this.del();
        }
        if(flip){
            batch.draw(currentAni.getKeyFrame(elapsedTime), getX()+getWidth(), getY(),-getWidth(),getHeight());
        }
        else{
            batch.draw(currentAni.getKeyFrame(elapsedTime), getX(), getY(),getWidth(),getHeight());
        }
    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    protected void positionChanged(){

        super.positionChanged();
    }
    public void del() {
        this.addAction(Actions.removeActor());
    }
//    ---------------------SETTERS/GETTERS-------------------
    public void setName(EnemyEnum enemy){
        this.enemy = enemy;
    }

    public TextureAtlas getEnemyAtlas() {
        return enemyAtlas;
    }

    public Animation<TextureAtlas.AtlasRegion> getCurrentAni() { return currentAni;}

    public void setCurrentAni(Animation<TextureAtlas.AtlasRegion> currentAni) {this.currentAni = currentAni;}

    public boolean isAlive(){return isAlive;}

    public void setBorderX(int borderX){this.borderX = borderX;}
    public void setBorderY(int borderY){this.borderY = borderY;}
    public int getBorderX(){return borderX;}
    public int getBorderY(){return  borderY;}
    public int getBorderWidth(){return borderWidth;}
    public int getBorderHeight(){return borderHeight;}

    public DirectionEnum getDirection() {return direction;}
    public void setDirection(DirectionEnum direction) {this.direction = direction;}

    public StateEnum getState(){return state;}
    public void setState(StateEnum state){this.state = state;}

    public void setCurrentAction(MoveByAction currentAction){this.currentAction = currentAction;}
    public MoveByAction getCurrentAction(){return currentAction;}

    public float getElapsedTime(){return elapsedTime;}
    public void setElapsedTime(float elapsedTime){this.elapsedTime = elapsedTime;}

}
