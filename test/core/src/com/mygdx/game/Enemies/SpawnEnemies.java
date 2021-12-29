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

    public SpawnEnemies(Stage stage, GameStage gameStage, int stageNum){
        this.stage = stage;
        this.gameStage = gameStage;
        this.stageNum = stageNum;
        this.playerX = MainGameScreen.playerX;
        this.playerY = MainGameScreen.playerY;
    }

//    Spawn enemies depending on stage
    public void execute(){
        switch (stageNum){
            case 1:
                spawnCaveman();
                break;
            case 2:
                spawnNinjaBlue();
                break;
            case 3:
                spawnSkunk();
                break;
            case 4:
                spawnAlien();
                break;
            default:
                System.out.println("spawnEnemy - stageNum - MISSING");
        }
    }

//        tileX: from 0 to 12
//        tileY: from 0 to 10
    private void spawnSkunk(){
        new Skunk(11, 0, DirectionEnum.LEFT, gameStage, stage);
        new Skunk(10, 8, DirectionEnum.DOWN, gameStage, stage);
    }
    private void spawnCaveman(){
        new Caveman(11, 0, DirectionEnum.LEFT, gameStage, stage);
        new Caveman(10, 8, DirectionEnum.DOWN, gameStage, stage);
    }
    private void spawnNinjaBlue(){
        new NinjaBlue(11, 0, DirectionEnum.LEFT, gameStage, stage);
        new NinjaBlue(10, 8, DirectionEnum.DOWN, gameStage, stage);
    }
    private void spawnAlien(){
        new Alien(11, 0, DirectionEnum.LEFT, gameStage, stage);
        new Alien(10, 8, DirectionEnum.DOWN, gameStage, stage);
    }
}
