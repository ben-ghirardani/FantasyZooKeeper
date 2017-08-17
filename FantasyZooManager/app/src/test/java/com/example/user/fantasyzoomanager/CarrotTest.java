package com.example.user.fantasyzoomanager;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 16/08/2017.
 */

public class CarrotTest {

    Carrot carrot;

    @Before
    public void before() {
        carrot = new Carrot("Carrot");
    }

    @Test
    public void checkThatThisCarrotIsACarrot() {
        assertEquals("Carrot", carrot.getType());
    }




}