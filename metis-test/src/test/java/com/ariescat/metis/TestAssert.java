package com.ariescat.metis;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ariescat
 * @version 2020/11/3 16:01
 */
public class TestAssert {

    @Test
    public void fun1() {
        System.err.println("fun1");
        Assert.fail();
    }
}
