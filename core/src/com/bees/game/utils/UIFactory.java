package com.bees.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
/**
 * Nos permite crear componentes para la interfaz de usuario
 * @see <a href="https://stackoverflow.com/questions/3543419/using-static-factory-classes-to-generate-gui-components-how-and-where-to-add-t?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa">Using static factory classes to generate GUI components - How and where to add the required listeners?</a>
 * Created by workaholic on 8/04/2018.
 */

public class UIFactory {
    public static ImageButton createButton(Texture texture) {
        return
                new ImageButton(
                        new TextureRegionDrawable(
                                new TextureRegion(texture) ) );
    }

    public static InputListener createListener(final ScreenEnum dstScreen, final Object... params) {
        return
                new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x,
                                             float y, int pointer, int button) {
                        ScreenManager.getInstance().showScreen(dstScreen, params);
                        return false;
                    }
                };
    }
}
