package leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jwang55
 */
public class Test_042_trap {

    /**
     * 方法一：三次遍历
     */
    @SuppressWarnings("UnnecessaryParentheses")
    public int trap1(int[] height) {
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }

        // 从左到右，记录i的左边界
        int[] left = new int[height.length];
        int maxLeft = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            maxLeft = Math.max(height[i], maxLeft);
            left[i] = maxLeft;
        }

        // 从右到左，记录i的右边界
        int[] right = new int[height.length];
        int maxRight = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight = Math.max(height[i], maxRight);
            right[i] = maxRight;
        }

        // 计算总灌水量
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(left[i], right[i]);
            if (minHeight > height[i]) {
                result += (minHeight - height[i]);
            }
        }
        return result;
    }

    /**
     * 方法一优化版本：减少一次遍历
     */
    @SuppressWarnings("UnnecessaryParentheses")
    public int trap1Refine(int[] height) {
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }

        // 记录i的边界高度
        int[] h = new int[height.length];

        // 从左往右记录左边界
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(height[i], max);
            h[i] = max;
        }

        // 从右到左，计算真正的边界高度以及接雨水量
        max = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            int right = max;
            int left = h[i];
            if (Math.min(right, left) > height[i]) {
                result += (Math.min(right, left) - height[i]);
            }
        }
        return result;
    }


    /**
     * 方法二：双指针一次遍历
     * note：有点难理解，易错
     */
    public int trap2(int[] height) {
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left <= right) {
            if (leftMax < rightMax) {
                // 短板往前走
                leftMax = Math.max(leftMax, height[left]);
                result += (leftMax - height[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += (rightMax - height[right]);
                right--;
            }
        }
        return result;
    }


    /**
     * 方法三：单调栈解决
     */
    public int trap3(int[] height) {
        int area = 0;
        if (height == null || height.length == 0) {
            return area;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int index = stack.pop();
                if (!stack.isEmpty()) {
                    int right = i;
                    int left = stack.peek();
                    int currentArea = (Math.min(height[left], height[right]) - height[index]) * (right - left - 1);
                    area += currentArea;
                }
            }
            stack.push(i);
        }
        return area;
    }
}
