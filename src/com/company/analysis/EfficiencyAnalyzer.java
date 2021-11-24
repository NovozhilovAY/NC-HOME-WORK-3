package com.company.analysis;

import java.util.LinkedList;
import java.util.Random;

public class EfficiencyAnalyzer {
    protected static final int NUMBER_OF_OPERATIONS = 1000;
    protected static Random random = new Random();

    protected static LinkedList<Integer> getRange(int start, int end, int step) {
        LinkedList<Integer> data = new LinkedList<>();
        for (int i = start; i <= end; i+=step) {
            data.add(i);
        }
        return data;
    }

    protected static double calculateAvgTime(long start, long stop) {
        return (stop - start) / 1000000.0  / NUMBER_OF_OPERATIONS;
    }
}
