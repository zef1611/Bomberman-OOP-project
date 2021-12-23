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

    public void execute(){
        switch (stageNum){
            case 1:
                spawnSkunk();
                break;
        }
    }

    private void spawnSkunk(){
        Skunk s1 = new Skunk(gameStage, playerX + 64*11, playerY + 64*0);
        stage.addActor(s1);
    }
}
