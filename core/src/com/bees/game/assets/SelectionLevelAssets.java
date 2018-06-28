package com.bees.game.assets;

import com.badlogic.gdx.graphics.Texture;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * Clase de recursos de la pantalla SelectionLevel
 * Created by workaholic on 16/04/2018.
 * @see <a href="https://bitbucket.org/dermetfan/libgdx-utils/wiki/net.dermetfan.gdx.assets.AnnotationAssetManager">AnnotationAssetManager</a>
 * @author Edwin César Condori Vilcapuma
 * @author Mauricio García Silva
 */

public class SelectionLevelAssets {
    @AnnotationAssetManager.Asset(Texture.class)
    public static final String
        FONDO_SELECCION = "recursos_imagenes/pantallaSeleccion.png",
        PURE_DE_PAPA="recursos_imagenes/platilloPurePapa.png",
        PAPA_A_LA_HUANCAINA="recursos_imagenes/platilloPapaHuancaina.png";
}
