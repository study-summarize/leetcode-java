package leetcode;

public class Test_Offer_051_reversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return countPairs(nums, 0, nums.length - 1);
    }

    private int countPairs(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            int leftCount = countPairs(nums, start, mid);
            int rightCount = countPairs(nums, mid + 1, end);
            return leftCount + rightCount + merge(nums, start, mid, end);
        }
        return 0;
    }

    /**
     * 求左右子数组在合并时产生逆序队的个数
     */
    private int merge(int[] nums, int start, int mid, int end) {
        int leftLength = mid - start + 1;
        int rightLength = end - mid;

        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            left[i] = nums[start + i];
        }

        for (int j = 0; j < rightLength; j++) {
            right[j] = nums[mid + 1 + j];
        }

        int index = start;
        int i = 0;
        int j = 0;
        int pairCount = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                nums[index++] = left[i++];
            } else {
                // 产生逆序对：count = leftLength - i
                nums[index++] = right[j++];
                pairCount += (leftLength - i);
            }
        }

        while (i < leftLength) {
            nums[index++] = left[i++];
        }

        while (j < rightLength) {
            nums[index++] = right[j++];
        }

        return pairCount;
    }

}
