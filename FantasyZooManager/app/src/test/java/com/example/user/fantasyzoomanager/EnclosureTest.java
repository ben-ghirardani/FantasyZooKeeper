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
    Enclosure mixedEnclosure;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;
    Visitor visitor5;
    Visitor visitor6;
    Visitor visitor7;
    Visitor visitor8;
    Visitor visitor9;
    Dragon dragon1;
    Dragon dragon2;
    Dragon dragon3;
    Dragon dragon4;
    Dragon dragon5;
    Dragon dragon6;
    Unicorn unicorn1;
    Unicorn unicorn2;
    Unicorn unicorn3;
    Unicorn unicorn4;
    Unicorn unicorn5;
    Unicorn unicorn6;
    Cabbage cabbage1;
    Carrot carrot1;
    Cauliflower cauliflower1;


    @Before
    public void before() {
        unicornEnclosure = new Enclosure("Unicorn Enclosure", 5);
        dragonEnclosure = new Enclosure("Dragon Enclosure", 7);
        visitor1 = new Visitor ("Frank", 7, 5, false);
        visitor2 = new Visitor ("Mary", 6, 9, false);
        visitor3 = new Visitor ("Melody", 45, 16, false);
        dragon1 = new Dragon(15, true, "Edward", "Dragon");
        dragon2 = new Dragon(14, true, "Fabian", "Dragon");
        unicorn1 = new Unicorn(20, false, "Samantha", "Unicorn", "Cauliflower");
        unicorn2 = new Unicorn(21, false, "Clive", "Unicorn", "Carrot");
        mixedEnclosure = new Enclosure("Enclosure 17", 3);
        cabbage1 = new Cabbage("Cabbage");
        carrot1 = new Carrot("Carrot");
        cauliflower1 = new Cauliflower("Cauliflower");

        // Final Test Subjects (Unicorns Win)

        visitor4 = new Visitor("Chris", 3, 10, false);
        visitor5 = new Visitor("Sophie", 3, 9, false);
        visitor6 = new Visitor("Tina", 6, 8, false);
        dragon3 = new Dragon(19, true, "Lesley", "Dragon");
        dragon4 = new Dragon(18, true, "Emily", "Dragon");
        unicorn3 = new Unicorn(21,false, "Elizabeth", "Unicorn", "Cabbage");
        unicorn4 = new Unicorn(20, false, "Barry", "Unicorn", "Carrot");

        // Final Test Subjects (Dragons Win)

        visitor7 = new Visitor("Phillip", 3, 10, false);
        visitor8 = new Visitor("Zoe", 3, 9, false);
        visitor9 = new Visitor("Ian", 6, 8, false);
        dragon5 = new Dragon(25, true, "Lauren", "Dragon");
        dragon6 = new Dragon(18, true, "Erik", "Dragon");
        unicorn5 = new Unicorn(17,false, "Sky", "Unicorn", "Cauliflower");
        unicorn6 = new Unicorn(18, false, "Theo", "Unicorn", "Cabbage");

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
        assertEquals(1, unicornEnclosure.countCreatures());
    }

    @Test
    public void removeCreatureFromEnclosure() {
        unicornEnclosure.addToCreatureEnclosure(visitor1);
        unicornEnclosure.removeFromCreatureEnclosure(visitor1);
        assertEquals(0, unicornEnclosure.countCreatures());
    }

    @Test
    public void visitorSeatingIsOccupied() {
        unicornEnclosure.addToVisitorSeating(visitor1);
        assertEquals(1, unicornEnclosure.countVisitors());
    }

    @Test
    public void removeVisitorFromSeating() {
        unicornEnclosure.addToVisitorSeating(visitor1);
        unicornEnclosure.removeVisitorFromSeating(visitor1);
        assertEquals(0, unicornEnclosure.countVisitors());
    }

    @Test
    public void foodTroughIsEmpty() {
        assertEquals(0, unicornEnclosure.countVegetables());
    }

    @Test
    public void canAddVegToFoodTrough() {
        unicornEnclosure.addVegetableToFoodTrough(carrot1);
        assertEquals(1, unicornEnclosure.countVegetables());
    }

    @Test
    public void canRemoveVegFromFoodTrough() {
        unicornEnclosure.addVegetableToFoodTrough(carrot1);
        assertEquals(1, unicornEnclosure.countVegetables());
        unicornEnclosure.removeVegetableFromFoodTrough(carrot1);
        assertEquals(0, unicornEnclosure.countVegetables());
    }

    @Test
    public void checkIfVisitorCanPay() {
        unicornEnclosure.addVisitorToSeatingAndPay(visitor1);
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
        mixedEnclosure.addCreatureToEnclosureCheckPredator(dragon1);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(dragon2);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(unicorn1);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(unicorn2);
        assertEquals(3, mixedEnclosure.countCreatures());
    }

    @Test
    public void resolveVisitorsInMixedEnclosureUnicornsWin() {
        mixedEnclosure.addCreatureToEnclosureCheckPredator(dragon3);

        // addCreatureToEnclosureCheckPredator should prevent a second predator being added.

        mixedEnclosure.addCreatureToEnclosureCheckPredator(dragon4);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(unicorn3);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(unicorn4);
        assertEquals(3, mixedEnclosure.countCreatures());

        assertEquals(3, visitor4.visitorFunds());
        mixedEnclosure.addVisitorToSeatingAndPay(visitor4);
        mixedEnclosure.addVisitorToSeatingAndPay(visitor5);
        mixedEnclosure.addVisitorToSeatingAndPay(visitor6);
        assertEquals(3, mixedEnclosure.countVisitors());
        assertEquals(0, visitor4.visitorFunds());

        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor4);
        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor5);
        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor6);
        assertEquals(0, mixedEnclosure.countVisitors());
        assertEquals(5, mixedEnclosure.countCreatures());

        mixedEnclosure.resolveVisitorsInMixedEnclosure();
        assertEquals(3, mixedEnclosure.countCreatures());

        assertEquals(10, visitor4.visitorFunds());
        assertEquals(10, visitor5.visitorFunds());

        assertEquals(0, dragon3.countBelly());

    }

    @Test
    public void resolveVisitorsInMixedEnclosureDragonsWin() {
        mixedEnclosure.addCreatureToEnclosureCheckPredator(dragon5);

        //  addCreatureToEnclosureCheckPredator should prevent a second predator being added.

        mixedEnclosure.addCreatureToEnclosureCheckPredator(dragon6);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(unicorn5);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(unicorn6);
        assertEquals(3, mixedEnclosure.countCreatures());

        assertEquals(3, visitor7.visitorFunds());
        mixedEnclosure.addVisitorToSeatingAndPay(visitor7);
        mixedEnclosure.addVisitorToSeatingAndPay(visitor8);
        mixedEnclosure.addVisitorToSeatingAndPay(visitor9);
        assertEquals(3, mixedEnclosure.countVisitors());
        assertEquals(0, visitor7.visitorFunds());

        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor7);
        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor8);
        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor9);
        assertEquals(0, mixedEnclosure.countVisitors());
        assertEquals(5, mixedEnclosure.countCreatures());

        mixedEnclosure.resolveVisitorsInMixedEnclosure();
        assertEquals(3, mixedEnclosure.countCreatures());

        assertEquals(0, visitor7.visitorFunds());
        assertEquals(0, visitor8.visitorFunds());

        assertEquals(2, dragon5.countBelly());
    }

    @Test
    public void resolveVisitorsInMixedEnclosureV2UnicornsWin() {
        mixedEnclosure.addCreatureToEnclosureCheckPredator(dragon3);

        // addCreatureToEnclosureCheckPredator should prevent a second predator being added.

        mixedEnclosure.addCreatureToEnclosureCheckPredator(dragon4);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(unicorn3);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(unicorn4);
        assertEquals(3, mixedEnclosure.countCreatures());

        assertEquals(3, visitor4.visitorFunds());
        mixedEnclosure.addVisitorToSeatingAndPay(visitor4);
        mixedEnclosure.addVisitorToSeatingAndPay(visitor5);
        mixedEnclosure.addVisitorToSeatingAndPay(visitor6);
        assertEquals(3, mixedEnclosure.countVisitors());
        assertEquals(0, visitor4.visitorFunds());

        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor4);
        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor5);
        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor6);
        assertEquals(0, mixedEnclosure.countVisitors());
        assertEquals(5, mixedEnclosure.countCreatures());

        mixedEnclosure.resolveVisitorsInMixedEnclosureV2();
        assertEquals(3, mixedEnclosure.countCreatures());

        assertEquals(10, visitor4.visitorFunds());
        assertEquals(10, visitor5.visitorFunds());

        assertEquals(0, dragon3.countBelly());

    }

    @Test
    public void resolveVisitorsInMixedEnclosureV2DragonsWin() {
        mixedEnclosure.addCreatureToEnclosureCheckPredator(dragon5);

        //  addCreatureToEnclosureCheckPredator should prevent a second predator being added.

        mixedEnclosure.addCreatureToEnclosureCheckPredator(dragon6);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(unicorn5);
        mixedEnclosure.addCreatureToEnclosureCheckPredator(unicorn6);
        assertEquals(3, mixedEnclosure.countCreatures());

        assertEquals(3, visitor7.visitorFunds());
        mixedEnclosure.addVisitorToSeatingAndPay(visitor7);
        mixedEnclosure.addVisitorToSeatingAndPay(visitor8);
        mixedEnclosure.addVisitorToSeatingAndPay(visitor9);
        assertEquals(3, mixedEnclosure.countVisitors());
        assertEquals(0, visitor7.visitorFunds());

        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor7);
        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor8);
        mixedEnclosure.removeVisitorIfTheyHaveMoney(visitor9);
        assertEquals(0, mixedEnclosure.countVisitors());
        assertEquals(5, mixedEnclosure.countCreatures());

        mixedEnclosure.resolveVisitorsInMixedEnclosureV2();
        assertEquals(3, mixedEnclosure.countCreatures());

        assertEquals(0, visitor7.visitorFunds());
        assertEquals(0, visitor8.visitorFunds());

        assertEquals(2, dragon5.countBelly());
    }

}
