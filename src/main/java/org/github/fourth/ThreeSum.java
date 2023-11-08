package org.github.fourth;

import java.util.Arrays;

public class ThreeSum {

    public int[] threeSum(int[] nums, int target) {
        int[] result = new int[3];
        if (nums.length < 3) {
            return result;
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        // 假设输出不要求顺序
                        result[0] = nums[i];
                        result[1] = nums[j];
                        result[2] = nums[k];
                        return result;
                    }
                }
            }
        }
        return result;
    }

    // ---
    public int[] threeSumV2(int[] nums, int target) {
        int[] result = new int[3];
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int nowTarget = target - nums[i];
            int first = i + 1;
            int second = nums.length - 1;
            while (first < second) {
                if (nums[first] + nums[second] == nowTarget) {
                    result[0] = nums[i];
                    result[1] = nums[first];
                    result[2] = nums[second];
                    return result;
                }
                if (nums[first] + nums[second] > nowTarget) {
                    second--;
                }
                if (nums[first] + nums[second] < nowTarget) {
                    first++;
                }
            }
        }
        return result;
    }
}
