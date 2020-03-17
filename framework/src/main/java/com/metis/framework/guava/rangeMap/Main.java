package com.metis.framework.guava.rangeMap;

import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import com.metis.framework.guava.immutable.TestImmutableMap;

public class Main {


    public static void main(String[] args) {
//        testTreeMap();
        testImmutableRangeMap();
    }

    /**
     * ImmutableRangeMap 由 List 实现，get 则采用二分查找
     * TODO 这里的二分查找有点东西，有空看看
     *
     * @see TestImmutableMap#main 看到这里了，顺便看看ImmutableMap吧
     */
    private static void testImmutableRangeMap() {
        ImmutableRangeMap.Builder<Comparable<Integer>, Integer> builder = ImmutableRangeMap.builder();
        builder.put(Range.closed(1, 3), 444);
        builder.put(Range.closed(5, 10), 555);
        builder.put(Range.closed(7, 8), 666);
        ImmutableRangeMap<Comparable<Integer>, Integer> rangeMap = builder.build();
        System.err.println(rangeMap);

        System.err.println(rangeMap.get(9));
    }

    /**
     * TreeRangeMap 由TreeMap的NavigableMap实现
     */
    public static void testTreeMap() {
        RangeMap<Integer, Integer> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 3), 111);
        rangeMap.put(Range.closed(5, 10), 222);
        rangeMap.put(Range.closed(7, 8), 333);
        System.err.println(rangeMap);

        System.err.println(rangeMap.get(9));
    }
}
