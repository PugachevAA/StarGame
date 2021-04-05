package ru.geekbrains.com;

import com.badlogic.gdx.Game;

import ru.geekbrains.com.screen.MenuScreen;

public class StarGame extends Game {


	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
