package com.mygdx.game.Player;

import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

//Animation order
//Bomb : 2 3 2 1 2 3 2 1 2
//Explosion: 1 2 3 4 3 2 1
public class Bomb extends Image {
    Player player;
    public Bomb (Player player){
        this.player = player;

    }
}
