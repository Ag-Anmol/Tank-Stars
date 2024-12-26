package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ResumePage implements Screen {

    private MyGame game;
    private Skin skin = new Skin(Gdx.files.internal("skin/golden-spiral/skin/golden-ui-skin.json"));
    Stage stage = new Stage();


    public ResumePage(MyGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        Image img = new Image(new Texture("BackGrounds/resume.png"));
        img.setPosition(0,0);
        img.setSize(1280,720);
        stage.addActor(img);
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


