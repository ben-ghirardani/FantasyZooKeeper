package com.example.user.fantasyzoomanager;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by user on 11/08/2017.
 */

public class UnicornTest {

    Unicorn unicorn;
    Visitor visitor1;
    Carrot carrot;

    @Before
    public void before() {
        unicorn = new Unicorn (8, false, "Larry", "Unicorn", "Carrot");
        visitor1 = new Visitor ("Frank", 10, 5, false);
        carrot = new Carrot("Carrot");
    }


    @Test
    public void checkIfPredator() {
        assertEquals(false, unicorn.isPredator());
    }

    @Test
    public void canGetAgility() {
        assertEquals(8, unicorn.getAgility());
    }

    @Test
    public void canGetName() {
        assertEquals("Larry", unicorn.getName());
    }

    @Test
    public void canGetType() {
        assertEquals("Unicorn", unicorn.getType());
    }

    @Test
    public void checkBellyContents() {
        assertEquals(0, unicorn.countBelly());
    }

    @Test
    public void unicornCanEat() {
        unicorn.addToBelly(carrot);
        assertEquals(1, unicorn.countBelly());
    }

    @Test
    public void unicornCanEmptyBelly() {
        unicorn.addToBelly(carrot);
        unicorn.removeFromBelly(carrot);
        assertEquals(0, unicorn.countBelly());
    }

    @Test
    public void canGetVegChoice() {
        assertEquals("Carrot", unicorn.getVegChoice());
    }


//    This test was to ensure the Unicorn ArrayList belly couldn't accept the wrong type, but the
//    test won't even run as the Visitor class isn't accepted, which is expected behaviour.

//    @Test
//    public void checkUnicornIsVegetarian() {
//        unicorn.addToBelly(visitor1);
//        assertEquals(0, unicorn.countBelly());
//    }

}
