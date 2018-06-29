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
    Utencilio utencilio;

    @Before
    public void setUp() throws Exception {
        ingrediente= new Ingrediente();
        utencilio= new Utencilio();

    }

    /**
     * Probar que el ingrediente este dentro del lugar de preparacion
     *
     *
     */
    @Test
    public void touchUp() throws Exception {

        if ((ingrediente.getX()>=utencilio.getX()&&ingrediente.getX()<=(utencilio.getX()+utencilio.getWidth()))&&(ingrediente.getY()>=utencilio.getY()&&ingrediente.getY()<=(utencilio.getY()+utencilio.getHeight()))){
            ingrediente.setestadoIngrediente(true);
        }
        assertEquals("El ingredient esta dentro del envase",true, ingrediente.getestadoIngrediente());
    }
}