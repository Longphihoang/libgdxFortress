package com.mygdx.game;

import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import server.*;

public class GameLoop extends ApplicationAdapter implements InputProcessor    {
	SpriteBatch batch;
	Texture img;
	server.Logic logic;
    float dt;
    OrthographicCamera camera;
	@Override
	public void create () {
		camera= new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//camera.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2,0);
		
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho(0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0, 0, 1);

		img = new Texture("wood.jpg");
		logic = new Logic();
		dt = Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
		camera.update();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logic.run();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for(int i=0;i<4;i++)
		{
		batch.draw(img,(float) logic.p1getCurrent().getPoints(i).getX()*25,(float) logic.p1getCurrent().getPoints(i).getY()*25);
		}
		for(int i=0;i<logic.getPlayerLanded().size();i++)
		{
			batch.draw(img,(float) logic.getPlayerLanded().get(i).getX()*25,(float) logic.getPlayerLanded().get(i).getY()*25);
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
			System.out.println("WORKING");
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
}
