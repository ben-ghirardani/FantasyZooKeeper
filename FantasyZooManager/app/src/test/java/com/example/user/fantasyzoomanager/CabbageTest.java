package com.example.user.fantasyzoomanager;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 16/08/2017.
 */

public class CabbageTest {

    Cabbage cabbage;

    @Before
    public void before() {
        cabbage = new Cabbage("Cabbage");
    }

    @Test
    public void checkThatThisCabbageIsACabbage() {
        assertEquals("Cabbage", cabbage.getType());
    }




}