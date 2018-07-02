package com.bees.game.presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.bees.game.assets.SelectionLevelAssets;
import com.bees.game.utils.Constantes;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;
import com.bees.game.utils.UIFactory;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;
import java.util.List;


/**
 * Pantalla que permite seleccionar el platillo
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Creado por Edwin César Condori Vilcapuma y Mauricio García Silva  20/03/2018.
 */

public class SelectionLevelScreen extends BaseScreen{
    private Image imagenFondo;
    private ImageButton botonPlatillo0, botonPlatillo1;
    private List<Object> platillosImagenes= new ArrayList<Object>();
    AnnotationAssetManager manager;

    public SelectionLevelScreen() {
        super();
        Constantes constantes= new Constantes();
        manager= new AnnotationAssetManager();
        platillosImagenes=constantes.getPlatillosImagenes();
        loadAssets();

    }

    private void loadAssets() {
        manager.load(SelectionLevelAssets.class);
        manager.finishLoading();
    }

    @Override
    public void buildStage() {
        Texture fondoPantalla = manager.get(SelectionLevelAssets.FONDO_SELECCION);
        Texture platillo0= manager.get((String) platillosImagenes.get(0));
        Texture platillo1= manager.get((String) platillosImagenes.get(1));

        botonPlatillo0= UIFactory.createButton(platillo0);
        botonPlatillo1= UIFactory.createButton(platillo1);

        botonPlatillo0.addListener(UIFactory.createListener(ScreenEnum.GAME_SCREEN, 0)) ;
        botonPlatillo1.addListener(UIFactory.createListener(ScreenEnum.GAME_SCREEN, 1));

        imagenFondo= new Image(fondoPantalla);
        imagenFondo.setSize(640, 360);
        imagenFondo.setPosition(0, 0);
        botonPlatillo0.setSize(250,250);
        botonPlatillo1.setSize(250,250);

        botonPlatillo0.setPosition(90,50);
        botonPlatillo1.setPosition(300,50);

        addActor(imagenFondo);
        addActor(botonPlatillo0);
        addActor(botonPlatillo1);

    }


    @Override
    public void dispose() {
        super.dispose();
        manager.dispose();
    }

}
