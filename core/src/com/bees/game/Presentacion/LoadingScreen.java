package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;

import static com.bees.game.MainGame.manager;

/**
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Creado por Edwin César Condori Vilcapuma y Mauricio García Silva  20/03/2018.
 */

public class LoadingScreen extends BaseScreen{

    private Skin skin;

    private Label loading;

    public LoadingScreen() {
        super();
        // Set up the stage and the skin. See GameOverScreen for more comments on this.
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

    }

    @Override
    public void buildStage() {
        loading = new Label("Loading...", skin);
        loading.setPosition(320 - loading.getWidth() / 2, 180 - loading.getHeight() / 2);
        addActor(loading);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (manager.update()) {
            manager.finishLoading();
            ScreenManager.getInstance().showScreen( ScreenEnum.MENU_SCREEN );
        } else {
            int progress = (int) (manager.getProgress() * 100);
            loading.setText("Loading... " + progress + "%");
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        skin.dispose();
    }
}
