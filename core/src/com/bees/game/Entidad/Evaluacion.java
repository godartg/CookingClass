package com.bees.game.entidad;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;

/**
 * Created by workaholic on 20/03/2018.
 */

public class Evaluacion {
    private int evaluacionId;
    private int evaluacionPuntaje;
    private int evaluacionTips;

    public void evaluarIngredientes(){

    }
    public void evaluarPreparacion(){

    }


    public static class EvaluarListener extends ChangeListener {
        Ingrediente leche, mantequilla, papa, sal;
        /**
         * Permite realizar el calculo del puntaje
         * Permite ingresar ingredientes
         */
        public EvaluarListener(Ingrediente ingredienteLeche, Ingrediente ingredienteMantequilla, Ingrediente ingredientePapa, Ingrediente ingredienteSal){
            leche= ingredienteLeche;
            mantequilla=ingredienteMantequilla;
            papa= ingredientePapa;
            sal= ingredienteSal;
        }

        @Override
        public void changed(ChangeEvent event, Actor actor) {
            int puntaje=0;
            if(leche.getestadoIngrediente()){
                puntaje+=5;
            }
            if (mantequilla.getestadoIngrediente()){
                puntaje+=5;
            }
            if (papa.getestadoIngrediente()){
                puntaje+=5;
            }
            if (sal.getestadoIngrediente()){
                puntaje+=5;
            }
            ScreenManager.getInstance().showScreen(ScreenEnum.SCORE_SCREEN,puntaje);
        }
    }
}
