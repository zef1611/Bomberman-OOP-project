package com.mygdx.game.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

//Animation order
//Bomb : 2 3 2 1 2 3 2 1 2
//Explosion: 1 2 3 4 3 2 1
public class Bomb extends Image {
    private Player player;
    private TextureAtlas atlas;
    private Animation<TextureAtlas.AtlasRegion> currentAni;
    private float elapsedTime;
    private Sprite bomb;
    public Bomb (Player player){
        this.player = player;
        atlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/bomb_explosion/bomb_explosion.txt"));
        Array<TextureAtlas.AtlasRegion> bombNormal = atlas.findRegions("bomb_normal");
        currentAni = new Animation<>(1f/15f,bombNormal.get(0));
        bomb = new Sprite(new TextureAtlas.AtlasSprite(bombNormal.get(0)));
        setBounds(bomb.getRegionX(), bomb.getRegionY(), bomb.getRegionWidth(), bomb.getRegionHeight());
        setTouchable(Touchable.enabled);
//        setBounds(bomb.getX(), bomb.getY(), bomb.getWidth(), bomb.getHeight());
        setPosition(player.getX(), player.getY());
        bomb.setPosition(player.getX(), player.getY());

        currentAni = new Animation<TextureAtlas.AtlasRegion>(1f/3f,
                atlas.findRegion("bomb_normal",2),
                atlas.findRegion("bomb_normal",3),
                atlas.findRegion("bomb_normal",2),
                atlas.findRegion("bomb_normal",1),
                atlas.findRegion("bomb_normal",2),
                atlas.findRegion("bomb_normal",3),
                atlas.findRegion("bomb_normal",2),
                atlas.findRegion("bomb_normal",1),
                atlas.findRegion("bomb_normal",2));
    }
    @Override
    public void draw(Batch batch, float parentAlpha){
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(currentAni.getKeyFrame(elapsedTime),
                bomb.getX(),bomb.getY(),bomb.getWidth(), bomb.getHeight());
    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
