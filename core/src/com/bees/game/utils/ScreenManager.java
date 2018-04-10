package com.bees.game.utils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.bees.game.Presentacion.BaseScreen;

/**Esta clase, en combinación con ScreenEnum, nos permitirá cambiar de pantalla facilmente.
 * En esta clase se usa el patrón Singleton.
 * @see <a href="http://www.pixnbgames.com/blog/libgdx/como-gestionar-varias-pantallas-en-libgdx/">Cómo gestionar varias pantallas en LibGDX</a>
 * Created by workaholic on 8/04/2018.
 */

public class ScreenManager {
    private static ScreenManager instance;
    private Game game;
    private ScreenManager() {
        super();
    }
    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }
    public void initialize(Game game) {
        this.game = game;
    }

    public void showScreen(ScreenEnum screenEnum, Object... params) {
        Screen currentScreen = game.getScreen();
        BaseScreen newScreen = screenEnum.getScreen(params);
        newScreen.buildStage();
        game.setScreen(newScreen);
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }
}
