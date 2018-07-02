package com.bees.game.entidad;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.bees.game.utils.Constantes;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;
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

    public void preparar(List<String> preparacion, Ingrediente ingrediente) {
        if(ingrediente.getIdIngrediente()==3){
            ingrediente.setVisible(false);
            preparacion.add(3+","+0+","+this.getId());
        }else{
            List<List<String>> ingredientes= constantes.getIngredientesImagenes();
            Texture texture= manager.get(ingredientes.get(ingrediente.getIdIngrediente()).get(id));
            ingrediente.setIngredienteTexture(texture);

            ingrediente.setEstado(this.getId());
            preparacion.add(ingrediente.getIdIngrediente()+","+ingrediente.getEstado()+","+this.getId());
        }

    }

    public void preparar(List<String> preparacion, Ingrediente ingredienteActual, Ingrediente ingrediente1) {
        ingredienteActual.setVisible(false);
        ingredienteActual.setPosition(ingredienteActual.getX(),ingredienteActual.getY());
        List<List<String>> ingredientes= constantes.getIngredientesImagenes();
        Texture texture= manager.get(ingredientes.get(9).get(0));
        ingrediente1.setIngredienteTexture(texture);
        ingrediente1.setIdIngrediente(9);
        ingrediente1.setEstado(0);
        preparacion.add(ingredienteActual.getIdIngrediente()+","+ingredienteActual.getEstado()+","+this.getId());
    }


}
