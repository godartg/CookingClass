package com.bees.game.Entidad;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by workaholic on 24/04/2018.
 */
public class AgregarListenerTest {
    EIngrediente ingrediente;
    ELugarPrep lugarPreparacion;

    @Before
    public void setUp() throws Exception {
        ingrediente= new EIngrediente();
        lugarPreparacion= new ELugarPrep();

    }

    @Test
    public void touchUp() throws Exception {

        if ((ingrediente.getX()>=lugarPreparacion.getX()&&ingrediente.getX()<=(lugarPreparacion.getX()+lugarPreparacion.getWidth()))&&(ingrediente.getY()>=lugarPreparacion.getY()&&ingrediente.getY()<=(lugarPreparacion.getY()+lugarPreparacion.getHeight()))){
            ingrediente.setestadoIngrediente(true);
        }
        assertEquals("El ingredient esta dentro del envase",true, ingrediente.getestadoIngrediente());
    }

}