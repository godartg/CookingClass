package com.bees.game.Entidad;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


/**
 * Created by workaholic on 20/03/2018.
 */

public class EIngrediente extends Actor{
    private int idIngrediente;
    private String nombreIngrediente;
    private boolean estadoIngrediente;


    public boolean getestadoIngrediente() {
        return estadoIngrediente;
    }

    public void setestadoIngrediente(boolean estadoIngrediente) {
        this.estadoIngrediente = estadoIngrediente;
    }

    public int getidIngrediente() {
        return idIngrediente;
    }


    public void setidIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getnombreIngrediente() {
        return nombreIngrediente;
    }

    public void setnombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }



    private Texture ingredienteTexture;

    public Texture getIngredienteTexture() {
        return ingredienteTexture;
    }

    public void setIngredienteTexture(Texture ingredienteTexture) {
        this.ingredienteTexture = ingredienteTexture;
    }
    public EIngrediente(){

    }

    public EIngrediente(Texture texture, float x, float y){
        this.ingredienteTexture = texture;
        setBounds(x, y,75,75);

    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(ingredienteTexture, getX(),getY(),75,75);
    }
    /*
     * La clase permite:
     * - El InputListener y hacer un Drag and Drop
     * - Verificar si existe colisión entre el ingrediente y el lugar de preparación
     *
     */
    public static class AgregarListener extends InputListener {
        float altura = 75 / 2;
        float touchDown_x;
        float touchDown_y;
        float dx;
        float dy;
        EIngrediente ingrediente;
        ELugarPrep lugarPrep;
        public AgregarListener(EIngrediente eingrediente, ELugarPrep eLugarPrep){
            ingrediente=eingrediente ;
            lugarPrep=eLugarPrep;
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
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            //Verificar colisión
            if ((ingrediente.getX()>=lugarPrep.getX()&&ingrediente.getX()<=(lugarPrep.getX()+lugarPrep.getWidth()))&&(ingrediente.getY()>=lugarPrep.getY()&&ingrediente.getY()<=(lugarPrep.getY()+lugarPrep.getHeight()))){
                ingrediente.setVisible(false);
                ingrediente.setestadoIngrediente(true);
            }else{
                ingrediente.setPosition(30,230);
            }
        }
    }
}
