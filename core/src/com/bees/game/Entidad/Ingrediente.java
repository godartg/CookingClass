package com.bees.game.entidad;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
import com.bees.game.utils.Constantes;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by workaholic on 20/03/2018.
 */

public class Ingrediente extends Actor{
    private int id;
    private String nombreIngrediente;
    private boolean estadoIngrediente;
    private Texture ingredienteTexture;
    private float posicionInicialX, posicionInicialY;

    public float getPosicionInicialX() {
        return posicionInicialX;
    }

    public void setPosicionInicialX(float posicionInicialX) {
        this.posicionInicialX = posicionInicialX;
    }

    public float getPosicionInicialY() {
        return posicionInicialY;
    }

    public void setPosicionInicialY(float posicionInicialY) {
        this.posicionInicialY = posicionInicialY;
    }

    public boolean getestadoIngrediente() {
        return estadoIngrediente;
    }

    public void setestadoIngrediente(boolean estadoIngrediente) {
        this.estadoIngrediente = estadoIngrediente;
    }

    public int getidIngrediente() {
        return id;
    }


    public void setidIngrediente(int idIngrediente) {
        this.id = idIngrediente;
    }

    public String getnombreIngrediente() {
        return nombreIngrediente;
    }

    public void setnombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public Texture getIngredienteTexture() {
        return ingredienteTexture;
    }

    public void setIngredienteTexture( Texture ingredienteTexture) {
        this.ingredienteTexture = ingredienteTexture;

    }
    public Ingrediente(int idIngrediente,Texture texture){
        this.ingredienteTexture = texture;
        this.id= idIngrediente;
    }
    public Ingrediente(){

    }
    public Ingrediente(Texture texture, float x, float y){
        this.ingredienteTexture = texture;
        posicionInicialX= x;
        posicionInicialY = y;
        setBounds(x, y,75,75);

    }
    public Ingrediente( int idIngrediente,Texture texture, float x, float y){
        this.id= idIngrediente;
        this.ingredienteTexture = texture;
        posicionInicialX= x;
        posicionInicialY = y;
        setBounds(x, y,75,75);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(ingredienteTexture, getX(),getY(),75,75);
    }

    /**
     *  Permitir un mejor manejo de eventos GUI
     */
    public static class AgregarListener extends InputListener {
        float altura = 75 / 2;
        float touchDown_x;
        float touchDown_y;
        float dx;
        float dy;
        Ingrediente ingrediente;
        Utencilio utencilio;

        public AgregarListener(Ingrediente ingredienteActual, Utencilio utencilio){
            ingrediente=ingredienteActual ;
            this.utencilio = utencilio;
        }

         public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            //Hallar posición del objeto
            touchDown_x = x;
            touchDown_y = altura - y;
            return true;
        }

        public void touchDragged(InputEvent event, float x, float y, int pointer) {
            //Mover el objeto
            dx = ingrediente.getX() - touchDown_x;
            dy = ingrediente.getY() - altura  + touchDown_y;
            ingrediente.setPosition(x + dx, y + dy);
        }

        /**
         * Verificar colisión entre ingrediente y lugar de preparación
         *  En caso de que halla colisión entre las coordenadas (x y) del evento y lugar de platillo el ingrediente ya no será visible y su estado true
         *  En caso de que halla colisión entre las coordenadas (x y) del evento y lugar de platillo el ingrediente será visible y su estado false
         */
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            if ((ingrediente.getX() >= utencilio.getX() && ingrediente.getX() <= (utencilio.getX() + utencilio.getWidth())) && (ingrediente.getY() >= utencilio.getY() && ingrediente.getY() <= (utencilio.getY() + utencilio.getHeight()))) {
                //ingrediente.setVisible(false);
                //ingrediente.setestadoIngrediente(true);

                utencilio.preparar(ingrediente);

            } else {
                ingrediente.setPosition(ingrediente.posicionInicialX, ingrediente.posicionInicialY);
            }

        }
    }
}