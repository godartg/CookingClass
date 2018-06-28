package com.bees.game.entidad;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by workaholic on 20/03/2018.
 */

public class Evaluacion {
    private int id;
    private int puntaje;
    private List<String> consejos= new ArrayList<String>();
    private String nombreJugador;
    private String RUTA_PUNTAJE= "";
    private Texture imagen;


    public void evaluarPartida(){

    }

    /**
     *
     * @return
     */
    public List<List<String>> obtenerPuntaje(){
        List<List<String>> listaPuntajes= new ArrayList<List<String>>();
        return listaPuntajes;
    }

    /**
     *
     * @param numeroPlatillo
     * @param preparacion
     * @return
     */
    public double evaluarPartida(int numeroPlatillo, List<List<String>> preparacion){
        double resultado=0;
        return resultado;
    }

    /**
     *
     * @param puntaje
     * @param nombreJugador
     */
    public void guardarPartida(String puntaje, String nombreJugador){

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
