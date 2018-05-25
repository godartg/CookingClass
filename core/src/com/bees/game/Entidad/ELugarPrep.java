package com.bees.game.entidad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
/**
 * Created by workaholic on 20/03/2018.
 */

public class ELugarPrep extends Actor{
    /** The player texture. */
    private Texture texture;

    public ELugarPrep() {

    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }


    public ELugarPrep(Texture texture, float pX, float pY){
        this.texture = texture;
        setBounds(pX, pY,230,230);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(texture, getX(), getY(),230,230);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
}
