package interview;

/**
 * Created by HappyWu on 16/7/30.
 */
public class NumRelatedAlgorithm {
    public static void main(String[] args){
        int[] nums = {1,2,1,2,7,1,2};
        System.out.println(getSingleNumber(nums));

        System.out.println(get_first_bit(12));
    }

    // 只有1个数出现1次,别的出现都两次
    public static int getSingleNumber(int[] nums){
        int a = 0, b = 0;
        for (int number:nums) {
            b = a & ( b ^ number);
            a = b | (a ^ number);
        }
        return a;
    }



    private static int get_first_bit(int num)
    {
        return num&~(num - 1);
    }
}