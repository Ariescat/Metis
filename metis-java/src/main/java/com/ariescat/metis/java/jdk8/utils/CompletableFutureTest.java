package com.ariescat.metis.java.jdk8.utils;

import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author Ariescat
 * @version 2021/2/24
 */
public class CompletableFutureTest {

    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();

    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t) / 1000 + " seconds");
        return rand.nextInt(1000);
    }

    public static void main(String[] args) throws Exception {
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureTest::getMoreData);
//        Future<Integer> f = future.whenComplete((v, e) -> {
//            System.out.println(v);
//            System.out.println(e);
//        });
//        System.out.println(f.get());
//        System.in.read();

        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> Strings.toRootUpperCase(s)))
                .collect(Collectors.toList());
        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
            if (th == null) {
                System.err.println(res);
            }
        });
    }
}
