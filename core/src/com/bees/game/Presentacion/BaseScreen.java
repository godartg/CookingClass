package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Clase Abstracta que permite la correcta gestión de las pantallas, tambien permite darle un tamaño determinado
 * @author Edwin César Condori Vilcapuma
 * @see <a href="http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/">How to manage screens in LibGDX</a>
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */

public abstract class BaseScreen extends Stage implements Screen{

    public BaseScreen() {
        super(new StretchViewport(640, 360, new OrthographicCamera()));
    }
    //Subclases deben cargar los actores en este método
    public abstract void buildStage();
    @Override
    public void show() {
        //Permite que la pantalla actual se visualice
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        //Limpiar pantalla
        Gdx.gl.glClearColor(182/255f,222/255f,232/255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Llamar los metodos de la clase Stage
        super.act(delta);
        super.draw();
    }

    @Override
    public void resize(int width, int height) {
        getViewport().update(width, height);
    }

    @Override
    public void pause() {
        // This method is invoked when the game is paused.
    }
    @Override
    public void resume() {
        // This method is invoked when the game is resumed.
    }
    @Override
    public void hide() {
        // This method is invoked when the screen is no more displayed.
    }
    @Override
    public void dispose() {
        // This method is invoked when the game closes.
    }
}
