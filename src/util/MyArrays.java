package util;

/**
 * Created by HappyWu on 16/7/31.
 */
public class MyArrays {
    public static void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
