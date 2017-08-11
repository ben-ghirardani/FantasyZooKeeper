package com.example.user.fantasyzoomanager;

/**
 * Created by user on 10/08/2017.
 */

public class Visitor {

    private String name;
    private int money;

    public Visitor(String name, int money) {
        this.money = money;
        this.name = name;
    }

    public int showVisitorFunds() {
        return this.money;
    }

    public String showVisitorName() {
        return this.name;
    }

}
