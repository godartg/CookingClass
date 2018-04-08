package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bees.game.Entidad.EIngrediente;
import com.bees.game.Entidad.ELugarPrep;
import com.bees.game.MainGame;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author Edwin César Condori Vilcapuma
 *
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */

public class GameScreen extends BaseScreen{
    private Stage stage;

    //Musica
    private Music backgroundMusic;
    private Vector3 position;
    String ingredientes;
    private Label lblTitulo, lblLugarPrep;
    private Skin skin;

    EIngrediente leche, papa, mantequilla,sal;
    ELugarPrep lugarPrep;
    ImageButton btnizquierda, btnderecha, btnLugarPrep;
    private TextButton btnCocinar;

    //Cuadro de dialogo
    ExitDialog exitDialog;
    Texture lugarTexture;
    ArrayList<String> lugarArray = new ArrayList<String>();
    ArrayList<Texture> pathArray = new ArrayList<Texture>();
    ListIterator<String> llugar;
    ListIterator<Texture> lpath;

    public GameScreen(MainGame game, String ingredientes) {
        super(game);
        this.ingredientes = ingredientes;
        stage = new Stage(new FitViewport(640, 360));
        position= new Vector3(stage.getCamera().position);
        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        Label.LabelStyle stle_label= skin.get("title",Label.LabelStyle.class);

        ImageButton.ImageButtonStyle stle_btn= skin.get("left", ImageButton.ImageButtonStyle.class);
        ImageButton.ImageButtonStyle stle_btn1= skin.get("right", ImageButton.ImageButtonStyle.class);
        //array lugar de preparación
        lugarArray.add("Olla");
        lugarArray.add("Posillo");
        lugarArray.add("Sarten");
        lugarArray.add("Tabla");
        //array path of lugar de preparación
        pathArray.add((Texture) game.getManager().get("recursos_imagenes/olla.png"));
        pathArray.add((Texture) game.getManager().get("recursos_imagenes/posillo.png"));
        pathArray.add((Texture) game.getManager().get("recursos_imagenes/sarten.png"));
        pathArray.add((Texture) game.getManager().get("recursos_imagenes/tabla.png"));
        llugar= lugarArray.listIterator();
        lpath= pathArray.listIterator();

        lblTitulo = new Label("Ingredientes", stle_label);
        lblLugarPrep = new Label("Olla", stle_label);
        btnderecha= new ImageButton(stle_btn);
        btnizquierda= new ImageButton(stle_btn1);

        //Funcionalidad de botones
        btnderecha.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(llugar.hasPrevious()){
                    lblLugarPrep.setText(llugar.previous());
                    lugarPrep.setTexture(lpath.previous());
                }else{
                }

            }
        });
        btnizquierda.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!
                if(llugar.hasNext()){
                    //btnizquierda.setLayoutEnabled(true);
                    lblLugarPrep.setText(llugar.next());
                    lugarPrep.setTexture(lpath.next());
                    //btnderecha.setLayoutEnabled(true);
                }else{

                    //btnizquierda.setLayoutEnabled(false);
                }
            }
        });

        lblTitulo.setSize(90,60);
        lblTitulo.setPosition(120,300);
        lblLugarPrep.setSize(90,60);
        lblLugarPrep.setPosition(425,290);
        btnderecha.setSize(49,49);
        btnderecha.setPosition(355,290);
        btnizquierda.setSize(49,49);
        btnizquierda.setPosition(570,290);
        backgroundMusic=game.getManager().get("recursos_sonidos/Bolero.mp3");


    }

    @Override
    public void show() {
        lugarTexture = game.getManager().get("recursos_imagenes/olla.png");//
        lugarPrep = new ELugarPrep(lugarTexture,370,50);
        stage.addActor(lugarPrep);
        final Texture lecheTexture=game.getManager().get("recursos_imagenes/milk.png");
        leche = new EIngrediente(lecheTexture,30,230);
        final Texture papaTexture=game.getManager().get("recursos_imagenes/potato.png");
        papa = new EIngrediente(papaTexture,110,230);
        final Texture mantequillaTexture=game.getManager().get("recursos_imagenes/butter.png");
        mantequilla = new EIngrediente(mantequillaTexture,190,230);
        final Texture salTexture=game.getManager().get("recursos_imagenes/sal.png");
        sal = new EIngrediente(salTexture,30,150);
        leche.setestadoIngrediente(false);
        papa.setestadoIngrediente(false);
        mantequilla.setestadoIngrediente(false);
        sal.setestadoIngrediente(false);

        leche.addListener(new EIngrediente.AgregarListener(leche, lugarPrep));
        papa.addListener(new EIngrediente.AgregarListener(papa, lugarPrep));
        mantequilla.addListener(new EIngrediente.AgregarListener(mantequilla, lugarPrep));
        sal.addListener(new EIngrediente.AgregarListener(sal, lugarPrep));

        boolean lecheexist=false,mantequillaexist=false,papaexist=false,salexist=false;
        for (String dato : ingredientes.split(",")){
            if(dato.equals("1")){
                mantequillaexist=true;
            }else{
                if(dato.equals("2")){
                    papaexist=true;
                }else{
                    if (dato.equals("3")){
                        lecheexist=true;
                    }else{
                        if (dato.equals("4")){
                            salexist= true;
                        }
                    }
                }
            }
        }

        if (mantequillaexist){
            stage.addActor(mantequilla);
        }
        if (papaexist){
            stage.addActor(papa);
        }
        if(lecheexist){
            stage.addActor(leche);
        }
        if(salexist){
            stage.addActor(sal);
        }

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
        //Crear skin para Textbutton
        TextButton.TextButtonStyle style_btn= skin.get(TextButton.TextButtonStyle.class);
        btnCocinar= new TextButton("Cocinar", style_btn);
        btnCocinar.setSize(120,60);
        btnCocinar.setPosition(280,30);
        btnCocinar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                int puntaje=0;
                if(leche.getestadoIngrediente()){
                    puntaje+=5;
                }
                if (mantequilla.getestadoIngrediente()){
                    puntaje+=5;
                }
                if (papa.getestadoIngrediente()){
                    puntaje+=5;
                }
                if (sal.getestadoIngrediente()){
                    puntaje+=5;
                }

                game.evaluar(puntaje);


            }
        });

        backgroundMusic.setVolume(1);
        backgroundMusic.play();
        stage.addActor(lblTitulo);
        stage.addActor(lblLugarPrep);
        stage.addActor(btnderecha);
        stage.addActor(btnizquierda);
        stage.addActor(btnCocinar);
        Gdx.input.setInputProcessor(stage);
    }



    @Override
    public void hide() {
        stage.clear();
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(182/255f,222/255f,232/255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

}
