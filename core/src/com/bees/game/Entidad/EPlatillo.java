package com.bees.game.Entidad;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by workaholic on 20/03/2018.
 */

public class EPlatillo extends Actor{
    /** The player texture. */
    private Texture texture;

    /** The world instance this player is in. */
    private World world;

    /** The body for this player. */
    private Body body;

    /** The fixture for this player. */
    private Fixture fixture;

    /** Entity's Attribute*/
    private int PlatilloId;
    private String PlatilloNombre;
    private String PlatilloReceta;
    private String PlatilloHistoria;
    private String PlatilloDificultad;
    private String PlatilloURL;

    public EPlatillo(World world, Texture floorTexture, Texture overfloorTexture, float x, float width, float y) {

    }
}
