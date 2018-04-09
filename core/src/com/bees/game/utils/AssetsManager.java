package com.bees.game.utils;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import net.dermetfan.gdx.assets.AnnotationAssetManager;
/**
 * Con esta clase gestionaremos mejor los recursos de imagenes y audios.
 * AnnotationAssetManager es otra herramienta que viene con la biblioteca libgdx-utils.
 * Es una herramienta que simplifica toda la situación aún más. Como puedes imaginar, utilizaremos anotaciones.
 * @see <a href="http://www.codinginsights.blog/libgdx-assetmanager/">Assets libgdx</a>
 * Created by workaholic on 9/04/2018.
 */

public class AssetsManager {
    @AnnotationAssetManager.Asset(Texture.class)
    public static final String
        INTRO="recursos_imagenes/intro.jpg",
        SUPERMARKET = "recursos_imagenes/supermarket.jpg",
        SALON_CLASES="recursos_imagenes/salon_clases.jpg",
        PUNTUACION="recursos_imagenes/puntuacion.png",
        LOGO="recursos_imagenes/logo.jpg",
        LOGOB="recursos_imagenes/logob.jpg",
        TUTORIAL1="recursos_imagenes/tutorial1.png",
        TUTORIAL2="recursos_imagenes/tutorial2.png",
        TUTORIAL3="recursos_imagenes/tutorial3.jpg",
        TUTORIAL4="recursos_imagenes/tutorial4.jpg",
        TUTORIAL5="recursos_imagenes/tutorial5.png",
        TUTORIAL6="recursos_imagenes/tutorial6.jpg",
        COMIDAS="recursos_imagenes/comidas1a.jpg",
        MANTEQUILLA="recursos_imagenes/butter.png",
        LECHE="recursos_imagenes/milk.png",
        POTATO="recursos_imagenes/potato.png",
        SAL="recursos_imagenes/sal.png",
        OLLA="recursos_imagenes/olla.png",
        POSILLO="recursos_imagenes/posillo.png",
        SARTEN="recursos_imagenes/sarten.png",
        TABLA="recursos_imagenes/tabla.png";
    @AnnotationAssetManager.Asset(Music.class)
    public static final String
        MENUET="audio/Menuet.ogg",
        WEINER="audio/Wiener.ogg",
        BOLERO="recursos_sonidos/Bolero.mp3";
    @AnnotationAssetManager.Asset(Sound.class)
    public static final String
        JUMP="audio/jump.ogg";

    private AssetsManager(){

    }
}
