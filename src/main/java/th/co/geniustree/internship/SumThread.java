/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.internship;

/**
 *
 * @author pramoth
 */
public class SumThread extends Thread {

    private int[] array;
    private long duration=0;

    public SumThread(int[] array) {
        this.array = array;
    }

    public void run() {
        long startTime = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        long endTime = System.nanoTime();
        duration = endTime - startTime;
    }
    public long getDuration(){
        return duration;
    }
    
}
