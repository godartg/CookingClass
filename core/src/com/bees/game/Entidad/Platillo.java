package com.bees.game.Entidad;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

/**
 * @author Edwin César Condori Vilcapuma
 *
 * Created by Edwin César Condori Vilcapuma on 20/03/2018.
 */

public class Platillo extends Actor {
    private int id;
    private String nombre;
    private String url;
    private ArrayList<Ingrediente> ingredientes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        int ejempli=id;

        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
