package com.bees.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.bees.game.assets.GameAssetsPlatillo0;
import com.bees.game.assets.GameAssetsPlatillo1;
import com.bees.game.entidad.Ingrediente;
import com.bees.game.entidad.Utencilio;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by workaholic on 28/06/2018.
 */

public class EntityFactory {
    private AnnotationAssetManager manager;

    public EntityFactory(AnnotationAssetManager manager){
        this.manager= manager;
    }

    /**
     * Crear un objeto de la clase de Utencilio
     *
     * @param textura
     * @param posicionX
     * @param posicionY
     * @return objeto Utencilio
     */
    public Utencilio crearUtencilio(int id,String textura, int posicionX, int posicionY){
        Texture texture= manager.get(textura);
        return new Utencilio(id, texture, posicionX, posicionY);
    }

    /**
     * Crear un objeto de la clase de ingrediente
     *
     * @param textura
     * @param id
     * @return objeto de tipo ingrediente
     */
    public Ingrediente crearIngrediente(int id, Texture textura){
        return new Ingrediente(id, textura);
    }

    /**
     * Crear una lista de objetos de la clase de Ingrediente
     * @param idPlatillo
     * @return List<Ingrediente> listaIngredientes
     */
    public List<Ingrediente> getIngredientes(int idPlatillo) {
        List<Ingrediente> listaIngredientes= new ArrayList<Ingrediente>();
        Constantes constantes= new Constantes();
        List<List<String>> ingredientesImagenes = constantes.getIngredientesImagenes();
        switch (idPlatillo){
            case 0:
                Texture textureIngrediente0= manager.get(ingredientesImagenes.get(0).get(0));
                Texture textureIngrediente1= manager.get(ingredientesImagenes.get(1).get(0));
                Texture textureIngrediente2= manager.get(ingredientesImagenes.get(2).get(0));
                Texture textureIngrediente3= manager.get(ingredientesImagenes.get(3).get(0));
                listaIngredientes.add( crearIngrediente(1, textureIngrediente1));
                listaIngredientes.add( crearIngrediente(0, textureIngrediente0));
                listaIngredientes.add( crearIngrediente(2, textureIngrediente2));
                listaIngredientes.add( crearIngrediente(3, textureIngrediente3));
                break;
            case 1:
                textureIngrediente1 = manager.get(ingredientesImagenes.get(1).get(0));
                Texture textureIngrediente4= manager.get(ingredientesImagenes.get(4).get(0));
                Texture textureIngrediente5= manager.get(ingredientesImagenes.get(5).get(0));
                Texture textureIngrediente6= manager.get(ingredientesImagenes.get(6).get(0));
                Texture textureIngrediente7= manager.get(ingredientesImagenes.get(7).get(0));
                Texture textureIngrediente8= manager.get(ingredientesImagenes.get(8).get(0));
                listaIngredientes.add( crearIngrediente(4, textureIngrediente4));
                listaIngredientes.add( crearIngrediente(5, textureIngrediente5));
                listaIngredientes.add( crearIngrediente(6, textureIngrediente6));
                listaIngredientes.add( crearIngrediente(7, textureIngrediente7));
                listaIngredientes.add( crearIngrediente(1, textureIngrediente1));
                listaIngredientes.add( crearIngrediente(8, textureIngrediente8));
                break;
        }

        return listaIngredientes;
    }

}
