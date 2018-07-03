package com.bees.game.entidad;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.bees.game.utils.Constantes;
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


    /**Comparar las listas de procedimiento del resultado actual contra el esperado
     *
     * @param numeroPlatillo
     * @param preparacion
     * @return
     */
    public double evaluarPartida(int numeroPlatillo, List<String> preparacion){
        Constantes constantes= new Constantes();
        List<String> preparacionCorrecta= constantes.getPreparacionPlatillo(numeroPlatillo);
        double resultado=0;
        double punto=100/preparacionCorrecta.size();
        for(int i=0; i< preparacionCorrecta.size();i++){
            for(int j=0; j< preparacion.size(); j++){
                if(preparacion.get(j).equals(preparacionCorrecta.get(i))){
                    resultado+= punto;
                }
            }
        }
        return resultado;
    }

    /**Guardar puntaje en un fichero
     *
     * @param puntaje
     * @param nombreJugador
     */
    public void guardarPartida(String puntaje, String nombreJugador){

    }

    public static class EvaluarListener extends ChangeListener {
        List<String> preparacionActual;
        int idPlatillo;
        /**
         * Permite realizar el calculo del puntaje
         * Permite ingresar ingredientes
         */
        public EvaluarListener(final int idPlatillo ,final List<String> preparacion) {
            this.preparacionActual= preparacion;
            this.idPlatillo= idPlatillo;
        }

        @Override
        public void changed(ChangeEvent event, Actor actor) {
            double puntaje=0;
            Evaluacion evaluacion= new Evaluacion();
            puntaje=evaluacion.evaluarPartida(idPlatillo, preparacionActual);
            ScreenManager.getInstance().showScreen(ScreenEnum.SCORE_SCREEN,puntaje);
        }
    }
}
