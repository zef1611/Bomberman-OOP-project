package com.mygdx.game.Screen;

import com.mygdx.game.Player.ColorEnum;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Screen.AbstractScreen;
import com.mygdx.game.Stage.GameStage;

public class MainGameScreen extends AbstractScreen {
    private int stageNum;
    private ColorEnum color;

    public MainGameScreen(){}

    @Override
    public void buildStage() {
//      Get StageNum, colorEnum
        stageNum = StartingScreen.stageNum;
        color = ColorEnum.BLUE;
//      Get gameStage background

//      Add the game stage
        GameStage gameStage = new GameStage(stageNum);
        addActor(gameStage);

//      Create player
        Player black = new Player(color, this, gameStage);
        black.position(96,64);
        setKeyboardFocus(black);
        addActor(black);
        gameStage.attachObserver(black);
//      set border


    }


    @Override
    public void dispose() {
        super.dispose();
    }

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
