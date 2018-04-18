package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.bees.game.assets.BaseAssets;
import com.bees.game.assets.LoadingAssets;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;


import net.dermetfan.gdx.assets.AnnotationAssetManager;


/**
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Creado por Edwin César Condori Vilcapuma y Mauricio García Silva  20/03/2018.
 */

public class LoadingScreen extends BaseScreen{
    private final AnnotationAssetManager manager, manager2;
    private Skin skin;
    private Label loading;
    private ScreenEnum siguienteScreen;
    public LoadingScreen(ScreenEnum param, BaseAssets baseAssets) {
        super();
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        manager= baseAssets.manager;
        manager2=LoadingAssets.manager;
        siguienteScreen=param;
    }

    @Override
    public void buildStage() {
        manager2.load(LoadingAssets.class);
        loading = new Label("Loading...", skin);
        loading.setPosition(320 - loading.getWidth() / 2, 180 - loading.getHeight() / 2);
        addActor(loading);
        if (manager.update()) {
            manager.finishLoading();
            ScreenManager.getInstance().showScreen( siguienteScreen, manager);
        } else {
            int progress = (int) (manager.getProgress() * 100);
            loading.setText("Loading... " + progress + "%");
        }
    }
    @Override
    public void render(float delta) {

    }

    @Override
    public void dispose() {
        super.dispose();
        skin.dispose();
    }
}
