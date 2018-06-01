package com.bees.game.entidad;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by workaholic on 1/06/2018.
 */
public class EvaluarListenerTest {
    Ingrediente leche, mantequilla, papa, sal;
    @Before
    public void setUp() throws Exception{
        leche= new Ingrediente();
        mantequilla = new Ingrediente();
        papa= new Ingrediente();
        sal = new Ingrediente();

    }

    /**
     * Evaluar el caso en el que solo 2 ingredientes esten en el lugar de preparacion
     */
    @Test
    public void calcualarPuntaje() {
        leche.setestadoIngrediente(true);
        mantequilla.setestadoIngrediente(false);
        papa.setestadoIngrediente(false);
        sal.setestadoIngrediente(true);

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
        assertEquals(10,puntaje);
    }

}