package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.security.Key;

public class HomePage implements Screen {

    private SpriteBatch batch;
    private MyGame Game;
    private Stage stage;
    private Viewport gamePort;
    private OrthographicCamera gameCam;
    private Texture img;
    private Skin skin;

    public HomePage(final MyGame game) {

        Game = game;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        gameCam = new OrthographicCamera();
        skin = new Skin(Gdx.files.internal("skin/golden-spiral/skin/golden-ui-skin.json"));
        gamePort = new FitViewport(1300, 700, gameCam);


    }
    @Override
    public void show() {
        TextButton NewGameButton = new TextButton("New Game", skin );
        NewGameButton.setPosition(430, 420);
        NewGameButton.setSize(400, 80);
        final MyGame finalGame = Game;
        NewGameButton.addListener(new ClickListener() {

            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button) {
                finalGame.setScreen(new MainScreen(finalGame,1));
            }
        });
        stage.addActor(NewGameButton);

        TextButton ResumeGameButton = new TextButton("Resume", skin );
        ResumeGameButton.setPosition(430, 340);
        ResumeGameButton.setSize(400, 80);
        ResumeGameButton.addListener(new ClickListener() {

            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button) {
                Game.setScreen(new ResumePage(Game));
            }
        });
        stage.addActor(ResumeGameButton);

        TextButton ExitGameButton = new TextButton("Exit Game", skin );
        ExitGameButton.setPosition(430, 260);
        ExitGameButton.setSize(400, 80);
        ExitGameButton.addListener(new ClickListener() {

            @Override
            public void touchUp(InputEvent e, float x, float y, int point, int button) {
                Gdx.app.exit();
            }
        });
        stage.addActor(ExitGameButton);

        this.img = new Texture("BackGrounds/BackGround1.png");
        this.batch = new SpriteBatch();

        if(Gdx.input.isKeyPressed(Input.Keys.B)){
            Gdx.app.exit();
        }


    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0,1);
        this.batch.begin();
        this.batch.draw(img, 0, 0, 1280, 720);
        this.batch.end();
        this.stage.act(delta);
        this.stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
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
        this.batch.dispose();
        this.img.dispose();
        this.stage.dispose();
    }
}
