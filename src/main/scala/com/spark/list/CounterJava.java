package com.spark.list;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import static com.spark.list.String2Array.*;
import scala.Serializable;

public class CounterJava implements Serializable{
    final ConcurrentMap<Double, Integer> counts = new ConcurrentHashMap<>();

    public void put(double it) {
        add(it, 1);
    }

    public void add(double it, int v) {
        counts.merge(it, v, Integer::sum);
    }

    public List<Double> mostCommon(int n) {
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

    public ConcurrentMap<Double, Integer> getCounts() {
        return counts;
    }

    public Map<Double, Integer> getSortedMaps() {
        return counts.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Double, Integer> countIntList(String list_str) {
        double[] l = stringToDoubleArray(list_str);
        CounterJava c = new CounterJava();
        for (double j : l) {
            c.put(j);
        }
        return c.getSortedMaps();
    }
}
