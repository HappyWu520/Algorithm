/**
 * Created by HappyWu on 16/5/29.
 */
public class SubArrayAlgorithm {
    public static int[] findMaxSubArray(int[] nums, int low, int high){
        if (low == high){
            int[] result = {low, high, nums[low]};
            return result;
        }

        int mid = (low+high)/2;
        int[] left_result = findMaxSubArray(nums, low, mid);
        int[] right_result = findMaxSubArray(nums, mid+1, high);
        int[] cross_result = findMaxCrossingSubArray(nums, low, mid, high);

        if (left_result[2] >= right_result[2] && left_result[2] >= cross_result[2])
            return left_result;
        else if (right_result[2] >= left_result[2] && right_result[2] >= cross_result[2])
            return right_result;
        else
            return cross_result;
    }

    private static int[] findMaxCrossingSubArray(int[] nums, int low, int mid, int high){
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        int left_index = mid;
        for (int i = mid; i >= low ; i--) {
            sum += nums[i];
            if (sum > left_sum){
                left_sum = sum;
                left_index = i;
            }
        }

        int right_sum = Integer.MIN_VALUE;
        sum = 0;
        int right_index = mid+1;
        for (int i = mid+1; i <= high; i++) {
            sum += nums[i];
            if (sum > right_sum){
                right_sum = sum;
                right_index = i;
            }
        }
        int[] tuple = {left_index, right_index, left_sum+right_sum};
        return tuple;
    }

    //P75 4.1-5
    public static int[] findMaxSubArray_DP(int[] nums){
        if (nums.length == 0){
            return null;
        }
        if (nums.length == 1){
            return new int[]{0,0,nums[0]};
        }

        int[] b = new int[nums.length];
        b[0] = nums[0];

        int left_index = 0;
        int right_index = 0;
        int max = b[0];

        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if(b[i-1] + nums[i] >= nums[i]) {
                b[i] = b[i-1] + nums[i];
            }
            else{
                b[i] = nums[i];
                left = i;
            }
            if (b[i] > max){
                max = b[i];
                left_index = left;
                right_index = i;
            }
        }
        return new int[]{left_index, right_index, max};
    }

    //最大子序和 DP算法
    public static int[] findMaxSubArray_DP2(int[] nums){
        int max_sum = Integer.MIN_VALUE;
        int sum_segment = 0;

        int left_index = 0;
        int right_index = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum_segment < 0) {
                sum_segment = 0;
                left = i;
            }

            sum_segment += nums[i];
            if (sum_segment > max_sum){
                max_sum = sum_segment;
                left_index = left;
                right_index = i;
            }
        }
        return new int[]{left_index, right_index, max_sum};
    }
}