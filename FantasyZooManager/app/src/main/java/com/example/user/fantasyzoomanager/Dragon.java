package com.example.user.fantasyzoomanager;

import java.util.ArrayList;

/**
 * Created by user on 13/08/2017.
 */

public class Dragon extends Creature {

    public ArrayList<Enclosable> belly;

    public Dragon(int agility, boolean predator, String name, String type) {
        super(agility, predator, name, type);
        this.belly = new ArrayList<Enclosable>();
    }

    public String dragonRoars() {
        return "Rarrr!";
    }

    public void addToBelly(Enclosable morsel) {
        belly.add(morsel);
    }

    public void removeFromBelly(Enclosable morsel) {
        belly.remove(morsel);
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
