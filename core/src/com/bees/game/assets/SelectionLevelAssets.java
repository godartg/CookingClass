package com.bees.game.assets;

import com.badlogic.gdx.graphics.Texture;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Clase de recursos de la pantalla SelectionLevel
 * Created by workaholic on 16/04/2018.
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 */

public class SelectionLevelAssets extends BaseAssets{
    public static AnnotationAssetManager manager;
    @AnnotationAssetManager.Asset(Texture.class)
    public static final String
        SUPERMARKET = "recursos_imagenes/supermarket.jpg",
        MANTEQUILLA="recursos_imagenes/butter.png",
        LECHE="recursos_imagenes/milk.png",
        POTATO="recursos_imagenes/potato.png",
        SAL="recursos_imagenes/sal.png";
    public SelectionLevelAssets(AnnotationAssetManager annotationAssetManager){
        manager= annotationAssetManager;
    }
    public void load(){
        manager = new AnnotationAssetManager();
        manager.load(SelectionLevelAssets.class);
    }
    public void dispose(){
        manager.dispose();
    }
}
