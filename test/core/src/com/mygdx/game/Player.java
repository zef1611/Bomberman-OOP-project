package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

import java.util.Objects;

import static com.badlogic.gdx.Gdx.input;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Player extends Actor {
    Sprite player;
    PlayerEnum color;

    public Player(PlayerEnum color) {
        player = switchCharacter(color);
        setBounds(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        setTouchable(Touchable.enabled);
//        setPosition(96,64);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        player.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

    public void position(int x, int y){
        setPosition(x, y);
        player.setPosition(x, y);
    }

    public void input(){
        addListener(new InputListener(){
            public boolean keyDown(InputEvent event, int keycode){
                if(keycode == Input.Keys.D){
//                    MoveByAction right = new MoveByAction();
//                    right.setAmount(128f, 0f);
//                    right.setDuration(30f);
//                    right.setTime(5f);
                    System.out.println("D");
                    positionChange(64f, 0f);

//                    Player.this.addAction(right);
                }
                if(keycode ==Input.Keys.W){
//                    MoveByAction up = new MoveByAction();
//                    up.setAmount(0f,128f);
//                    up.setDuration(5f);
//                    up.setTime(5f);
                    System.out.println("W %f %f",(float)player.getX(),player.getY());

                    positionChange(0f,64f);

//                    Player.this.addAction(up);
                }
                if(keycode == Input.Keys.S){
//                    MoveByAction down = new MoveByAction();
//                    down.setAmount(0f,-128f);
//                    down.setDuration(5f);
//                    down.setTime(5f);
                    System.out.println("S");
                    positionChange(0f,-64f);

//                    Player.this.addAction(down);
                }
                if(keycode == Input.Keys.A){
//                    MoveByAction left = new MoveByAction();
//                    left.setAmount(-128f, 0f);
//                    left.setDuration(5f);
//                    left.setTime(5f);
                    System.out.println("A");
                    positionChange(-64f, 0f);

//                    Player.this.addAction(left);
                }
                return true;
            }
        });
    }

    protected void positionChange(float x, float y){
        setPosition(getX()+x,getY()+y);
        player.setPosition(getX()+x,getY()+y);
//        super.positionChanged();
    }

    protected Sprite switchCharacter(PlayerEnum color) {
        switch (color){
            case BLACK:
                player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_black/still/bomberman_still_1.png")));
                break;
            case BLUE:
                player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_blue/still/bomberman_still_1.png")));
                break;
            case GREEN:
                player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_green/still/bomberman_still_1.png")));
                break;
            case RED:
                player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_red/still/bomberman_still_1.png")));
                break;
            case WHITE:
                player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_white/still/bomberman_still_1.png")));
                break;
        }
        return player;
    }
}
