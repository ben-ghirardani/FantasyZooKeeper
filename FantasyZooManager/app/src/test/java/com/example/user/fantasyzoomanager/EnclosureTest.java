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
    Enclosure genPop;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;
    Visitor visitor5;
    Visitor visitor6;
    Dragon dragon1;
    Dragon dragon2;
    Dragon dragon3;
    Dragon dragon4;
    Unicorn unicorn1;
    Unicorn unicorn2;
    Unicorn unicorn3;
    Unicorn unicorn4;

    @Before
    public void before() {
        unicornEnclosure = new Enclosure("Unicorn Enclosure", 5);
        dragonEnclosure = new Enclosure("Dragon Enclosure", 7);
        visitor1 = new Visitor ("Frank", 7, 5, false);
        visitor2 = new Visitor ("Mary", 6, 9, false);
        visitor3 = new Visitor ("Melody", 45, 16, false);
        dragon1 = new Dragon(15, true, "Edward", "Dragon");
        dragon2 = new Dragon(14, true, "Fabian", "Dragon");
        unicorn1 = new Unicorn(20, false, "Samantha", "Unicorn");
        unicorn2 = new Unicorn(21, false, "Clive", "Unicorn");
        genPop = new Enclosure("Enclosure 17", 3);

        // Final Test Subjects

        visitor4 = new Visitor("Chris", 3, 10, false);
        visitor5 = new Visitor("Sophie", 3, 9, false);
        visitor6 = new Visitor("Tina", 6, 8, false);
        dragon3 = new Dragon(19, true, "Lesley", "Dragon");
        dragon4 = new Dragon(18, true, "Emily", "Dragon");
        unicorn3 = new Unicorn(21,false, "Elizabeth", "Unicorn");
        unicorn4 = new Unicorn(20, false, "Barry", "Unicorn");
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

    @Test
    public void countVisitorsInCreatureEnclosure() {
        unicornEnclosure.addToCreatureEnclosure(visitor1);
        unicornEnclosure.addToCreatureEnclosure(visitor2);
        unicornEnclosure.addToCreatureEnclosure(visitor3);
        unicornEnclosure.addToCreatureEnclosure(unicorn1);
        unicornEnclosure.addToCreatureEnclosure(unicorn2);
        assertEquals(3, unicornEnclosure.countVisitorsInCreatureEnclosure());
        assertEquals(2, unicornEnclosure.countUnicornsInCreatureEnclosure());
    }

    @Test
    public void countDragonsInCreatureEnclosure() {
        dragonEnclosure.addToCreatureEnclosure(dragon1);
        assertEquals(1, dragonEnclosure.countDragonsInCreatureEnclosure());
    }

    @Test
    public void resolveVisitorsInUnicornEnclosure() {
        unicornEnclosure.addToCreatureEnclosure(visitor1);
        unicornEnclosure.addToCreatureEnclosure(visitor2);
        unicornEnclosure.addToCreatureEnclosure(visitor3);
        unicornEnclosure.addToCreatureEnclosure(unicorn1);
        unicornEnclosure.addToCreatureEnclosure(unicorn2);
        assertEquals(3, unicornEnclosure.countVisitorsInCreatureEnclosure());
        assertEquals(2, unicornEnclosure.countUnicornsInCreatureEnclosure());
        unicornEnclosure.resolveVisitorsInUnicornEnclosure();
        assertEquals(2, unicornEnclosure.countUnicornsInCreatureEnclosure());
        assertEquals(0, unicornEnclosure.countVisitorsInCreatureEnclosure());
        assertEquals(17, visitor1.visitorFunds());
    }

    @Test
    public void addVariousCreatures() {
        genPop.addCreatureToEnclosureCheckPredator(dragon1);
        genPop.addCreatureToEnclosureCheckPredator(dragon2);
        genPop.addCreatureToEnclosureCheckPredator(unicorn1);
        genPop.addCreatureToEnclosureCheckPredator(unicorn2);
        assertEquals(3, genPop.countCreatures());
    }

    @Test
    public void resolveVisitorsInGenPop() {
        genPop.addCreatureToEnclosureCheckPredator(dragon3);
        genPop.addCreatureToEnclosureCheckPredator(dragon4);
        genPop.addCreatureToEnclosureCheckPredator(unicorn3);
        genPop.addCreatureToEnclosureCheckPredator(unicorn4);
        assertEquals(3, genPop.countCreatures());

        assertEquals(3, visitor4.visitorFunds());
        genPop.addVisitorToSeatingAndPay(visitor4);
        genPop.addVisitorToSeatingAndPay(visitor5);
        genPop.addVisitorToSeatingAndPay(visitor6);
        assertEquals(3, genPop.countVisitors());
        assertEquals(0, visitor4.visitorFunds());

        genPop.removeVisitorIfTheyHaveMoney(visitor4);
        genPop.removeVisitorIfTheyHaveMoney(visitor5);
        genPop.removeVisitorIfTheyHaveMoney(visitor6);
        assertEquals(0, genPop.countVisitors());
        assertEquals(5, genPop.countCreatures());

        genPop.resolveVisitorsInGenPop();
        assertEquals(3, genPop.countCreatures());
    }



}
