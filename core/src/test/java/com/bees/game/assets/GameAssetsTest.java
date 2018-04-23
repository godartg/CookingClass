package com.bees.game.assets;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by workaholic on 23/04/2018.
 */
public class GameAssetsTest {

    @Test
    public void comprobarRecurso() {
        GameAssets objetoGameAssets = new GameAssets();
        Class<? extends GameAssets> objetoGameAssetsConInformacionDeGameAssets = objetoGameAssets.getClass();
        Field[] todasLasVariables = objetoGameAssetsConInformacionDeGameAssets.getFields();
        File fichero;
        for(Field variable : todasLasVariables){
            fichero= new File(variable+"");
            assertTrue(fichero.exists());
        }
    }

}