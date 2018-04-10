package com.bees.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.bees.game.Presentacion.SelectionLevelScreen;
import com.bees.game.utils.AssetsManager;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Esta es la clase principal la cual nos permite inicializar las pantallas
 * Tambien cargamos los recursos con la clase AnnotationAssetManager
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Creado por Edwin César Condori Vilcapuma y Mauricio García Silva  20/03/2018.
 * @see <a href= "http://www.pixnbgames.com/blog/libgdx/como-gestionar-varias-pantallas-en-libgdx/"/>Cómo gestionar varias pantallas en LibGDX</a>
 * @see <a href="https://bitbucket.org/dermetfan/libgdx-utils/wiki/net.dermetfan.gdx.assets.AnnotationAssetManager">AnnotationAssetManager</a>
 */

public class MainGame extends Game{
    public static final AnnotationAssetManager manager = new AnnotationAssetManager();
    @Override
    public void create () {
        manager.load(AssetsManager.class);
        ScreenManager.getInstance().initialize(this);
        ScreenManager.getInstance().showScreen( ScreenEnum.LOADING_SCREEN );
    }

}
