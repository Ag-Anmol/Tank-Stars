package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Null;

import javax.swing.*;

public class GamePage implements Screen {
    private World world;
    private MyGame game;
    private Player player1 , player2;
    private Box2DDebugRenderer renderer;
    private OrthographicCamera camera;
    private Sprite sprite;
    private SpriteBatch batch;
    private Stage stage = new Stage();
    private BodyDef ball = new BodyDef();
    private Image img = new Image(new Texture("BackGrounds/GameBg.png"));
    private Image img2 = new Image(new Texture("Arrows/Aim.png"));
    private Image img3 = new Image(new Texture("Arrows/Aim.png"));

    private Array<Body> temp = new Array<Body>( );
    private final float speed = 400000;
    private Vector2 move = new Vector2(0,0);
    private Vector2 aimv = new Vector2(0,0);
    private Vector2 aimv2 = new Vector2(0,0);
    private Body box;
    private Body box2,box3,box4;
    private float x = 212,y = 367;
    private float x1 = 900,y1 = 367;
    private final float TIMESTEP = 1/60f;
    private final int VELOCITY=8 , POSITION=3;
    public GamePage(MyGame game,Player P1,Player P2){
        this.game= game;
        this.player1 = game.P1;
        this.player2 = game.P2;
    }


    @Override
    public void show() {
        world = new World(new Vector2(0,-100f),true);
        renderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(1280,720);
        batch = new SpriteBatch();
        img.setPosition(0,0);
        img.setSize(1600,800);
        stage.addActor(img);
        img2.setSize(25,25);
        img2.setPosition(0,0);
        stage.addActor(img2);
        img3.setSize(25,25);
        img3.setPosition(0,0);
        stage.addActor(img3);
//        x = box.getPosition().x;
//        x = box.getWorldCenter().x;
//        y = box.getWorldCenter().y;


        Gdx.input.setInputProcessor(new Inputs(){
            @Override
            public boolean keyDown(int keycode) {
                switch(keycode){
                    case Input.Keys.LEFT:
                        box.applyLinearImpulse(-speed , 0, box.getWorldCenter().x,box.getWorldCenter().y,true);
                        break;
                    case Input.Keys.RIGHT:
                        box.applyLinearImpulse(speed , 0, box.getWorldCenter().x,box.getWorldCenter().y,true);
                        break;
                    case Input.Keys.SPACE:
                        firebullet();
                        box2.applyLinearImpulse(x/10,y/10,box.getWorldCenter().x,box.getWorldCenter().y,true);
                        break;
                    case Input.Keys.J:
                        box3.applyLinearImpulse(-speed , 0, box3.getWorldCenter().x,box3.getWorldCenter().y,true);
                        break;
                    case Input.Keys.L:
                        box3.applyLinearImpulse(speed , 0, box3.getWorldCenter().x,box3.getWorldCenter().y,true);
                        break;
                    case Input.Keys.K:
                        firebullet();
                        box3.applyLinearImpulse(x1/10,y1/10,box3.getWorldCenter().x,box3.getWorldCenter().y,true);
                        break;
//                    case Input.Keys.SPACE:
//                        box2.applyLinearImpulse(aim.x,aim.y,box.getWorldCenter().x,box.getWorldCenter().y,true);
                }
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                switch(keycode){
                    case Input.Keys.LEFT:
//                        if(box.getPosition().x)
                        box.applyLinearImpulse(speed , 0, box.getWorldCenter().x,box.getWorldCenter().y,true);
                        break;
                    case Input.Keys.RIGHT:
                        box.applyLinearImpulse(-speed , 0, box.getWorldCenter().x,box.getWorldCenter().y,true);
                        break;
                    case Input.Keys.J:
//                        if(box.getPosition().x)
                        box3.applyLinearImpulse(speed , 0, box3.getWorldCenter().x,box3.getWorldCenter().y,true);
                        break;
                    case Input.Keys.L:
                        box3.applyLinearImpulse(-speed , 0, box3.getWorldCenter().x,box3.getWorldCenter().y,true);
                        break;
                }
                return true;
            }
        });
        if(Gdx.input.isKeyPressed(Input.Keys.B)){
            Gdx.app.exit();
        }

        ball.type = BodyDef.BodyType.DynamicBody;
        ball.position.set(-20,10);

//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(.5f,1);
        CircleShape shape = new CircleShape();
//        shape.setPosition(new Vector2(0,50));
        shape.setRadius(.5f);

        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = 300000;
        fixture.friction = 2f;
        fixture.restitution = 0.6f;

        box = world.createBody(ball);
        box.createFixture(fixture);

        sprite = new Sprite(player1.getTank());
        sprite.setSize(2.6f,2f);
        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
        box.setUserData(sprite);

        shape.dispose();

        //tank 2
        ball.type = BodyDef.BodyType.DynamicBody;
        ball.position.set(20,10);

//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(.5f,1);
        shape = new CircleShape();
//        shape.setPosition(new Vector2(0,50));
        shape.setRadius(.5f);

//        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = 300000;
        fixture.friction = 2f;
        fixture.restitution = 0.6f;

        box3 = world.createBody(ball);
        box3.createFixture(fixture);

        sprite = new Sprite(game.P2.getRtank());
        sprite.setSize(2.6f,2f);
        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
        box3.setUserData(sprite);

        shape.dispose();

//        box.applyAngularImpulse(1000,true);


        //ground
        ball.type = BodyDef.BodyType.StaticBody;
        ball.position.set(0,-2.5f);

        ChainShape ground = new ChainShape();
//        ChainShape ground1 = new ChainShape();
//        ChainShape ground2 = new ChainShape();
        ground.createChain(new Vector2[] {new Vector2(-800,0),new Vector2(800,0)});
//        ground.createChain(new Vector2[] {new Vector2(1,390),new Vector2(1,440)});
//        ground.createChain(new Vector2[] {new Vector2(1270,390),new Vector2(1270,440)});
//        ground.createChain;

        fixture.shape = ground;
        fixture.friction = 10f;
        fixture.restitution =0f;

        world.createBody(ball).createFixture(fixture);
        ground.dispose();
//        firebullet();
//        aim();
    }

