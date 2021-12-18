package com.mygdx.game.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Observer.SoftObserve;

public class Soft extends Image implements SoftObserve {
    Sprite soft;
    public Soft(){
        soft = new Sprite(new Texture(Gdx.files.internal("sprite/stage/stage_01/soft_01.png")));
    }
}
