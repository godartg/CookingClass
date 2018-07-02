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
    public Ingrediente crearIngrediente(int id, String textura){
        Texture texture= manager.get(textura);
        return new Ingrediente(id, texture);
    }

    /**
     * Crear una lista de objetos de la clase de Ingrediente
     * @param idPlatillo
     * @return List<Ingrediente> ingredientes
     */
    private List<Ingrediente> getIngredientes(int idPlatillo) {
        List<Ingrediente> listaIngredientes= new ArrayList<Ingrediente>();
        Constantes constantes= new Constantes();
        List<List<String>> ingredientesNombres = constantes.getIngredientesNombres();
        switch (idPlatillo){
            case 0:
                listaIngredientes.add( crearIngrediente(6, GameAssetsPlatillo0.LECHE));
                listaIngredientes.add( crearIngrediente(0, GameAssetsPlatillo0.PAPA));
                listaIngredientes.add( crearIngrediente(11, GameAssetsPlatillo0.MANTEQUILLA));
                listaIngredientes.add( crearIngrediente(17, GameAssetsPlatillo0.SAL));
                break;
            case 1:
                listaIngredientes.add( crearIngrediente(18, ingredientesNombres.get(1).get(18)));
                listaIngredientes.add( crearIngrediente(24, ingredientesNombres.get(1).get(24)));
                listaIngredientes.add( crearIngrediente(30, ingredientesNombres.get(1).get(30)));
                listaIngredientes.add( crearIngrediente(36, ingredientesNombres.get(1).get(36)));
                listaIngredientes.add( crearIngrediente(0, ingredientesNombres.get(1).get(0)));
                listaIngredientes.add( crearIngrediente(42, ingredientesNombres.get(1).get(42)));
                break;
        }

        return listaIngredientes;
    }

}
