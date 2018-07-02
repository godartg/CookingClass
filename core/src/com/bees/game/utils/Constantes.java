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
    private static final List<List<String>> PLATILLOS= new ArrayList<List<String>>(){{
        add(new ArrayList<String>());
        add(new ArrayList<String>());

        get(0).add("Pure de papa");
        get(1).add(SelectionLevelAssets.PURE_DE_PAPA);
        get(0).add("Papa a la huancaina");
        get(1).add(SelectionLevelAssets.PAPA_A_LA_HUANCAINA);

    }};
    private static final List<List<String>> PREPARACIONES= new ArrayList<List<String>>(){{
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        //ingrediente de platillo 0
        get(0).add("0,0,0");
        get(0).add("0,1,1");
        get(0).add("1,0,1");
        get(0).add("2,0,1");
        get(0).add("3,0,1");
        get(0).add("9,0,5");
        //ingrediente de platillo 1
        get(1).add("4,0,3");//cortar ají
        get(1).add("4,3,1");//freir ají en la sartén
        get(1).add("5,0,1");//echar el queso
        get(1).add("9,1,4");//licuar preparación
        get(1).add("0,0,0");//hervir la papa
        get(1).add("0,1,3");//picar la papa
        get(1).add("6,0,1");//hervir el huevo
        get(1).add("6,1,3");//picar el huevo
        get(1).add("8,0,5");//echar la lechuga
        get(1).add("0,4,5");//echar la papa
        get(1).add("7,0,5");//echar la aceituna
        get(1).add("6,4,5");//echar el huevo
        get(1).add("9,1,5");//echar crema
    }};
    private static final List<List<String>> INGREDIENTES_IMAGENES= new ArrayList<List<String>>(){{
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        get(0).add(GameAssetsPlatillo0.PAPA);//0
        get(0).add(GameAssetsPlatillo0.PAPA_COCIDA);//1
        get(0).add(GameAssetsPlatillo0.PAPA_APLASTADA);//2
        get(0).add(GameAssetsPlatillo0.PAPA_FRITA);//3
        get(0).add(GameAssetsPlatillo0.PAPA_CORTADA);//4
        get(0).add(GameAssetsPlatillo0.PAPA_LICUADA);//5
        get(1).add(GameAssetsPlatillo0.LECHE);
        get(1).add(GameAssetsPlatillo0.LECHE_CALIENTE);
        get(1).add(GameAssetsPlatillo0.LECHE_POSILLO);
        get(1).add(GameAssetsPlatillo0.LECHE_FRITA);
        get(1).add(GameAssetsPlatillo0.LECHE_LICUADA);
        get(2).add(GameAssetsPlatillo0.MANTEQUILLA);
        get(2).add(GameAssetsPlatillo0.MANTEQUILLA_DERRETIDA);
        get(2).add(GameAssetsPlatillo0.MANTEQUILLA_APLASTADA);
        get(2).add(GameAssetsPlatillo0.MANTEQUILLA_FRITA);
        get(2).add(GameAssetsPlatillo0.MANTEQUILLA_PICADA);
        get(2).add(GameAssetsPlatillo0.MANTEQUILLA_LICUADA);
        get(3).add(GameAssetsPlatillo0.SAL);
        get(4).add(GameAssetsPlatillo1.AJI);
        get(4).add(GameAssetsPlatillo1.AJI_COCIDO);
        get(4).add(GameAssetsPlatillo1.AJI_APLASTADO);
        get(4).add(GameAssetsPlatillo1.AJI_FRITO);
        get(4).add(GameAssetsPlatillo1.AJI_PICADO);
        get(4).add(GameAssetsPlatillo1.AJI_LICUADO);
        get(5).add(GameAssetsPlatillo1.QUESO);
        get(5).add(GameAssetsPlatillo1.QUESO_COCIDO);
        get(5).add(GameAssetsPlatillo1.QUESO_APLASTADO);
        get(5).add(GameAssetsPlatillo1.QUESO_FRITO);
        get(5).add(GameAssetsPlatillo1.QUESO_PICADO);
        get(5).add(GameAssetsPlatillo1.QUESO_LICUADO);
        get(6).add(GameAssetsPlatillo1.HUEVO);
        get(6).add(GameAssetsPlatillo1.HUEVO_COCIDO);
        get(6).add(GameAssetsPlatillo1.HUEVO_APLASTADO);
        get(6).add(GameAssetsPlatillo1.HUEVO_FRITO);
        get(6).add(GameAssetsPlatillo1.HUEVO_PICADO);
        get(6).add(GameAssetsPlatillo1.HUEVO_LICUADO);
        get(7).add(GameAssetsPlatillo1.ACEITUNA);
        get(7).add(GameAssetsPlatillo1.ACEITUNA_COCIDA);
        get(7).add(GameAssetsPlatillo1.ACEITUNA_APLASTADA);
        get(7).add(GameAssetsPlatillo1.ACEITUNA_FRITA);
        get(7).add(GameAssetsPlatillo1.ACEITUNA_PICADA);
        get(7).add(GameAssetsPlatillo1.ACEITUNA_LICUADA);
        get(8).add(GameAssetsPlatillo1.LECHUGA);
        get(8).add(GameAssetsPlatillo1.LECHUGA_COCIDA);
        get(8).add(GameAssetsPlatillo1.LECHUGA_APLASTADA);
        get(8).add(GameAssetsPlatillo1.LECHUGA_FRITA);
        get(8).add(GameAssetsPlatillo1.LECHUGA_CORTADA);
        get(8).add(GameAssetsPlatillo1.LECHUGA_LICUADA);
        get(9).add(GameAssetsPlatillo0.MEZCLA_BLANCA);
        get(9).add(GameAssetsPlatillo0.MEZCLA_AMARILLA);
    }};
    private static final List<List<String>> INGREDIENTES_NOMBRES= new ArrayList<List<String>>(){{
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        add(new ArrayList<String>());
        get(0).add("papa");//0
        get(0).add("papa cocida");//1
        get(0).add("papa aplastada");//2
        get(0).add("papa frita");//3
        get(0).add("papa cortada");//4
        get(0).add("papa licuada");//5
        get(1).add("leche");//6
        get(1).add("leche caliente");//7
        get(1).add("leche posillo");//8
        get(1).add("leche frita");//9
        get(1).add("leche licuado");//10
        get(2).add("mantequilla");//11
        get(2).add("mantequilla derretida");//12
        get(2).add("mantequilla aplastada");//13
        get(2).add("mantequilla frita");//14
        get(2).add("mantequilla picada");//15
        get(2).add("mantequilla licuada");//16
        get(3).add("sal");//17
        get(4).add("ají");//18
        get(4).add("ají cocido");//19
        get(4).add("ají aplastado");//20
        get(4).add("ají frito");//21
        get(4).add("ají picado");//22
        get(4).add("ají licuado");//23
        get(5).add("queso");//24
        get(5).add("queso cocido");//25
        get(5).add("queso aplastado");//26
        get(5).add("queso frito");//27
        get(5).add("queso picado");//28
        get(5).add("queso licuado");//29
        get(6).add("huevo");//30
        get(6).add("huevo cocido");//31
        get(6).add("huevo aplastado");//32
        get(6).add("huevo frito");//33
        get(6).add("huevo picado");//34
        get(6).add("huevo frito");//35
        get(7).add("aceituna");//36
        get(7).add("aceituna codida");//37
        get(7).add("aceituna aplastada");//38
        get(7).add("aceituna frita");//39
        get(7).add("aceituna picada");//40
        get(7).add("aceituna licuada");//41
        get(8).add("lechuga");//42
        get(8).add("lechuga cocida");//43
        get(8).add("lechuga aplastada");//44
        get(8).add("lechuga frita");//45
        get(8).add("lechuga cortada");//46
        get(8).add("lechuga licuada");//47
        get(9).add("mezcla blanca");//48
        get(9).add("mezcla amarilla");//49
    }};

    public List<List<Integer>> getPOSICIONES_COCINA() {
        return POSICIONES_COCINA;
    }

    private final List<List<Integer>> POSICIONES_COCINA= new ArrayList<List<Integer>>(){{
        add(new ArrayList<Integer>());
        add(new ArrayList<Integer>());
        add(new ArrayList<Integer>());
        add(new ArrayList<Integer>());
        add(new ArrayList<Integer>());
        add(new ArrayList<Integer>());
        add(new ArrayList<Integer>());
        add(new ArrayList<Integer>());
        add(new ArrayList<Integer>());
        get(0).add(30);
        get(0).add(235);
        get(1).add(110);
        get(1).add(235);
        get(2).add(190);
        get(2).add(235);
        get(3).add(30);
        get(3).add(155);
        get(4).add(110);
        get(4).add(155);
        get(5).add(190);
        get(5).add(155);
        get(6).add(30);
        get(6).add(95);
        get(7).add(110);
        get(7).add(95);
        get(8).add(190);
        get(8).add(95);
    }} ;
    public Constantes(){

    }
    public List<String> getPreparacionPlatillo(int idPlatillo){
        List<String> preparacion= PREPARACIONES.get(idPlatillo);
        return preparacion;
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

    public List<List<String>> getPlatillos() {
        return PLATILLOS;
    }
    public List<String> getPlatillosImagenes() {
        List<String> platillosImagenes= new ArrayList<String>();
        platillosImagenes=PLATILLOS.get(1);
        return platillosImagenes;
    }
    public List<List<String>> getIngredientesImagenes() {
        return INGREDIENTES_IMAGENES;
    }
    public List<List<String>> getIngredientesNombres() {
        return INGREDIENTES_NOMBRES;
    }

}
