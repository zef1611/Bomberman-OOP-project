package com.mygdx.game.Stage;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Screen.MainGameScreen;

public class SpawnSoft {
    Stage stage;
    int stageNum;
    GameStage gameStage;
    int playerX;
    int playerY;

    public SpawnSoft(Stage stage, GameStage gameStage, int stageNum){
        this.stage = stage;
        this.gameStage = gameStage;
        this.stageNum = stageNum;
        this.playerX = MainGameScreen.playerX;
        this.playerY = MainGameScreen.playerY;
    }
    public void execute(){
        switch (stageNum){
            case 1:
                stage1();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Spawn Soft - stageNum - Missing");
        }
    }
    private void stage1(){
        new Soft(2,0,stageNum,gameStage,stage);
        new Soft(3,0,stageNum,gameStage,stage);
        new Soft(4,0,stageNum,gameStage,stage);
        new Soft(5,0,stageNum,gameStage,stage);
        new Soft(2,1,stageNum,gameStage,stage);
        new Soft(4,1,stageNum,gameStage,stage);
        new Soft(6,1,stageNum,gameStage,stage);
        new Soft(0,2,stageNum,gameStage,stage);
        new Soft(1,2,stageNum,gameStage,stage);
        new Soft(2,2,stageNum,gameStage,stage);
        new Soft(3,2,stageNum,gameStage,stage);
        new Soft(4,2,stageNum,gameStage,stage);
        new Soft(5,2,stageNum,gameStage,stage);
        new Soft(6,2,stageNum,gameStage,stage);
        new Soft(7,2,stageNum,gameStage,stage);
        new Soft(8,2,stageNum,gameStage,stage);
        new Soft(12,2,stageNum,gameStage,stage);
        new Soft(2,3,stageNum,gameStage,stage);
        new Soft(4,3,stageNum,gameStage,stage);
        new Soft(6,3,stageNum,gameStage,stage);
        new Soft(8,3,stageNum,gameStage,stage);
        new Soft(10,3,stageNum,gameStage,stage);
        new Soft(7,4,stageNum,gameStage,stage);
        new Soft(9,4,stageNum,gameStage,stage);
        new Soft(10,4,stageNum,gameStage,stage);
        new Soft(2,5,stageNum,gameStage,stage);
        new Soft(8,5,stageNum,gameStage,stage);
        new Soft(10,5,stageNum,gameStage,stage);
        new Soft(12,5,stageNum,gameStage,stage);
        new Soft(9,6,stageNum,gameStage,stage);
        new Soft(9,6,stageNum,gameStage,stage);
        new Soft(3,6,stageNum,gameStage,stage);
        new Soft(1,6,stageNum,gameStage,stage);
        new Soft(2,6,stageNum,gameStage,stage);
        new Soft(10,7,stageNum,gameStage,stage);
        new Soft(4,8,stageNum,gameStage,stage);
        new Soft(8,8,stageNum,gameStage,stage);
        new Soft(10,8,stageNum,gameStage,stage);
        new Soft(6,9,stageNum,gameStage,stage);
        new Soft(8,9,stageNum,gameStage,stage);
        new Soft(4,10,stageNum,gameStage,stage);

    }
}
