package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bees.game.MainGame;

/**
 * @author Edwin César Condori Vilcapuma
 *
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */

public class TituloScreen extends BaseScreen{

    private Stage stage;
    ExitDialog exitDialog;
    private Image fondo_pantalla;
    private Skin skin;
    ImageButton btnplay;
    private Music backgroundMusic;

    public TituloScreen(final MainGame game) {
        super(game);
        stage = new Stage(new FitViewport(640, 360));
        fondo_pantalla= new Image(game.getManager().get("recursos_imagenes/intro.jpg", Texture.class));
        fondo_pantalla.setSize(640, 360);
        fondo_pantalla.setPosition(0, 0);

        //Intancia un objeto de clase skin para hacer uso de un recurso imagen
        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        //Selección de la imagen para el objeto imagebutton
        ImageButton.ImageButtonStyle imageButtonStyle = skin.get( "right", ImageButton.ImageButtonStyle.class );
        btnplay= new ImageButton( imageButtonStyle );
        //Agregar evento
        btnplay.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!
                game.setScreen(game.menuScreen);
            }
        });
        //Agregar tamaño
        btnplay.setSize(50, 50);
        //Agregar posición
        btnplay.setPosition(295, 59);
        //Tomar en cuenta el orden
        //Agregar a la pantalla
        stage.addActor(fondo_pantalla);
        //Agregar a la pantalla
        stage.addActor(btnplay);

    }


    /**
     *
     * @retun Es el numero de pixel en la pantalla
     */
    @Override
    public void show() {
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
        //
        // When the screen is no more visible, you have to remember to unset the input processor.
        // Otherwise, input might act weird, because even if you aren't using this screen, you are
        // still using the stage for handling input.
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        // Elimina objetos que no se usan para que sea menos pesado la aplicación
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
}
