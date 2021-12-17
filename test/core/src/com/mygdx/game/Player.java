package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;

import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;

import java.util.Iterator;
//Player state includes still, walking,
//Player direction include left right up down
//Combine to get the current sprite state

public class Player extends Image {
    PlayerAnimation playerAni;
    TextureAtlas atlas;
    Sprite player;
    Animation <TextureAtlas.AtlasRegion> currentAni;
    float elapsedTime = 0;
    public enum StateEnum{WALK, STILL, HWALK, HSTILL};
    public enum DirectionEnum{LEFT, RIGHT, UP, DOWN, NONE};
    public enum ColorEnum {BLACK, BLUE, GREEN, RED, WHITE};
    int stepCount; // For deciding the animation in update method
    DirectionEnum direction = DirectionEnum.NONE;
    StateEnum state = StateEnum.STILL;
    ColorEnum color;

    public Player(PlayerEnum color) {
//        Allow animation to be updated
        playerAni = new PlayerAnimation(this);

//        Import the texture
        atlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/character/bomberman_black/bomber_black.txt"));
        Array<TextureAtlas.AtlasRegion> stillFrames = atlas.findRegions("bomberman_still");
        currentAni = new Animation<>(1f/15f,stillFrames);

//        Set the player avatar and bounds
        player = new Sprite(new TextureAtlas.AtlasSprite(currentAni.getKeyFrames()[1]));
        setBounds(player.getRegionX(), player.getRegionY(), player.getRegionWidth(), player.getRegionHeight());
        setTouchable(Touchable.enabled);

//        For Character to move
        input();
    }

//    This is to render animations
    @Override
    public void draw(Batch batch, float parentAlpha) {
        boolean flip = (direction == DirectionEnum.LEFT);
        elapsedTime += Gdx.graphics.getDeltaTime();
        System.out.println(elapsedTime);
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
        float STEP = 16f;
    }

    public void position(int x, int y){
        setPosition(x, y);
        player.setPosition(x, y);
    }

//    This is used to update animation in the input method depends on state and direction
    public void updateAni(){
        elapsedTime = 0;
        if(state == StateEnum.WALK){
            switch (direction){
                case RIGHT:
                case LEFT:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_right_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_right_o"));
                    }
                    break;
                case UP:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_up_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_up_o"));
                    }
                    break;
                case DOWN:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_down_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_walk_down_o"));
                    }
                    break;
                case NONE:
                    break;
            }
        }
        if(state == StateEnum.HWALK){
            switch (direction){
                case RIGHT:
                case LEFT:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_right_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_right_o"));
                    }
                    break;
                case UP:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_up_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_up_o"));
                    }
                    break;
                case DOWN:
                    if(stepCount%2==0){
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_down_e"));
                    } else {
                        currentAni = new Animation<>(1f/8f,atlas.findRegions(
                                "bomberman_hwalk_down_o"));
                    }
                    break;
                case NONE:
                    break;
            }
        }

    }

//    Every input happens here + Update the animation
    public void input(){
        addListener(new InputListener(){
            public boolean keyDown(InputEvent event, int keycode){
                if(keycode == Input.Keys.D){
                    MoveByAction right = new MoveByAction();
                    right.setAmount(64f, 0f);
                    right.setDuration(1f/2f);
                    Player.this.addAction(right);

                    // For animations
                    if(direction != DirectionEnum.RIGHT){
                        stepCount = 0;
                    }
                    direction = DirectionEnum.RIGHT;
                    stepCount++;
                    state = StateEnum.WALK;
                    updateAni();
                }
                if(keycode ==Input.Keys.W){
                    MoveByAction up = new MoveByAction();
                    up.setAmount(0f,64f);
                    up.setDuration(1f/2f);
                    Player.this.addAction(up);

                    // For animations
                    if(direction != DirectionEnum.UP) {
                        stepCount = 0;
                    }
                    direction = DirectionEnum.UP;
                    stepCount++;
                    state = StateEnum.WALK;
                    updateAni();

//                    Debugging
//                    String text = String.format("%s %f %f","W",Player.this.getX(),Player.this.getY());
//                    System.out.println(text);
                }
                if(keycode == Input.Keys.S){
                    MoveByAction down = new MoveByAction();
                    down.setAmount(0f,-64f);
                    down.setDuration(1f/2f);
                    Player.this.addAction(down);

                    // For animations
                    if(direction != DirectionEnum.DOWN) {
                        stepCount = 0;
                    }
                    direction = DirectionEnum.DOWN;
                    stepCount++;
                    state = StateEnum.WALK;
                    updateAni();

//                    Debugging
//                    String text = String.format("%s %f %f","S",Player.this.getX(),Player.this.getY());
//                    System.out.println(text);
                }
                if(keycode == Input.Keys.A){
                    MoveByAction left = new MoveByAction();
                    left.setAmount(-64f, 0f);
                    left.setDuration(1f/2f);
                    Player.this.addAction(left);

                    // For animations
                    if(direction != DirectionEnum.LEFT) {
                        stepCount = 0;
                    }
                    direction = DirectionEnum.LEFT;
                    stepCount++;
                    state = StateEnum.WALK;
                    updateAni();

//                    Debugging
//                    String text = String.format("%s %f %f","A",Player.this.getX(),Player.this.getY());
//                    System.out.println(text);
                }

                return true;
            }
        });
    }

    @Override
    protected void positionChanged(){
        player.setPosition(getX(),getY());
        super.positionChanged();
    }

    public StateEnum getState(){
        return state;
    }
    public DirectionEnum getDirection(){
        return direction;
    }
    public int getStepCount(){
        return stepCount;
    }
    protected  void setState(StateEnum state){
        this.state = state;
    }
    protected  void setDirection(DirectionEnum direction){
        this.direction = direction;
    }
    protected void setStepCount(int stepCount){
        this.stepCount = stepCount;
    }

//    protected Sprite switchCharacter(PlayerEnum color) {
//        switch (color){
//            case BLACK:
//                player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_black/still/bomberman_still_1.png")));
//                break;
//            case BLUE:
//                player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_blue/still/bomberman_still_1.png")));
//                break;
//            case GREEN:
//                player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_green/still/bomberman_still_1.png")));
//                break;
//            case RED:
//                player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_red/still/bomberman_still_1.png")));
//                break;
//            case WHITE:
//                player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_white/still/bomberman_still_1.png")));
//                break;
//        }
//        return player;
//    }
}
