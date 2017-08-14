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

    @Before
    public void before() {
        unicorn = new Unicorn (8, false, "Larry", "Unicorn");
        visitor1 = new Visitor ("Frank", 10, 5, false);
    }


    @Test
    public void checkIfPredator() {
        assertEquals(false, unicorn.isPredator());
        System.out.println(unicorn.isPredator());
    }

    @Test
    public void canGetAgility() {
        assertEquals(8, unicorn.getAgility());
        System.out.println(unicorn.getAgility());
    }

    @Test
    public void canGetName() {
        assertEquals("Larry", unicorn.getName());
        System.out.println(unicorn.getName());
    }

    @Test
    public void canGetType() {
        assertEquals("Unicorn", unicorn.getType());
        System.out.println(unicorn.getType());
    }

    @Test
    public void checkBellyContents() {
        assertEquals(0, unicorn.countBelly());
        System.out.println(unicorn.countBelly());
    }

    @Test
    public void unicornCanEat() {
        unicorn.addToBelly(visitor1);
        System.out.println(unicorn.countBelly());
        assertEquals(1, unicorn.countBelly());
    }

    @Test
    public void unicornCanEmptyBelly() {
        unicorn.addToBelly(visitor1);
        System.out.println(unicorn.countBelly());
        unicorn.removeFromBelly(visitor1);
        System.out.println(unicorn.countBelly());
        assertEquals(0, unicorn.countBelly());
    }

}
