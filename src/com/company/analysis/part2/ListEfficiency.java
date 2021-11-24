package com.company.analysis.part2;

import com.company.analysis.EfficiencyAnalyzer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListEfficiency extends EfficiencyAnalyzer {
    public static void main(String[] args) {
        LinkedList<Integer> x = getRange(1000, 100000, 1000);
        System.out.println("x =  " + x);
        LinkedList<Double> y1Add = getTimeOfAdd(x, new ArrayList<>(), 0.5);
        LinkedList<Double> y2Add = getTimeOfAdd(x, new LinkedList<>(), 0.5);
        System.out.println("y1Add =  " + y1Add);
        System.out.println("y2Add =  " + y2Add);

        LinkedList<Double> y1AddEnd = getTimeOfAdd(x, new ArrayList<>(), 1);
        LinkedList<Double> y2AddEnd = getTimeOfAdd(x, new LinkedList<>(), 1);
        System.out.println("y1AddEnd =  " + y1AddEnd);
        System.out.println("y2AddEnd =  " + y2AddEnd);

        LinkedList<Double> y1AddBegin = getTimeOfAdd(x, new ArrayList<>(), 0);
        LinkedList<Double> y2AddBegin = getTimeOfAdd(x, new LinkedList<>(), 0);
        System.out.println("y1AddBegin =  " + y1AddBegin);
        System.out.println("y2AddBegin =  " + y2AddBegin);

        LinkedList<Double> y1Get = getTimeOfGet(x, new ArrayList<>());
        LinkedList<Double> y2Get = getTimeOfGet(x, new LinkedList<>());
        System.out.println("y1Get =  " + y1Get);
        System.out.println("y2Get =  " + y2Get);

        LinkedList<Double> y2Remove = getTimeOfRemove(x, new LinkedList<>());
        LinkedList<Double> y1Remove = getTimeOfRemove(x, new ArrayList<>());
        System.out.println("y1Remove = " + y1Remove);
        System.out.println("y2Remove = " + y2Remove);
    }

    public static LinkedList<Double> getTimeOfAdd(LinkedList<Integer> x, List<Integer> list, double indexCoef){
        LinkedList<Double> times = new LinkedList<>();
        long start, stop;
        for (Integer numberOfElems : x) {
            fillList(list, numberOfElems);
            start = System.nanoTime();
            for (int i = 0; i< NUMBER_OF_OPERATIONS; i++) {
                list.add((int)(list.size() * indexCoef), random.nextInt());
            }
            stop = System.nanoTime();
            times.add(calculateAvgTime(start,stop));
            list.clear();
        }
        return times;
    }

    public static LinkedList<Double> getTimeOfGet(LinkedList<Integer> x, List<Integer> list){
        LinkedList<Double> times = new LinkedList<>();
        long start, stop;
        for (Integer numberOfElems : x) {
            fillList(list, numberOfElems);
            start = System.nanoTime();
            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
                list.get(random.nextInt(list.size()));
            }
            stop = System.nanoTime();
            times.add(calculateAvgTime(start,stop));
            list.clear();
        }
        return times;
    }

    public static LinkedList<Double> getTimeOfRemove(LinkedList<Integer> x, List<Integer> list){
        LinkedList<Double> times = new LinkedList<>();
        long start, stop;
        for (Integer numberOfElems : x) {
            fillList(list, numberOfElems);
            start = System.nanoTime();
            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
                list.remove(random.nextInt(list.size()));
            }
            stop = System.nanoTime();
            times.add(calculateAvgTime(start,stop));
            list.clear();
        }
        return times;
    }

    public static void fillList(List<Integer> list, int numElements) {
        for (int i = 0; i < numElements; i++) {
            list.add(random.nextInt());
        }
    }
}
