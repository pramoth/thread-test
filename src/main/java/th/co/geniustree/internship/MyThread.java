/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.internship;

/**
 *
 * @author Natthaphon Phanit <kekhuay@e-mail.ph>
 */
public class MyThread extends Thread {

    private int[] array;
    private int maxValue = Integer.MIN_VALUE;

    public MyThread(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public void run() {
        // System.out.println("Important job running in MyThread");
        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
    }
}
