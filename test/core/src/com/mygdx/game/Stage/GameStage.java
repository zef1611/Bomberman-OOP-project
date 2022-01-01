package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Enemies.Enemy;
import com.mygdx.game.Items;
import com.mygdx.game.Player.Bomb;
import com.mygdx.game.Player.Player;

import java.util.ArrayList;

//This class define the stage background, status bar, border size
public class GameStage extends Image {
    ArrayList<Player> listPlayer = new ArrayList<Player>();
    ArrayList<Items> listSoft = new ArrayList<>();
    ArrayList<Items> listSolid = new ArrayList<>();
    ArrayList<Items> listBomb = new ArrayList<>();
    ArrayList<Enemy> listEnemy = new ArrayList<>();
    TextureAtlas stageAtlas;
    int borderX, borderY, borderWidth, borderHeight;
    Sprite txStatusBar, txBackground;

    public GameStage(int stageNum) {

        txStatusBar = new Sprite(new Texture(Gdx.files.internal("sprite/stage/status_bar.png")));
        txBackground = new Sprite(new Texture(Gdx.files.internal("sprite/raw_asset/stage/stage_01/stage_01_sheet.png")));
        txBackground = switchBackground(stageNum);
//        txBackground = new Sprite(new Texture(Gdx.files.internal("sprite/stage/stage_01/stage_blank_01.png")));
        txStatusBar.setPosition(0,
                Gdx.graphics.getHeight() - txStatusBar.getHeight());

        txBackground.setPosition(Gdx.graphics.getWidth() / 2f - txBackground.getWidth() / 2f,
                (Gdx.graphics.getHeight() - txStatusBar.getHeight()) / 2f - txBackground.getHeight() / 2f);
        txBackground.setScale(4, 4);

        borderX = 96;
        borderY = 64;
        borderWidth = 13 * 64;
        borderHeight = 11 * 64;

//        Soft.placeSoft();
    }

    public Sprite switchBackground(int stageNum) {
//        stageAtlas = new TextureAtlas(Gdx.files.internal("sprite_sheet/stage/stage.txt"));
//        txBackground = new TextureAtlas.AtlasSprite(stageAtlas.findRegion("stage", stageNum));
        txBackground = new Sprite(new Texture(Gdx.files.internal("sprite_sheet/stage/stage_" + stageNum + ".png")));
        return txBackground;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        txStatusBar.draw(batch);
        txBackground.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    //    --------------------------ATTACH/DETACH--------------------------
    public void attachPlayer(Player player) {
        listPlayer.add(player);
    }

    public void detachPlayer(Player player) {
        listPlayer.remove(player);
    }

    public void attachSoft(Soft soft) {
        listSoft.add(soft);
    }

    public void detachSoft(Soft soft) {
        listSoft.remove(soft);
    }

    public void attachSolid(Solid solid) {
        listSolid.add(solid);
    }
    public void attachBomb(Bomb bomb) {
        listBomb.add(bomb);
    }
    public void  detachBomb(Bomb bomb) {
        listBomb.remove(bomb);
    }
    public void attachEnemy(Enemy enemy) {
        listEnemy.add(enemy);
    }

    public void detachEnemy(Enemy enemy) {
        listEnemy.remove(enemy);
    }

    //---------------------------GETTER/SETTERS------------------------
    public int getBorderX() {
        return borderX;
    }

    public int getBorderY() {
        return borderY;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public int getBorderHeight() {
        return borderHeight;
    }

    public ArrayList<Items> getListSoft() {
        return listSoft;
    }

    public ArrayList<Items> getListSolid() {
        return listSolid;
    }
    public ArrayList<Items> getListBomb() {
        return listBomb;
    }
    public ArrayList<Player> getListPlayer() {
        return listPlayer;
    }

    public ArrayList<Enemy> getListEnemy() {
        return this.listEnemy;
    }

}
