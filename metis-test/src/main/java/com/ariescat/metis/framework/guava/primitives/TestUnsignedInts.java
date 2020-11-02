package com.ariescat.metis.framework.guava.primitives;

import com.google.common.primitives.UnsignedInts;

/**
 * @author Ariescat
 * @version 2020/11/2 17:21
 */
public class TestUnsignedInts {

    public static void main(String[] args) {
        int min = UnsignedInts.min(0xffff_ffff, 0xffff_fffe, 0xffff_fff1, 1, 5);
//                                        0x7fff_ffff, 0x7fff_fffe, 0x7fff_fff1, 0x8000_0001, 0x8000_0005);
        System.out.println("min:" + min);

        System.out.println(0xffff_ffff + " -> " + 0x7fff_ffff);
        System.out.println(0xffff_fffe + " -> " + 0x7fff_fffe);
        System.out.println(0xffff_fff1 + " -> " + 0x7fff_fff1);
        System.out.println(1 + " -> " + 0x8000_0001);
        System.out.println(5 + " -> " + 0x8000_0005);
    }
}
