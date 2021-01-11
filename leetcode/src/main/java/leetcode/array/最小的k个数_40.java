package leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * easy
 */
public class 最小的k个数_40 {

//    public int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = arr[i];
//        }
//        return result;
//    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);

        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        int[] result = new int[k];
        int count = 0;
        for (Integer num : pq) {
            result[count] = num;
            count++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 最小的k个数_40().getLeastNumbers(new int[]{3, 2, 1}, 2)));
    }
}
