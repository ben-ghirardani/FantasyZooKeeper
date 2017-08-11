package com.example.user.fantasyzoomanager;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by user on 11/08/2017.
 */

public class UnicornTest {

    Unicorn unicorn;

    @Before
    public void before() { unicorn = new Unicorn ("Larry", "Unicorn"); }

    @Test
    public void canGetName() {
        assertEquals("Larry", unicorn.getName());
    }

    @Test
    public void canGetType() {
        assertEquals("Unicorn", unicorn.getType());
    }

}
