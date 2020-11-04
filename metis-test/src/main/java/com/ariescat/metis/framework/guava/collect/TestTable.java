package com.ariescat.metis.framework.guava.collect;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

/**
 * @author Ariescat
 * @version 2020/11/3 11:56
 */
public class TestTable {

    public static void main(String[] args) {
        Table<Integer, Integer, Integer> table1 = Tables.newCustomTable(Maps.newConcurrentMap(), Maps::newConcurrentMap);

        ImmutableTable.Builder<Integer, Integer, Integer> builder = ImmutableTable.builder();
        ImmutableTable<Integer, Integer, Integer> table2 = builder.build();
    }
}
