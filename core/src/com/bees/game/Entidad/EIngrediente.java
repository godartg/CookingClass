package com.bees.game.Entidad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.FloatAction;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

/**
 * Created by workaholic on 20/03/2018.
 */

public class EIngrediente extends Actor{
    private int idIngrediente;
    private String nombreIngrediente;
    private boolean estadoIngrediente;

    public boolean getestadoIngrediente() {
        return estadoIngrediente;
    }

    public void setestadoIngrediente(boolean estadoIngrediente) {
        this.estadoIngrediente = estadoIngrediente;
    }

    public int getidIngrediente() {
        return idIngrediente;
    }


    public void setidIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getnombreIngrediente() {
        return nombreIngrediente;
    }

    public void setnombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }



    private Texture ingredienteTexture;

    public Texture getIngredienteTexture() {
        return ingredienteTexture;
    }

    public void setIngredienteTexture(Texture ingredienteTexture) {
        this.ingredienteTexture = ingredienteTexture;
    }
    public EIngrediente(){

    }

    public EIngrediente(Texture texture, float x, float y){
        this.ingredienteTexture = texture;
        setBounds(x, y,75,75);

    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(ingredienteTexture, getX(),getY(),75,75);
    }
}
