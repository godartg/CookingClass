package com.bees.game.entidad;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by workaholic on 22/06/2018.
 */

public class Utencilio extends Actor{
    private int id;
    private String nombre;
    private Texture imagen;

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

    public Texture getImagen() {
        return imagen;
    }

    public void setImagen(Texture imagen) {
        this.imagen = imagen;
    }
    public Utencilio(Texture texture, float posicionX, float posicionY){
        this.imagen = texture;
        setBounds(posicionX, posicionY,230,230);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(imagen, getX(), getY(),230,230);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
}
