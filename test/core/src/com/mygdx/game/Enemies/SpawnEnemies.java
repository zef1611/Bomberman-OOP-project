package com.mygdx.game.Enemies;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Screen.MainGameScreen;

public class SpawnEnemies {
    Stage stage;
    int stageNum;
    int playerX;
    int playerY;

    public SpawnEnemies(Stage stage, int stageNum, int playerX, int playerY){
        this.stage = stage;
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
        Skunk s1 = new Skunk(playerX + 64*12, playerY + 64*0);
        stage.addActor(s1);
    }
}
