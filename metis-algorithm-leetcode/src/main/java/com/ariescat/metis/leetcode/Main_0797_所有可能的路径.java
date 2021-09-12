package com.ariescat.metis.leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 *
 * @date 2021-08-25
 */
public class Main_0797_所有可能的路径 {

    public static void main(String[] args) {
        Main_0797_所有可能的路径 main = new Main_0797_所有可能的路径();
        System.err.println(main.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        System.err.println(main.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
        System.err.println(main.allPathsSourceTarget(new int[][]{{1}, {}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(graph);
//        return bfs(graph);
    }

    // dfs
    public List<List<Integer>> dfs(int[][] graph) {
        List<List<Integer>> retList = new ArrayList<>();

        LinkedList<Integer> curWalk = new LinkedList<>();
        curWalk.add(0);

        dfs0(graph, 0, curWalk, retList);

        return retList;
    }

    public void dfs0(int[][] graph, int dfsIndex, LinkedList<Integer> curWalk, List<List<Integer>> retList) {
        int end = graph.length - 1;
//        if (!curWalk.isEmpty() && curWalk.peekLast().equals(end)) {
        if (dfsIndex == end) {
            retList.add(new ArrayList<>(curWalk));
            return;
        }
        for (int to : graph[dfsIndex]) {
            curWalk.offer(to);
            dfs0(graph, to, curWalk, retList);
            curWalk.pollLast();
        }
    }

    // bfs
    public List<List<Integer>> bfs(int[][] graph) {
        List<List<Integer>> retList = new ArrayList<>();

        int end = graph.length - 1;

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Collections.singletonList(0));
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            Integer lastElement = poll.get(poll.size() - 1);
            if (lastElement == end) {
                retList.add(poll);
                continue;
            }
            for (int to : graph[lastElement]) {
                List<Integer> newList = new ArrayList<>(poll.size() + 1);
                newList.addAll(poll);
                newList.add(to);
                queue.offer(newList);
            }
        }
        return retList;
    }
}
