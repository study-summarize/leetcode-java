package leetcode;

public class Test_152_maxProduct {

    /**
     * 动态规划
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // state 考虑附属的情况，一个负数乘以一个负数为正数，负数越小，相乘结果越大
        // maxDp[i]：以nums[i]结尾的子数组最大乘积
        // minDp[i]：以nums[i]结尾的子数组最大乘积
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        // condition:
        // maxDp[0] = nums[0], minDp[0] = nums[0]
        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        // function
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 先假设当前值是最优值，省的后面去比较
            maxDp[i] = minDp[i] = nums[i];

            if (nums[i] > 0) {
                maxDp[i] = Math.max(maxDp[i], maxDp[i - 1] * nums[i]);
                minDp[i] = Math.min(minDp[i], minDp[i - 1] * nums[i]);
            } else if (nums[i] < 0){
                maxDp[i] = Math.max(maxDp[i], minDp[i - 1] * nums[i]);
                minDp[i] = Math.min(minDp[i], maxDp[i - 1] * nums[i]);
            }
            result = Math.max(maxDp[i], result);
        }

        return result;
    }
}
