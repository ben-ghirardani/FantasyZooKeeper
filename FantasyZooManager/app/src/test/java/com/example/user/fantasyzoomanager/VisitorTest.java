package com.example.user.fantasyzoomanager;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 10/08/2017.
 */

public class VisitorTest {

    Visitor visitor;

    @Before
    public void before() { visitor = new Visitor("Clive", 10); }

    @Test
    public void canGetVisitorFunds() {
        assertEquals(10, visitor.showVisitorFunds());
    }

    @Test
    public void canGetVisitorName() {
        assertEquals("Clive", visitor.showVisitorName());
    }

}
