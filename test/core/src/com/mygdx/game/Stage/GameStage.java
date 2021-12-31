package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Enemies.Enemy;
import com.mygdx.game.Player.Player;

import java.util.ArrayList;

//This class define the stage background, status bar, border size
public class GameStage extends Image  {
    private ArrayList <Player> listPlayer = new ArrayList<Player>();
    private ArrayList <Soft> listSoft = new ArrayList<Soft>();
    private ArrayList <Solid> listSolid = new ArrayList<Solid>();
    private ArrayList <Enemy> listEnemy = new ArrayList<>();
    private int borderX, borderY, borderWidth, borderHeight;
    private Sprite txStatusBar, txBackground;

    public GameStage(int stageNum){
//        Set the background and status sprite
        txStatusBar = new Sprite(new Texture(Gdx.files.internal("sprite/stage/status_bar.png")));
        txBackground = new Sprite(new Texture(Gdx.files.internal("sprite/raw_asset/stage/stage_01/stage_01_sheet.png")));
        txBackground = switchBackground(stageNum);

        txStatusBar.setPosition(0,
                Gdx.graphics.getHeight()-txStatusBar.getHeight());

        txBackground.setPosition(Gdx.graphics.getWidth()/2f - txBackground.getWidth()/2f,
                (Gdx.graphics.getHeight()-txStatusBar.getHeight())/2f - txBackground.getHeight()/2f );
        txBackground.setScale(4,4);

//        Set the border coordinate
        borderX = 96;
        borderY = 64;
        borderWidth = 13*64;
        borderHeight = 11*64;
    }

    private Sprite switchBackground(int stageNum){
        txBackground = new Sprite(new Texture(Gdx.files.internal("sprite_sheet/stage/stage_"+stageNum+".png")));
        return txBackground;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        txStatusBar.draw(batch);
        txBackground.draw(batch);
    }
    @Override
    public void act(float delta){
        super.act(delta);
    }

//    --------------------------ATTACH/DETACH--------------------------
    public void attachPlayer(Player player){
    listPlayer.add(player);
}
    public void detachPlayer(Player player){listPlayer.remove(player);}

    public void attachSoft(Soft soft) {listSoft.add(soft);}
    public void detachSoft(Soft soft) {listSoft.remove(soft);}

    public void attachSolid(Solid solid) {listSolid.add(solid);}

    public void attachEnemy(Enemy enemy){listEnemy.add(enemy);}
    public void detachEnemy(Enemy enemy){listEnemy.remove(enemy);}

    //---------------------------GETTER/SETTERS------------------------
    public int getBorderX(){return borderX;}
    public int getBorderY(){return borderY;}
    public int getBorderWidth(){return borderWidth;}
    public int getBorderHeight(){return borderHeight;}

    public ArrayList<Soft> getListSoft(){return listSoft;}
    public ArrayList<Solid> getListSolid(){return listSolid;}
    public ArrayList<Player> getListPlayer(){return listPlayer;}

}
