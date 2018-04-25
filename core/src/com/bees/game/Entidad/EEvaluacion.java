package com.bees.game.Entidad;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;

/**
 * Created by workaholic on 20/03/2018.
 */

public class EEvaluacion {
    private int EvaluacionId;
    private int EvaluacionPuntaje;
    private int EvaluacionTips;

    public void EvaluarIngredientes(){

    }
    public void EvaluarPreparacion(){

    }
    public static class EvaluarListener extends ChangeListener {
        EIngrediente leche, mantequilla, papa, sal;
        public EvaluarListener(EIngrediente ingredienteLeche, EIngrediente ingredienteMantequilla, EIngrediente ingredientePapa, EIngrediente ingredienteSal){
            leche= ingredienteLeche;
            mantequilla=ingredienteMantequilla;
            papa= ingredientePapa;
            sal= ingredienteSal;
        }

        @Override
        public void changed(ChangeEvent event, Actor actor) {
            //Calcular puntaje del usuario
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
