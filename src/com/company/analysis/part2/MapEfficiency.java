package com.company.analysis.part2;

import com.company.analysis.EfficiencyAnalyzer;

import java.util.*;

public class MapEfficiency extends EfficiencyAnalyzer {
    private static final int MAX = 1000000;

    public static void main(String[] args) {
        LinkedList<Integer> x = getRange(1000, 100000, 1000);
        LinkedList<Double> y1Add = getTimeOfPut(new HashMap<Integer, Integer>(), x);
        LinkedList<Double> y2Add = getTimeOfPut(new LinkedHashMap<Integer, Integer>(), x);
        LinkedList<Double> y3Add = getTimeOfPut(new TreeMap<Integer, Integer>(), x);
        System.out.println("x = " + x);
        System.out.println("y1Add = " + y1Add);
        System.out.println("y2Add = " + y2Add);
        System.out.println("y3Add = " + y3Add);

        LinkedList<Double> y1Get = getTimeOfGet(new HashMap<Integer, Integer>(), x);
        LinkedList<Double> y2Get = getTimeOfGet(new LinkedHashMap<Integer, Integer>(), x);
        LinkedList<Double> y3Get = getTimeOfGet(new TreeMap<Integer, Integer>(), x);
        System.out.println("y1Get = " + y1Get);
        System.out.println("y2Get = " + y2Get);
        System.out.println("y3Get = " + y3Get);

        LinkedList<Double> y1Rem = getTimeOfRemove(new HashMap<Integer, Integer>(), x);
        LinkedList<Double> y2Rem = getTimeOfRemove(new LinkedHashMap<Integer, Integer>(), x);
        LinkedList<Double> y3Rem = getTimeOfRemove(new TreeMap<Integer, Integer>(), x);
        System.out.println("y1Rem = " + y1Rem);
        System.out.println("y2Rem = " + y2Rem);
        System.out.println("y3Rem = " + y3Rem);

    }


    public static LinkedList<Double> getTimeOfRemove(Map<Integer, Integer> map, LinkedList<Integer> x) {
        LinkedList<Double> times = new LinkedList<>();
        for (Integer numOfElems : x) {
            fillMap(map, numOfElems);
            long start = System.nanoTime();
            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
                map.remove(random.nextInt(MAX));
            }
            long stop = System.nanoTime();
            times.add(calculateAvgTime(start, stop));
            map.clear();
        }
        return times;
    }

    public static LinkedList<Double> getTimeOfGet(Map<Integer, Integer> map, LinkedList<Integer> x) {
        LinkedList<Double> times = new LinkedList<>();
        for (Integer numOfElems : x) {
            fillMap(map, numOfElems);
            long start = System.nanoTime();
            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
                map.get(random.nextInt(MAX));
            }
            long stop = System.nanoTime();
            times.add(calculateAvgTime(start, stop));
            map.clear();
        }
        return times;
    }


    public static LinkedList<Double> getTimeOfPut(Map<Integer, Integer> map, LinkedList<Integer> x) {
        LinkedList<Double> times = new LinkedList<>();
        for (Integer numOfElems : x) {
            fillMap(map, numOfElems);
            long start = System.nanoTime();
            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
                map.put(random.nextInt(MAX), random.nextInt());
            }
            long stop = System.nanoTime();
            times.add(calculateAvgTime(start, stop));
            map.clear();
        }
        return times;
    }

    public static void fillMap(Map<Integer, Integer> map, int numElements) {
        for (int i = 0; i < numElements; i++) {
            map.put(random.nextInt(MAX), random.nextInt());
        }
    }

}
