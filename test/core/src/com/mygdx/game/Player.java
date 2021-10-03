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

import static com.badlogic.gdx.Gdx.input;


public class Player extends Actor {
    Sprite player;

    public Player(String color){
        player = switchCharacter(color);
        setBounds(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        setTouchable(Touchable.enabled);

        addListener(new InputListener(){
            public boolean keyDown(InputEvent event, int keycode){
                if(keycode == Input.Keys.D){
                    MoveByAction right = new MoveByAction();
                    right.setAmount(64f, 0f);
                    right.setDuration(5f);

                    Player.this.addAction(right);
                }
                if(keycode ==Input.Keys.W){
                    MoveByAction up = new MoveByAction();
                    up.setAmount(0f,64f);
                    up.setDuration(5f);

                    Player.this.addAction(up);
                }
                if(keycode == Input.Keys.S){
                    MoveByAction down = new MoveByAction();
                    down.setAmount(0f,-64f);
                    down.setDuration(5f);

                    Player.this.addAction(down);
                }
                if(keycode == Input.Keys.A){
                    MoveByAction left = new MoveByAction();
                    left.setAmount(-64f, 0f);
                    left.setDuration(5f);

                    Player.this.addAction(left);
                }
                return true;
            }
        });
    }
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch, parentAlpha);
    }
    public void act(float delta){
        super.act(delta);
    }
    protected void positionChange(){
        player.setPosition(getX(),getY());
        super.positionChanged();
    }
    private Sprite switchCharacter(String color){
        if(color == "black"){
            player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_black/still/bomberman_still_1.png")));
        }
        if(color == "white"){
            player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_white/still/bomberman_still_1.png")));
        }
        if(color == "red"){
            player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_red/still/bomberman_still_1.png")));
        }
        if(color == "green"){
            player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_green/still/bomberman_still_1.png")));
        }
        if(color == "blue"){
            player = new Sprite(new Texture(Gdx.files.internal("sprite/character/bomberman_blue/still/bomberman_still_1.png")));
        }
        return player;
    }
}
