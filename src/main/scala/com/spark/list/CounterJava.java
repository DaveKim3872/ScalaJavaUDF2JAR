package com.spark.list;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import scala.Serializable;

public class CounterJava implements Serializable{
    final ConcurrentMap<Integer, Integer> counts = new ConcurrentHashMap<>();

    public void put(int it) {
        add(it, 1);
    }

    public void add(int it, int v) {
        counts.merge(it, v, Integer::sum);
    }

    public static int[] stringToIntegerArray(String str) {
        String[] s1 = str.replaceAll("\\[", "").replaceAll("]", "").split(",");
        return Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
    }

    public List<Integer> mostCommon(int n) {
        return counts.entrySet().stream()
                // Sort by value.
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                // Top n.
                .limit(n)
                // Keys only.
                .map(Map.Entry::getKey)
                // As a list.
                .collect(Collectors.toList());
    }

    public ConcurrentMap<Integer, Integer> getCounts() {
        return counts;
    }

    public Map<Integer, Integer> getSortedMaps() {
        return counts.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Integer, Integer> countIntList(String list_str) {
        int[] l = stringToIntegerArray(list_str);
        CounterJava c = new CounterJava();
        for (int j : l) {
            c.put(j);
        }
        return c.getSortedMaps();
    }
}
