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
    int idPlatillo;
    private Skin skin;
    private Image imagenFondo;
    ImageButton btnizquierda, btnderecha;
    Ingrediente leche, papa, mantequilla,sal;
    private TextButton btnCocinar;
    Texture pantallaGame, lugarTexture,ollaTexture, posilloTexture, sartenTexture, tablaTexture;
    ArrayList<String> lugarArray = new ArrayList<String>();
    ArrayList<Texture> pathArray = new ArrayList<Texture>();
    ListIterator<String> llugar;
    ListIterator<Texture> lpath;
    Constantes constantes;
    List<String> preparacion= new ArrayList<String>();
    /**
    List<Ingrediente> ingredientes;
    List<String> nombreUtencilios;
    List<String> imagenesDeUtencilios;
    List<Texture> texturasDeUtencilios;
    ListIterator<String> listaNombre;
    ListIterator<Texture> listaTextura;
     **/
    Utencilio utencilio, utencilioPlato;
    EntityFactory entityFactory;

    /**
     * @param platilloNumero recibe un entero con el id del platillo
     */
    public GameScreen(int platilloNumero) {
        super();
        manager= new AnnotationAssetManager();

        loadAssets(platilloNumero);
        this.idPlatillo= platilloNumero;
        entityFactory= new EntityFactory(manager);
        //ingredientes= getIngredientes(platilloNumero);
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

        constantes= new Constantes();

        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        Label.LabelStyle stle_label= skin.get("title",Label.LabelStyle.class);

        ImageButton.ImageButtonStyle stle_btn= skin.get("left", ImageButton.ImageButtonStyle.class);
        ImageButton.ImageButtonStyle stle_btn1= skin.get("right", ImageButton.ImageButtonStyle.class);
/**
        nombreUtencilios= constantes.getUtenciliosNombre();
        imagenesDeUtencilios= constantes.getUtenciliosImagen();

        utencilio= entityFactory.crearUtencilio(0,imagenesDeUtencilios.get(0),370,50);

        listaNombre= nombreUtencilios.listIterator();
        for(String imagenUtencilio: imagenesDeUtencilios){
            Texture texture= manager.get(imagenUtencilio);
            texturasDeUtencilios.add( texture);
        }
        listaTextura=  texturasDeUtencilios.listIterator();
*/

        lblTitulo = new Label("Ingredientes", stle_label);
        lblLugarPrep = new Label("Olla", stle_label);
        btnderecha= new ImageButton(stle_btn);
        btnizquierda= new ImageButton(stle_btn1);

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
                    lblLugarPrep.setText(llugar.next());
                    utencilio.setImagen(lpath.next());
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
        lugarTexture = manager.get(GameAssets.OLLA);
        utencilio = new Utencilio(manager,0,lugarTexture,370,50);
        addActor(utencilio);
        Texture lecheTexture=manager.get(GameAssetsPlatillo0.LECHE);
        leche = new Ingrediente(1,0,lecheTexture,posicionesCocina.get(0).get(0),posicionesCocina.get(0).get(1));
        Texture papaTexture=manager.get(GameAssetsPlatillo0.PAPA);
        papa = new Ingrediente( 0,0,papaTexture,posicionesCocina.get(1).get(0),posicionesCocina.get(1).get(1));
        Texture mantequillaTexture=manager.get(GameAssetsPlatillo0.MANTEQUILLA);
        mantequilla = new Ingrediente(2,0,mantequillaTexture,posicionesCocina.get(2).get(0),posicionesCocina.get(2).get(1));
        Texture salTexture=manager.get(GameAssetsPlatillo0.SAL);
        sal = new Ingrediente(3,0,salTexture,posicionesCocina.get(3).get(0),posicionesCocina.get(3).get(1));


        leche.addListener(new Ingrediente.AgregarListener(this.preparacion, leche,papa,mantequilla, sal, utencilio));
        papa.addListener(new Ingrediente.AgregarListener(this.preparacion,papa,leche,mantequilla, sal, utencilio));
        mantequilla.addListener(new Ingrediente.AgregarListener(this.preparacion,mantequilla,papa,leche, sal, utencilio));
        sal.addListener(new Ingrediente.AgregarListener(this.preparacion,sal,papa,mantequilla, leche, utencilio));

        addActor(leche);
        addActor(papa);
        addActor(mantequilla);
        addActor(sal);
        /**
        int posicionInicialX=30;
        int posicionInicialY=150;
        for(Ingrediente ingrediente: ingredientes){
            posicionInicialX+=90;
            posicionInicialY+=80;
           ingrediente.setPosition(posicionInicialX, posicionInicialY);
            ingrediente.setestadoIngrediente(true);
            addActor(ingrediente);
        }
        */

        TextButton.TextButtonStyle style_btn= skin.get(TextButton.TextButtonStyle.class);
        btnCocinar= new TextButton("Cocinar", style_btn);
        btnCocinar.setSize(120,60);
        btnCocinar.setPosition(280,30);
        btnCocinar.addCaptureListener(new Evaluacion.EvaluarListener(idPlatillo, preparacion));

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
