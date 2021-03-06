package com.example.user.fantasyzoomanager;

import java.util.ArrayList;

/**
 * Created by user on 11/08/2017.
 */

public class Unicorn extends Creature {

    public ArrayList<Vegetable> belly;
    public String vegChoice;

    public Unicorn(int agility, boolean predator, String name, String type, String vegChoice) {
        super(agility, predator, name, type);
        this.belly = new ArrayList<Vegetable>();
        this.vegChoice = vegChoice;
    }

    public void addToBelly(Vegetable veg) {
        belly.add(veg);
    }

    public void removeFromBelly(Vegetable veg) {
        belly.remove(veg);
    }

    public String getVegChoice() {
        return this.vegChoice;
    }

    public int countBelly() {
        int count = 0;
        for (Vegetable veg : belly) {
            if (veg != null) {
                count++;
            }
        }
        return count;
    }

}
