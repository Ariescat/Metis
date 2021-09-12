package com.ariescat.metis.framework.guava.collect;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ariescat
 * @version 2020/11/3 12:37
 */
public class TestOrdering {

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(5, 9, 7, 2, 3);
        System.err.println(list);

        Collections.sort(list, Ordering.natural());
        System.err.println(list);

        // 返回一个副本
        // 注意 Lists.newArrayList(Arrays.asList(array)) 这里没有进行集合元素的深复制！！
        List<Integer> copyList1 = Ordering.natural().sortedCopy(list);

        // 包装一个ImmutableList （SingletonImmutableList / RegularImmutableList）
        List<Integer> copyList2 = Ordering.natural().immutableSortedCopy(list);

        List<Integer> listInt = Arrays.asList(1, 5, 3, 8, 2);
        Collections.sort(listInt, Ordering.usingToString());
        System.err.println(listInt);

        List<String> listString = Lists.newArrayList("wang", "test", "a");
        Collections.sort(listString, Ordering.usingToString());
        System.err.println(listString);

        List<String> listLex1 = Lists.newArrayList("wang", "a", "e");
        List<String> listLex2 = Lists.newArrayList("wang", "b", "e");
        List<String> listLex3 = Lists.newArrayList("li", "c", "e");
        List<List<String>> listLex = Lists.newArrayList(listLex1, listLex2, listLex3);
        Collections.sort(listLex, Ordering.natural().lexicographical());
        System.err.println(listLex);
    }
}
