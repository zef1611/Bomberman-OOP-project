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
    TextureAtlas atlasBlack;
    TextureRegion walk;
    TextureRegion currentFrame;
    Sprite player;
    Boolean isLeft= false, isRight=false, isUp=false, isDown = false;
    Image img;
    Animation<TextureAtlas.AtlasRegion> walkingAni;
    Animation<TextureAtlas.AtlasRegion> stillAni;
    Animation <TextureAtlas.AtlasRegion> currentAni;
    PlayerEnum color;
    float elapsedTime = 0;

    public enum StateEnum{WALK, STILL, HWALK, HSTILL};
    public enum DirectionEnum{LEFT, RIGHT, UP, DOWN, NONE};

    DirectionEnum direction = DirectionEnum.NONE;
    StateEnum state = StateEnum.STILL;

    public Player(PlayerEnum color) {
        atlasBlack = new TextureAtlas(Gdx.files.internal("sprite_sheet/character/bomberman_black/bomber_black.txt"));
        walk = atlasBlack.findRegion("bomberman_walk",1);
        player = new Sprite(walk);
        setBounds(player.getRegionX(), player.getRegionY(), player.getRegionWidth(), player.getRegionHeight());
        setTouchable(Touchable.enabled);
        input();
//        setPosition(96,64);
        Array<TextureAtlas.AtlasRegion> walkingFrames = atlasBlack.findRegions("bomberman_walk");
        Array<TextureAtlas.AtlasRegion> stillFrames = atlasBlack.findRegions("bomberman_still");

        walkingAni = new Animation<>(1f/15f,walkingFrames);
        stillAni = new Animation<>(1f/15f,stillFrames);
        currentAni = walkingAni;
//        player = new TextureAtlas.AtlasSprite(ani.getKeyFrame(2f/2f));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
//        player.draw(batch);
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(currentAni.getKeyFrames()[0], getX(), getY());
        if (direction == DirectionEnum.RIGHT) {
            float startTime = elapsedTime;
            System.out.println(startTime);
            System.out.println(elapsedTime - startTime);
            batch.draw(currentAni.getKeyFrames()[2], getX(), getY(), -getWidth(), getHeight());
            batch.draw(currentAni.getKeyFrames()[4], getX(), getY(), -getWidth(), getHeight());

            direction = DirectionEnum.NONE;
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

    public void input(){
        addListener(new InputListener(){
            public boolean keyDown(InputEvent event, int keycode){
                if(keycode == Input.Keys.D){
                    MoveByAction right = new MoveByAction();
                    right.setAmount(64f, 0f);
                    right.setDuration(1f/2f);

                    Player.this.addAction(right);
                    direction = DirectionEnum.RIGHT;

                }
                if(keycode ==Input.Keys.W){
                    MoveByAction up = new MoveByAction();
                    up.setAmount(0f,64f);
                    up.setDuration(1f/2f);
//                    up.setTime(5f);
                    Player.this.addAction(up);
                    isUp = true;
//                    Debugging
//                    String text = String.format("%s %f %f","W",Player.this.getX(),Player.this.getY());
//                    System.out.println(text);
                }
                if(keycode == Input.Keys.S){
                    MoveByAction down = new MoveByAction();
                    down.setAmount(0f,-64f);
                    down.setDuration(1f/2f);
//                    down.setTime(5f);
                    Player.this.addAction(down);
                    isDown = true;
//                    Debugging
//                    String text = String.format("%s %f %f","S",Player.this.getX(),Player.this.getY());
//                    System.out.println(text);
                }
                if(keycode == Input.Keys.A){
                    MoveByAction left = new MoveByAction();
                    left.setAmount(-64f, 0f);
                    left.setDuration(1f/2f);
//                    left.setTime(5f);
                    Player.this.addAction(left);
                    isLeft = true;
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
//        player.setRegionX((int)getX());
//        player.setRegionY((int)getY());
        super.positionChanged();
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
