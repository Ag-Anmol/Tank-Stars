package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Player {
    private Tanks tanks = new Tanks();
    int h;
    int w;
    private Texture tank;
    private Texture rtank;

    public void setRtank(Texture rtank) {
        this.rtank = rtank;
    }

    public static ArrayList<Texture> imgs = new ArrayList<>();
    public static ArrayList<Texture> imgs2 = new ArrayList<>();

    public Texture getTank() {
        return tank;
    }

    public Texture getRtank() {
        return rtank;
    }

    public Player(int n){
        imgs.add(new Texture("Tanks/helios.png"));
        imgs.add(new Texture("Tanks/Blazer.png"));
        imgs.add(new Texture("Tanks/T34.png"));

        imgs2.add(new Texture("Tanks/helios1.png"));
        imgs2.add(new Texture("Tanks/Blazer1.png"));
        imgs2.add(new Texture("Tanks/T341.png"));

        this.tank = imgs.get(n);
        this.rtank = imgs2.get(n);

    }

//    public Texture getRTank() {
//        return rtank;
//    }
}
