/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.internship;

import java.util.Random;

/**
 *
 * @author Natthaphon Phanit <kekhuay@e-mail.ph>
 */
public class NoUseThread {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int max = 100000000;
        int[] array = new int[max];
        Random generator = new Random();
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(max);
        }
        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Max value = " + maxValue);
        System.out.println("Overall time = " + duration / 1000000);
    }
}
