package com.bees.game;

import com.badlogic.gdx.Game;
import com.bees.game.assets.MenuAssets;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;


/**
 * Esta es la clase principal la cual nos permite inicializar las pantallas
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 * Creado por Edwin César Condori Vilcapuma y Mauricio García Silva  20/03/2018.
 * @see <a href= "http://www.pixnbgames.com/blog/libgdx/como-gestionar-varias-pantallas-en-libgdx/"/>Cómo gestionar varias pantallas en LibGDX</a>
 * @see <a href="https://bitbucket.org/dermetfan/libgdx-utils/wiki/net.dermetfan.gdx.assets.AnnotationAssetManager">AnnotationAssetManager</a>
 */

public class MainGame extends Game{
    MenuAssets menuAssets;
    @Override
    public void create () {
        ScreenManager.getInstance().initialize(this);
        ScreenManager.getInstance().showScreen( ScreenEnum.LOADING_SCREEN,  menuAssets);
    }

}
