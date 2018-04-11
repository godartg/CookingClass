package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.bees.game.utils.AssetsManager;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;

import net.dermetfan.gdx.assets.AnnotationAssetManager;



/**
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Creado por Edwin César Condori Vilcapuma y Mauricio García Silva  20/03/2018.
 */

public class SelectionLevelScreen extends BaseScreen{
    //private Music backgroundMusic;
    /**
     * The stage where all the buttons are added.
     */
    private Image imagenFondo,imagenIngrediente1, imagenIngrediente2, imagenIngrediente3, imagenIngrediente4;
    private Label lblTitulo;
    private TextButton btnComenzar;
    private Skin skin;
    private CheckBox chIngrediente1,chIngrediente2,chIngrediente3, chIngrediente4;
    private Texture fondoPantalla, mantequila, papa, leche, sal;
    AnnotationAssetManager manager;
    public SelectionLevelScreen() {
        super();
        manager= new AnnotationAssetManager();
        fondoPantalla = manager.get(AssetsManager.SUPERMARKET);
        mantequila= manager.get(AssetsManager.MANTEQUILLA);
        papa= manager.get(AssetsManager.POTATO);
        leche= manager.get(AssetsManager.LECHE);
        sal= manager.get(AssetsManager.SAL);

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

    }

    @Override
    public void buildStage() {
        imagenFondo= new Image(fondoPantalla);
        imagenFondo.setSize(640, 360);
        imagenFondo.setPosition(0, 0);
        imagenIngrediente1= new Image(mantequila);
        imagenIngrediente1.setSize(75, 75);
        imagenIngrediente1.setPosition(80, 205);
        imagenIngrediente2= new Image(papa);
        imagenIngrediente2.setSize(75, 75);
        imagenIngrediente2.setPosition(200, 205);
        imagenIngrediente3= new Image(leche);
        imagenIngrediente3.setSize(75, 75);
        imagenIngrediente3.setPosition(320, 205);
        imagenIngrediente4= new Image(sal);
        imagenIngrediente4.setSize(75, 75);
        imagenIngrediente4.setPosition(80, 85);
        btnComenzar.setSize(120,60);
        btnComenzar.setPosition(260,30);

        btnComenzar.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String ingredientes="";
                if(chIngrediente1.isChecked()){
                    ingredientes+="1,";
                    Gdx.app.log("checked","1");
                }
                if (chIngrediente2.isChecked()){
                    ingredientes+="2,";
                    Gdx.app.log("checked","2");
                }
                if (chIngrediente3.isChecked()){
                    ingredientes+="3,";
                    Gdx.app.log("checked","3");
                }
                if (chIngrediente4.isChecked()){
                    ingredientes+="4,";
                    Gdx.app.log("checked","4");
                }
                ScreenManager.getInstance().showScreen( ScreenEnum.GAME_SCREEN, ingredientes );
            }
        });
        addActor(imagenFondo);
        addActor(chIngrediente1);
        addActor(chIngrediente2);
        addActor(chIngrediente3);
        addActor(chIngrediente4);
        addActor(btnComenzar);
        addActor(imagenIngrediente1);
        addActor(imagenIngrediente2);
        addActor(imagenIngrediente3);
        addActor(imagenIngrediente4);
        addActor(lblTitulo);
    }


    @Override
    public void dispose() {
        super.dispose();
        skin.dispose();
    }

}
