package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class MainScreen implements Screen {

    private SpriteBatch batch;
    private MyGame game;
    private Stage stage;
    private Texture background;
    private Viewport gamePort;
    private OrthographicCamera gameCam;

    private ImageButton tank1;
    private ImageButton tank2;
    private ImageButton tank3;


    public MainScreen(final MyGame game, final int Player){

        this.game = game;
        this.stage = new Stage();
        this.background = new Texture("BackGrounds/BackGround2.png");
        Gdx.input.setInputProcessor(stage);
        gameCam = new OrthographicCamera();
        Skin skin = new Skin(Gdx.files.internal("skin/golden-spiral/skin/golden-ui-skin.json"));
        gamePort = new FitViewport(1300, 700, gameCam);

        Label LeftTop, NumCoinLabel, NumDiamondLabel, tank1Label, tank2Label, tank3Label, Player1, Player2;
        LeftTop = null;
        TextButton LeftBottom, RightBottom;
        RightBottom = null;
        Texture Tank1, Tank2, Tank3;


        LeftBottom = new TextButton("Back", skin);
        LeftBottom.setPosition(12, 12);
        LeftBottom.setSize(230, 70);
        LeftBottom.setScale(1.3f, 1.3f);

        TextField name1Field, name2Field;



        if (Player == 1) {
            LeftTop = new Label("Player 1", skin);
            RightBottom = new TextButton("Next", skin);
            RightBottom.addListener(new ClickListener() {

                @Override
                public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
                    game.setScreen(new MainScreen(game, 2));
                }
            });
            LeftBottom.addListener(new ClickListener(){

                @Override
                public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
                    game.setScreen(new HomePage(game));
                }

            });

        }
        else {
            LeftTop = new Label("Player 2", skin);
            RightBottom = new TextButton("Play Game", skin);
            LeftBottom.addListener(new ClickListener(){

                @Override
                public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
                    game.setScreen(new MainScreen(game, 1));
                }

            });
            RightBottom.addListener(new ClickListener() {

                @Override
                public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
                    game.setScreen(new GamePage(game,game.P1,game.P2));
                }
            });
        }

        stage.addActor(LeftBottom);

        LeftTop.setPosition(67, 632);
        LeftTop.setSize(100, 50);
        LeftTop.setFontScale(2,2);
        stage.addActor(LeftTop);

        RightBottom.setPosition(1054, 12);
        RightBottom.setSize(230, 70);
        RightBottom.setScale(1.3f, 1.3f);
        stage.addActor(RightBottom);

        NumDiamondLabel = new Label("0", skin);
        NumDiamondLabel.setPosition(1200, 650);
        NumDiamondLabel.setSize(50,25);
        NumDiamondLabel.setFontScale((float)1.75, (float)1.75);
        stage.addActor(NumDiamondLabel);

        NumCoinLabel = new Label("500", skin);
        NumCoinLabel.setPosition(1055, 650);
        NumCoinLabel.setSize(50,25);
        NumCoinLabel.setFontScale((float)1.75, (float)1.75);
        stage.addActor(NumCoinLabel);

        Tank1 = new Texture("Tanks/helios.png");
        TextureRegion Tank1R = new TextureRegion(Tank1);
        TextureRegionDrawable Tank1RD = new TextureRegionDrawable(Tank1R);
        tank1 = new ImageButton(Tank1RD);
        tank1.setPosition(84, 238);
        tank1.setSize(290, 190);
        tank1.addListener(new ClickListener() {

            @Override
            public void touchUp(InputEvent e, float x, float y, int pointer, int button) {
                if (Player == 1) {
                    game.P1 = new Player(0);
                }
                else {
                    game.P2 = new Player(0);
//                    game.P2.setRtank(Player.);
                }
            }
        });
        stage.addActor(tank1);



        tank1Label = new Label("Helios", skin);
        tank1Label.setSize(50, 25);
        tank1Label.setPosition(187, 465);
        tank1Label.setFontScale(1.5f, 1.5f);
        stage.addActor(tank1Label);

        Tank2 = new Texture("Tanks/Blazer.png");
        TextureRegion Tank2R = new TextureRegion(Tank2);
        TextureRegionDrawable Tank2RD = new TextureRegionDrawable(Tank2R);
        tank2 = new ImageButton(Tank2RD);
        tank2.setPosition(505, 245);
        tank2.setSize(290, 190);
        tank2.addListener(new ClickListener() {

            @Override
            public void touchUp(InputEvent e, float x, float y, int pointer, int button) {
                tank2.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("Tanks/Blazer.png")));
                if (Player == 1) {
                    game.P1 = new Player(1);
                }
                else {
                    game.P2 = new Player(1);
                }
            }
        });
        stage.addActor(tank2);

        tank2Label = new Label("Blazer", skin);
        tank2Label.setSize(50, 25);
        tank2Label.setPosition(609, 465);
        tank2Label.setFontScale(1.5f, 1.5f);
        stage.addActor(tank2Label);

        Tank3 = new Texture("Tanks/T34.png");
        TextureRegion Tank3R = new TextureRegion(Tank3);
        TextureRegionDrawable Tank3RD = new TextureRegionDrawable(Tank3R);
        tank3 = new ImageButton(Tank3RD);
        tank3.setPosition(900, 240);
        tank3.setSize(290, 190);
        tank3.addListener(new ClickListener() {

            @Override
            public void touchUp(InputEvent e, float x, float y, int pointer, int button) {
                tank3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture("Tanks/T34.png")));
                if (Player == 1) {
                    game.P1 = new Player(2);
                }else {
                    game.P2 = new Player(2);
                }
            }
        });
        stage.addActor(tank3);


        tank3Label = new Label("T34", skin);
        tank3Label.setSize(50, 25);
        tank3Label.setPosition(1000, 465);
        tank3Label.setFontScale(1.5f, 1.5f);
        stage.addActor(tank3Label);

        this.batch = new SpriteBatch();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        this.batch.begin();
        this.batch.draw(background, 0, 0, 1300, 700);
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
        this.stage.dispose();
        this.background.dispose();
    }
}
