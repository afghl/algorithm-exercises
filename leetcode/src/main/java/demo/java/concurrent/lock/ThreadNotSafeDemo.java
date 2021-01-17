package demo.java.concurrent.lock;

import java.util.*;
import java.util.concurrent.*;

public class ThreadNotSafeDemo {

    /**
     * 一个arrayList线程不安全的case
     *
     * 用copyOnWriteArrayList，使得它变成线程安全
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        RunnableFuture<Integer> f = new FutureTask<>(() -> 1);
        f.run();
        Integer r = f.get();
        System.out.println(r);

        int[] index = new int[5] ;
    }

    private static int calculate(int m, int n, int[] nums) {
        if (nums == null || nums.length <= 0 || m <= 0 || n <= 0) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;
        // 记录每种颜色射中的最右下标
        int[] index = new int[n + 1];
        Arrays.fill(index, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // 记录当前颜色的最右下标
            index[nums[i]] = i;

            // 遍历index，找到最右值和最左值
            int min = nums.length;
            int max = 0;
            boolean all = true; // 是否已经打爆所有颜色的气球
            for (int j = 1; j < index.length; j++) {
                if (index[j] == -1) {
                    all = false;
                    break;
                } else {
                    min = Math.min(min, index[j]);
                    max = Math.max(max, index[j]);
                }
            }

            if (all) {
                ans = Math.min(ans, max - min + 1);

                // 如果最小枪数就是颜色数，说明已经是全局最小，直接返回
                if (ans == n) {
                    return ans;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
