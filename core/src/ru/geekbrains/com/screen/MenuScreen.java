package ru.geekbrains.com.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.com.base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private Texture img;
    private Texture ship;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 speed;
    private Vector2 touchDown;
    private Vector2 endPos;
    private int shipCenterX = 41;
    private int shipCenterY = 31;


    @Override
    public void show() {
        super.show();
        img = new Texture("back.jpg");
        ship = new Texture("spaceship3.png");
        pos = new Vector2(250 - shipCenterX, 50 - shipCenterY);
        v = new Vector2();
        endPos = new Vector2();
        speed = new Vector2();

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.draw(ship, pos.x, pos.y);
        batch.end();
        pos.add(v);
        speed.sub(v);
        if (Math.abs(speed.x) < Math.abs(v.x) && Math.abs(speed.y) < Math.abs(v.y)) v.set(0,0);
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        endPos.set(screenX - shipCenterX,  Gdx.graphics.getHeight() - screenY - shipCenterY);
        speed.set(endPos.cpy().sub(pos));
        v.set(speed.x/speed.len(), speed.y/speed.len());
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.UP:
                pos.y += 10;
                break;
            case Input.Keys.DOWN:
                pos.y -= 10;
                break;
            case Input.Keys.RIGHT:
                pos.x += 10;
                break;
            case Input.Keys.LEFT:
                pos.x -= 10;
                break;
        }
        return false;
    }
}
