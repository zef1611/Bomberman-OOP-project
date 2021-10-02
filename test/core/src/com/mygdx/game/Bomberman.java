package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Bomberman extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Texture background;
	private Texture statusBar;
	private Texture player;
	private Sprite backgroundSprite;
	private Sprite statusBarSprite;
	private Sprite playerSprite;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		background = new Texture(Gdx.files.internal("stage/stage_01/stage_01.png"));
		statusBar = new Texture(Gdx.files.internal("stage/status_bar.png"));
		player = new Texture(Gdx.files.internal("character/bomberman_black/still/bomberman_still_1.png"));

		statusBarSprite = new Sprite(statusBar);
		statusBarSprite.setPosition(0, 832);

		backgroundSprite = new Sprite(background);
		backgroundSprite.setPosition(Gdx.graphics.getWidth()/2 - backgroundSprite.getWidth()/2,
					Gdx.graphics.getHeight()/2 - (backgroundSprite.getHeight()/2 + statusBarSprite.getHeight()/2));

		playerSprite = new Sprite(player);
		playerSprite.setPosition(96,64);

	}

	@Override
	public void render () {
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			playerSprite.translateY(64f);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			playerSprite.translateY(-64f);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			playerSprite.translateX(-64f);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			playerSprite.translateX(64f);
		}

		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(statusBar, statusBarSprite.getX(), statusBarSprite.getY());
		batch.draw(backgroundSprite, backgroundSprite.getX(), backgroundSprite.getY());
		batch.draw(playerSprite,playerSprite.getX(),playerSprite.getY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
//		statusBar.dispose();
		player.dispose();
	}
}
