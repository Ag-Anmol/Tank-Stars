package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Tank_helios implements Screen {
    private MyGame game;
    private Stage stage;
    private Texture img = new Texture("Tanks/helios.png");

    public Tank_helios(MyGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        Image tankpos = new Image(img);
        tankpos.setSize(309,197);
        tankpos.setPosition(486,280);
        stage.addActor(tankpos);
    }

    @Override
    public void render(float delta) {
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
