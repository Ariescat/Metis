package com.ariescat.metis.base.operator;

import java.math.BigInteger;

/**
 * @author Ariescat
 * @version 2020/6/8 16:15
 */
public class Test {

    public static void main(String[] args) {
        /*
         * java.util.BitSet.wordIndex
         * 这里相当于除以64
         */
        System.err.println(64 >> 6);

        /*
         * 将包含BigInteger的二进制补码表示形式的byte数组转换为BigInteger
         */
        System.err.println(new BigInteger(new byte[]{3, 2, 3}));
        System.err.println(3 * 256 * 256 + 2 * 256 + 3);
    }
}
