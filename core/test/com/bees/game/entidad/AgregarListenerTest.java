package com.bees.game.entidad;

import com.badlogic.gdx.graphics.Texture;
import com.bees.game.assets.GameAssets;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 *
 * Created by workaholic on 1/06/2018.
 */
public class AgregarListenerTest {
    Ingrediente ingrediente;
    LugarPreparacion lugarPreparacion;

    @Before
    public void setUp() throws Exception {
        ingrediente= new Ingrediente();
        lugarPreparacion= new LugarPreparacion();

    }

    /**
     * Probar que el ingrediente este dentro del lugar de preparacion
     *
     *
     */
    @Test
    public void touchUp() throws Exception {

        if ((ingrediente.getX()>=lugarPreparacion.getX()&&ingrediente.getX()<=(lugarPreparacion.getX()+lugarPreparacion.getWidth()))&&(ingrediente.getY()>=lugarPreparacion.getY()&&ingrediente.getY()<=(lugarPreparacion.getY()+lugarPreparacion.getHeight()))){
            ingrediente.setestadoIngrediente(true);
        }
        assertEquals("El ingredient esta dentro del envase",true, ingrediente.getestadoIngrediente());
    }
}