package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
public abstract class Items extends Image{
    protected int borderX, borderY, borderWidth, borderHeight;
    public Sprite item;

    @Override
    public void draw(Batch batch, float parentAlpha){
        item.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void del() {
        this.addAction(Actions.removeActor());
    }

    public int getBorderX() {
        return borderX;
    }
    public int getBorderY() {
        return borderY;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public int getBorderHeight() {
        return borderHeight;
    }
}
