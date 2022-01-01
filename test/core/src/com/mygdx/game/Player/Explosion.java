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

    public Explosion(int x, int y, int direction, GameStage gameStage) {
        /*
            x,y: the position to set up bomb explosion
            direction: 0: col, 1: row
         */

        atlas = new TextureAtlas(Gdx.files.internal
                ("sprite_sheet/bomb_explosion/bomb_explosion.txt"));
        Array<TextureAtlas.AtlasRegion> bombNormal = atlas.findRegions("bomb_normal");
        currentAni = new Animation<>(1f/15f,bombNormal.get(0));
        explo = new Sprite(new TextureAtlas.AtlasSprite(bombNormal.get(0)));
        setBounds(explo.getRegionX(), explo.getRegionY(), explo.getRegionWidth(), explo.getRegionHeight());
        setTouchable(Touchable.enabled);
        explo.setPosition(x, y);
        this.x = x; this.y = y;
        if (direction == 0)
            currentAni = new Animation<TextureAtlas.AtlasRegion>(1f/5,
                    atlas.findRegion("explosion_body_col",1),
                    atlas.findRegion("explosion_body_col",2),
                    atlas.findRegion("explosion_body_col",3),
                    atlas.findRegion("explosion_body_col",4),
                    atlas.findRegion("explosion_body_col",3),
                    atlas.findRegion("explosion_body_col",2),
                    atlas.findRegion("explosion_body_col",1)
                    );
        if (direction == 1)
            currentAni = new Animation<TextureAtlas.AtlasRegion>(1f/5f,
                    atlas.findRegion("explosion_body_row",1),
                    atlas.findRegion("explosion_body_row",2),
                    atlas.findRegion("explosion_body_row",3),
                    atlas.findRegion("explosion_body_row",4),
                    atlas.findRegion("explosion_body_row",3),
                    atlas.findRegion("explosion_body_row",2),
                    atlas.findRegion("explosion_body_row",1)

                    );

        this.stillAlive = true;
        this.gameStage = gameStage;
    }
    public void draw(Batch batch, float parentAlpha){
        elapsedTime += Gdx.graphics.getDeltaTime();

        batch.draw(currentAni.getKeyFrame(elapsedTime),
                explo.getX(), explo.getY(), explo.getWidth(), explo.getHeight());

        if (elapsedTime > 1) {
            delSoft();
            delEnemies();
            this.addAction(Actions.removeActor());
        }

    }
    private void delSoft(){
        System.out.printf("%d %d\nDelete----\n", this.x, this.y);
        ListIterator<Items> it = gameStage.getListSoft().listIterator();
        while (it.hasNext()) {
            Items s = it.next();
            int minX = s.getBorderX(), maxX = s.getBorderWidth() + s.getBorderX();
            int minY = s.getBorderY(), maxY =  s.getBorderHeight() + s.getBorderY();
            if (minX <= this.x && this.x < maxX && minY <= this.y && this.y < maxY) {
                System.out.printf("minX: %d, maxX: %d ", s.getBorderX(), s.getBorderWidth() + s.getBorderX());
                System.out.printf("minY: %d, maxY: %d\n", s.getBorderY(), s.getBorderHeight() + s.getBorderY());

                s.del();
                it.remove();
            }

        }
    }
    private void delEnemies(){
        ListIterator<Enemy> it = gameStage.getListEnemy().listIterator();
        while (it.hasNext()) {
            Enemy s = it.next();
            int minX = s.getBorderX(), maxX = s.getBorderWidth() + s.getBorderX();
            int minY = s.getBorderY(), maxY =  s.getBorderHeight() + s.getBorderY();
//            System.out.printf("minX: %d, maxX: %d ", s.getBorderX(), s.getBorderWidth() + s.getBorderX());
//            System.out.printf("minY: %d, maxY: %d ", s.getBorderY(), s.getBorderHeight() + s.getBorderY());
            if (minX <= this.x && this.x <= maxX && minY <= this.y && this.y <= maxY) {
                s.del();
                it.remove();
            }

        }
    }
}
