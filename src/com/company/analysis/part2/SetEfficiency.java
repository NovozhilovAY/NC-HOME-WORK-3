package com.company.analysis.part2;

import com.company.analysis.EfficiencyAnalyzer;

import java.util.*;

public class SetEfficiency extends EfficiencyAnalyzer {
    private static final int MAX = 1000000;
    public static void main(String[] args) {
        LinkedList<Integer> x = getRange(1000, 100000, 1000);
        LinkedList<Double> y1Add = getTimeOfAdd(new HashSet<>(), x);
        LinkedList<Double> y2Add = getTimeOfAdd(new LinkedHashSet<>(), x);
        LinkedList<Double> y3Add = getTimeOfAdd(new TreeSet<>(), x);
        System.out.println("x = " + x);
        System.out.println("y1Add = " + y1Add);
        System.out.println("y2Add = " + y2Add);
        System.out.println("y3Add = " + y3Add);

        LinkedList<Double> y3Contains = getTimeOfContains(new TreeSet<>(), x);
        LinkedList<Double> y2Contains = getTimeOfContains(new LinkedHashSet<>(), x);
        LinkedList<Double> y1Contains = getTimeOfContains(new HashSet<>(), x);
        System.out.println("x = " + x);
        System.out.println("y1Contains = " + y1Contains);
        System.out.println("y2Contains = " + y2Contains);
        System.out.println("y3Contains = " + y3Contains);

        LinkedList<Double> y3Remove = getTimeOfRemove(new TreeSet<>(), x);
        LinkedList<Double> y2Remove = getTimeOfRemove(new LinkedHashSet<>(), x);
        LinkedList<Double> y1Remove = getTimeOfRemove(new HashSet<>(), x);
        System.out.println("y1Remove = " + y1Remove);
        System.out.println("y2Remove = " + y2Remove);
        System.out.println("y3Remove = " + y3Remove);
    }

    private static LinkedList<Double> getTimeOfAdd(Set<Integer> set, LinkedList<Integer> x) {
        LinkedList<Double> times = new LinkedList<>();
        for (Integer numOfElems : x) {
            fillSet(set, numOfElems);
            long start = System.nanoTime();
            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
                set.add(random.nextInt(MAX));
            }
            long stop = System.nanoTime();
            times.add(calculateAvgTime(start,stop));
            set.clear();
        }
        return times;
    }

    private static LinkedList<Double> getTimeOfContains(Set<Integer> set, LinkedList<Integer> x) {
        LinkedList<Double> times = new LinkedList<>();
        for (Integer numOfElems : x) {
            fillSet(set, numOfElems);
            long start = System.nanoTime();
            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++){
                set.contains(random.nextInt(MAX));
            }
            long stop = System.nanoTime();
            times.add(calculateAvgTime(start,stop));
            set.clear();
        }
        return times;
    }

    private static LinkedList<Double> getTimeOfRemove(Set<Integer> set, LinkedList<Integer> x) {
        LinkedList<Double> times = new LinkedList<>();
        for (Integer numOfElems : x) {
            fillSet(set, numOfElems);
            long start = System.nanoTime();
            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++){
                set.remove(random.nextInt(MAX));
            }
            long stop = System.nanoTime();
            times.add(calculateAvgTime(start,stop));
            set.clear();
        }
        return times;
    }

    private static void fillSet(Set<Integer> set, int numElements) {
        for (int i = 0; i < numElements; i++) {
            set.add(random.nextInt(MAX));
        }
    }
}
