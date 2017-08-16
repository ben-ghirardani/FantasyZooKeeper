package com.example.user.fantasyzoomanager;

import java.util.ArrayList;

/**
 * Created by user on 10/08/2017.
 */


public abstract class Creature implements Enclosable {


    public ArrayList<Enclosable> belly;
    public int agility;
    public boolean predator;
    public String name;
    public String type;

    public Creature(int agility, boolean predator, String name, String type) {
        this.belly = new ArrayList<Enclosable>();
        this.agility = agility;
        this.predator = predator;
        this.name = name;
        this.type = type;
    }

//    public abstract void addToBelly();

//    can't make addToBelly an abstract method even though both Unicorn and Dragon inherit it as
//    they take in different variables.


    public String getName() {
        return this.name;
    }

    public int getAgility() {
        return this.agility;
    }

    public String getType() {
        return this.type;
    }

    public boolean isPredator() {
        return this.predator;
    }


}
