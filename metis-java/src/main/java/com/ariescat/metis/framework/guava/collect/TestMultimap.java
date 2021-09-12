package com.ariescat.metis.framework.guava.collect;

import com.google.common.collect.*;

/**
 * @author Ariescat
 * @version 2020/11/4 15:44
 */
public class TestMultimap {

    public static void main(String[] args) {
        HashMultimap<Integer, Integer> multimap = HashMultimap.create();
        fill(multimap);
        System.err.println(multimap);

        ArrayListMultimap<Integer, Integer> multimap1 = ArrayListMultimap.create();
        fill(multimap1);
        System.err.println(multimap1);

        Multimap<Integer, Integer> multimap2 = Multimaps.newMultimap(Maps.newHashMap(), Lists::newArrayList);
        fill(multimap2);
        System.err.println(multimap2);
    }

    private static void fill(Multimap<Integer, Integer> map) {
        map.put(315, 2);
        map.put(315, 3);
        map.put(315, 2);
        map.put(27, 3);
        map.put(3, 2);
        map.put(3, 3);
        map.put(18, 2);
        map.put(18, 3);
    }
}
