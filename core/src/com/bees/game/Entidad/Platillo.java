package com.bees.game.entidad;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by workaholic on 22/06/2018.
 */

public class Platillo {
    private int id;
    private String nombre;
    private Texture imagen;
    private List<List<String>> preparacion= new ArrayList<List<String>>();

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Texture getImagen() {
        return imagen;
    }

    public List<List<String>> getPreparacion() {
        return preparacion;
    }
}
