package interview;

import util.MyArrays;

import java.util.Arrays;

/**
 * Created by HappyWu on 16/7/30.
 */
public class FindSingleNumberProblem {
    public static void main(String[] args){
        int[] nums = {1,2,1,2,7,1,2};
        System.out.println(getSingleNumber(nums));

        int[] nums2 = {1,4,6,4,1,7,8,6,11};
        System.out.println(Arrays.toString(getThreeSingleNumber(nums2)));
    }

    // 只有一个数出现1次,别的出现都3次 NOT UNDERSTOOD
    public static int getSingleNumber(int[] nums){
        int a = 0, b = 0;
        for (int number:nums) {
            b = a & ( b ^ number);
            a = b | (a ^ number);
        }
        return a;
    }

    // 巧妙算法,一个数出现1此,其余出现3次 NOT UNDERSTOOD
    public static int wisdom_getSingleNumber(int[] nums){
        int one = 0;
        int accumulation = 0;
        for (int i=0; i<nums.length; i++){
            accumulation |= nums[i] & one; //只要第二次或者以上出现,就为1
            one ^= nums[i]; //出现奇数次保留,偶数次抛弃
            int t = one & accumulation; //第三次的时候one和accumulation都保留了该位的值
            one &= ~t;
            accumulation &= ~t;
        }
        return one;
    }

    // ones中保存着余1的位, twos中保存着余2的位 ALMOST UNDERSTOOD
    public static int all_three_but_one(int[] nums){
        int ones=0, twos=0;
        for (int num: nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }

    // 只有两个数出现1次,别的数都出现2次
    public static int[] getTwoSingleNumber(int[] nums){
        int x_xor_y = 0;
        for (int num: nums){
            x_xor_y ^= num;
        }

        int judge = get_first_bit(x_xor_y);
        int x = 0, y = 0;
        for (int num: nums){
            if ((judge & num) == 0){
                x ^= num;
            }
            else {
                y ^=num;
            }
        }
        int[] result = {x, y};
        return result;
    }

    // 只有三个数出现1次,别的数都出现2次
    public static int[] getThreeSingleNumber(int[] nums){
        int a=0, b=0, c=0;
        int abc_xor_result = 0;
        for (int num:nums)
            abc_xor_result ^= num;

        int flag = 0;
        for (int num:nums){
            flag ^= get_first_bit(abc_xor_result ^ num);
        }
        flag = get_first_bit(flag);

        for (int num:nums){
            if (get_first_bit(abc_xor_result ^ num) == flag)
                a ^= num;
        }

        for (int i=0; i<nums.length; i++){
            if (nums[i] == a) {
                MyArrays.swap(nums, i, nums.length - 1);
                break;
            }
        }

        int[] b_c = new int[2];
        int[] b_c_array = new int[nums.length-1];
        for (int i=0; i<nums.length-1; i++){
            b_c_array[i] = nums[i];
        }

        System.out.println(Arrays.toString(b_c_array));

        b_c = getTwoSingleNumber(b_c_array);

        int[] result = new int[3];
        result[0] = a;
        result[1] = b_c[0];
        result[2] = b_c[1];

        return result;
    }

    private static int get_first_bit(int num)
    {
        return num&~(num - 1);
    }

    // 将a的第i位设置为1
    static int set(int a,int i) {
        return a |= (1<<i);
    }
}