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
import com.bees.game.assets.GameAssetsPlatillo1;
import com.bees.game.entidad.Evaluacion;
import com.bees.game.entidad.Ingrediente;
import com.bees.game.assets.GameAssets;
import com.bees.game.entidad.Utencilio;
import com.bees.game.utils.Constantes;
import com.bees.game.utils.EntityFactory;

import net.dermetfan.gdx.assets.AnnotationAssetManager;
import java.util.ArrayList;
import java.util.List;
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
    ImageButton btnizquierda, btnderecha;
    Ingrediente leche, papa, mantequilla,sal;
    private TextButton btnCocinar;
    Texture pantallaGame,ollaTexture, posilloTexture, sartenTexture, tablaTexture, licuadoraTexture, platoTextura;
    Constantes constantes;
    List<String> lugarArray;
    List<Texture> pathArray;
    List<Ingrediente> ingredientes;
    List<String> nombreUtencilios;
    List<String> imagenesDeUtencilios;
    List<Texture> texturasDeUtencilios;
    ListIterator<String> listaNombre;
    ListIterator<Texture> listaTextura;
    ListIterator<String> llugar;
    ListIterator<Texture> lpath;
    Utencilio utencilio, utencilioPlato;
    EntityFactory entityFactory;

    /**
     * @param platilloNumero recibe un entero con el id del platillo
     */
    public GameScreen(int platilloNumero) {
        super();
        manager= new AnnotationAssetManager();
        constantes= new Constantes();
        loadAssets(platilloNumero);
        entityFactory= new EntityFactory(manager);
        ingredientes= entityFactory.getIngredientes(platilloNumero);

        lugarArray =new ArrayList<String>();
        lugarArray.add("Olla");
        lugarArray.add("Posillo");
        lugarArray.add("Sarten");
        lugarArray.add("Tabla");
        pantallaGame= manager.get(GameAssets.PANTALLA_COCINA);

        ollaTexture=manager.get(GameAssets.OLLA);
        posilloTexture= manager.get(GameAssets.POSILLO);
        sartenTexture= manager.get(GameAssets.SARTEN);
        tablaTexture= manager.get(GameAssets.TABLA);
        pathArray =new ArrayList<Texture>();
        pathArray.add(ollaTexture );
        pathArray.add(posilloTexture);
        pathArray.add(sartenTexture);
        pathArray.add(tablaTexture);
        llugar= lugarArray.listIterator();
        lpath= pathArray.listIterator();

        constantes= new Constantes();

        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        Label.LabelStyle stle_label= skin.get("title",Label.LabelStyle.class);

        ImageButton.ImageButtonStyle stle_btn= skin.get("left", ImageButton.ImageButtonStyle.class);
        ImageButton.ImageButtonStyle stle_btn1= skin.get("right", ImageButton.ImageButtonStyle.class);

        nombreUtencilios= constantes.getUtenciliosNombre();
        imagenesDeUtencilios= constantes.getUtenciliosImagen();
        /*
        utencilio= entityFactory.crearUtencilio(0,imagenesDeUtencilios.get(0),370,50);

        listaNombre= nombreUtencilios.listIterator();
        ollaTexture=manager.get(GameAssets.OLLA);
        posilloTexture= manager.get(GameAssets.POSILLO);
        sartenTexture= manager.get(GameAssets.SARTEN);
        tablaTexture= manager.get(GameAssets.TABLA);
        licuadoraTexture= manager.get(GameAssets.LICUADORA);
        platoTextura= manager.get(GameAssets.PLATO);
        texturasDeUtencilios.add(ollaTexture);
        texturasDeUtencilios.add(posilloTexture);
        texturasDeUtencilios.add(sartenTexture);
        texturasDeUtencilios.add(tablaTexture);
        texturasDeUtencilios.add(licuadoraTexture);
        texturasDeUtencilios.add(platoTextura);
        listaTextura=  texturasDeUtencilios.listIterator();
        */

        lblTitulo = new Label("Ingredientes", stle_label);
        lblLugarPrep = new Label("Olla", stle_label);
        btnderecha= new ImageButton(stle_btn);
        btnizquierda= new ImageButton(stle_btn1);
        utencilio = new Utencilio(manager,0,ollaTexture,370,50);

        btnderecha.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(llugar.hasPrevious()){
                    int idUtencilio= utencilio.getId();
                    lblLugarPrep.setText(llugar.previous());
                    utencilio.setImagen(lpath.previous());
                    utencilio.setId(idUtencilio-1);
                }
            }
        });
        btnizquierda.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                if(llugar.hasNext()){
                    int idUtencilio= utencilio.getId();
                    lblLugarPrep.setText(listaNombre.next());
                    utencilio.setImagen(listaTextura.next());
                    utencilio.setId(idUtencilio+1);
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
    private void loadAssets(int idPlatillo) {
        manager.load(GameAssets.class);
        switch (idPlatillo){
            case 0:
                manager.load(GameAssetsPlatillo0.class);
                break;
            case 1:
                manager.load(GameAssetsPlatillo1.class);
                break;
        }
        manager.finishLoading();
    }

    @Override
    public void buildStage() {
        List<List<Integer>> posicionesCocina=constantes.getPOSICIONES_COCINA();
        pantallaGame= manager.get(GameAssets.PANTALLA_COCINA);
        imagenFondo= new Image(pantallaGame);
        imagenFondo.setSize(640, 360);
        imagenFondo.setPosition(0, 0);

        addActor(imagenFondo);


        addActor(utencilio);

        Texture lecheTexture=manager.get(GameAssetsPlatillo0.LECHE);
        leche = new Ingrediente(1,lecheTexture,posicionesCocina.get(0).get(0),posicionesCocina.get(0).get(1));
        Texture papaTexture=manager.get(GameAssetsPlatillo0.PAPA);
        papa = new Ingrediente( 0,papaTexture,posicionesCocina.get(1).get(0),posicionesCocina.get(1).get(1));
        Texture mantequillaTexture=manager.get(GameAssetsPlatillo0.MANTEQUILLA);
        mantequilla = new Ingrediente(2,mantequillaTexture,posicionesCocina.get(2).get(0),posicionesCocina.get(2).get(1));
        Texture salTexture=manager.get(GameAssetsPlatillo0.SAL);
        sal = new Ingrediente(3,salTexture,posicionesCocina.get(3).get(0),posicionesCocina.get(3).get(1));
        leche.setestadoIngrediente(false);
        papa.setestadoIngrediente(false);
        mantequilla.setestadoIngrediente(false);
        sal.setestadoIngrediente(false);

        leche.addListener(new Ingrediente.AgregarListener(leche, utencilio));
        papa.addListener(new Ingrediente.AgregarListener(papa, utencilio));
        mantequilla.addListener(new Ingrediente.AgregarListener(mantequilla, utencilio));
        sal.addListener(new Ingrediente.AgregarListener(sal, utencilio));

        addActor(leche);
        addActor(papa);
        addActor(mantequilla);
        addActor(sal);
/*
        for(int i=0; i<=ingredientes.size(); i++){
            ingredientes.get(i).setPosition(posicionesCocina.get(i).get(0), posicionesCocina.get(i).get(1));
            ingredientes.get(i).setestadoIngrediente(true);
            addActor(ingredientes.get(i));
        }
*/

        TextButton.TextButtonStyle style_btn= skin.get(TextButton.TextButtonStyle.class);
        btnCocinar= new TextButton("Cocinar", style_btn);
        btnCocinar.setSize(120,60);
        btnCocinar.setPosition(280,30);
        btnCocinar.addCaptureListener(new Evaluacion.EvaluarListener(leche,mantequilla,papa,sal));

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
