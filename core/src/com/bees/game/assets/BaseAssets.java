package com.bees.game.assets;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * @see <a href="http://www.codinginsights.blog/libgdx-assetmanager/">AssetManager</a>
 * @see <a href="https://www.javatips.net/api/Wisper-master/wisper-libgdx/core/src/java/fr/wisper/screens/gamescreen/GameScreen.java">Wisper-master</a>
 * Created by workaholic on 17/04/2018.
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 */

public abstract class BaseAssets {
    public static AnnotationAssetManager manager;
    public abstract void load();
    public abstract void dispose();
}
