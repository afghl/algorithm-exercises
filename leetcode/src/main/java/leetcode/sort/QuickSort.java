package leetcode.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr1 = new int[] {2,6,5,3,9,20,25,14,15,13,17,16,18,11,10,2,8,4};
        int[] arr = new int[] {2,3};
        quickSort(arr);
//        quickSort(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    private static int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1, j = p;

        // 排序过程中维护两个区域，[p, i]都是比x小，[j, r - 2]为未排序的
        // 这里要考虑只有两个元素时，怎么样
        while (j <= r - 1) {
            // 如果找到一个比x小的，排到前面
            if (arr[j] <= x) {
                // 移动i的指针
                i = i + 1;
                // swap
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
            j = j + 1;
        }

        // 此时，i指向一个比x小的最右边值，此时交换x和i + 1指向的值
        arr[r] = arr[i + 1];
        arr[i + 1] = x;
        // 返回x的下标
        return i + 1;
    }
}
