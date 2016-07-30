import java.util.Arrays;

/**
 * Created by HappyWu on 16/7/23.
 */
public class SelectionAlgorithm {
    public static void main(String[] args){
//        int min, max;
//        int[] a = {1,5};
//        System.out.println(minimum(a));
//        System.out.println(maximum(a));
//        System.out.println(Arrays.toString(min_and_max(a)));
        int[] a = {1,1,8,12,6,19,7,3};
        System.out.println(randomized_select(a, 0, a.length-1, 4));

        int[] b = {1,1,8,12,6,19,7,3};
        System.out.println(iterative_randomized_select(b, 0, a.length-1, 4));
    }

    public static int minimum(int[] A){
        int min = A[0];
        for (int i=1; i<A.length-1; i++){
            if (A[i] < min){
                min = A[i];
            }
        }
        return min;
    }

    public static int maximum(int[] A){
        int max = A[0];
        // 因为for循环会首先检测条件,可以直接从1开始
        for (int i=1; i<A.length-1; i++){
            if (A[i] > max){
                max = A[i];
            }
        }
        return max;
    }

    public static int[] min_and_max(int[] A){
        int min, max;
        int n = A.length;
        int start_index;

        if (n % 2 == 0) {
            if (A[0] > A[1]){
                min = A[1];
                max = A[0];
            }
            else {
                min = A[0];
                max = A[1];
            }
            start_index = 2;
        }
        else{
            min = max = A[0];
            start_index = 1;
        }

        for (int i = start_index; i<n-1; i+=2){
            if (A[i] > A[i+1]){
                if (A[i+1] < min)
                    min = A[i+1];
                if (A[i] > max)
                    max = A[i];
            }
            else {
                if (A[i] < min)
                    min = A[i];
                if (A[i+1] > max)
                    max = A[i+1];
            }
        }
        int[] result = {min, max};
        return result;
    }

    public static int iterative_randomized_select(int[] a, int p, int r, int i){
        int q, k;
        int result = a[p];
        while(i > 0){
            q = randomized_partition(a, p ,r );
            k = q - p + 1;

            if (i == k) {
                result = a[q];
                break;
            }
            else if (i < k){
                r = q;
                continue;
            }
            else{
                p = q+1;
                i = i - k;
                continue;
            }
        }

        return result;
    }

    public static int randomized_select(int[] a, int p, int r, int i){
        if (p == r)
            return a[p];
        int q = randomized_partition(a, p, r);
        int k = q - p + 1;
        if (i == k)
            return a[q];
        else if (i < k)
            return randomized_select(a, p, q-1, i);
        else
            return randomized_select(a, q+1, r, i-k);
    }

    private static int randomized_partition(int[] a, int p, int r) {
        int index = (int) (Math.ceil(Math.random() * (r-p)) + p);
        swap(a, index, r);
        return partition(a, p, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p-1;
        for (int j=p; j<r; j++){
            if (a[j] < pivot){
                i++;
                swap(a, i, j);
            }
        }
        i++;
        swap(a, i, r);
        return i;
    }

    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
