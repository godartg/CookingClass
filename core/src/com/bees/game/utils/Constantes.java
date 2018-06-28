package com.bees.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.bees.game.assets.GameAssets;
import com.bees.game.assets.GameAssetsPlatillo0;
import com.bees.game.assets.GameAssetsPlatillo1;
import com.bees.game.assets.SelectionLevelAssets;
import com.bees.game.entidad.Utencilio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by workaholic on 23/06/2018.
 */

public final class Constantes {
    private static final List<List<Object>> UTENCILIOS= new ArrayList<List<Object>>(){{
        add(new ArrayList<Object>());
        add(new ArrayList<Object>());
        get(0).add("Olla");
        get(1).add(GameAssets.OLLA);
        get(0).add("Posillo");
        get(1).add(GameAssets.POSILLO);
        get(0).add("Sarten");
        get(1).add(GameAssets.SARTEN);
        get(0).add("Tabla");
        get(1).add(GameAssets.TABLA);
        get(0).add("Licuadora");
        get(1).add(GameAssets.LICUADORA);
        get(0).add("plato");
        get(1).add(GameAssets.PLATO);
    }};
    private static final List<List<Object>> PLATILLOS= new ArrayList<List<Object>>(){{
        add(new ArrayList<Object>());
        add(new ArrayList<Object>());
        add(new ArrayList<Object>());
        add(new ArrayList<Object>());
        add(new ArrayList<Object>());
        get(0).add("Pure de papa");
        get(1).add(SelectionLevelAssets.PURE_DE_PAPA);
        get(0).add("Papa a la huancaina");
        get(1).add(SelectionLevelAssets.PAPA_A_LA_HUANCAINA);
        //posición de los procedimientos de los platillos
        get(2).add(0);
        get(2).add(5);
        //ingrediente de platillo 1
        get(3).add(0);
        get(3).add(3);
        get(3).add(6);
        get(3).add(11);
        get(3).add(17);
        get(3).add(48);
        //ingrediente de platillo 2
        get(3).add(18);//cortar ají
        get(3).add(22);//freir ají en la sartén
        get(3).add(21);//licuar preparación
        get(3).add(23);//echar el queso
        get(3).add(0);//hervir la papa
        get(3).add(1);//picar la papa
        get(3).add(30);//picar el huevo
        get(3).add(42);//echar la lechuga
        get(3).add(4);//echar la papa
        get(3).add(36);//echar la aceituna
        get(3).add(49);//echar crema
        //utencilios de platillo 1
        get(4).add(0);
        get(4).add(1);
        get(4).add(1);
        get(4).add(1);
        get(4).add(1);
        get(4).add(5);
        //utencilios de platillo 2
        get(4).add(3);//cortar ají
        get(4).add(1);//freir ají en la sartén
        get(4).add(4);//licuar preparación
        get(4).add(1);//echar el queso
        get(4).add(1);//hervir la papa
        get(4).add(3);//picar la papa
        get(4).add(3);//picar el huevo
        get(4).add(5);//echar la lechuga
        get(4).add(5);//echar la papa
        get(4).add(5);//echar la aceituna
        get(4).add(5);//echar crema

    }};
    private static final List<List<Object>> INGREDIENTES= new ArrayList<List<Object>>(){{
        add(new ArrayList<Object>());
        add(new ArrayList<Object>());
        get(0).add("papa");
        get(1).add(GameAssetsPlatillo0.PAPA);
        get(0).add("papa cocida");
        get(1).add(GameAssetsPlatillo0.PAPA_COCIDA);
        get(0).add("papa aplastada");
        get(1).add(GameAssetsPlatillo0.PAPA_APLASTADA);
        get(0).add("papa frita");
        get(1).add(GameAssetsPlatillo0.PAPA_FRITA);
        get(0).add("papa cortada");
        get(1).add(GameAssetsPlatillo0.PAPA_CORTADA);
        get(0).add("papa licuada");
        get(1).add(GameAssetsPlatillo0.PAPA_LICUADA);
        get(0).add("leche");
        get(1).add(GameAssetsPlatillo0.LECHE);
        get(0).add("leche caliente");
        get(1).add(GameAssetsPlatillo0.LECHE_CALIENTE);
        get(0).add("leche posillo");
        get(1).add(GameAssetsPlatillo0.LECHE_POSILLO);
        get(0).add("leche frita");
        get(1).add(GameAssetsPlatillo0.LECHE_FRITA);
        get(0).add("leche licuado");
        get(1).add(GameAssetsPlatillo0.LECHE_LICUADA);
        get(0).add("mantequilla");
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA);
        get(0).add("mantequilla derretida");
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA_DERRETIDA);
        get(0).add("mantequilla aplastada");
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA_APLASTADA);
        get(0).add("mantequilla frita");
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA_FRITA);
        get(0).add("mantequilla picada");
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA_PICADA);
        get(0).add("mantequilla licuada");
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA_LICUADA);
        get(0).add("sal");
        get(1).add(GameAssetsPlatillo0.SAL);
        get(0).add("ají");
        get(1).add(GameAssetsPlatillo1.AJI);
        get(0).add("ají cocido");
        get(1).add(GameAssetsPlatillo1.AJI_COCIDO);
        get(0).add("ají aplastado");
        get(1).add(GameAssetsPlatillo1.AJI_APLASTADO);
        get(0).add("ají frito");
        get(1).add(GameAssetsPlatillo1.AJI_FRITO);
        get(0).add("ají picado");
        get(1).add(GameAssetsPlatillo1.AJI_PICADO);
        get(0).add("ají licuado");
        get(1).add(GameAssetsPlatillo1.AJI_LICUADO);
        get(0).add("queso");
        get(1).add(GameAssetsPlatillo1.QUESO);
        get(0).add("queso cocido");
        get(1).add(GameAssetsPlatillo1.QUESO_COCIDO);
        get(0).add("queso aplastado");
        get(1).add(GameAssetsPlatillo1.QUESO_APLASTADO);
        get(0).add("queso frito");
        get(1).add(GameAssetsPlatillo1.QUESO_FRITO);
        get(0).add("queso picado");
        get(1).add(GameAssetsPlatillo1.QUESO_PICADO);
        get(0).add("queso licuado");
        get(1).add(GameAssetsPlatillo1.QUESO_LICUADO);
        get(0).add("huevo");
        get(1).add(GameAssetsPlatillo1.HUEVO);
        get(0).add("huevo cocido");
        get(1).add(GameAssetsPlatillo1.HUEVO_COCIDO);
        get(0).add("huevo aplastado");
        get(1).add(GameAssetsPlatillo1.HUEVO_APLASTADO);
        get(0).add("huevo frito");
        get(1).add(GameAssetsPlatillo1.HUEVO_FRITO);
        get(0).add("huevo picado");
        get(1).add(GameAssetsPlatillo1.HUEVO_PICADO);
        get(0).add("huevo frito");
        get(1).add(GameAssetsPlatillo1.HUEVO_LICUADO);
        get(0).add("aceituna");
        get(1).add(GameAssetsPlatillo1.ACEITUNA);
        get(0).add("aceituna codida");
        get(1).add(GameAssetsPlatillo1.ACEITUNA_COCIDA);
        get(0).add("aceituna aplastada");
        get(1).add(GameAssetsPlatillo1.ACEITUNA_APLASTADA);
        get(0).add("aceituna frita");
        get(1).add(GameAssetsPlatillo1.ACEITUNA_FRITA);
        get(0).add("aceituna picada");
        get(1).add(GameAssetsPlatillo1.ACEITUNA_PICADA);
        get(0).add("aceituna licuada");
        get(1).add(GameAssetsPlatillo1.ACEITUNA_LICUADA);
        get(0).add("lechuga");
        get(1).add(GameAssetsPlatillo1.LECHUGA);
        get(0).add("lechuga cocida");
        get(1).add(GameAssetsPlatillo1.LECHUGA_COCIDA);
        get(0).add("lechuga aplastada");
        get(1).add(GameAssetsPlatillo1.LECHUGA_APLASTADA);
        get(0).add("lechuga frita");
        get(1).add(GameAssetsPlatillo1.LECHUGA_FRITA);
        get(0).add("lechuga cortada");
        get(1).add(GameAssetsPlatillo1.LECHUGA_CORTADA);
        get(0).add("lechuga licuada");
        get(1).add(GameAssetsPlatillo1.LECHUGA_LICUADA);
        get(0).add("mezcla blanca");
        get(1).add(GameAssetsPlatillo0.MEZCLA_BLANCA);
        get(0).add("mezcla amarilla");
        get(1).add(GameAssetsPlatillo0.MEZCLA_AMARILLA);

    }};
    public Constantes(){

    }
    public List<List<Object>> getUtencilios() {
        return UTENCILIOS;
    }

    public List<List<Object>> getPlatillos() {
        return PLATILLOS;
    }
    public List<Object> getPlatillosImagenes() {
        List<Object> platillosImagenes= new ArrayList<Object>();
        platillosImagenes=PLATILLOS.get(1);
        return platillosImagenes;
    }
    public List<List<Object>> getIngredientes() {
        return INGREDIENTES;
    }
    public List<List<Object>> getIngredientes(int idPlatillo) {

        return INGREDIENTES;
    }
}
