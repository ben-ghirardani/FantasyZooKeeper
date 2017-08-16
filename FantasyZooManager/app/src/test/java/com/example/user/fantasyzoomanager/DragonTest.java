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
    Carrot carrot;

    @Before
    public void before() {
        dragon = new Dragon (15, true, "Chad", "Dragon");
        visitor1 = new Visitor ("Frank", 10, 5, false);
        carrot = new Carrot("Carrot");
    }

    @Test
    public void checkDragonCanRoar() {
        assertEquals("Rarrr!", dragon.dragonRoars());
    }

    @Test
    public void checkIfPredator() {
        assertEquals(true, dragon.isPredator());
    }

    @Test
    public void canGetAgility() {
        assertEquals(15, dragon.getAgility());
    }

    @Test
    public void canGetName() {
        assertEquals("Chad", dragon.getName());
    }

    @Test
    public void canGetType() {
        assertEquals("Dragon", dragon.getType());
    }

    @Test
    public void checkBellyContents() {
        assertEquals(0, dragon.countBelly());
    }

    @Test
    public void dragonCanEat() {
        dragon.addToBelly(visitor1);
        assertEquals(1, dragon.countBelly());
    }

    @Test
    public void dragonCanEmptyBelly() {
        dragon.addToBelly(visitor1);
        dragon.removeFromBelly(visitor1);
        assertEquals(0, dragon.countBelly());
    }


//    This test was to ensure the Dragon ArrayList belly couldn't accept the wrong type, but the
//    test won't even run as the Carrot class isn't accepted, which is expected behaviour.

//    @Test
//    public void checkDragonIsCarnivore() {
//        dragon.addToBelly(carrot);
//        assertEquals(0, dragon.countBelly());
//    }

}
