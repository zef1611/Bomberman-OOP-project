package com.mygdx.game.Screen;

import com.mygdx.game.Enemies.SpawnEnemies;
import com.mygdx.game.Player.ColorEnum;
import com.mygdx.game.Player.Player;
import com.mygdx.game.PowerUps.SpawnPowerUps;
import com.mygdx.game.Screen.AbstractScreen;
import com.mygdx.game.Stage.*;

import java.util.ArrayList;

public class MainGameScreen extends AbstractScreen {
    private int stageNum;
    private ColorEnum color;
    public static int playerX = 96;
    public static int playerY = 64;

    public MainGameScreen(){}
    public HUD hud;
    @Override
    public void buildStage() {
//      Get StageNum, colorEnum
        stageNum = StageSelectScreen.stageNum;
        color = CharSelectScreen.colorEnum;
//      Get gameStage background

//      Add the game stage
        GameStage gameStage = new GameStage(stageNum);
        addActor(gameStage);

//      HUD
        hud = new HUD();
        addActor(hud);

//      Spawn soft blocks
        SpawnSoft spawnSoft = new SpawnSoft(this, gameStage, stageNum);
        spawnSoft.execute();

//      Spawn solid blocks
        SpawnSolid spawnSolid = new SpawnSolid(this, gameStage,stageNum);
        spawnSolid.execute();

//      Spawn enemies
        SpawnEnemies emySpawn = new SpawnEnemies(this,gameStage, stageNum);
        emySpawn.execute();
//      Spawn bombs here (so that it would not overlap the player animation)

        SpawnPowerUps spawn = new SpawnPowerUps(this, gameStage);
        spawn.execute();
//      Create player
        Player player1 = new Player(color, this, gameStage);
        player1.position(playerX,playerY);
        setKeyboardFocus(player1);
        addActor(player1);
//        ArrayList<Actor>
        gameStage.attachPlayer(player1);
    }


    @Override
    public void dispose() {
        super.dispose();
    }
//    ----------------SETTERS/GETTERS--------------------------

}
