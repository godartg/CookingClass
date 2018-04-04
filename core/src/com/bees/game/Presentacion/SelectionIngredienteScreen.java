package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
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

public class SelectionIngredienteScreen extends BaseScreen{
    private Music backgroundMusic;
    //Guardar;

    /**
     * The stage where all the buttons are added.
     */
    private Stage stage;
    //Agregar imagen de fondo de la pantalla
    private Image fondo_pantalla,img_ingre1, img_ingre2, img_ingre3, img_ingre4;
    private Label lblTitulo;
    private TextButton btnComenzar;
    private Skin skin;
    private CheckBox chIngrediente1,chIngrediente2,chIngrediente3, chIngrediente4;
    //private ArrayList<Integer> ingredientesArray = new ArrayList<Integer>();
    ExitDialog exitDialog;

    public SelectionIngredienteScreen(final MainGame game) {
        super(game);
        stage = new Stage(new FitViewport(640, 360));

        fondo_pantalla = new Image(game.getManager().get("recursos_imagenes/supermarket.png", Texture.class));
        fondo_pantalla.setSize(640, 360);
        fondo_pantalla.setPosition(0, 0);

        img_ingre1= new Image(game.getManager().get("recursos_imagenes/butter.png", Texture.class));
        img_ingre1.setSize(75, 75);
        img_ingre1.setPosition(80, 205);

        img_ingre2= new Image(game.getManager().get("recursos_imagenes/potato.png", Texture.class));
        img_ingre2.setSize(75, 75);
        img_ingre2.setPosition(200, 205);

        img_ingre3= new Image(game.getManager().get("recursos_imagenes/milk.png", Texture.class));
        img_ingre3.setSize(75, 75);
        img_ingre3.setPosition(320, 205);

        img_ingre4= new Image(game.getManager().get("recursos_imagenes/sal.png", Texture.class));
        img_ingre4.setSize(75, 75);
        img_ingre4.setPosition(80, 85);
        //Importacion de los recursos para skins
        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        //Creacion de estilo para el checkbox
        CheckBox.CheckBoxStyle stle_chbox= skin.get(CheckBox.CheckBoxStyle.class);
        //Crear los checbox indicando:Texto,estilo(skin)
        chIngrediente1= new CheckBox(" Mantequilla",stle_chbox);
        chIngrediente2= new CheckBox(" Papa",stle_chbox);
        chIngrediente3= new CheckBox(" Leche",stle_chbox);
        chIngrediente4= new CheckBox(" Sal",stle_chbox);

        //Crear skin para label
        Label.LabelStyle stle_label= skin.get("title",Label.LabelStyle.class);
        lblTitulo = new Label("Ingredientes", stle_label);
        //Crear skin para Textbutton
        TextButton.TextButtonStyle style_btn= skin.get(TextButton.TextButtonStyle.class);
        btnComenzar= new TextButton("Comenzar", style_btn);
        //Indicar tamaño de los chbox
        chIngrediente1.setSize(120,60);
        chIngrediente2.setSize(120,60);
        chIngrediente3.setSize(120,60);
        chIngrediente4.setSize(120,60);

        //Indicar posicion de los chbox
        chIngrediente1.setPosition(75,140);
        chIngrediente2.setPosition(185,140);
        chIngrediente3.setPosition(300,140);
        chIngrediente4.setPosition(75,35);
        //Label
        lblTitulo.setSize(90,60);
        lblTitulo.setPosition(275,300);
        //Button
        btnComenzar.setSize(120,60);
        btnComenzar.setPosition(260,30);

        btnComenzar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!

                String ingredientes="";
                if(chIngrediente1.isChecked()){
                    ingredientes+="1,";
                    Gdx.app.log("checked","1");
                }
                if (chIngrediente2.isChecked()){
                    //ingredientesArray.add(2);
                    ingredientes+="2,";
                    Gdx.app.log("checked","2");
                }
                if (chIngrediente3.isChecked()){
                    //ingredientesArray.add(3);
                    ingredientes+="3,";
                    Gdx.app.log("checked","3");
                }
                if (chIngrediente4.isChecked()){
                    //ingredientesArray.add(4);
                    ingredientes+="4,";
                    Gdx.app.log("checked","4");
                }

                game.startGame(ingredientes);


            }
        });


        //this.dBsqlite.cerrarDB();
        //Actores de stages
        stage.addActor(fondo_pantalla);
        stage.addActor(chIngrediente1);
        stage.addActor(chIngrediente2);
        stage.addActor(chIngrediente3);
        stage.addActor(chIngrediente4);
        stage.addActor(btnComenzar);
        stage.addActor(img_ingre1);
        stage.addActor(img_ingre2);
        stage.addActor(img_ingre3);
        stage.addActor(img_ingre4);
        stage.addActor(lblTitulo);
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
