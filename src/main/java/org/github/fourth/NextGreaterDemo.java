package org.github.fourth;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterDemo {

    public static int[] findRightNextGreater(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] findRightNextSmaller(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] findLeftNextGreater(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] findLeftNextSmaller(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 1, 5, 3, 4};
        System.out.println("findRightNextGreater: " + Arrays.toString(findRightNextGreater(nums)));
        System.out.println("findRightNextSmaller: " + Arrays.toString(findRightNextSmaller(nums)));
        System.out.println("findLeftNextGreater: " + Arrays.toString(findLeftNextGreater(nums)));
        System.out.println("findLeftNextSmaller: " + Arrays.toString(findLeftNextSmaller(nums)));

    }
}
