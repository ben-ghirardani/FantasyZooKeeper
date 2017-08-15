package com.example.user.fantasyzoomanager;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 10/08/2017.
 */

public class EnclosureTest {

    Enclosure unicornEnclosure;
    Enclosure dragonEnclosure;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Dragon dragon1;
    Dragon dragon2;

    @Before
    public void before() {
        unicornEnclosure = new Enclosure("Unicorn Enclosure", 5);
        dragonEnclosure = new Enclosure("Dragon Enclosure", 7);
        visitor1 = new Visitor ("Frank", 7, 5, false);
        visitor2 = new Visitor ("Mary", 6, 9, false);
        visitor3 = new Visitor ("Melody", 45, 16, false);
        dragon1 = new Dragon(15, true, "Edward", "Dragon");
        dragon2 = new Dragon(14, true, "Fabian", "Dragon");
    }

    @Test
    public void canGetName() {
        assertEquals("Unicorn Enclosure", unicornEnclosure.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(5, unicornEnclosure.getPrice());
    }

    @Test
    public void creatureEnclosureIsEmpty() {
        assertEquals(0, unicornEnclosure.countCreatures());
    }

    @Test
    public void visitorSeatingIsEmpty() {
        assertEquals(0, unicornEnclosure.countVisitors());
    }

    @Test
    public void creatureEnclosureIsOccupied() {
        unicornEnclosure.addToCreatureEnclosure(visitor1);
        System.out.println(unicornEnclosure.countCreatures());
        assertEquals(1, unicornEnclosure.countCreatures());
    }

    @Test
    public void removeCreatureFromEnclosure() {
        unicornEnclosure.addToCreatureEnclosure(visitor1);
        System.out.println(unicornEnclosure.countCreatures());
        unicornEnclosure.removeFromCreatureEnclosure(visitor1);
        System.out.println(unicornEnclosure.countCreatures());
        assertEquals(0, unicornEnclosure.countCreatures());
    }

    @Test
    public void visitorSeatingIsOccupied() {
        unicornEnclosure.addToVisitorSeating(visitor1);
        System.out.println(unicornEnclosure.countVisitors());
        assertEquals(1, unicornEnclosure.countVisitors());
    }

    @Test
    public void removeVisitorFromSeating() {
        unicornEnclosure.addToVisitorSeating(visitor1);
        System.out.println(unicornEnclosure.countVisitors());
        unicornEnclosure.removeVisitorFromSeating(visitor1);
        System.out.println(unicornEnclosure.countVisitors());
        assertEquals(0, unicornEnclosure.countVisitors());
    }

    @Test
    public void checkIfVisitorCanPay() {
        unicornEnclosure.addVisitorToSeatingAndPay(visitor1);
        System.out.println("Number of visitors: " + unicornEnclosure.countVisitors());
        System.out.println(visitor1.getName() + " has " + visitor1.money + " money remaining.");
        assertEquals(1, unicornEnclosure.countVisitors());
        assertEquals(2, visitor1.visitorFunds());
    }

    @Test
    public void checkNumberOfPredators() {
        dragonEnclosure.addToCreatureEnclosure(dragon1);
        dragonEnclosure.addToCreatureEnclosure(dragon2);
        assertEquals(2, dragonEnclosure.countCreatures());
        assertEquals(2, dragonEnclosure.countPredatorsInCreatureEnclosure());
    }

    @Test
    public void addCreatureToEnclosureCheckPredator() {
        dragonEnclosure.addCreatureToEnclosureCheckPredator(dragon1);
        assertEquals(1, dragonEnclosure.countCreatures());
        dragonEnclosure.addCreatureToEnclosureCheckPredator(dragon2);
        assertEquals(1, dragonEnclosure.countCreatures());
    }

    @Test
    public void removeVisitorIfTheyHaveMoney() {
        dragonEnclosure.addVisitorToSeatingAndPay(visitor1);
        assertEquals(1, dragonEnclosure.countVisitors());
        assertEquals(0, visitor1.visitorFunds());
        dragonEnclosure.removeVisitorIfTheyHaveMoney(visitor1);
        assertEquals(0, dragonEnclosure.countVisitors());
        assertEquals(1, dragonEnclosure.countCreatures());
    }

    @Test
    public void findDragonInArrayOfItems() {
        dragonEnclosure.addToCreatureEnclosure(dragon1);
        dragonEnclosure.addToCreatureEnclosure(visitor1);
        dragonEnclosure.addToCreatureEnclosure(visitor2);
        dragonEnclosure.addToCreatureEnclosure(visitor3);
        assertEquals(4, dragonEnclosure.countCreatures());
        assertEquals(1, dragonEnclosure.findDragonInArrayOfItems());
    }

    @Test
    public void comparePredatorAgilityToVisitors() {
        dragonEnclosure.addToCreatureEnclosure(dragon1);
        dragonEnclosure.addToCreatureEnclosure(visitor1);
        dragonEnclosure.addToCreatureEnclosure(visitor2);
        dragonEnclosure.addToCreatureEnclosure(visitor3);
        assertEquals(15, dragonEnclosure.comparePredatorAgilityToVisitors());
    }

    @Test
    public void resolveVisitorsInDragonEnclosure() {
        dragonEnclosure.addToCreatureEnclosure(dragon1);
        dragonEnclosure.addToCreatureEnclosure(visitor1);
        dragonEnclosure.addToCreatureEnclosure(visitor2);
        dragonEnclosure.addToCreatureEnclosure(visitor3);
        assertEquals(4, dragonEnclosure.countCreatures());
        dragonEnclosure.resolveVisitorsInDragonEnclosure();
        assertEquals(2, dragon1.countBelly());
        assertEquals(1, dragonEnclosure.countCreatures());
    }


}
