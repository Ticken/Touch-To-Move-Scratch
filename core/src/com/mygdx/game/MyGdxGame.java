package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture img,imgDude,imgBackground;
	float fTouchX, fTouchY,fPx=640,fPy=640;
	TiledMap tiledMap;
	OrthographicCamera camera;
	TiledMapRenderer tiledMapRenderer;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 424, 250);
		camera.position.set(fPx - 212, fPy - 117, 0);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		tiledMap = new TmxMapLoader().load("MyMap.tmx");
		imgDude = new Texture("player.png");
		batch = new SpriteBatch();
		imgBackground = new Texture("touchBackground.png");
		Rectangle recPlayer = new Rectangle();
		recPlayer.set(fPx,fPy, 16,16);



	}

	@Override
	public void render () {
		camera.position.set(fPx -212,fPy-117,0);
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			fTouchX = (touchPos.x);
			fTouchY = (touchPos.y);
		}
		batch.begin();
		batch.draw(imgDude, fTouchX-(imgDude.getWidth()/2) , fTouchY-(imgDude.getHeight()/2));
		batch.end();
	}
	public boolean touchUp(int n1, int n2, int n3, int n4) {return false;}
	public boolean touchDown(int n1, int n2, int n3, int n4) {
		return false;
	}
	public boolean touchDragged(int n1, int n2, int n3) {
		return false;
	}
	public boolean keyTyped(char character) {
		return false;
	}
	public boolean keyDown(int keycode) {return false; }
	public boolean keyUp(int keycode) {
		return false;
	}
	public boolean mouseMoved(int n1, int n2) {
		return false;
	}
	public boolean scrolled(int n1) {
		return false;
	}

}

