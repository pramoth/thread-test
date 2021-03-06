/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.internship;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author pramoth
 */
public class SumWithThread {

    public static final int THREAD_COUNT = 10;
    public static final int MAX = 100000000;

    public static void main(String[] args) throws InterruptedException {
        int[] toArray = IntStream.rangeClosed(0, MAX).toArray();
        testWithThread(toArray);
        testWithSingleThread(toArray);
        testWithStreamParalell();
    }

    private static void testWithThread(int[] toArray) throws InterruptedException {
        SumThread[] sumThreads = new SumThread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            sumThreads[i] = new SumThread(toArray);
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            sumThreads[i].start();
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            sumThreads[i].join();
        }
        //---------------------------------------------------------------
        long sumOfDuration = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            System.out.println(sumThreads[i].getName() + " : " + sumThreads[i].getDuration());
            sumOfDuration += sumThreads[i].getDuration();
        }
        //---------------------------------------------------------------

        System.out.println("Overall time = " + sumOfDuration);
    }

    private static void testWithSingleThread(int[] array) {
        //---------------------------------------------------------------
        long startTime = System.nanoTime();
        for (int t = 0; t < THREAD_COUNT; t++) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
        }
        long endTime = System.nanoTime();
        //---------------------------------------------------------------
        long duration = endTime - startTime;
        System.out.println("Overall time = " + duration);
    }

    private static void testWithStreamParalell() {
        IntStream[] parallels = new IntStream[THREAD_COUNT];
        for (int t = 0; t < THREAD_COUNT; t++) {
            parallels[t] = IntStream.rangeClosed(0, MAX).parallel();
        }
        //---------------------------------------------------------------
        long startTime = System.nanoTime();
        for (int t = 0; t < THREAD_COUNT; t++) {
            parallels[t].sum();
        }
        long endTime = System.nanoTime();
        //---------------------------------------------------------------
        long duration = endTime - startTime;
        System.out.println("Overall time = " + duration);
    }
}
