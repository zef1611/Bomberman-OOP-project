package com.mygdx.game.Stage;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Screen.MainGameScreen;

public class SpawnSolid {
    private Stage stage;
    private int stageNum;
    private GameStage gameStage;

    public SpawnSolid(Stage stage, GameStage gameStage, int stageNum){
        this.stage = stage;
        this.gameStage = gameStage;
        this.stageNum = stageNum;
    }

//    Spawn solid blocks on stage
    public void execute(){
        for (int i = 1; i < 12; i+= 2){
            for (int j = 1; j < 10; j+= 2){
                new Solid(i,j,stageNum, gameStage, stage);
            }
        }
//        new Solid(1,1,stageNum,gameStage,stage);
    }
}
