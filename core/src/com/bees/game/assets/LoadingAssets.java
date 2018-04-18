package com.bees.game.assets;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Clase de recursos de la pantalla Loading
 * Created by workaholic on 16/04/2018.
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 */

public class LoadingAssets extends BaseAssets{

    @AnnotationAssetManager.Asset(Skin.class)
    public static final String UISKIN = "skin/uiskin.json";
    public LoadingAssets(AnnotationAssetManager annotationAssetManager){
        manager= annotationAssetManager;
    }
    public void load(){
        manager = new AnnotationAssetManager();
        manager.load(LoadingAssets.class);
    }
    public void dispose(){
        manager.dispose();
    }
}
