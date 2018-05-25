package com.bees.game.utils;

import com.bees.game.presentacion.BaseScreen;
import com.bees.game.presentacion.ConfiguracionScreen;
import com.bees.game.presentacion.GameScreen;
import com.bees.game.presentacion.MenuScreen;
import com.bees.game.presentacion.ScoreScreen;
import com.bees.game.presentacion.SelectionLevelScreen;
import com.bees.game.presentacion.TutorialScreen;

/**
 * Para gestionar las escenas, crearemos un tipo Enum de java, llamado ScreenEnum, con la lista de
 * pantallas disponibles. Además, el enumerado tiene un método getScreen() que utilizaremos para
 * obtener cada pantalla a partir de su tipo enumerado.
 *
 * Created by workaholic on 8/04/2018.
 * @see <a href="http://www.pixnbgames.com/blog/libgdx/how-to-manage-screens-in-libgdx/">How to manage screens in LibGDX</a>
 */

public enum ScreenEnum {
    MENU_SCREEN{
        public BaseScreen getScreen(Object... params){
            return new MenuScreen();
        }
    },
    CONFIGURACION_SCREEN{
        public BaseScreen getScreen(Object... params){
            return new ConfiguracionScreen();
        }
    },
    TUTORIAL_SCREEN{
        public BaseScreen getScreen(Object... params){
            return new TutorialScreen();
        }
    },
    SELECCION_LEVEL_SCREEN{
        public BaseScreen getScreen(Object... params){
            return new SelectionLevelScreen();
        }
    },
    GAME_SCREEN{
        public BaseScreen getScreen(Object... params){
            return new GameScreen((String) params[0]);
        }
    },
    SCORE_SCREEN{
        public BaseScreen getScreen(Object... params){
            return new ScoreScreen((Integer) params[0]);
        }
    };

    public abstract BaseScreen getScreen(Object... params);
}
