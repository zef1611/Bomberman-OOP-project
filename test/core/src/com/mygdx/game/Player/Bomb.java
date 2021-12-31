package com.mygdx.game.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Stage.GameStage;

//Animation order
//Bomb : 2 3 2 1 2 3 2 1 2
//Explosion: 1 2 3 4 3 2 1
public class Bomb extends Image {
    GameStage gameStage;
    Player player;
    TextureAtlas atlas;
    Animation<TextureAtlas.AtlasRegion> currentAni;
    float elapsedTime;
    Sprite bomb;
    int stage = 0;
    int x, y;
    Boolean stillAlive;
    public Bomb (Player player, GameStage gameStage){
        this.player = player;
        atlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/bomb_explosion/bomb_explosion.txt"));
        Array<TextureAtlas.AtlasRegion> bombNormal = atlas.findRegions("bomb_normal");
        currentAni = new Animation<>(1f/15f,bombNormal.get(0));
        bomb = new Sprite(new TextureAtlas.AtlasSprite(bombNormal.get(0)));

        setBounds(bomb.getRegionX(), bomb.getRegionY(), bomb.getRegionWidth(), bomb.getRegionHeight());

        setTouchable(Touchable.enabled);
//        setBounds(bomb.getX(), bomb.getY(), bomb.getWidth(), bomb.getHeight());
        System.out.printf("%.5f %.5f",  player.getX(), player.getY());
        this.x = (int)player.getX();
        this.y = (int)player.getY();
//        setPosition(player.getX(), player.getY());
        bomb.setPosition(player.getX(), player.getY());
        System.out.println("ok");
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
        this.stillAlive = true;

        this.gameStage = gameStage;
        System.out.printf("%3.5f %3.5f",  (float)gameStage.getBorderX(), (float)gameStage.getBorderY());
    }
    @Override
    public void draw(Batch batch, float parentAlpha){
        if (this.stillAlive == false) return; // that bomb does not exist
        elapsedTime += Gdx.graphics.getDeltaTime();
        this.stage += 1;
        if (this.stage == 7 && this.stillAlive == true) {
            batch.draw(currentAni.getKeyFrame(elapsedTime),
                    bomb.getX(), bomb.getY(), bomb.getWidth(), bomb.getHeight());
            this.stage = 0;
        }
        if (elapsedTime > 3) { // 3: after 3 second the bomb will explore
//            this.stillAlive = false;
            addExplosion(x + 65, y, 1 );
            addExplosion(x - 65, y, 1 );
            addExplosion(x, y + 65, 0 );
            addExplosion(x, y - 65, 0 );
            // remove a bomb
            this.addAction(Actions.removeActor());

        }

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
    private void addExplosion(int x, int y, int direction) {
        if (!checkBorder(x, y)) return;
        player.getStage().addActor(new Explosion(x, y, direction));
    }

    private boolean checkBorder(int x, int y) {
        if (x   >= gameStage.getBorderX() + gameStage.getBorderHeight())
            return  false;
        System.out.println(x);
        System.out.println(gameStage.getBorderX());
        if (x < gameStage.getBorderX() - 1)
            return false;
        if (y >= gameStage.getBorderY() + gameStage.getBorderWidth())
            return false;
        if (y < gameStage.getBorderY() - 1)
            return  false;
        return  true;
    }
}
