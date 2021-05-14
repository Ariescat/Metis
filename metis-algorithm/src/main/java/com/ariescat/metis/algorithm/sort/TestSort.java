package com.ariescat.metis.algorithm.sort;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ariescat
 * @version 2020/11/3 17:36
 */
public class TestSort {

    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(5, 7, 3, 9, 2, 13, 17, 15, 8);
        List<Integer> list2 = Lists.newArrayList(5, 7, 3, 9, 2, 13, 17, 15, 8);
        List<Integer> list3 = Lists.newArrayList(5, 7, 3, 9, 2, 13, 17, 15, 8);
        List<Integer> list4 = Lists.newArrayList(5, 7, 3, 9, 2, 13, 17, 15, 8);
        List<Integer> list5 = Lists.newArrayList(5, 7, 3, 9, 2, 13, 17, 15, 8);
        Iterable<Integer> concat = Iterables.concat(list1, list2, list3, list4, list5);
        ArrayList<Integer> integers = Lists.newArrayList(concat);
        Arrays.sort(integers.toArray());
    }
}
