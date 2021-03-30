package ru.geekbrains.com.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.geekbrains.com.StarGame;

public class DesktopLauncher {
	private static final int WINDOW_HEIGHT = 700;
	private static final int WINDOW_WIDTH = 554;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = WINDOW_HEIGHT;
		config.width = WINDOW_WIDTH;
		new LwjglApplication(new StarGame(), config);
	}
}
