package com.metis.groovy.withJava;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

public class TestGroovy {

    public List<String> printArgs(String str1, String str2, String str3) {
        String jsonString = "[\"" + str1 + "\",\"" + str2 + "\",\"" + str3 + "\"]";
        return JSON.parseObject(jsonString, new TypeReference<List<String>>() {
        });

//        throw new RuntimeException("ttt");
    }

}
