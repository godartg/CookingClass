package com.bees.game.Presentacion;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * @author Edwin César Condori Vilcapuma
 *
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */

public class MenuScreen extends BaseScreen{
    /** The stage where all the buttons are added. */
    private Stage stage;

    /** The skin that we use to set the style of the buttons. */
    private Skin skin;

    /** The logo image you see on top of the screen. */
    //private Image logo

    //Agregar imagen de fondo de la pantalla
    private Image fondo_pantalla;

    /** The play button you use to jump to the game screen. */
    private TextButton btnplay, btnrecetas, btnopciones;

    ExitDialog exitDialog;

    public MenuScreen(final MainGame game) {
        super(game);
        // Create a new stage, as usual.
        stage = new Stage(new FitViewport(640, 360));

        fondo_pantalla= new Image(game.getManager().get("recursos_imagenes/comidas1a.jpg", Texture.class));
        fondo_pantalla.setSize(640, 360);
        fondo_pantalla.setPosition(0, 0);
        stage.addActor(fondo_pantalla);

        // Load the skin file. The skin file contains information about the skins. It can be
        // passed to any widget in Scene2D UI to set the style. It just works, amazing.
        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));

        // For instance, here you see that I create a new button by telling the label of the
        // button as well as the skin file. The background image for the button is in the skin
        // file.
        btnplay = new TextButton("Jugar", skin);
        btnrecetas = new TextButton("Recetas", skin);
        btnopciones = new TextButton("Opciones", skin);

        // Also, create an image. Images are actors that only display some texture. Useful if you
        // want to display a texture in a Scene2D based screen but you don't want to rewrite code.
        //logo = new Image(game.getManager().get("logo.png", Texture.class));

        // Add capture listeners. Capture listeners have one method, changed, that is executed
        // when the button is pressed or when the user interacts somehow with the widget. They are
        // cool because they let you execute some code when you press them.
        btnplay.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!
                game.setScreen(game.selectioningredienteScreen);
            }
        });


        // Now I position things on screen. Sorry for making this the hardest part of this screen.
        // I position things on the screen so that they look centered. This is why I make the
        // buttons the same size.
        //logo.setPosition(440 - logo.getWidth() / 2, 320 - logo.getHeight());
        btnplay.setSize(90, 100);
        btnplay.setPosition(40, 140);

        btnrecetas.setSize(90, 100);
        btnrecetas.setPosition(140, 140);

        btnopciones.setSize(90, 100);
        btnopciones.setPosition(240, 140);

        // Do not forget to add actors to the stage or we wouldn't see anything.
        stage.addActor(btnplay);
        //stage.addActor(btnrecetas);
        //stage.addActor(btnopciones);
        //stage.addActor(logo);
    }
    @Override
    public void show() {
        // Now this is important. If you want to be able to click the button, you have to make
        // the Input system handle input using this Stage. Stages are also InputProcessors. By
        // making the Stage the default input processor for this game, it is now possible to
        // click on buttons and even to type on input fields.
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        // When the screen is no more visible, you have to remember to unset the input processor.
        // Otherwise, input might act weird, because even if you aren't using this screen, you are
        // still using the stage for handling input.
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        // Dispose assets.
        stage.dispose();
        skin.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.3f, 0.5f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    /**
     * Esta es la clase principal la cual heredará de la clase Game la cual nos permite crear multiples pantallas
     * @author Edwin César Condori Vilcapuma
     *
     * Created by Edwin César Condori Vilcapuma on 20/03/2018.
     * @see  <a href= "https://www.youtube.com/watch?v=csNXZgka5-o"/> LIBGDX para Android - Tutorial 14 - Multiples Pantallas </a>
     */

    public static class MainGame extends Game {
        /** This is the asset manager we use to centralize the assets. */
        private AssetManager manager;
        private Music backgroundMusic;

        /**
         *
         * These are the screens that we use in this game. I invite you to use a better system than
         * just public variables. For instance, you could create an ArrayList or maybe use some
         * structure such as a map where you can associate a number or a string to a screen.
         */
        public BaseScreen loadingScreen, tituloScreen, menuScreen, gameScreen, instructionScreen, scoreScreen, selectioningredienteScreen;

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
            loadingScreen = new LoadingScreen(this);
            setScreen(loadingScreen);
        }

        public void finishLoading() {
            backgroundMusic = getManager().get("audio/Menuet.ogg");
            backgroundMusic.setVolume(1);
            backgroundMusic.play();
            tituloScreen = new TituloScreen(this);
            menuScreen = new MenuScreen(this);
            instructionScreen = new InstructionScreen(this);
            selectioningredienteScreen= new SelectionIngredienteScreen(this);
            //1.2.1
            setScreen(tituloScreen);
        }
        public void startGame(String ingredientes){
            backgroundMusic.stop();
            gameScreen = new GameScreen(this, ingredientes);
            setScreen(gameScreen);
        }
        public void evaluar(int score){
            scoreScreen = new ScoreScreen(this, score);
            setScreen(scoreScreen);
        }

        public AssetManager getManager() {
            return manager;
        }
    }
}
