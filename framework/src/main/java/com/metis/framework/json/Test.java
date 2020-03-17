package com.metis.framework.json;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Ariescat
 * @version 2020/3/12 16:11
 */
public class Test {

    public static void main(String[] args) {

        HashMap<Integer, MagicCircleItem> hashMap = new HashMap<Integer, MagicCircleItem>() {
            {
                put(1, new MagicCircleItem());
            }
        };
        Set<Map.Entry<Integer, MagicCircleItem>> entries = hashMap.entrySet();

        HashMap<Integer, MagicCircleItem> hashMap1 = new HashMap<>();
        hashMap1.put(1, new MagicCircleItem());
        Set<Map.Entry<Integer, MagicCircleItem>> entries1 = hashMap1.entrySet();

        System.err.println("--------------------- Gson ------------------------");
        System.err.println(new Gson().toJson(hashMap));
        System.err.println(new Gson().toJson(entries));

        System.err.println(new Gson().toJson(hashMap1));
        System.err.println(new Gson().toJson(entries1));

        System.err.println("--------------------- FastJson --------------------");
        System.err.println(JSON.toJSONString(entries));
//        System.err.println(JSON.toJSONString(hashMap));


        System.err.println("--------------------- A ---------------------------");

        A a = new A() {
            int a = 5;

            @Override
            public int getA() {
                return a;
            }

            @Override
            public int getB() {
                return 7;
            }
        };
        Set<A> set = Sets.newHashSet(a);
        System.err.println(new Gson().toJson(set));
        System.err.println(JSON.toJSONString(set));
    }

    interface A {
        int getA();
        int getB();
    }
}
