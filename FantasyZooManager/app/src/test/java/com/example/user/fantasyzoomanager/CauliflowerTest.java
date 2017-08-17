package com.example.user.fantasyzoomanager;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 16/08/2017.
 */

public class CauliflowerTest {

    Cauliflower cauliflower;

    @Before
    public void before() {
        cauliflower = new Cauliflower("Cauliflower");
    }

    @Test
    public void checkThatThisCauliflowerIsACarrot() {
        assertEquals("Cauliflower", cauliflower.getType());
    }




}
