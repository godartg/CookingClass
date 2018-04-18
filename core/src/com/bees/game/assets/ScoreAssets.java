package com.bees.game.assets;

import com.badlogic.gdx.graphics.Texture;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Clase de recursos de la pantalla Score
 * Created by workaholic on 16/04/2018.
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 */

public class ScoreAssets extends BaseAssets{
    public static AnnotationAssetManager manager;
    @AnnotationAssetManager.Asset(Texture.class)
    public static final String
    PUNTUACION="recursos_imagenes/puntuacion.png";
    public ScoreAssets(AnnotationAssetManager annotationAssetManager){
        manager= annotationAssetManager;
    }
    public void load(){
        manager = new AnnotationAssetManager();
        manager.load(ScoreAssets.class);
    }
    public void dispose(){
        manager.dispose();
    }
}
