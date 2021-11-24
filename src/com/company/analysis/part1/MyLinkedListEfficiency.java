package com.company.analysis.part1;

import com.company.analysis.EfficiencyAnalyzer;
import com.company.analysis.part2.ListEfficiency;
import com.company.list.MyLinkedList;

import java.util.LinkedList;

public class MyLinkedListEfficiency extends EfficiencyAnalyzer {

    public static void main(String[] args) {
        LinkedList<Integer> x = getRange(1000, 100000, 1000);
        System.out.println("x = " + x);
        LinkedList<Double> y1AddEnd = getTimeOfAdd(x, new MyLinkedList<>(), 1);
        LinkedList<Double> y2AddEnd = ListEfficiency.getTimeOfAdd(x, new LinkedList<>(), 1);
        System.out.println("y1AddEnd = " + y1AddEnd);
        System.out.println("y2AddEnd = " + y2AddEnd);

        LinkedList<Double> y1AddBegin = getTimeOfAdd(x, new MyLinkedList<>(), 0);
        LinkedList<Double> y2AddBegin = ListEfficiency.getTimeOfAdd(x, new LinkedList<>(), 0);
        System.out.println("y1AddBegin = " + y1AddBegin);
        System.out.println("y2AddBegin = " + y2AddBegin);

        LinkedList<Double> y1AddMiddle = getTimeOfAdd(x, new MyLinkedList<>(), 0.5);
        LinkedList<Double> y2AddMiddle = ListEfficiency.getTimeOfAdd(x, new LinkedList<>(), 0.5);
        System.out.println("y1AddMiddle = " + y1AddMiddle);
        System.out.println("y2AddMiddle = " + y2AddMiddle);

        LinkedList<Double> y1Get = getTimeOfGet(x, new MyLinkedList<>());
        LinkedList<Double> y2Get = ListEfficiency.getTimeOfGet(x, new LinkedList<>());
        System.out.println("y1Get = " + y1Get);
        System.out.println("y2Get = " + y2Get);


        LinkedList<Double> y2Remove = ListEfficiency.getTimeOfRemove(x, new LinkedList<>());
        LinkedList<Double> y1Remove = getTimeOfRemove(x, new MyLinkedList<>());
        System.out.println("y1Remove = " + y1Remove);
        System.out.println("y2Remove = " + y2Remove);

    }

    private static LinkedList<Double> getTimeOfAdd(LinkedList<Integer> x, MyLinkedList<Integer> list, double indexCoef) {
        LinkedList<Double> times = new LinkedList<>();
        long start, stop;
        for (Integer numberOfElems : x) {
            fillList(list, numberOfElems);
            start = System.nanoTime();
            for (int i = 0; i < NUMBER_OF_OPERATIONS; i++) {
                list.add((int)(list.size() * indexCoef), random.nextInt());
            }
            stop = System.nanoTime();
            times.add(calculateAvgTime(start,stop));
            list.clear();
        }
        return times;
    }

    private static LinkedList<Double> getTimeOfGet(LinkedList<Integer> x, MyLinkedList<Integer> list) {
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

    private static LinkedList<Double> getTimeOfRemove(LinkedList<Integer> x, MyLinkedList<Integer> list) {
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

    private static void fillList(MyLinkedList<Integer> list, int numOfElems) {
        for (int i = 0; i < numOfElems; i++) {
            list.add(random.nextInt());
        }
    }
}
