package com.company;

import com.company.list.MyLinkedList;

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

        //System.out.println(list.indexOf(228));

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

        /*for (int i = 0; list.size() > 0;i++) {
            list.remove(0);
        }*/
        Object[] array = list.toArray();
        Integer[] array2 = list.toArray(new Integer[8]);

        for (Object val : array) {
            System.out.print(val + " ");
        }
        System.out.println(Arrays.toString(array2));


        //list.getNode(2);



    }

}
