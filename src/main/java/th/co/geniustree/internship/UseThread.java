/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.internship;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Natthaphon Phanit <kekhuay@e-mail.ph>
 */
public class UseThread {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int max = 100000000;
        int maxValue = Integer.MIN_VALUE;
        int[] myArray = new int[max];
        Random generator = new Random();
        for (int i = 0; i < max; i++) {
            myArray[i] = generator.nextInt(max);
            // System.out.println(myArray[i]);
        }
        int allThread = 4;
        MyThread[] threads = new MyThread[allThread];
        int len = myArray.length;
        for (int i = 0; i < allThread; i++) {
            threads[i] = new MyThread(Arrays.copyOfRange(myArray, i
                    * (len / allThread), (i + 1) * (len / allThread)));
        }
        for (int i = 0; i < allThread; i++) {
            threads[i].start();
        }
        try {
            for (int i = 0; i < allThread; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < allThread; i++) {
            System.out.println("Max value of " + threads[i].getName() + " = "
                    + threads[i].getMaxValue());
            if (maxValue < threads[i].getMaxValue()) {
                maxValue = threads[i].getMaxValue();
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Overall max value = " + maxValue);
        System.out.println("Overall time = " + duration / 1000000);
    }
}