    void firebullet(){
        ball.type = BodyDef.BodyType.DynamicBody;
        ball.position.set(box.getPosition());

//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(.5f,1);
        CircleShape shape = new CircleShape();
//        shape.setPosition(new Vector2(0,50));
        shape.setRadius(.2f);

        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = 7;
        fixture.friction = 2000000f;
        fixture.restitution = 0f;

        box2 = world.createBody(ball);
        box2.createFixture(fixture);

        sprite = new Sprite(new Texture("Bullet/CannonBall.png"));
        sprite.setSize(0.6f,0.6f);
        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
        box2.setUserData(sprite);

        shape.dispose();

    }
    void firebullet2(){
        ball.type = BodyDef.BodyType.DynamicBody;
        ball.position.set(box3.getPosition());

//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(.5f,1);
        CircleShape shape = new CircleShape();
//        shape.setPosition(new Vector2(0,50));
        shape.setRadius(.2f);

        FixtureDef fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = 7;
        fixture.friction = 2000000f;
        fixture.restitution = 0f;

        box4 = world.createBody(ball);
        box4.createFixture(fixture);

        sprite = new Sprite(new Texture("Bullet/CannonBall.png"));
        sprite.setSize(0.6f,0.6f);
        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
        box4.setUserData(sprite);

        shape.dispose();

    }

    void aim(){

    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render(world,camera.combined);

        world.step(TIMESTEP,VELOCITY,POSITION);
//        System.out.println(Gdx.input.getX());
//        System.out.println(Gdx.input.getX()+" "+box.getPosition().x);


        stage.draw();
        aimv.set(x,y);
        aimv2.set(x1,y1);
        img2.setPosition(x,y);
        img3.setPosition(x1,y1);
//        System.out.println(Gdx.input.getX()+" "+Gdx.input.getY());
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            x -=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            x +=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            y +=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.X)){
            y -=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.F)){
            x1 -=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.H)){
            x1 +=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.T)){
            y1 +=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.V)){
            y1 -=1;
        }
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        world.getBodies(temp);
        for(Body body : temp)
            if(body.getUserData()!=null && body.getUserData() instanceof Sprite){
                Sprite sprite = (Sprite) body.getUserData();
                sprite.setPosition(body.getPosition().x - sprite.getWidth()/5,body.getPosition().y - sprite.getHeight()/4);
//                sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
                sprite.draw(batch);
            }
        batch.end();
//        box.applyLinearImpulse(move,box.getWorldCenter(),true);
    }


    @Override
    public void resize(int width, int height) {
        camera.viewportWidth= width / 25;
        camera.viewportHeight = height/25;
        camera.update();

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
