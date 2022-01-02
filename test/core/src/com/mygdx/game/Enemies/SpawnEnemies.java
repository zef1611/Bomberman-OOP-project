package com.mygdx.game.Enemies;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.DirectionEnum;
import com.mygdx.game.Screen.MainGameScreen;
import com.mygdx.game.Stage.GameStage;

public class SpawnEnemies {
    private Stage stage;
    private int stageNum;
    private GameStage gameStage;

    public SpawnEnemies(Stage stage, GameStage gameStage, int stageNum){
        this.stage = stage;
        this.gameStage = gameStage;
        this.stageNum = stageNum;
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
        new Skunk(6, 2, DirectionEnum.UP, gameStage, stage, 1);
        new Skunk(12, 0, DirectionEnum.UP, gameStage, stage, 2);

        new Skunk(2, 9, DirectionEnum.DOWN, gameStage, stage, 3);
        new Skunk(4, 6, DirectionEnum.DOWN, gameStage, stage, 4);
        new Skunk(8, 8, DirectionEnum.DOWN, gameStage, stage, 5);
        new Skunk(10, 10, DirectionEnum.DOWN, gameStage, stage, 6);

    }
    private void spawnCaveman(){
        new Caveman(4, 2, DirectionEnum.LEFT, gameStage, stage, 1);
        new Caveman(9, 8, DirectionEnum.LEFT, gameStage, stage, 2);

        new Caveman(0, 10, DirectionEnum.DOWN, gameStage, stage, 3);
        new Caveman(10, 10, DirectionEnum.DOWN, gameStage, stage,4);
        new Caveman(12, 10, DirectionEnum.DOWN, gameStage, stage, 5);
        new Caveman(2, 1, DirectionEnum.UP, gameStage, stage,6);
    }
    private void spawnNinjaBlue(){
        new NinjaBlue(5, 6, DirectionEnum.LEFT, gameStage, stage, 1);
        new NinjaBlue(1, 10, DirectionEnum.LEFT, gameStage, stage, 2);
        new NinjaBlue(7, 8, DirectionEnum.LEFT, gameStage, stage,3 );
        new NinjaBlue(5, 0, DirectionEnum.LEFT, gameStage, stage, 4);
        new NinjaBlue(10, 4, DirectionEnum.DOWN, gameStage, stage, 5);
        new NinjaBlue(4, 10, DirectionEnum.DOWN, gameStage, stage, 6);

    }
    private void spawnAlien(){
        new Alien(1, 6, DirectionEnum.LEFT, gameStage, stage, 1);
        new Alien(11, 4, DirectionEnum.RIGHT, gameStage, stage, 2);
        new Alien(6, 9, DirectionEnum.DOWN, gameStage, stage, 3);
        new Alien(2, 1, DirectionEnum.UP, gameStage, stage, 4);
        new Alien(10, 1, DirectionEnum.UP, gameStage, stage, 5);

    }
}
