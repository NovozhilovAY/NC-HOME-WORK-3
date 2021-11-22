package com.company;

import com.company.list.MyLinkedList;
import com.company.point.MyPoint;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.indexOf(15));
        list.add(4, 9);
        list.add(5, 10);
        list.add(0, 11);
        list.add(1, 12);
        list.set(0, 55);
        list.add(0, 1);
        list.add(0, 2);
        list.remove(0);
        list.remove(2);

        for (Integer integer : list) {
            System.out.println(integer);
        }


        Object[] array = list.toArray();
        Integer[] array2 = list.toArray(new Integer[8]);

        for (Object val : array) {
            System.out.print(val + " ");
        }
        System.out.println(Arrays.toString(array2));

        for (int i = 0; list.size() > 0;i++) {
            list.remove(0);
        }
        System.out.println("===========================================");

        MyLinkedList<MyPoint> points = new MyLinkedList<>();
        System.out.println(points);
        points.add(new MyPoint());
        System.out.println(points);
        points.add(new MyPoint());
        points.add(new MyPoint(1,2));
        points.add(new MyPoint(3,4));
        System.out.println(points);
        points.add(1, new MyPoint(5,5));
        System.out.println(points);
        System.out.println(points.get(4));
        System.out.println(points.indexOf(new MyPoint(1,2)));
        System.out.println(points.remove(0));
        System.out.println(points);
        System.out.println(points.set(1, new MyPoint(6, 6)));
        System.out.println(points);
        System.out.println(points.size());
        System.out.println(Arrays.toString(points.toArray(new MyPoint[4])));


    }

}
