package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Bomberman;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Bomberman";
		config.width = 1024;
		config.height = 832+84;
		config.foregroundFPS  = 30;
		config.resizable = false;
		config.addIcon("sprite/starting_screen/bomberman_icon.png", Files.FileType.Internal);
		new LwjglApplication(new Bomberman(), config);
	}
}
