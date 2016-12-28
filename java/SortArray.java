import java.util.Arrays;

// 最大在最前
public class SortArray {
    private static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    private static void merge(int[] arr) {
        int[] tmp = Arrays.copyOf(arr, arr.length);
        mergesort(arr, 0, arr.length, tmp);
    }

    private static void mergesort(int[] result, int left, int right, int[] arr) {
        if (right - left > 1) {
            int mid = (left + right) / 2;
            mergesort(arr, left, mid, result);
            mergesort(arr, mid, right, result);
            mergearray(result, left, mid, right, arr);
        }
    }

    private static void mergearray(int[] result, int left, int mid, int right, int[] arr) {
        int i = left, l = left, r = mid;

        while (l < mid && r < right) {
            if (arr[l] > arr[r]) {
                result[i++] = arr[l++];
            } else {
                result[i++] = arr[r++];
            }
        }

        while (l < mid) result[i++] = arr[l++];
        while (r < right) result[i++] = arr[r++];

    }

    public static void main(String[] args) {
        int[] arr = { -2, 11, -4, 13, -5, -2, 3, 5, 77, 77, 40 };
        bubble(arr);
        inspect(arr);
        int[] arr2 = { -2, 11, -4, 13, -5, -2, 3, 5, 77, 77, 40 };
        merge(arr2);
        inspect(arr2);

    }

    private static void inspect(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
