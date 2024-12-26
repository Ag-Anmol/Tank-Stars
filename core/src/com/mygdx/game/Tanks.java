package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

public class Tanks {
    private Player player;
    Texture img;
    private int strength=100;
    private int fuel=100;
//    private int tank_number=0;
    public Image bullet = new Image(new Texture("Bullet/CannonBall.png"));
    public ArrayList<Texture> tanks = new ArrayList<>();

    public Tanks() {
//        this.tank_number = tank_number;
        tanks.add(new Texture("Tanks/helios.png"));
        tanks.add(new Texture("Tanks/Blazer.png"));
        tanks.add(new Texture("Tanks/T34.png"));
    }

    public int move(String dirc){
        if(dirc.equals("front")){
            this.fuel-=10;
            return 1;
        }
        else if(dirc.equals("back")){
            this.fuel-=10;
            return -1;
        }
        else return 0;
    }

    public void strength(boolean hit) {
        if (hit) {
            this.strength -= 10;
        } else {
        }
    }


}
