package com.bees.game.Entidad;

/**
 * Created by workaholic on 20/03/2018.
 */

public class EPartida {
    private int IdPartida;
    private String IngredientesPartida;

    public EPartida(int idPartida, String ingredientesPartida){
        this.IdPartida = idPartida;
        this.IngredientesPartida = ingredientesPartida;
    }

    public int getIdPartida() {
        return IdPartida;
    }

    public void setIdPartida(int idPartida) {
        IdPartida = idPartida;
    }

    public String getIngredientesPartida() {
        return IngredientesPartida;
    }

    public void setIngredientesPartida(String ingredientesPartida) {
        IngredientesPartida = ingredientesPartida;
    }
}
