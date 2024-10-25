# 单调栈

是求数组中，每个元素距离左边、右边，第一个比当前元素大、小的技巧。

一、定义
符合先进后出、且栈底到栈顶的元素是严格单调递增、单调递减的。

二、种类
- 单调性分类：单调递增、单调递减
- 单调性方向：栈底到栈顶、栈顶到栈底

> 一般来说，只需要注意从栈底到栈顶的单调递增、单调递减

三、具体实现
1、从栈底到栈顶、单调递减栈
（1）定义
栈永远保持从栈底到栈顶都是单调递减的。

（2）步骤
- 依次遍历数组元素
- 如果栈不为空，或者当前元素大于栈顶元素，就出栈。此时，当前元素是比之前元素都大的
- 否则，就入栈。此时，当前元素是比栈里元素都小的

（3）模版
```java
import java.util.ArrayDeque;
import java.util.Deque;

public static void main(String[] args) {
    int[] nums = new int[n];

    Deque<Integer> minStack = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
        while (!minStack.isEmpty() && nums[i] > nums[minStack.pop()]) {
            // 弹出栈元素，此时nums[i]是比之前元素都大。此时nums[i]在后测没法在连续了
            int minIndex = minStack.pop();
            // 此时nums[Index]右侧第一个比他大的值nums[i]
        }
        // 入栈元素，此时nums[i]是比之前元素都小
        minStack.push(i);
    }
}

```

2、从栈底到栈顶、单调递增栈
（1）定义
从栈底到栈顶的元素都是单调递增的。适合找当前元素比之前元素第一次小的题目

（2）步骤

（3）模版

```java
import java.util.ArrayDeque;
import java.util.Deque;

public static void main(String[] args) {
    int[] nums = new int[n];

    Deque<Integer> maxStack = new ArrayDeque<>();
    for (int i = 0; i < nums.length ; i++) {
        while (!maxStack.isEmpty() && nums[i] < nums[maxStack.peek()]) {
            // 出栈，当前元素都比之前元素都小
            int maxIndex = maxStack.pop();
            // 此时nums[maxIndex]右边第一个比他小的值是nums[i]
        }
        maxStack.push(i);
    }

}
```
