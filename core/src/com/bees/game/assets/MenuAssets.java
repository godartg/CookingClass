package com.bees.game.assets;

import com.badlogic.gdx.graphics.Texture;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Clase de recursos de la pantalla Menu
 * Created by workaholic on 16/04/2018.
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 */

public class MenuAssets {
    @AnnotationAssetManager.Asset(Texture.class)
    public static final String
        PANTALLA_PRINCIPAL="recursos_imagenes/pantallaPrincipal.png",
        BOTON_JUGAR="recursos_imagenes/botonJugar.png",
        BOTON_TUTORIAL="recursos_imagenes/botonTutorial.png",
        BOTON_SALIR="recursos_imagenes/botonSalir.png";
}
