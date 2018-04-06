package com.bees.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

/**
 * Esta es la clase principal la cual heredará de la clase Game la cual nos permite crear multiples pantallas
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Creado por Edwin César Condori Vilcapuma y Mauricio García Silva  20/03/2018.
 * @see  <a href= "https://www.youtube.com/watch?v=csNXZgka5-o"/> LIBGDX para Android - Tutorial 14 - Multiples Pantallas </a>
 */

public class MainGame extends Game{

    private AssetManager manager;
    private Music backgroundMusic;

    public com.bees.game.Presentacion.BaseScreen loadingScreen, tituloScreen, menuScreen, gameScreen, instructionScreen, scoreScreen, selectioningredienteScreen;

    @Override
    public void create () {
        manager = new AssetManager();

        //Se agrego los ultimos recursos
        //el nombre de la carpeta fue cambiado porque no puede haber espacio entre los caracteres
        //pantallas
        manager.load("recursos_imagenes/intro.jpg", Texture.class);
        manager.load("recursos_imagenes/supermarket.png", Texture.class);
        manager.load("recursos_imagenes/salon_clases.jpg", Texture.class);
        manager.load("recursos_imagenes/puntuacion.png", Texture.class);

        manager.load("recursos_imagenes/logo.jpg", Texture.class);
        manager.load("recursos_imagenes/logob.jpg", Texture.class);
        manager.load("recursos_imagenes/tutorial1.png", Texture.class);
        manager.load("recursos_imagenes/tutorial2.png", Texture.class);
        manager.load("recursos_imagenes/tutorial3.jpg", Texture.class);
        manager.load("recursos_imagenes/tutorial4.jpg", Texture.class);
        manager.load("recursos_imagenes/tutorial5.png", Texture.class);
        manager.load("recursos_imagenes/tutorial6.jpg", Texture.class);
        manager.load("recursos_imagenes/comidas1a.jpg", Texture.class);

        manager.load("recursos_imagenes/butter.png", Texture.class);
        manager.load("recursos_imagenes/milk.png", Texture.class);
        manager.load("recursos_imagenes/potato.png", Texture.class);
        manager.load("recursos_imagenes/sal.png", Texture.class);

        manager.load("recursos_imagenes/olla.png", Texture.class);
        manager.load("recursos_imagenes/posillo.png", Texture.class);
        manager.load("recursos_imagenes/sarten.png", Texture.class);
        manager.load("recursos_imagenes/tabla.png", Texture.class);

        manager.load("audio/jump.ogg", Sound.class);
        manager.load("audio/Menuet.ogg", Music.class);
        manager.load("audio/Wiener.ogg", Music.class);
        manager.load("recursos_sonidos/Bolero.mp3", Music.class);

        loadingScreen = new com.bees.game.Presentacion.LoadingScreen(this);
        setScreen(loadingScreen);
    }

    public void finishLoading() {
        backgroundMusic = getManager().get("audio/Menuet.ogg");
        backgroundMusic.setVolume(1);
        backgroundMusic.play();
        tituloScreen = new com.bees.game.Presentacion.TituloScreen(this);
        menuScreen = new com.bees.game.Presentacion.MenuScreen(this);
        instructionScreen = new com.bees.game.Presentacion.InstructionScreen(this);
        selectioningredienteScreen= new com.bees.game.Presentacion.SelectionIngredienteScreen(this);
        setScreen(tituloScreen);
    }
    public void startGame(String ingredientes){
        backgroundMusic.stop();
        gameScreen = new com.bees.game.Presentacion.GameScreen(this, ingredientes);
        setScreen(gameScreen);
    }
    public void evaluar(int score){
        scoreScreen = new com.bees.game.Presentacion.ScoreScreen(this, score);
        setScreen(scoreScreen);
    }

    public AssetManager getManager() {
        return manager;
    }
}
