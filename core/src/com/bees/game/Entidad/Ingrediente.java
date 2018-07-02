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
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estadoIngrediente) {
        this.estado = estadoIngrediente;
    }

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

      public int getIdIngrediente() {
        return id;
    }


    public void setIdIngrediente(int idIngrediente) {
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
    public Ingrediente( int idIngrediente, int estado,Texture texture, float x, float y){
        this.id= idIngrediente;
        this.ingredienteTexture = texture;
        posicionInicialX= x;
        posicionInicialY = y;
        this.estado= estado;
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
        Ingrediente ingredienteActual, ingrediente1, ingrediente2, ingrediente3;
        Utencilio utencilio;
        List<String> preparacionActual= new ArrayList<String>();


        public AgregarListener(List<String> preparacionActual, Ingrediente ingrediente,Ingrediente ingrediente1,Ingrediente ingrediente2,Ingrediente ingrediente3, Utencilio utencilio){
            ingredienteActual= ingrediente;
            this.ingrediente1= ingrediente1;
            this.ingrediente2= ingrediente2;
            this.ingrediente3= ingrediente3;
            this.utencilio = utencilio;
            this.preparacionActual= preparacionActual;
        }

         public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            //Hallar posición del objeto
            touchDown_x = x;
            touchDown_y = altura - y;
            return true;
        }

        public void touchDragged(InputEvent event, float x, float y, int pointer) {
            //Mover el objeto
            dx = ingredienteActual.getX() - touchDown_x;
            dy = ingredienteActual.getY() - altura  + touchDown_y;
            ingredienteActual.setPosition(x + dx, y + dy);
        }

        /**
         * Verificar colisión entre ingrediente y lugar de preparación
         *  En caso de que halla colisión entre las coordenadas (x y) del evento y lugar de platillo el ingrediente ya no será visible y su estado true
         *  En caso de que halla colisión entre las coordenadas (x y) del evento y lugar de platillo el ingrediente será visible y su estado false
         */
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            if ((ingredienteActual.getX() >= utencilio.getX() && ingredienteActual.getX() <= (utencilio.getX() + utencilio.getWidth())) && (ingredienteActual.getY() >= utencilio.getY() && ingredienteActual.getY() <= (utencilio.getY() + utencilio.getHeight()))) {

                if((ingredienteActual.getX() >= ingrediente1.getX() && ingredienteActual.getX() <= (ingrediente1.getX() + ingrediente1.getWidth())) && (ingredienteActual.getY() >= ingrediente1.getY() && ingredienteActual.getY() <= (ingrediente1.getY() + ingrediente1.getHeight()))){
                    utencilio.preparar(preparacionActual, ingredienteActual, ingrediente1);
                }else if((ingredienteActual.getX() >= ingrediente2.getX() && ingredienteActual.getX() <= (ingrediente2.getX() + ingrediente2.getWidth())) && (ingredienteActual.getY() >= ingrediente2.getY() && ingredienteActual.getY() <= (ingrediente2.getY() + ingrediente2.getHeight()))){
                    utencilio.preparar(preparacionActual, ingredienteActual, ingrediente2);
                }else if((ingredienteActual.getX() >= ingrediente3.getX() && ingredienteActual.getX() <= (ingrediente3.getX() + ingrediente3.getWidth())) && (ingredienteActual.getY() >= ingrediente3.getY() && ingredienteActual.getY() <= (ingrediente3.getY() + ingrediente3.getHeight()))){
                    utencilio.preparar(preparacionActual, ingredienteActual, ingrediente3);
                }else{

                    utencilio.preparar(preparacionActual, ingredienteActual);
                }
            } else {
                ingredienteActual.setPosition(ingredienteActual.posicionInicialX, ingredienteActual.posicionInicialY);
            }

        }
    }
}
