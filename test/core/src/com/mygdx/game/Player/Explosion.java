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
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Enemies.Enemy;
import com.mygdx.game.Items;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Stage.Soft;

import java.util.ListIterator;

public class Explosion extends Image {
    TextureAtlas atlas;
    Animation<TextureAtlas.AtlasRegion> currentAni;
    float elapsedTime;
    Sprite explo;
    int x, y;
    Boolean stillAlive;
    GameStage gameStage;
    boolean deActive;
    boolean flip;
    int direction;
    public Explosion(int x, int y, int direction, GameStage gameStage, boolean flip) {
        /*
            x,y: the position to set up bomb explosion
            direction: 0: col, 1: row, 2: col_edge, 3: row_edge, 4: center
         */

        atlas = new TextureAtlas(Gdx.files.internal
                ("sprite_sheet/bomb_explosion/bomb_explosion.txt"));
        Array<TextureAtlas.AtlasRegion> bombNormal = atlas.findRegions("bomb_normal");
        currentAni = new Animation<>(1f / 15f, bombNormal.get(0));
        explo = new Sprite(new TextureAtlas.AtlasSprite(bombNormal.get(0)));
        setBounds(explo.getRegionX(), explo.getRegionY(), explo.getRegionWidth(), explo.getRegionHeight());
        setTouchable(Touchable.enabled);
        explo.setPosition(x, y);
        this.x = x;
        this.y = y;
        this.flip = flip;
        this.direction = direction;
        if (direction == 0)
            currentAni = new Animation<TextureAtlas.AtlasRegion>(1f / 5, atlas.findRegions("explosion_body_col"));
        else if (direction == 1)
            currentAni = new Animation<TextureAtlas.AtlasRegion>(1f / 5f, atlas.findRegions("explosion_body_row"));
        else if (direction == 2)
            currentAni = new Animation<TextureAtlas.AtlasRegion>(1f / 5f, atlas.findRegions("explosion_edge_col"));
        else if (direction == 3)
            currentAni = new Animation<TextureAtlas.AtlasRegion>(1f / 5f, atlas.findRegions("explosion_edge_row"));
        else if(direction == 4)
            currentAni = new Animation<TextureAtlas.AtlasRegion>(1f / 5f, atlas.findRegions("explosion_core"));
//        System.out.printf("%d %d\n", this.x / 64, y / 64);
        gameStage.setDeath(this.x / 64, this.y / 64, 1);
        this.stillAlive = true;
        this.gameStage = gameStage;
        deActive = false;
    }

    public void draw(Batch batch, float parentAlpha) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        delPlayer();
        if (flip) {
                if (direction == 2 || direction == 0) {
                    batch.draw(currentAni.getKeyFrame(elapsedTime),explo.getX() , explo.getY() + explo.getHeight(), explo.getWidth(), -explo.getHeight());
                } else {
                    batch.draw(currentAni.getKeyFrame(elapsedTime),explo.getX() + explo.getWidth(), explo.getY(), -explo.getWidth(), explo.getHeight());
                }
        } else {
            batch.draw(currentAni.getKeyFrame(elapsedTime),
                    explo.getX(), explo.getY(), explo.getWidth(), explo.getHeight());
        }
        if (elapsedTime > 1) {
            delSoft();
//            delEnemies();
            if (deActive == false)
                gameStage.setDeath(this.x / 64, this.y / 64, -1);
            this.addAction(Actions.removeActor());
        }

    }

    private void delSoft() {
//        System.out.printf("%d %d\nDelete----\n", this.x, this.y);
        ListIterator<Items> it = gameStage.getListSoft().listIterator();
        while (it.hasNext()) {
            Items s = it.next();
            int minX = s.getBorderX(), maxX = s.getBorderWidth() + s.getBorderX();
            int minY = s.getBorderY(), maxY = s.getBorderHeight() + s.getBorderY();
            if (minX <= this.x && this.x < maxX && minY <= this.y && this.y < maxY) {
                deActive = true;
                s.del();
                it.remove();
                gameStage.setDeath(this.x / 64, this.y / 64, -1);
                return;
            }

        }
    }

    private void delPlayer() {
        ListIterator<Player> it = gameStage.getListPlayer().listIterator();

        while (it.hasNext()) {
            Player s = it.next();
            int x = (int) s.getX(), y = (int) s.getY();
            if (gameStage.getDeath(x/64, y / 64) > 0) s.death();
        }
    }
}
