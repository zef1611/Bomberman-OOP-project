package com.mygdx.game.Enemies;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Screen.MainGameScreen;
import com.mygdx.game.Stage.GameStage;

public class SpawnEnemies {
    Stage stage;
    int stageNum;
    GameStage gameStage;
    int playerX;
    int playerY;

    public SpawnEnemies(Stage stage, GameStage gameStage, int stageNum, int playerX, int playerY){
        this.stage = stage;
        this.gameStage = gameStage;
        this.stageNum = stageNum;
        this.playerX = playerX;
        this.playerY = playerY;
    }

//    Spawn enemies depending on stage
    public void execute(){
        switch (stageNum){
            case 1:
                spawnSkunk();
                break;
        }
    }

//        tileX: from 0 to 12
//        tileY: from 0 to 10
    private void spawnSkunk(){

        Skunk s1 = new Skunk(gameStage, 11, 0, DirectionEnum.LEFT);
        Skunk s2 = new Skunk(gameStage, 10, 8, DirectionEnum.DOWN);
        stage.addActor(s1);
        stage.addActor(s2);
    }
}
