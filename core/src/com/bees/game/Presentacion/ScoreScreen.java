package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bees.game.MainGame;

/**
 * @author Edwin César Condori Vilcapuma
 *
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */

public class /**
 * @author Edwin César Condori Vilcapuma
 *
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */ScoreScreen extends BaseScreen{
    /** The stage where all the buttons are added. */
    private Stage stage;
    ExitDialog exitDialog;
    Skin skin;
    //Agregar imagen de fondo de la pantalla
    private Image fondo_pantalla;
    private Label lbltitulo,lblScore;
    TextButton btnRegresarMenu;

    public ScoreScreen(final MainGame game, int score) {
        super(game);
        stage = new Stage(new FitViewport(640, 360));
        fondo_pantalla= new Image(game.getManager().get("recursos_imagenes/puntuacion.png", Texture.class));
        fondo_pantalla.setSize(640, 360);
        fondo_pantalla.setPosition(0, 0);
        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        Label.LabelStyle stle_label= skin.get("title",Label.LabelStyle.class);
        lblScore = new Label(""+score, stle_label);
        lbltitulo = new Label( "Felicidades por tu score ", stle_label);
        lblScore.setSize(90,60);
        lblScore.setPosition(300,119);
        lbltitulo.setSize(90,60);
        lbltitulo.setPosition(225, 180);
        TextButton.TextButtonStyle style_btn= skin.get(TextButton.TextButtonStyle.class);
        btnRegresarMenu= new TextButton("Regresar", style_btn);
        btnRegresarMenu.setSize(120,60);
        btnRegresarMenu.setPosition(260,50);

        btnRegresarMenu.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!
                game.setScreen(game.menuScreen);

            }
        });

        stage.addActor(fondo_pantalla);
        stage.addActor(lbltitulo);
        stage.addActor(lblScore);
        stage.addActor(btnRegresarMenu);
    }
    @Override
    public void show() {
        // Now this is important. If you want to be able to click the button, you have to make
        // the Input system handle input using this Stage. Stages are also InputProcessors. By
        // making the Stage the default input processor for this game, it is now possible to
        // click on buttons and even to type on input fields.
        stage.addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                System.out.println("keycode "+keycode);
                if(keycode==4 || keycode==82){
                    exitDialog= new ExitDialog("Confirmación de salida",skin);
                    exitDialog.show(stage);
                    exitDialog.pack();
                    //Gdx.app.exit();
                    return true;
                }
                return super.keyDown(event, keycode);
            }
        });
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
        //skin.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.3f, 0.5f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

    }
}
