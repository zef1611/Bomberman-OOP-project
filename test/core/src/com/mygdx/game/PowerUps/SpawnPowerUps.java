package com.mygdx.game.PowerUps;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Stage.SpawnSoft;

public class SpawnPowerUps {
    private Stage stage;
    private int stageNum;
    private GameStage gameStage;

    public SpawnPowerUps(Stage stage, GameStage gameStage) {
        this.gameStage = gameStage;
        this.stage = stage;
    }

    public void execute() {
        new IncreaseBombs(1, 2, gameStage, stage);
        new FireUps(1, 4, gameStage, stage);
        new IncreaseSpeed(3, 2, gameStage, stage);
    }
}

