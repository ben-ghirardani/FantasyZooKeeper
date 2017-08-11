package com.example.user.fantasyzoomanager;

import java.util.ArrayList;

/**
 * Created by user on 11/08/2017.
 */

public class Unicorn extends Creature {

    private ArrayList<Eatable> belly;
//    better name for predator?
    private boolean predator;
    private String name;
    private String type;

    public Unicorn(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

}
