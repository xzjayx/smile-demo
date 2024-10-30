package com.demo.math.horse;





/**
 * 1、⼆路归并
 * 实现⼀个merge函数 ，功能是将两个有序数组 ，将它们合并成⼀个有序数组
 * 输⼊： [1,2,3,7,9] ， [2,4,6]
 * 输出： [1,2,2,3,4,6,7,9]
 *
 * */
public class MergeSort {



    public static void main(String[] args) {
        int[] arr1 = {1,2,3,7,9};
        int[] arr2 = {2,4,6};
        int[] merge = merge(arr1, arr2);
        System.out.println(merge);



    }

    public static int[] merge(int[] arr1,int[] arr2){
        int[] arr = new int[arr1.length+arr2.length];
        if(arr1.length == 0 || arr2.length == 0){
            return arr;
        }
        //思路合并比较大小，用双指针执行。左边的数据指针，和后边的数组指针。
        int beginA = 0;
        int beginB = 0;
        int index = 0;
        while (beginA < arr1.length && beginB<arr2.length){
            if (arr1[beginA] <= arr2[beginB]){
                arr[index] = arr1[beginA];
                beginA++;
                index++;
            }else {
                arr[index] = arr2[beginB];
                beginB++;
                index++;
            }
        }
        //有可能某个数据还没有额外的元素
        while(beginA < arr1.length){
            arr[index] = arr1[beginA];
            beginA++;
            index++;
        }
        while(beginB<arr2.length){
            arr[index] = arr2[beginB];
            beginB++;
            index++;
        }
        return arr;
    }

}
