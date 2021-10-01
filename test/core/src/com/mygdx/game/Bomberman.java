package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Bomberman extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Texture background;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture(Gdx.files.internal("stage/battle_stage_1.png"));
		System.out.println("test");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(background, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
