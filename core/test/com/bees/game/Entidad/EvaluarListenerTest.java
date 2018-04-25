package com.bees.game.Entidad;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.bees.game.utils.ScreenEnum;
import com.bees.game.utils.ScreenManager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by workaholic on 25/04/2018.
 */
public class EvaluarListenerTest {
    EIngrediente leche, mantequilla, papa, sal;
    @Before
    public void setUp() throws Exception{
        leche= new EIngrediente();
        mantequilla = new EIngrediente();
        papa= new EIngrediente();
        sal = new EIngrediente();

    }
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