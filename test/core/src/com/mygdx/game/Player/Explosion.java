package com.mygdx.game.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

public class Explosion extends Image {
    TextureAtlas atlas;
    Animation<TextureAtlas.AtlasRegion> currentAni;
    float elapsedTime;
    Sprite bomb;
    int stage = 0;
    Boolean stillAlive;
    int direction;
    public Explosion(int x, int y, int direction) {
        /*
            x,y: the position to set up bomb explosion
            direction: 0: col, 1: row
         */

        atlas = new TextureAtlas(Gdx.files.internal
                ("sprite_sheet/bomb_explosion/bomb_explosion.txt"));
        Array<TextureAtlas.AtlasRegion> bombNormal = atlas.findRegions("bomb_normal");
        currentAni = new Animation<>(1f/15f,bombNormal.get(0));
        bomb = new Sprite(new TextureAtlas.AtlasSprite(bombNormal.get(0)));
        setBounds(bomb.getRegionX(), bomb.getRegionY(), bomb.getRegionWidth(), bomb.getRegionHeight());
        setTouchable(Touchable.enabled);
        bomb.setPosition(x, y);
        if (direction == 0)
            currentAni = new Animation<TextureAtlas.AtlasRegion>(1f/3f,
                    atlas.findRegion("explosion_body_col",1),
                    atlas.findRegion("explosion_body_col",2),
                    atlas.findRegion("explosion_body_col",3),
                    atlas.findRegion("explosion_body_col",3)
            );
        if (direction == 1)
            currentAni = new Animation<TextureAtlas.AtlasRegion>(1f/3f,
                    atlas.findRegion("explosion_body_row",1),
                    atlas.findRegion("explosion_body_row",2),
                    atlas.findRegion("explosion_body_row",3),
                    atlas.findRegion("explosion_body_row",3)
            );

        this.stillAlive = true;
    }
    public void draw(Batch batch, float parentAlpha){
        if (this.stillAlive == false) return; // that bomb does not exist
        elapsedTime += Gdx.graphics.getDeltaTime();
        this.stage += 1;
        if (this.stage == 7 && this.stillAlive == true) {
            batch.draw(currentAni.getKeyFrame(elapsedTime),
                    bomb.getX(), bomb.getY(), bomb.getWidth(), bomb.getHeight());
            this.stage = 0;
        }
        if (elapsedTime > 2) {
            this.stillAlive = false;
            this.addAction(Actions.removeActor());
        }

//        System.out.println(elapsedTime);
    }

}
