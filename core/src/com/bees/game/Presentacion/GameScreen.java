package com.bees.game.presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.bees.game.assets.GameAssetsPlatillo0;
import com.bees.game.entidad.Evaluacion;
import com.bees.game.entidad.Ingrediente;
import com.bees.game.entidad.LugarPreparacion;
import com.bees.game.assets.GameAssets;
import net.dermetfan.gdx.assets.AnnotationAssetManager;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Pantalla encargada de mostrar el proceso principal del juego
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */

public class GameScreen extends BaseScreen{
    private AnnotationAssetManager manager;
    private Label lblTitulo, lblLugarPrep;
    private Skin skin;
    private Image imagenFondo;
    Ingrediente leche, papa, mantequilla,sal;
    LugarPreparacion lugarPreparacion;
    ImageButton btnizquierda, btnderecha, btnLugarPrep;
    private TextButton btnCocinar;
    Texture pantallaGame, lugarTexture,ollaTexture, posilloTexture, sartenTexture, tablaTexture;
    ArrayList<String> lugarArray = new ArrayList<String>();
    ArrayList<Texture> pathArray = new ArrayList<Texture>();
    ListIterator<String> llugar;
    ListIterator<Texture> lpath;

    /**
     * @param platilloNumero recibe un entero con el id del platillo
     */
    public GameScreen(int platilloNumero) {
        super();
        manager= new AnnotationAssetManager();
        loadAssets();

        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        Label.LabelStyle stle_label= skin.get("title",Label.LabelStyle.class);

        ImageButton.ImageButtonStyle stle_btn= skin.get("left", ImageButton.ImageButtonStyle.class);
        ImageButton.ImageButtonStyle stle_btn1= skin.get("right", ImageButton.ImageButtonStyle.class);

        lugarArray.add("Olla");
        lugarArray.add("Posillo");
        lugarArray.add("Sarten");
        lugarArray.add("Tabla");
        pantallaGame= manager.get(GameAssets.PANTALLA_COCINA);
        ollaTexture=manager.get(GameAssets.OLLA);
        posilloTexture= manager.get(GameAssets.POSILLO);
        sartenTexture= manager.get(GameAssets.SARTEN);
        tablaTexture= manager.get(GameAssets.TABLA);
        pathArray.add(ollaTexture );
        pathArray.add(posilloTexture);
        pathArray.add(sartenTexture);
        pathArray.add(tablaTexture);
        llugar= lugarArray.listIterator();
        lpath= pathArray.listIterator();

        lblTitulo = new Label("Ingredientes", stle_label);
        lblLugarPrep = new Label("Olla", stle_label);
        btnderecha= new ImageButton(stle_btn);
        btnizquierda= new ImageButton(stle_btn1);

        btnderecha.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(llugar.hasPrevious()){
                    lblLugarPrep.setText(llugar.previous());
                    lugarPreparacion.setTexture(lpath.previous());
                }else{
                }

            }
        });
        btnizquierda.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(llugar.hasNext()){
                    lblLugarPrep.setText(llugar.next());
                    lugarPreparacion.setTexture(lpath.next());
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
    }

    /**
     * Cargar los recursos como imagenes y audios
     */
    private void loadAssets() {
        manager.load(GameAssets.class);
        manager.finishLoading();
    }

    @Override
    public void buildStage() {
        imagenFondo= new Image(pantallaGame);
        lugarTexture = manager.get(GameAssets.OLLA);
        lugarPreparacion = new LugarPreparacion(lugarTexture,370,50);
        addActor(lugarPreparacion);
        Texture lecheTexture=manager.get(GameAssetsPlatillo0.LECHE);
        leche = new Ingrediente(lecheTexture,30,230);
        Texture papaTexture=manager.get(GameAssetsPlatillo0.PAPA);
        papa = new Ingrediente(papaTexture,110,230);
        Texture mantequillaTexture=manager.get(GameAssetsPlatillo0.MANTEQUILLA);
        mantequilla = new Ingrediente(mantequillaTexture,190,230);
        Texture salTexture=manager.get(GameAssetsPlatillo0.SAL);
        sal = new Ingrediente(salTexture,30,150);
        leche.setestadoIngrediente(false);
        papa.setestadoIngrediente(false);
        mantequilla.setestadoIngrediente(false);
        sal.setestadoIngrediente(false);

        leche.addListener(new Ingrediente.AgregarListener(leche, lugarPreparacion));
        papa.addListener(new Ingrediente.AgregarListener(papa, lugarPreparacion));
        mantequilla.addListener(new Ingrediente.AgregarListener(mantequilla, lugarPreparacion));
        sal.addListener(new Ingrediente.AgregarListener(sal, lugarPreparacion));

        addActor(leche);
        addActor(papa);
        addActor(mantequilla);
        addActor(sal);
        TextButton.TextButtonStyle style_btn= skin.get(TextButton.TextButtonStyle.class);
        btnCocinar= new TextButton("Cocinar", style_btn);
        btnCocinar.setSize(120,60);
        btnCocinar.setPosition(280,30);
        btnCocinar.addCaptureListener(new Evaluacion.EvaluarListener(leche,mantequilla,papa,sal));
        imagenFondo= new Image(pantallaGame);
        imagenFondo.setSize(640, 360);
        imagenFondo.setPosition(0, 0);
        addActor(imagenFondo);
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
        skin.dispose();
        manager.dispose();
    }

}
