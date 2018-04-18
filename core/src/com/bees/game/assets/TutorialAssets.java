package com.bees.game.assets;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Clase de recursos de la pantalla Tutorial
 * Created by workaholic on 16/04/2018.
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 */

public class TutorialAssets extends BaseAssets{

    public TutorialAssets(AnnotationAssetManager annotationAssetManager){
        manager= annotationAssetManager;
    }
    public void load(){
        manager = new AnnotationAssetManager();
        manager.load(TutorialAssets.class);
    }
    public void dispose(){
        manager.dispose();
    }
}
