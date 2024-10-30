package com.demo.math.horse;

/**
 * @author eversec
 * 二分查找算法学习
 * https://www.bilibili.com/video/BV1Lv4y1e7HL?p=2&vd_source=c75ed670f9aabc15636833bc2cc0b3d7
 * 计算机 二进制默认采取最高位是符号位。https://blog.csdn.net/qq_25439881/article/details/107509416
 * 正常二进制是没有符号位的说法，因为计算机只能计算加法，没发设计减法，所以才引入了反码和补码操作
 * 原码=最高符号位+数值位     (表示正数)
 * 反码=最高符号位不变 + 数值位取反
 * 补码= 反码+1(逢二进一)    (表示负数)
 *
 * 比如：1111_1111  1符号位 7位数值先求反码
 *      0000 0001  -1
 *      1111 1110  反码==>转原码
 *      1000 0001  最高位符号位表示负数 -1。所以能得出1111_1111 在计算式内是表示-1的二进制
 */
public class BinarySearch {

    /**
     * 需求：在有序数组A中，查找值target，如果找到返回索引，找不到返回-1
     * */
    public static void main(String[] args) {
        //1必须保证有序数组：假定升序排列，A0 <= A1 <= ....An
        int[] array = {2,4,5,14,22,30,30,31,38,42,53,63,69,76,85,99};
        System.out.println(getIndex(array,31));
    }


    public static int getIndex(int[] nums,int target){
        //2 假设2个值i,j 分别指向数组的头尾。也就是索引0，索引最大值
        int i = 0, j = nums.length-1;
        //3 二分法核心就是目标找到数组的中间值比较，如果小于就表明值确定了某一个范围的区间，然后把区间角标在确定
        while (i<=j){
            int numIndex = (i+j) >>> 1;  //  (i+j)/2一样等于除以2,但是直接i+j在Java层面会如果数组超过了int的最大值会变成负数  为什么？ https://www.bilibili.com/video/BV1Lv4y1e7HL?p=5&vd_source=c75ed670f9aabc15636833bc2cc0b3d7
            if(target < nums[numIndex]){
                j = numIndex - 1;
            }else if(target > nums[numIndex]){
                i = numIndex + 1;
            }else{
                return numIndex;
            }
        }
        return -1;
    }

}
