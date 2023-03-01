package com.crunch;

import org.junit.Test;

import static org.junit.Assert.*;

public class RadishTest {

    @Test
    public void getColor() {
        Radish radish = new Radish("red");
        assertNotEquals("blue", radish.getColor());
    }
}