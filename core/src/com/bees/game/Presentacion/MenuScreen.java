package com.bees.game.presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.bees.game.assets.MenuAssets;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.UIFactory;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Pantalla Menu para seleccionar si jugar o no
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Creado por Edwin César Condori Vilcapuma y Mauricio García Silva  20/03/2018.
 */

public class MenuScreen extends BaseScreen{

    private Skin skin;
    private Texture fondoPantalla;
    AnnotationAssetManager manager;
    public MenuScreen() {
        super();
        manager= new AnnotationAssetManager();
        loadAssets();
        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));

    }

    private void loadAssets() {
        manager.load(MenuAssets.class);
        manager.finishLoading();
    }

    @Override
    public void buildStage() {
        Image imagenFondo;
        TextButton btnPlay, btnSalir;
        fondoPantalla= manager.get(MenuAssets.COMIDAS);
        btnPlay = new TextButton("Jugar", skin);
        btnSalir = new TextButton("Salir", skin);
        btnPlay.setSize(90, 100);
        btnPlay.setPosition(40, 140);
        btnSalir.setSize(90, 100);
        btnSalir.setPosition(140, 140);
        imagenFondo= new Image(fondoPantalla);
        imagenFondo.setSize(640, 360);
        imagenFondo.setPosition(0, 0);
        addActor(imagenFondo);
        addActor(btnPlay);
        addActor(btnSalir);
        btnPlay.addListener(UIFactory.createListener(ScreenEnum.SELECCION_LEVEL_SCREEN));
        btnSalir.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return false;
            }
        });
    }

    @Override
    public void dispose() {
        super.dispose();
        skin.dispose();
        manager.dispose();
    }

}
