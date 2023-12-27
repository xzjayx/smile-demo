package com.demo.test.math;

/**
 * @author :xiezhi
 * @date : 2023/11/27
 */
public class BubbleSort {


    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int[] arr = new int[80000];
        for(int i = 0; i<arr.length;i++){
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println(System.currentTimeMillis() - time);
        bubbleSort(arr);
        System.out.println(System.currentTimeMillis() - time);
    }


    public static void bubbleSort(int[] array){
        for(int i = 0;i<array.length-1;i++){
            for(int j = 0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
