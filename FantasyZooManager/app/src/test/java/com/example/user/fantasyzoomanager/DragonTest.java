package com.example.user.fantasyzoomanager;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 13/08/2017.
 */

public class DragonTest {

    Dragon dragon;
    Visitor visitor1;

    @Before
    public void before() {
        dragon = new Dragon (15, true, "Chad", "Dragon");
        visitor1 = new Visitor ("Frank", 10, 5, false);
    }


    @Test
    public void checkIfPredator() {
        assertEquals(true, dragon.isPredator());
        System.out.println(dragon.isPredator());
    }

    @Test
    public void canGetAgility() {
        assertEquals(15, dragon.getAgility());
        System.out.println(dragon.getAgility());
    }

    @Test
    public void canGetName() {
        assertEquals("Chad", dragon.getName());
        System.out.println(dragon.getName());
    }

    @Test
    public void canGetType() {
        assertEquals("Dragon", dragon.getType());
        System.out.println(dragon.getType());
    }

    @Test
    public void checkBellyContents() {
        assertEquals(0, dragon.countBelly());
        System.out.println(dragon.countBelly());
    }

    @Test
    public void dragonCanEat() {
        dragon.addToBelly(visitor1);
        System.out.println(dragon.countBelly());
        assertEquals(1, dragon.countBelly());
    }

    @Test
    public void unicornCanEmptyBelly() {
        dragon.addToBelly(visitor1);
        System.out.println(dragon.countBelly());
        dragon.removeFromBelly(visitor1);
        System.out.println(dragon.countBelly());
        assertEquals(0, dragon.countBelly());
    }
}
