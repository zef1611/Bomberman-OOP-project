package com.mygdx.game.Screen;

import com.mygdx.game.Enemies.SpawnEnemies;
import com.mygdx.game.Player.ColorEnum;
import com.mygdx.game.Player.Player;
import com.mygdx.game.Screen.AbstractScreen;
import com.mygdx.game.Stage.*;

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

//      Spawn soft blocks
        SpawnSoft spawnSoft = new SpawnSoft(this, gameStage, 1);
        spawnSoft.execute();

//      Spawn solid blocks
        SpawnSolid spawnSolid = new SpawnSolid(this, gameStage,stageNum);
        spawnSolid.execute();

//      Spawn enemies
        SpawnEnemies emySpawn = new SpawnEnemies(this,gameStage, stageNum);
        emySpawn.execute();

//      Spawn bombs here (so that it would not overlap the player animation)


//      Create player
        Player black = new Player(color, this, gameStage);
        black.position(playerX,playerY);
        setKeyboardFocus(black);
        addActor(black);
        gameStage.attachPlayer(black);

    }


    @Override
    public void dispose() {
        super.dispose();
    }
//    ----------------SETTERS/GETTERS--------------------------

}
