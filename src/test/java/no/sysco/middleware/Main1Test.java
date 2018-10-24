/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sysco.middleware;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 100tsa
 */
public class Main1Test {

    public Main1Test() {
    }

    @Test
    public void testResultEquality() {
        String testString = "aa aaaaa aaaaaa aaaaaaa aaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        assertTrue(Main1.longestWordA(testString).equals(Main1.longestWordB(testString))
                && Main1.longestWordB(testString).equals(Main1.longestWordC(testString))
                && Main1.longestWordC(testString).equals(Main1.longestWordA(testString)));
    }

}
