package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;

import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
//Player state includes still, walking,
//Player direction include left right up down
//Combine to get the current sprite state

public class Player extends Image {
    PlayerAnimation playerAni;
    TextureAtlas atlas;
    Sprite player;
    Animation <TextureAtlas.AtlasRegion> currentAni;
    float elapsedTime = 0;
    MoveByAction currentAction = new MoveByAction();

    public enum StateEnum{
        WALK("walk"), STILL("still"), HWALK("hwalk"), HSTILL("hstill");
        String stateName;
        StateEnum(String stateName){
            this.stateName = stateName;
        }
        @Override
        public String toString(){
            return stateName;
        }
    };
    public enum DirectionEnum{
        LEFT("left"), RIGHT("right"), UP("up"), DOWN("down"), NONE("none");
        String directionName;
        DirectionEnum(String directionName){
            this.directionName = directionName;
        }
        @Override
        public String toString(){
            return directionName;
        }
    };

    int stepCount; // For deciding the animation in update method
    DirectionEnum direction = DirectionEnum.NONE;
    StateEnum state = StateEnum.STILL;
    ColorEnum color;

    public Player(com.mygdx.game.ColorEnum color) {
//        Import the texture
        atlas = switchCharacter(color);

//        Allow animation to be updated
        playerAni = new PlayerAnimation(this, atlas);

//        Set the player avatar and bounds
        Array<TextureAtlas.AtlasRegion> stillFrames = atlas.findRegions("bomberman_still");
        currentAni = new Animation<>(1f/15f,stillFrames.get(0));
        player = new Sprite(new TextureAtlas.AtlasSprite(stillFrames.get(0)));
        setBounds(player.getRegionX(), player.getRegionY(), player.getRegionWidth(), player.getRegionHeight());
        setTouchable(Touchable.enabled);

//        For Character to move
        input();
//        Work around for character to move 1 step at a time
        currentAction.setDuration(0f);
        Player.this.addAction(currentAction);
    }

//    This is to render animations
    @Override
    public void draw(Batch batch, float parentAlpha) {
        boolean flip = (direction == DirectionEnum.LEFT);
        elapsedTime += Gdx.graphics.getDeltaTime();
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
        player.setPosition(getX(),getY());
        super.positionChanged();
    }

    public void position(int x, int y) {
        setPosition(x, y);
        player.setPosition(x, y);
    }

//    Every input happens here + Update the animation
    public void input(){
        addListener(new InputListener(){
            public boolean keyDown(InputEvent event, int keycode){
                if(keycode == Input.Keys.D && currentAction.isComplete()){
                    MoveByAction right = new MoveByAction();
                    right.setAmount(64f, 0f);
                    right.setDuration(1f/2f);
                    currentAction = right;
//                    System.out.println(right.isComplete());
                    Player.this.addAction(right);

                    // For animations
                    if(direction != DirectionEnum.RIGHT){
                        stepCount = 0;
                    }
                    direction = DirectionEnum.RIGHT;
                    stepCount++;
                    state = StateEnum.WALK;
                    playerAni.updateAni();
                }
                if(keycode ==Input.Keys.W && currentAction.isComplete()){
                    MoveByAction up = new MoveByAction();
                    up.setAmount(0f,64f);
                    up.setDuration(1f/2f);
                    currentAction = up;
                    Player.this.addAction(up);

                    // For animations
                    if(direction != DirectionEnum.UP) {
                        stepCount = 0;
                    }
                    direction = DirectionEnum.UP;
                    stepCount++;
                    state = StateEnum.WALK;
                    playerAni.updateAni();

//                    Debugging
//                    String text = String.format("%s %f %f","W",Player.this.getX(),Player.this.getY());
//                    System.out.println(text);
                }
                if(keycode == Input.Keys.S && currentAction.isComplete()){
                    MoveByAction down = new MoveByAction();
                    down.setAmount(0f,-64f);
                    down.setDuration(1f/2f);
                    currentAction = down;
                    Player.this.addAction(down);

                    // For animations
                    if(direction != DirectionEnum.DOWN) {
                        stepCount = 0;
                    }
                    direction = DirectionEnum.DOWN;
                    stepCount++;
                    state = StateEnum.WALK;
                    playerAni.updateAni();

//                    Debugging
//                    String text = String.format("%s %f %f","S",Player.this.getX(),Player.this.getY());
//                    System.out.println(text);
                }
                if(keycode == Input.Keys.A && currentAction.isComplete()){
                    MoveByAction left = new MoveByAction();
                    left.setAmount(-64f, 0f);
                    left.setDuration(1f/2f);
                    currentAction = left;
                    Player.this.addAction(left);

                    // For animations
                    if(direction != DirectionEnum.LEFT) {
                        stepCount = 0;
                    }
                    direction = DirectionEnum.LEFT;
                    stepCount++;
                    state = StateEnum.WALK;
                    playerAni.updateAni();

//                    Debugging
//                    String text = String.format("%s %f %f","A",Player.this.getX(),Player.this.getY());
//                    System.out.println(text);
                }

                return true;
            }
        });
    }

    protected TextureAtlas switchCharacter(com.mygdx.game.ColorEnum color) {
        String colorName = color.toString();
        String fileName = "sprite_sheet/character/bomberman_" + colorName + "/bomber_" + colorName + ".txt";
        return new TextureAtlas(Gdx.files.internal(fileName));
    }
//---------------------------GETTER/SETTERS------------------------
    public StateEnum getState(){
        return state;
    }
    protected  void setState(StateEnum state){
        this.state = state;
    }

    public DirectionEnum getDirection(){
        return direction;
    }
    protected  void setDirection(DirectionEnum direction){
        this.direction = direction;
    }

    public int getStepCount(){
        return stepCount;
    }
    protected void setStepCount(int stepCount){
        this.stepCount = stepCount;
    }

    public Animation <TextureAtlas.AtlasRegion> getCurrentAni(){
        return currentAni;
    }
    protected void setCurrentAni(Animation <TextureAtlas.AtlasRegion> currentAni){
        this.currentAni = currentAni;
    }

    public float getElapsedTime(){
        return elapsedTime;
    }
    protected void setElapsedTime(float elapsedTime){
        this.elapsedTime = elapsedTime;
    }


}
