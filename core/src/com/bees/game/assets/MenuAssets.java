package com.bees.game.assets;

import com.badlogic.gdx.graphics.Texture;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Clase de recursos de la pantalla Menu
 * Created by workaholic on 16/04/2018.
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 */

public class MenuAssets extends BaseAssets{
    public static AnnotationAssetManager manager;
    @AnnotationAssetManager.Asset(Texture.class)
    public static final String
        INTRO="recursos_imagenes/intro.jpg",
        COMIDAS="recursos_imagenes/comidas1a.jpg";
    public MenuAssets(AnnotationAssetManager annotationAssetManager){
        manager= annotationAssetManager;
    }
    public void load(){
        manager = new AnnotationAssetManager();
        manager.load(MenuAssets.class);
    }
    public void dispose(){
        manager.dispose();
    }
}
