package com.sam.testingexample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
/**
 * Unit test for simple App.
 */
class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    
    @Test
    public static void testAdd() {
    	Assertions.assertEquals(13.2, add(8.0,4.2));
    }

    private static Double add(double d, double e) {
		return d + e;
	}
}
