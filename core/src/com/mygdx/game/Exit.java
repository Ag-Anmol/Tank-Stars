package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Exit implements Screen {
    private MyGame game;
    private Stage stage = new Stage();
    private Image img1 = new Image(new Texture("BackGrounds/BackGround1.png"));
    private Image img2 = new Image(new Texture("buttons/PvP.png"));
    private Image img3 = new Image(new Texture("buttons/ResumeGame.jpg.png"));

    public Exit(MyGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        img1.setPosition(0,0);
        img1.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        stage.addActor(img1);

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
