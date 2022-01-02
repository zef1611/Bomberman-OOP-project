package com.mygdx.game.Stage;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.PowerUps.IncreaseBombs;

public class SpawnSoft {
    private Stage stage;
    private int stageNum;
    private GameStage gameStage;

    public SpawnSoft(Stage stage, GameStage gameStage, int stageNum){
        this.stage = stage;
        this.gameStage = gameStage;
        this.stageNum = stageNum;
    }
    public void execute(){
        switch (stageNum){
            case 1:
                stage1();
                break;
            case 2:
                stage2();
                break;
            case 3:
                stage3();
                break;
            case 4:
                stage4();
                break;
            default:
                System.out.println("Spawn Soft - stageNum - Missing");
        }
    }
    private void stage1(){
        for (int i = 2; i < 11; i++){
            new Soft(i, 0, stageNum, gameStage, stage);
            new Soft(i, 10, stageNum, gameStage, stage);
        }
        for (int j = 2; j < 9; j++){
            new Soft(0,j,stageNum, gameStage, stage);
            new Soft(12,j, stageNum, gameStage, stage);
        }
        new Soft(6, 3, stageNum, gameStage, stage);
        new Soft(5, 4, stageNum, gameStage, stage);
        new Soft(6, 4, stageNum, gameStage, stage);
        new Soft(7, 4, stageNum, gameStage, stage);
        new Soft(4, 5, stageNum, gameStage, stage);
        new Soft(8, 5, stageNum, gameStage, stage);
        new Soft(5, 6, stageNum, gameStage, stage);
        new Soft(6, 6, stageNum, gameStage, stage);
        new Soft(7, 6, stageNum, gameStage, stage);
        new Soft(6, 7, stageNum, gameStage, stage);

    }
    private void stage2(){
        new Soft(2,0,stageNum,gameStage,stage);
        new Soft(4,0,stageNum,gameStage,stage);
        new Soft(8,0,stageNum,gameStage,stage);
        new Soft(10,0,stageNum,gameStage,stage);
        new Soft(0,2,stageNum,gameStage,stage);
        new Soft(4,2,stageNum,gameStage,stage);
        new Soft(6,2,stageNum,gameStage,stage);
        new Soft(8,2,stageNum,gameStage,stage);
        new Soft(12,2,stageNum,gameStage,stage);
        new Soft(2,4,stageNum,gameStage,stage);
        new Soft(6,4,stageNum,gameStage,stage);
        new Soft(10,4,stageNum,gameStage,stage);
        new Soft(0,6,stageNum,gameStage,stage);
        new Soft(4,6,stageNum,gameStage,stage);
        new Soft(8,6,stageNum,gameStage,stage);
        new Soft(12,6,stageNum,gameStage,stage);
        new Soft(2,8,stageNum,gameStage,stage);
        new Soft(6,8,stageNum,gameStage,stage);
        new Soft(10,8,stageNum,gameStage,stage);
        new Soft(0,10,stageNum,gameStage,stage);
        new Soft(4,10,stageNum,gameStage,stage);
        new Soft(8,10,stageNum,gameStage,stage);
        new Soft(12,10,stageNum,gameStage,stage);
    }
    private void stage3(){
        new Soft(4,0,stageNum,gameStage,stage);
        new Soft(8,0,stageNum,gameStage,stage);
        new Soft(6,1,stageNum,gameStage,stage);
        new Soft(5,2,stageNum,gameStage,stage);
        new Soft(7,2,stageNum,gameStage,stage);
        new Soft(4,3,stageNum,gameStage,stage);
        new Soft(8,3,stageNum,gameStage,stage);
        new Soft(0,4,stageNum,gameStage,stage);
        new Soft(3,4,stageNum,gameStage,stage);
        new Soft(9,4,stageNum,gameStage,stage);
        new Soft(12,4,stageNum,gameStage,stage);
        new Soft(2,5,stageNum,gameStage,stage);
        new Soft(6,5,stageNum,gameStage,stage);
        new Soft(10,5,stageNum,gameStage,stage);
        new Soft(3,6,stageNum,gameStage,stage);
        new Soft(7,6,stageNum,gameStage,stage);
        new Soft(11,6,stageNum,gameStage,stage);
        new Soft(0,7,stageNum,gameStage,stage);
        new Soft(4,7,stageNum,gameStage,stage);
        new Soft(6,7,stageNum,gameStage,stage);
        new Soft(10,7,stageNum,gameStage,stage);
        new Soft(1,8,stageNum,gameStage,stage);
        new Soft(5,8,stageNum,gameStage,stage);
        new Soft(9,8,stageNum,gameStage,stage);
        new Soft(0,9,stageNum,gameStage,stage);
        new Soft(8,9,stageNum,gameStage,stage);
        new Soft(12,9,stageNum,gameStage,stage);
        for (int i = 1; i < 8; i++){
            new Soft(i,10,stageNum,gameStage,stage);
        }

    }
    private void stage4(){
        for (int i= 4; i < 9; i+=4){
            for (int j = 2; j < 9; j += 6 ){
                new Soft(i, j+1, stageNum, gameStage,stage);
                new Soft(i, j-1, stageNum, gameStage,stage);
                new Soft(i, j, stageNum, gameStage,stage);
                new Soft(i+1, j, stageNum, gameStage,stage);
                new Soft(i-1, j, stageNum, gameStage,stage);
            }
        }
        new Soft(0,4,stageNum,gameStage,stage);
        new Soft(0,6,stageNum,gameStage,stage);
        new Soft(12,4,stageNum,gameStage,stage);
        new Soft(12,6,stageNum,gameStage,stage);

        for(int i = 2; i < 11; i+=4){
            new Soft(i, 0, stageNum, gameStage, stage);
            new Soft(i, 10, stageNum, gameStage, stage);
        }
    }

}
