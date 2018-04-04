package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
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

public class InstructionScreen extends BaseScreen{
    private Stage stage;
    ExitDialog exitDialog;
    //Agregar imagen de fondo de la pantalla
    private Skin skin;
    private Image fondo_pantalla;
    private TextButton btnsiguiente;

    public InstructionScreen(final MenuScreen.MainGame game) {
        super(game);
        stage = new Stage(new FitViewport(640, 360));

        fondo_pantalla= new Image(game.getManager().get("recursos_imagenes/tutorial1.png", Texture.class));
        fondo_pantalla.setSize(640, 360);
        fondo_pantalla.setPosition(0, 0);

        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        btnsiguiente = new TextButton("Siguiente", skin);

        btnsiguiente.addCaptureListener(new ChangeListener() {
            int contadortutorial=1;

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!
                tutorial(contadortutorial);
                contadortutorial++;
            }

            private void tutorial(int contadortutorial) {

                switch (contadortutorial){
                    case 1:
                        Image imagen2 = new Image(game.getManager().get("recursos_imagenes/tutorial2.png",Texture.class));
                        imagen2.setSize(640, 360);
                        imagen2.setPosition(0, 0);
                        btnsiguiente.setPosition(244,30);
                        stage.addActor(imagen2);
                        stage.addActor(btnsiguiente);
                        break;
                    case 2:
                        Image imagen3 = new Image(game.getManager().get("recursos_imagenes/tutorial3.jpg",Texture.class));
                        imagen3.setSize(640, 360);
                        imagen3.setPosition(0, 0);
                        btnsiguiente.setPosition(244,30);
                        stage.addActor(imagen3);
                        stage.addActor(btnsiguiente);
                        break;
                    case 3:
                        Image imagen4 = new Image(game.getManager().get("recursos_imagenes/tutorial4.jpg",Texture.class));
                        imagen4.setSize(640, 360);
                        imagen4.setPosition(0, 0);
                        btnsiguiente.setPosition(244,30);
                        stage.addActor(imagen4);
                        stage.addActor(btnsiguiente);
                        break;
                    case 4:
                        Image imagen5 = new Image(game.getManager().get("recursos_imagenes/tutorial5.png",Texture.class));
                        imagen5.setSize(640, 360);
                        imagen5.setPosition(0, 0);
                        btnsiguiente.setPosition(244,30);
                        stage.addActor(imagen5);
                        stage.addActor(btnsiguiente);
                        break;
                    case 5:
                        Image imagen6 = new Image(game.getManager().get("recursos_imagenes/tutorial6.jpg",Texture.class));
                        imagen6.setSize(640, 360);
                        imagen6.setPosition(0, 0);
                        btnsiguiente.setPosition(244,30);
                        stage.addActor(imagen6);
                        stage.addActor(btnsiguiente);
                        break;
                    case 6:
                        game.setScreen(game.selectioningredienteScreen);
                        break;
                }

            }

        });
        btnsiguiente.setSize(120, 60);
        btnsiguiente.setPosition(244, 30);

        // Do not forget to add actors to the stage or we wouldn't see anything.
        stage.addActor(fondo_pantalla);
        stage.addActor(btnsiguiente);
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
