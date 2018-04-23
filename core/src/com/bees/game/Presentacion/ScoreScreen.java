package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.bees.game.assets.MenuAssets;
import com.bees.game.assets.ScoreAssets;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.UIFactory;

import net.dermetfan.gdx.assets.AnnotationAssetManager;


/**
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Creado por Edwin César Condori Vilcapuma y Mauricio García Silva  20/03/2018.
 */

public class ScoreScreen extends BaseScreen{
    Skin skin;
    private Image fondo_pantalla;
    private Label lbltitulo,lblScore;
    TextButton btnRegresarMenu;
    Texture fondoPantalla;
    AnnotationAssetManager manager;
    public ScoreScreen(int score) {
        super();
        manager= new AnnotationAssetManager();
        loadAssets();
        fondoPantalla= manager.get(ScoreAssets.PUNTUACION);
        fondo_pantalla= new Image(fondoPantalla);
        fondo_pantalla.setSize(640, 360);
        fondo_pantalla.setPosition(0, 0);
        skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        Label.LabelStyle stle_label= skin.get("title",Label.LabelStyle.class);
        lblScore = new Label(""+score, stle_label);
        lbltitulo = new Label( "Felicidades por tu score ", stle_label);
    }

    private void loadAssets() {
        manager.load(ScoreAssets.class);
        manager.finishLoading();
    }

    @Override
    public void buildStage() {

        lblScore.setSize(90,60);
        lblScore.setPosition(300,119);
        lbltitulo.setSize(90,60);
        lbltitulo.setPosition(225, 180);
        TextButton.TextButtonStyle style_btn= skin.get(TextButton.TextButtonStyle.class);
        btnRegresarMenu= new TextButton("Regresar", style_btn);
        btnRegresarMenu.setSize(120,60);
        btnRegresarMenu.setPosition(260,50);
        btnRegresarMenu.addListener(UIFactory.createListener(ScreenEnum.MENU_SCREEN));
        addActor(fondo_pantalla);
        addActor(lbltitulo);
        addActor(lblScore);
        addActor(btnRegresarMenu);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        super.dispose();
        skin.dispose();
        manager.dispose();
    }

}
