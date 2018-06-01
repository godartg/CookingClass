package com.bees.game.presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Clase Abstracta que permite la gestion de pantallas
 * @author Edwin César Condori Vilcapuma
 * @see <a href="http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/">How to manage screens in LibGDX</a>
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */

public abstract class BaseScreen extends Stage implements Screen{

    public BaseScreen() {
        super(new StretchViewport(640, 360, new OrthographicCamera()));
    }

    /**
     * Las clases deben cargar los actores en este método
     */
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

    /**
     * Permitir cambiar el tamaño de la pantalla
     * @param width ancho de pantalla
     * @param height alto de pantalla
     */
    @Override
    public void resize(int width, int height) {
        getViewport().update(width, height);
    }

    /**
     * Pausa el juego
     */
    @Override
    public void pause() {
    }
    /**
     *  Continuar el juego despues de ser pausado
     */
    @Override
    public void resume() {
        // This method is invoked when the game is resumed.
    }
    /**
     *  Ocultar la pantalla
     */
    @Override
    public void hide() {
    }
    /**
     *  Invocar el estado del juego cerrar
     */
    @Override
    public void dispose() {
    }
}
