package com.mygdx.game;

import com.mygdx.game.Player.ColorEnum;
import com.mygdx.game.Player.Player;

public class MainGameScreen extends AbstractScreen {


    public MainGameScreen(){}

    @Override
    public void buildStage() {
//      Add the game stage
        GameStage gameStage = new GameStage();
        addActor(gameStage);

//      Create player
        Player black = new Player(ColorEnum.BLUE, this, gameStage);
        black.position(96,64);
        setKeyboardFocus(black);
        addActor(black);
        gameStage.attachObserver(black);
//      set border
        gameStage.borderNotify();

    }


    @Override
    public void dispose() {super.dispose();}

//    public void getBackgroundTexture(int stageNum){
//        this.stageNum = stageNum;
//    }
//    public Texture setBackgroundTexture(int stageNum){
//        if(stageNum == 1){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_01/stage_01.png"));
//        }
//        if(stageNum == 2){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_02/stage_02.png"));
//        }
//        if(stageNum == 3){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_03/stage_03.png"));
//        }
//        if(stageNum == 4){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_04/stage_04.png"));
//        }
//        if(stageNum == 5){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_05/stage_05.png"));
//        }
//        if(stageNum == 6){
//            background = new Texture(Gdx.files.internal("sprite/stage/stage_06/stage_06.png"));
//        }
//
//        return background;
//    }

//    public void setPlayer(String color){
//
//    }

}
