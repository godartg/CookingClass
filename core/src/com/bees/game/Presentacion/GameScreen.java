package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
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
    /** The stage where all the buttons are added. */
    //necesario declarar
    private Stage stage;

    /** World instance for Box2D engine. */
    //private World world;
    //Musica
    private Music backgroundMusic;
    private Sound jump;
    private Vector3 position;
    String ingredientes;
    private Label lblTitulo, lblLugarPrep;
    private Skin skin;

    //private Vector<Vector<String>> datos= new Vector();
    EIngrediente leche, papa, mantequilla,sal;
    ELugarPrep lugarPrep;
    DragAndDrop dragAndDrop = new DragAndDrop();
    ImageButton btnizquierda, btnderecha, btnLugarPrep;
    private TextButton btnCocinar;
    float touchDown_x;
    float touchDown_y;
    float dx;
    float dy;
    //Cuadro de dialogo
    ExitDialog exitDialog;
    //Lugar de Preparación
    private int contLugarPrep;
    Texture lugarTexture;
    //Array de lugar de preparacion
    ArrayList<String> lugarArray = new ArrayList<String>();
    ArrayList<Texture> pathArray = new ArrayList<Texture>();
    ListIterator<String> llugar;
    ListIterator<Texture> lpath;
    //Array para ingredientes
    //ArrayList<Integer> ingredientesArray = new ArrayList<Integer>();

    public GameScreen(MainGame game, String ingredientes) {
        super(game);
        //necesario instanciar
        this.ingredientes = ingredientes;
        stage = new Stage(new FitViewport(640, 360));
//        stage.setDebugAll(true);
        position= new Vector3(stage.getCamera().position);
        //world= new World(new Vector2(0,0),true);
        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        Label.LabelStyle stle_label= skin.get("title",Label.LabelStyle.class);

        //Label.LabelStyle stle_label1= skin.get(Label.LabelStyle.class);
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
        //Labels
        llugar= lugarArray.listIterator();
        lpath= pathArray.listIterator();

        lblTitulo = new Label("Ingredientes", stle_label);
        lblLugarPrep = new Label("Olla", stle_label);
        //Botones
        btnderecha= new ImageButton(stle_btn);
        btnizquierda= new ImageButton(stle_btn1);

        //Funcionalidad de botones
        btnderecha.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // Take me to the game screen!
                if(llugar.hasPrevious()){
                    //btnderecha.setLayoutEnabled(true);
                    lblLugarPrep.setText(llugar.previous());
                    lugarPrep.setTexture(lpath.previous());
                    //btnizquierda.setLayoutEnabled(true);
                }else{
                    //btnderecha.setLayoutEnabled(false);
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
        //Tamaño y Posicionamiento
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
        //EPartida ePartida= new EPartida();
        //PartidaMetodos partida= new PartidaMetodos();
        //IngredienteMetodos ingredientes= new IngredienteMetodos();
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
        leche.addListener(new InputListener() {
            final float h = 75 / 2;
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                touchDown_x = x;
                touchDown_y = h - y;
                return true;
            }
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                dx = leche.getX() - touchDown_x;
                dy = leche.getY() - h  + touchDown_y;
                leche.setPosition(x + dx, y + dy);
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if ((leche.getX()>=lugarPrep.getX()&&leche.getX()<=(lugarPrep.getX()+lugarPrep.getWidth()))&&(leche.getY()>=lugarPrep.getY()&&leche.getY()<=(lugarPrep.getY()+lugarPrep.getHeight()))){
                    leche.setVisible(false);
                    leche.setestadoIngrediente(true);
                }else{
                    leche.setPosition(30,230);
                    //System.out.println("X:"+x+";"+"Y"+y);
                }
            }
        });
        papa.addListener(new InputListener() {
            final float h = 75 / 2;
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                touchDown_x = x;
                touchDown_y = h - y;
                return true;
            }
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                dx = papa.getX() - touchDown_x;
                dy = papa.getY() -h + touchDown_y;
                papa.setPosition(x + dx, y + dy);
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if ((papa.getX()>=lugarPrep.getX()&&papa.getX()<=(lugarPrep.getX()+lugarPrep.getWidth()))&&(papa.getY()>=lugarPrep.getY()&&papa.getY()<=(lugarPrep.getY()+lugarPrep.getHeight()))){
                    papa.setVisible(false);
                    papa.setestadoIngrediente(true);
                }else{
                    papa.setPosition(110,230);
                    //System.out.println("X:"+x+";"+"Y"+y);
                }
            }
        });
        mantequilla.addListener(new InputListener() {
            final float h = 75 / 2;
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                touchDown_x = x;
                touchDown_y = h - y;
                return true;
            }
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                dx = mantequilla.getX() - touchDown_x;
                dy = mantequilla.getY() -h + touchDown_y;
                mantequilla.setPosition(x + dx, y + dy);
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if ((mantequilla.getX()>=lugarPrep.getX()&&mantequilla.getX()<=(lugarPrep.getX()+lugarPrep.getWidth()))&&(mantequilla.getY()>=lugarPrep.getY()&&mantequilla.getY()<=(lugarPrep.getY()+lugarPrep.getHeight()))){
                    mantequilla.setVisible(false);
                    mantequilla.setestadoIngrediente(true);
                }else{
                    mantequilla.setPosition(190,230);
                    //System.out.println("X:"+x+";"+"Y"+y);
                }
                //
            }
        });
        sal.addListener(new InputListener() {
            final float h = 75 / 2;
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                touchDown_x = x;
                touchDown_y = h - y;
                return true;
            }
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                dx = sal.getX() - touchDown_x;
                dy = sal.getY() -h + touchDown_y;
                sal.setPosition(x + dx, y + dy);
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if ((sal.getX()>=lugarPrep.getX()&&sal.getX()<=(lugarPrep.getX()+lugarPrep.getWidth()))&&(sal.getY()>=lugarPrep.getY()&&sal.getY()<=(lugarPrep.getY()+lugarPrep.getHeight()))){
                    sal.setVisible(false);
                    sal.setestadoIngrediente(true);
                }else{
                    sal.setPosition(30,150);
                    //System.out.println("X:"+x+";"+"Y"+y);
                }
                //
            }
        });
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
                // Take me to the game screen!
                int puntaje=0;
                if(leche.getestadoIngrediente()){
                    puntaje+=5;
                    //Gdx.app.log("checked","1");
                }
                if (mantequilla.getestadoIngrediente()){
                    puntaje+=5;
                    //Gdx.app.log("checked","2");
                }
                if (papa.getestadoIngrediente()){
                    puntaje+=5;
                    //Gdx.app.log("checked","3");
                }
                if (sal.getestadoIngrediente()){
                    puntaje+=5;
                    //Gdx.app.log("checked","4");
                }

                game.evaluar(puntaje);


            }
        });

        //stage.setDebugAll(true);
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
        //IngredienteList.clear();
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        // Dispose assets.

        stage.dispose();

    }

    @Override
    public void render(float delta) {
        //Gdx.gl.glClearColor(0.2f, 0.3f, 0.5f, 1f);
        Gdx.gl.glClearColor(182/255f,222/255f,232/255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();

        stage.draw();
    }
}
