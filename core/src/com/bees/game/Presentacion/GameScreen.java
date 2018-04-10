package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.bees.game.Entidad.EIngrediente;
import com.bees.game.Entidad.ELugarPrep;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;
import java.util.ArrayList;
import java.util.ListIterator;

import static com.bees.game.MainGame.manager;

/**
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */

public class GameScreen extends BaseScreen{
    private Music backgroundMusic;
    String ingredientes;
    private Label lblTitulo, lblLugarPrep;
    private Skin skin;

    EIngrediente leche, papa, mantequilla,sal;
    ELugarPrep lugarPrep;
    ImageButton btnizquierda, btnderecha, btnLugarPrep;
    private TextButton btnCocinar;
    Texture lugarTexture;
    ArrayList<String> lugarArray = new ArrayList<String>();
    ArrayList<Texture> pathArray = new ArrayList<Texture>();
    ListIterator<String> llugar;
    ListIterator<Texture> lpath;

    public GameScreen( String ingredientes) {
        super();
        this.ingredientes = ingredientes;
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
        pathArray.add((Texture) manager.get("recursos_imagenes/olla.png"));
        pathArray.add((Texture) manager.get("recursos_imagenes/posillo.png"));
        pathArray.add((Texture) manager.get("recursos_imagenes/sarten.png"));
        pathArray.add((Texture) manager.get("recursos_imagenes/tabla.png"));
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
        backgroundMusic=manager.get("recursos_sonidos/Bolero.mp3");


    }

    @Override
    public void buildStage() {
        lugarTexture = manager.get("recursos_imagenes/olla.png");//
        lugarPrep = new ELugarPrep(lugarTexture,370,50);
        addActor(lugarPrep);
        final Texture lecheTexture=manager.get("recursos_imagenes/milk.png");
        leche = new EIngrediente(lecheTexture,30,230);
        final Texture papaTexture=manager.get("recursos_imagenes/potato.png");
        papa = new EIngrediente(papaTexture,110,230);
        final Texture mantequillaTexture=manager.get("recursos_imagenes/butter.png");
        mantequilla = new EIngrediente(mantequillaTexture,190,230);
        final Texture salTexture=manager.get("recursos_imagenes/sal.png");
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
            addActor(mantequilla);
        }
        if (papaexist){
            addActor(papa);
        }
        if(lecheexist){
            addActor(leche);
        }
        if(salexist){
            addActor(sal);
        }
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
                ScreenManager.getInstance().showScreen( ScreenEnum.MENU_SCREEN );
            }
        });

        backgroundMusic.setVolume(1);
        backgroundMusic.play();
        addActor(lblTitulo);
        addActor(lblLugarPrep);
        addActor(btnderecha);
        addActor(btnizquierda);
        addActor(btnCocinar);
    }




    @Override
    public void hide() {
        super.clear();
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        super.dispose();
    }


}
