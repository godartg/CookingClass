package com.bees.game.entidad;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.bees.game.utils.Constantes;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.List;

/**
 * Created by workaholic on 22/06/2018.
 */

public class Utencilio extends Actor{
    private int id;
    private String nombre;
    private Texture imagen;
    private Constantes constantes;
    private AnnotationAssetManager manager;
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

    public Utencilio(AnnotationAssetManager manager, int idUtencilio, Texture texture, float posicionX, float posicionY){
        this.imagen = texture;
        this.id=idUtencilio;
        setBounds(posicionX, posicionY,230,230);
        constantes= new Constantes();
        this.manager = manager;
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

    public void preparar(Ingrediente ingrediente) {
        if(ingrediente.getidIngrediente()==3){
            ingrediente.setVisible(false);
        }else{
            List<List<String>> ingredientes= constantes.getIngredientesImagenes();
            Texture texture= manager.get(ingredientes.get(ingrediente.getidIngrediente()).get(id));
            ingrediente.setIngredienteTexture(texture);
        }

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
                ingrediente.setPosition(ingrediente.getPosicionInicialX(), ingrediente.getPosicionInicialY());
            }

        }
    }
}
