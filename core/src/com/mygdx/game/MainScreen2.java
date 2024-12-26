//package com.mygdx.game;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;
//import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
//import jdk.tools.jmod.Main;
//import org.w3c.dom.ls.LSOutput;
//
//public class MainScreen2 implements Screen {
//    private final MyGame game;
//    private Tanks tank = new Tanks();
//    private Image tankpos;
//    private Texture tex1,tex2,tex3;
//    private TextureRegion reg1,reg2,reg3;
//    private TextureRegionDrawable dr1,dr2,dr3;
//    private ImageButton b1,b2,b3;
//    private Image bg = new Image(new Texture("BackGrounds/14.png"));
//    private Stage stage = new Stage();
//    private int pointer = 0;
//    public MainScreen2(final MyGame game){
//        this.game = game;
//        Gdx.input.setInputProcessor(stage);
//        bg.setSize(1280,720);
//        bg.setPosition(0,0);
//        stage.addActor(bg);
//        tex1 = tank.tanks.get(0);
//        tex2 = tank.tanks.get(1);
//        tex3 = tank.tanks.get(2);
//        reg1 = new TextureRegion(tex1);
//        reg2 = new TextureRegion(tex2);
//        reg3 = new TextureRegion(tex3);
//        dr1 = new TextureRegionDrawable(reg1);
//        dr2 = new TextureRegionDrawable(reg2);
//        dr3 = new TextureRegionDrawable(reg3);
//        b1 = new ImageButton(dr1);
//        b2 = new ImageButton(dr2);
//        b3 = new ImageButton(dr3);
//        b1.setPosition(100,200);
//        b1.setSize(300,200);
//        b2.setPosition(150,-100);
//        b2.setSize(1000,800);
//        b3.setPosition(500,-100);
//        b3.setSize(1000,800);
//        b1.addListener(new ClickListener(){
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.P1 = new Player(0);
//            }
//        });
//        b2.addListener(new ClickListener(){
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.P2 = new Player(1);
//            }
//        });
//        b3.addListener(new ClickListener(){
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.P1 = new Player(2);
//            }
//        });
////        System.out.println(pointer);
////        stage.addActor(b1);
////        stage.addActor(b2);
////        stage.addActor(b3);
////        game.setScreen(new GamePage(game.P1,game.P2));
////        game.P1 = new Player(pointer);
//    }
//    /*
//    @Test
//     */
//    public boolean tester(){
//        try {
//            assert game.P1 != null;
//        }
//        catch (AssertionError e){
//            return false;
//        }
//        return true;
//    }
//    @Override
//    public void show() {
//
//    }
//
//    @Override
//    public void render(float delta) {
//        System.out.println(pointer);
//        stage.draw();
////        stage.dispose();
//
//
////        System.out.println(Gdx.input.getY());
////        System.out.println(Gdx.input.getX());
//    }
//
//    @Override
//    public void resize(int width, int height) {
//
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//
//    }
//}
