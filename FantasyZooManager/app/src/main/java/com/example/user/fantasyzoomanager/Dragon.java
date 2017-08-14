package com.example.user.fantasyzoomanager;

/**
 * Created by user on 13/08/2017.
 */

public class Dragon extends Creature {

    public Dragon(int agility, boolean predator, String name, String type) {
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
