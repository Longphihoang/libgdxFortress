package com.mygdx.game;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.utils.Timer.Task;

import server.*;

public class GameLoop extends ApplicationAdapter implements InputProcessor    {
	SpriteBatch batch;
	//Sound sound;
	Texture img;
	Texture img2;
	Texture background;
	server.Logic logic;
    float dt;
    BitmapFont font;
    OrthographicCamera camera;
	@Override
	public void create () {
		//sound = new Sound("");
		camera= new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//camera.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2,0);
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho(0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0, 0, 1);
		background = new Texture("background.png");
		img = new Texture("wood.jpg");
		img2 = new Texture("woodRotate.png");
		logic = new Logic();
		dt = Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f);
		Gdx.input.setInputProcessor(this);
		font = new BitmapFont();
		
		StartTick(2f,.5f);
		
			}

	@Override
	public void render () {
		camera.update();
		
		//logic.run();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background,0,0);
		batch.draw(img2,(float) logic.p1getCurrent().getPoints(0).getX()*25,(float) logic.p1getCurrent().getPoints(0).getY()*25);
		for(int i=1;i<4;i++)
		{
		batch.draw(img,(float) logic.p1getCurrent().getPoints(i).getX()*25,(float) logic.p1getCurrent().getPoints(i).getY()*25);
		}
		for(int i=0;i<logic.getPlayerLanded().size();i++)
		{
			batch.draw(img,(float) logic.getPlayerLanded().get(i).getX()*25,(float) logic.getPlayerLanded().get(i).getY()*25);
		}
		for(int i = 0;i<15;i++)
		{
			font.draw(batch, ""+i, i*25, 580);
			font.draw(batch, ""+i, i*25, 0);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(keycode==Keys.LEFT)
		{
			logic.moveP1("left");
			return true;
		}
		if(keycode==Keys.RIGHT)
		{
			logic.moveP1("right");
			return true;
		}
		if(keycode==Keys.DOWN)
		{
			logic.moveP1("down");
			return true;
		}
		if(keycode==Keys.UP)
		{
			logic.moveP1("up");
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void StartTick(float delay, float inteval)
	{
		Timer.schedule(new Task(){
            @Override
            public void run() {
                logic.run();
            }
        }
        , delay        //    (delay)
        , inteval     //    (seconds)
    );

	}
}
