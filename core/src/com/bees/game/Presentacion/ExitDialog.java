package com.bees.game.Presentacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
/**
 * @author Edwin César Condori Vilcapuma
 *
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */

public class ExitDialog extends Dialog{
    public ExitDialog(String title, Skin windowStyle) {
        super(title, windowStyle);
    }
    {
        text("¿Desea cerrar la aplicación?");
        button("Yes", true);
        button("No", false);
    }

    @Override
    protected void result(Object object) {
        Boolean cerrar= (Boolean) object;
        if (cerrar){
            Gdx.app.exit();
        }else{

        }
    }
}
