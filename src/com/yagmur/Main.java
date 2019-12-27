package com.yagmur;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;


// Your program will accept two separate unsorted input files of
// numbers with equal number of lines as input. Each number is
// separated by EOL. Load first file into a LinkedList and then load
// second file into a LinkedList. Compute the pairwise product of the
// elements of these two lists. Then do the same for Queue. Compare the
// time spent for two data structures

public class Main {

    public static void main(String[] args) {
        File int_of_files = new File(args[0]);
        File int_of_files_second = new File(args[1]);
        System.out.println("... files are accepted!");

        LinkedList<Integer> linkedList_first = linkedListGenerator(int_of_files);
        LinkedList<Integer> linkedList_second = linkedListGenerator(int_of_files_second);
        System.out.println("... added into linked list!");


        Queue<Integer> queue_first = queueGenerator(int_of_files);
        Queue<Integer> queue_second = queueGenerator(int_of_files_second);
        System.out.println("... added into queue!");

        long start = System.currentTimeMillis();
        computePairwise(linkedList_first, linkedList_second);
        long end = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds spend for  linked list to calculate pairwise product");

        long start2 = System.currentTimeMillis();
        computePairwise(queue_first, queue_second);
        long end2 = System.currentTimeMillis();
        //finding the time difference and converting it into seconds
        float sec2 = (end2 - start2) / 1000F;
        System.out.println(sec2 + " seconds spend for  queue to calculate pairwise product");

    }


    private static LinkedList<Integer> linkedListGenerator(File file) {

        BufferedReader in;
        LinkedList<Integer> linkedList = new LinkedList<>();
        try {
            in = new BufferedReader(new FileReader(file));
            String read;
            while ((read = in.readLine()) != null) {
                String[] splited =  read.split("\\s+");
                for (String part : splited) {
                    linkedList.add(Integer.parseInt(part));

                }
            }
        } catch (Exception e) {
            System.out.println("There was a problem: " + e);
            e.printStackTrace();
        }

        return linkedList ;
    }

    public static Queue<Integer> queueGenerator(File file) {

        BufferedReader in;
        Queue<Integer> queue = new LinkedList<>();

        try {
            in = new BufferedReader(new FileReader(file));
            String read;
            while ((read = in.readLine()) != null) {
                String[] splited =  read.split("\\s+");
                for (String part : splited) {
                    queue.add(Integer.parseInt(part));
                }
            }
        } catch (Exception e) {
            System.out.println("There was a problem: " + e);
            e.printStackTrace();
        }
        return queue ;
    }

    private static ArrayList<Integer> computePairwise(LinkedList<Integer> list_one , LinkedList<Integer> list_two) {
        Iterator<Integer> iterator = list_one.iterator();
        Iterator<Integer> iterator2 = list_two.iterator();
        int pairwise_result;
        ArrayList<Integer> d = new ArrayList<>();

        while(iterator.hasNext()) {
            Integer num = iterator.next();
            Integer num2 = iterator2.next();
            pairwise_result = num * num2;
            d.add(pairwise_result);
        }
        return  d;
    }

    private static ArrayList<Integer> computePairwise(Queue<Integer> list_one , Queue<Integer> list_two) {
        Iterator<Integer> iterator = list_one.iterator();
        Iterator<Integer> iterator2 = list_two.iterator();
        int pairwise_result;
        ArrayList<Integer> d = new ArrayList<>();

        while(iterator.hasNext()) {
            Integer num = iterator.next();
            Integer num2 = iterator2.next();
            pairwise_result = num * num2;
            d.add(pairwise_result);
        }
        return  d;
    }
}
