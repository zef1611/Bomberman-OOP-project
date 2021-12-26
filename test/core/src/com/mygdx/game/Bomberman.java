package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.*;
import com.mygdx.game.Screen.ScreenEnum;
import com.mygdx.game.Screen.ScreenManager;

public class Bomberman extends Game {
	public SpriteBatch batch;

//	The first thing the game will do when activated
	@Override
	public void create () {
		ScreenManager.getInstance().initialize(this);
		ScreenManager.getInstance().showScreen(ScreenEnum.STARTING_SCREEN);
	}

//	Call when the game should render itself
	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
