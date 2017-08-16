package com.example.user.fantasyzoomanager;

import java.util.ArrayList;

/**
 * Created by user on 11/08/2017.
 */

public class Unicorn extends Creature {

    public ArrayList<Vegetable> belly;

    public Unicorn(int agility, boolean predator, String name, String type) {
        super(agility, predator, name, type);
        this.belly = new ArrayList<Vegetable>();
    }

    public void addToBelly(Vegetable veg) {
        belly.add(veg);
    }

    public void removeFromBelly(Vegetable veg) {
        belly.remove(veg);
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
