package com.mygdx.game.Screen;

import com.mygdx.game.Enemies.SpawnEnemies;
import com.mygdx.game.Player.ColorEnum;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Screen.AbstractScreen;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Stage.Soft;

public class MainGameScreen extends AbstractScreen {
    private int stageNum;
    private ColorEnum color;
    public static int playerX = 96;
    public static int playerY = 64;

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
        black.position(playerX,playerY);
        setKeyboardFocus(black);
        addActor(black);
        gameStage.attachPlayer(black);
//      Spawn soft blocks
        Soft s1 = new Soft(12*64+playerX, playerY, gameStage);
        Soft s2 = new Soft(8*64+playerX, playerY, gameStage);
        addActor(s1);
        addActor(s2);
        for (Soft s: gameStage.getListSoft()){
            System.out.println(s);
        }

//      Spawn solid blocks

//      Spawn enemies
        SpawnEnemies emySpawn = new SpawnEnemies(this,gameStage, stageNum, playerX, playerY);
        emySpawn.execute();

    }


    @Override
    public void dispose() {
        super.dispose();
    }
//    ----------------SETTERS/GETTERS--------------------------
    public int getStageNum(){return stageNum;}

}
