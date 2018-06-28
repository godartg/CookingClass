package com.bees.game.presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
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
    private Texture fondoPantalla, imagenBotonJugar, imagenBotonTutorial, imagenBotonSalir;
    AnnotationAssetManager manager;
    public MenuScreen() {
        super();
        manager= new AnnotationAssetManager();
        loadAssets();
        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        fondoPantalla= manager.get(MenuAssets.PANTALLA_PRINCIPAL);
        imagenBotonJugar= manager.get(MenuAssets.BOTON_JUGAR);
        imagenBotonTutorial= manager.get(MenuAssets.BOTON_TUTORIAL);
        imagenBotonSalir= manager.get(MenuAssets.BOTON_SALIR);
    }

    private void loadAssets() {
        manager.load(MenuAssets.class);
        manager.finishLoading();
    }

    @Override
    public void buildStage() {
        Image imagenFondo;
        ImageButton btnPlay, btnTutorial, btnSalir;

        btnPlay = UIFactory.createButton(imagenBotonJugar);
        btnTutorial = UIFactory.createButton(imagenBotonTutorial);
        btnSalir = UIFactory.createButton(imagenBotonSalir);
        btnPlay.setSize(100, 120);
        btnPlay.setPosition(150, 75);
        btnSalir.setSize(100, 120);
        btnSalir.setPosition(300, 75);
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
