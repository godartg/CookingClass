package com.bees.game.entidad;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(Texture imagen) {
        this.imagen = imagen;
    }

    public Utencilio(int idUtencilio, Texture texture, float posicionX, float posicionY){
        this.imagen = texture;
        this.id=idUtencilio;
        setBounds(posicionX, posicionY,230,230);
    }
    public Utencilio(){

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(imagen, getX(), getY(),230,230);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
    public static class AgregarListenerUtencilio extends InputListener {
        float altura = 75 / 2;
        float touchDown_x;
        float touchDown_y;
        float dx;
        float dy;
        Ingrediente ingrediente;
        Utencilio utencilio;
        public AgregarListenerUtencilio (Ingrediente ingredienteActual, Utencilio utencilio){
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
                ingrediente.setVisible(false);
                ingrediente.setestadoIngrediente(true);
            } else {
                ingrediente.setPosition(30, 230);
            }

        }
    }
}
