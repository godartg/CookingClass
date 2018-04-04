package com.bees.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

/**
 * Esta es la clase principal la cual heredará de la clase Game la cual nos permite crear multiples pantallas
 * @author Edwin César Condori Vilcapuma
 *
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 * @see  <a href= "https://www.youtube.com/watch?v=csNXZgka5-o"/> LIBGDX para Android - Tutorial 14 - Multiples Pantallas </a>
 */

public class MainGame extends Game{
    /** This is the asset manager we use to centralize the assets. */
    private AssetManager manager;
    private Music backgroundMusic;

    /**
     *
     * These are the screens that we use in this game. I invite you to use a better system than
     * just public variables. For instance, you could create an ArrayList or maybe use some
     * structure such as a map where you can associate a number or a string to a screen.
     */
    public com.bees.game.Presentacion.BaseScreen loadingScreen, tituloScreen, menuScreen, gameScreen, instructionScreen, scoreScreen, selectioningredienteScreen;

    @Override
    public void create () {
        // Initialize the asset manager. We add every aset to the manager so that it can be loaded
        // inside the LoadingScreen screen. Remember to put the name of the asset in the first
        // argument, then the type of the asset in the second argument.
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

        //Agregación de ingredientes
        manager.load("recursos_imagenes/butter.png", Texture.class);
        manager.load("recursos_imagenes/milk.png", Texture.class);
        manager.load("recursos_imagenes/potato.png", Texture.class);
        manager.load("recursos_imagenes/sal.png", Texture.class);
        //Agregación de lugares de preparación
        manager.load("recursos_imagenes/olla.png", Texture.class);
        manager.load("recursos_imagenes/posillo.png", Texture.class);
        manager.load("recursos_imagenes/sarten.png", Texture.class);
        manager.load("recursos_imagenes/tabla.png", Texture.class);
        //Agregación de recursos de musica
        manager.load("audio/jump.ogg", Sound.class);
        manager.load("audio/Menuet.ogg", Music.class);
        manager.load("audio/Wiener.ogg", Music.class);
        manager.load("recursos_sonidos/Bolero.mp3", Music.class);
        //manager.load("data/partida.txt", File.class);
        //dBsqlite= new DBsqlite();
        // Enter the loading screen to load the assets.
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
        //1.2.1
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
