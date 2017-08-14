package com.example.user.fantasyzoomanager;

import java.util.ArrayList;

/**
 * Created by user on 11/08/2017.
 */

public class Unicorn extends Creature {


    public Unicorn(int agility, boolean predator, String name, String type) {
        super(agility, predator, name, type);
    }

    public int getAgility() {
        return this.agility;
    }

    public String getType() {
        return this.type;
    }

    public int countBelly() {
        int count = 0;
        for (Enclosable enclosable : belly) {
            if (enclosable != null) {
                count++;
            }
        }
        return count;
    }


}
