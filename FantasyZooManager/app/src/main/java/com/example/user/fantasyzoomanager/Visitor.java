package com.example.user.fantasyzoomanager;

/**
 * Created by user on 10/08/2017.
 */

public class Visitor implements Enclosable {

    private String name;
    public int money;
    private int agility;
    private boolean predator;

    public Visitor(String name, int money, int agility, boolean predator) {
        this.name = name;
        this.money = money;
        this.agility = agility;
        this.predator = predator;

    }

    public String getName() {
        return this.name;
    }

    public int visitorFunds() {
        return this.money;
    }

    public int visitorAgility() {
        return this.agility;
    }

    public boolean isPredator() {
        return this.predator;
    }

}
