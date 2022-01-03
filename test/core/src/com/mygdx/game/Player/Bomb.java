package com.mygdx.game.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.ConstantValue;
import com.mygdx.game.Items;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Stage.Solid;

import java.util.ArrayList;

//Animation order
//Bomb : 2 3 2 1 2 3 2 1 2
//Explosion: 1 2 3 4 3 2 1
public class Bomb extends Items {
    GameStage gameStage;
    Player player;
    TextureAtlas atlas;
    Animation<TextureAtlas.AtlasRegion> currentAni;
    float elapsedTime;

    int stage = 0;
    int x, y, length;

    public Bomb(Player player, GameStage gameStage) {

        this.player = player;
        atlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/bomb_explosion/bomb_explosion.txt"));
        Array<TextureAtlas.AtlasRegion> bombNormal = atlas.findRegions("bomb_normal");
        currentAni = new Animation<>(1f / 15f, bombNormal.get(0));
        item = new Sprite(new TextureAtlas.AtlasSprite(bombNormal.get(0)));

        setBounds(item.getRegionX(), item.getRegionY(), item.getRegionWidth(), item.getRegionHeight());

        this.length = player.getBombRange();
        setTouchable(Touchable.enabled);
        this.x = (int) (ConstantValue.GetX(player.getX()));
        this.y = (int) (ConstantValue.GetY(player.getY()));

        borderX = this.x;
        borderY = this.y;
        borderWidth = 64;
        borderHeight = 64;

        item.setPosition(this.x, this.y);

        currentAni = new Animation<TextureAtlas.AtlasRegion>(1f / 2f, atlas.findRegions("bomb_normal"));

        this.gameStage = gameStage;
        player.setRemainBomb(1);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        elapsedTime += Gdx.graphics.getDeltaTime() * 2;
        this.stage += 1;

        batch.draw(currentAni.getKeyFrame(elapsedTime),
                item.getX(), item.getY(), item.getWidth(), item.getHeight());


        if (elapsedTime > 3) { // 3: after 3 second the bomb will explore

            addExplosion(x, y, 4, false);
            boolean checkL = true, checkD = true, checkU = true, checkR = true;
            for (int i = 1; i <= length; i++) {
                if (i != length) {
                    if (checkR) checkR &= addExplosion(this.x + 64 * i, this.y, 1, true);
                    if (checkL) checkL &= addExplosion(this.x - 64 * i, this.y, 1, false);
                    if (checkD) checkD &= addExplosion(this.x, this.y - 64 * i, 0, false);
                    if (checkU) checkU &= addExplosion(this.x, this.y + 64 * i, 0, true);
                }
                else {
                    if (checkR) checkR &= addExplosion(this.x + 64 * i, this.y, 3, true);
                    if (checkL) checkL &= addExplosion(this.x - 64 * i, this.y, 3, false);
                    if (checkD) checkD &= addExplosion(this.x, this.y - 64 * i, 2, false);
                    if (checkU) checkU &= addExplosion(this.x, this.y + 64 * i, 2, true);
                }
            }

            // remove a bomb
            player.setRemainBomb(-1);
            this.gameStage.detachBomb(this);
            this.addAction(Actions.removeActor());

        }

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    private boolean addExplosion(int x, int y, int direction, boolean flip) {
        if (!checkValid(x, y)) return false;

        player.getStage().addActor(new Explosion(x, y, direction, gameStage, flip));
        if (!checkConflict(x, y, gameStage.getListSoft())) return false;
        return true;
    }

    private boolean checkValid(int x, int y) {
        if (x - this.getHeight() - 3 > (int) (gameStage.getBorderX() + gameStage.getBorderHeight()))
            return false;

        if (x < gameStage.getBorderX() - 1)
            return false;

        if (y + 64 * 2 >= gameStage.getBorderY() + gameStage.getBorderWidth())
            return false;

        if (y < gameStage.getBorderY() - 1)
            return false;

        if (!checkConflict(x, y, gameStage.getListSolid())) return false;

        return true;
    }

    private boolean checkConflict(int x, int y, ArrayList<Items> arr) {
        for (Items s : arr) {
            if (s.getBorderX() - 5 <= x && x <= s.getBorderX() + s.getBorderWidth() - 5
                    && s.getBorderY() - 5 <= y && y <= s.getBorderY() + s.getBorderHeight() - 5)
                return false;
        }

        return true;
    }
}
