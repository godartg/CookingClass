package com.bees.game.utils;

import com.badlogic.gdx.graphics.Texture;
import com.bees.game.assets.GameAssets;
import com.bees.game.assets.GameAssetsPlatillo0;
import com.bees.game.assets.GameAssetsPlatillo1;
import com.bees.game.assets.SelectionLevelAssets;
import com.bees.game.entidad.Ingrediente;
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
    private static final List<List<String>> UTENCILIOS= new ArrayList<List<String>>(){{
        add(new ArrayList<String>());
        add(new ArrayList<String>());
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
        get(0).add("papa");//0
        get(1).add(GameAssetsPlatillo0.PAPA);
        get(0).add("papa cocida");//1
        get(1).add(GameAssetsPlatillo0.PAPA_COCIDA);
        get(0).add("papa aplastada");//2
        get(1).add(GameAssetsPlatillo0.PAPA_APLASTADA);
        get(0).add("papa frita");//3
        get(1).add(GameAssetsPlatillo0.PAPA_FRITA);
        get(0).add("papa cortada");//4
        get(1).add(GameAssetsPlatillo0.PAPA_CORTADA);
        get(0).add("papa licuada");//5
        get(1).add(GameAssetsPlatillo0.PAPA_LICUADA);
        get(0).add("leche");//6
        get(1).add(GameAssetsPlatillo0.LECHE);
        get(0).add("leche caliente");//7
        get(1).add(GameAssetsPlatillo0.LECHE_CALIENTE);
        get(0).add("leche posillo");//8
        get(1).add(GameAssetsPlatillo0.LECHE_POSILLO);
        get(0).add("leche frita");//9
        get(1).add(GameAssetsPlatillo0.LECHE_FRITA);
        get(0).add("leche licuado");//10
        get(1).add(GameAssetsPlatillo0.LECHE_LICUADA);
        get(0).add("mantequilla");//11
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA);
        get(0).add("mantequilla derretida");//12
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA_DERRETIDA);
        get(0).add("mantequilla aplastada");//13
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA_APLASTADA);
        get(0).add("mantequilla frita");//14
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA_FRITA);
        get(0).add("mantequilla picada");//15
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA_PICADA);
        get(0).add("mantequilla licuada");//16
        get(1).add(GameAssetsPlatillo0.MANTEQUILLA_LICUADA);
        get(0).add("sal");//17
        get(1).add(GameAssetsPlatillo0.SAL);
        get(0).add("ají");//18
        get(1).add(GameAssetsPlatillo1.AJI);
        get(0).add("ají cocido");//19
        get(1).add(GameAssetsPlatillo1.AJI_COCIDO);
        get(0).add("ají aplastado");//20
        get(1).add(GameAssetsPlatillo1.AJI_APLASTADO);
        get(0).add("ají frito");//21
        get(1).add(GameAssetsPlatillo1.AJI_FRITO);
        get(0).add("ají picado");//22
        get(1).add(GameAssetsPlatillo1.AJI_PICADO);
        get(0).add("ají licuado");//23
        get(1).add(GameAssetsPlatillo1.AJI_LICUADO);
        get(0).add("queso");//24
        get(1).add(GameAssetsPlatillo1.QUESO);
        get(0).add("queso cocido");//25
        get(1).add(GameAssetsPlatillo1.QUESO_COCIDO);
        get(0).add("queso aplastado");//26
        get(1).add(GameAssetsPlatillo1.QUESO_APLASTADO);
        get(0).add("queso frito");//27
        get(1).add(GameAssetsPlatillo1.QUESO_FRITO);
        get(0).add("queso picado");//28
        get(1).add(GameAssetsPlatillo1.QUESO_PICADO);
        get(0).add("queso licuado");//29
        get(1).add(GameAssetsPlatillo1.QUESO_LICUADO);
        get(0).add("huevo");//30
        get(1).add(GameAssetsPlatillo1.HUEVO);
        get(0).add("huevo cocido");//31
        get(1).add(GameAssetsPlatillo1.HUEVO_COCIDO);
        get(0).add("huevo aplastado");//32
        get(1).add(GameAssetsPlatillo1.HUEVO_APLASTADO);
        get(0).add("huevo frito");//33
        get(1).add(GameAssetsPlatillo1.HUEVO_FRITO);
        get(0).add("huevo picado");//34
        get(1).add(GameAssetsPlatillo1.HUEVO_PICADO);
        get(0).add("huevo frito");//35
        get(1).add(GameAssetsPlatillo1.HUEVO_LICUADO);
        get(0).add("aceituna");//36
        get(1).add(GameAssetsPlatillo1.ACEITUNA);
        get(0).add("aceituna codida");//37
        get(1).add(GameAssetsPlatillo1.ACEITUNA_COCIDA);
        get(0).add("aceituna aplastada");//38
        get(1).add(GameAssetsPlatillo1.ACEITUNA_APLASTADA);
        get(0).add("aceituna frita");//39
        get(1).add(GameAssetsPlatillo1.ACEITUNA_FRITA);
        get(0).add("aceituna picada");//40
        get(1).add(GameAssetsPlatillo1.ACEITUNA_PICADA);
        get(0).add("aceituna licuada");//41
        get(1).add(GameAssetsPlatillo1.ACEITUNA_LICUADA);
        get(0).add("lechuga");//42
        get(1).add(GameAssetsPlatillo1.LECHUGA);
        get(0).add("lechuga cocida");//43
        get(1).add(GameAssetsPlatillo1.LECHUGA_COCIDA);
        get(0).add("lechuga aplastada");//44
        get(1).add(GameAssetsPlatillo1.LECHUGA_APLASTADA);
        get(0).add("lechuga frita");//45
        get(1).add(GameAssetsPlatillo1.LECHUGA_FRITA);
        get(0).add("lechuga cortada");//46
        get(1).add(GameAssetsPlatillo1.LECHUGA_CORTADA);
        get(0).add("lechuga licuada");//47
        get(1).add(GameAssetsPlatillo1.LECHUGA_LICUADA);
        get(0).add("mezcla blanca");//48
        get(1).add(GameAssetsPlatillo0.MEZCLA_BLANCA);
        get(0).add("mezcla amarilla");//49
        get(1).add(GameAssetsPlatillo0.MEZCLA_AMARILLA);

    }};
    public Constantes(){

    }
    public List<String> getUtenciliosNombre() {
        List<String> listaUtencilios= new ArrayList<String>();
        for(String utencilio: UTENCILIOS.get(0)){
            listaUtencilios.add( utencilio);
        }
        return listaUtencilios;
    }
    public List<String> getUtenciliosImagen() {
        List<String> listaUtencilios= new ArrayList<String>();
        for(String utencilio: UTENCILIOS.get(1)){
            listaUtencilios.add( utencilio);
        }
        return listaUtencilios;
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

}
