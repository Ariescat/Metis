package com.ariescat.metis.framework.guava.collect;

import com.google.common.collect.*;

import java.util.ArrayList;

/**
 * @author Ariescat
 * @version 2020/11/4 15:04
 */
public class TestMultiset {
    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(315, 27, 3, 18, 96);

        HashMultiset<Integer> multiset1 = HashMultiset.create(list);
        System.err.println(multiset1);

        LinkedHashMultiset<Integer> multiset2 = LinkedHashMultiset.create(list);
        System.err.println(multiset2);

        TreeMultiset<Integer> multiset3 = TreeMultiset.create(list);
        System.err.println(multiset3);

        ImmutableSortedMultiset<Integer> multiset4 = ImmutableSortedMultiset.copyOf(list);
        System.err.println(multiset4);

        ImmutableMultiset<Integer> multiset5 = ImmutableMultiset.copyOf(list);
        System.err.println(multiset5);
    }
}
