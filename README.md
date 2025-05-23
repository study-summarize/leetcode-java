<a href="https://app.codecov.io/github/study-summarize/leetcode-java/"><img src="https://codecov.io/github/study-summarize/leetcode-java/coverage.svg?branch=main" alt="Coverage Status"></a>
<a href="https://github.com/study-summarize/leetcode-java/actions/workflows/build_and_test.yaml">
    <img src="https://img.shields.io/github/actions/workflow/status/study-summarize/leetcode-java/build_and_test.yaml?branch=main&logo=github&logoColor=white&label=fast ci" alt="Github Workflow Build Status">
</a>
<a href="https://github.com/study-summarize/leetcode-java"><img src="https://img.shields.io/github/repo-size/study-summarize/leetcode-java" alt="GitHub repo size"></a>
<a href="https://github.com/study-summarize/leetcode-java/issues"><img src="https://img.shields.io/github/issues/study-summarize/leetcode-java" alt="GitHub issues"></a>
<a href="https://github.com/study-summarize/leetcode-java/graphs/contributors"><img src="https://img.shields.io/github/contributors/study-summarize/leetcode-java" alt="GitHub Contributors"></a>
<a href="https://github.com/study-summarize/leetcode-java/stargazers"><img src="https://img.shields.io/github/stars/study-summarize/leetcode-java" alt="GitHub Stars"></a>
<a href="https://github.com/study-summarize/leetcode-java/fork"><img src="https://img.shields.io/github/forks/study-summarize/leetcode-java" alt="GitHub Forks"></a>


# leetcode-java
## 数组：
### swap技巧
数组中swap俩个位置的数字，为了省空间

### 前缀和模板
1、一维数组动态和

适合求连续区间的数组之和。
```groovy
int[] prefixSum = new int[nums.length + 1];
for(int i = 0; i < nums.length ; i++) {
    prefixSum[i + 1] = prefixSum[i] + nums[i];
}

// 求nums中下标2～5的值
interval[2, 5] = prefixSum[6] - prefixSum[2];
```
2、二维数组动态和
```groovy
int m = nums.length;
int n = nums[0].length;

int[][] prefixSum = new int[m + 1][n + 1];
for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
        prefixSum[i + 1][j + 1] = prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j] + nums[i][j];
    }
}

// 求nums(5, 1, 9,2)
sumRange = prefixSum[10][3] - prefixSum[10][1] - prefixSum[5][3] + prefixSum[5][1];
```
3、一维数组动态积
```groovy
int[] nums = new int[length];

int[] left = new int[length];
int[] right = new int[length];
int[] answer = new int[length];

left[0] = 1;
for (int i = 1; i < length; i++) {
    left[i] = left[i - 1] * nums[i - 1];
}

right[length - 1] = 1;
for (int i = length - 2; i >= 0; i--) {
    right[i] = right[i + 1] * nums[i + 1];
}

for (int i = 0; i < length; i++) {
    answer[i] = left[i] * right[i];
}
```

## 栈和队列：
```java
Deque<Integer> stack = new LinkedList<>();
Queue<Integer> queue = new LinkedList<>();
```
### 单调栈
- 适合的问题
- 解题的思路       

1、从左往右，递增栈
```groovy
int[] nums = new int[length];

int[] right = new int[length];
// 防止右边没有比当前元素小的值
Arrays.fill(right, length);
Deque<Integer> stack = new LinkedList<>();
for (int i = 0; i < length; i++) {
    while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        int index = stack.pop();
        right[index] = i;
    }
    stack.push(i);
}
```
2、从右往左，递增栈
```groovy
int[] nums = new int[length];

int[] left = new int[length];
// 防止左边没有比当前元素小的值
Arrays.fill(left, -1);
Deque<Integer> stack = new LinkedList<>();
for (int i = length - 1; i >= 0; i--) {
    while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        int index = stack.pop();
        left[index] = i;
    }
    stack.push(i);
}
```
3、从左到右，递减栈
```groovy
int[] nums = new int[length];

int[] right = new int[length];
// 防止右边没有比当前元素大的值
Arrays.fill(right, length);
Deque<Integer> stack = new LinkedList<>();
for (int i = 0; i < length; i++) {
    while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        int index = stack.pop();
        right[index] = i;
    }
    stack.push(i);
}
```
4、从右到左，递减栈
```groovy
int[] nums = new int[length];

int[] left = new int[length];
// 防止左边没有比当前元素大的值
Arrays.fill(length, -1);
Deque<Integer> stack = new LinkedList<>();
for (int i = length - 1; i >= 0; i--) {
    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        int index = stack.pop();
        left[index] = i;
    }
    stack.push(i);
}
```

## 链表：
1、定义以及实现
- 中间结点

2、dummyNode     
（1）适用场景
- 改变链表结构

3、头插法

```groovy
ListNode preNode = new ListNode()
ListNode head = preNode.next
while (head != null) {
    ListNode temp = head.next
    head.next = temp.next
    temp.next = preNode.next
    preNode.next = temp
}
```

## 二分搜索：
1、二分搜索的模板

时间复杂度：
```groovy

```

## 双指针
1、相遇型双指针
- Two-sum类
- 划分类
- 灌水类

2、同向型双指针
- 快慢类
- 窗口类
```groovy
int[] nums = new int[k];
int start = 0;
int end = 0;
for (; start < nums.length; start++) {
    while (end < nums.length) {
        // 窗口继续向右扩张
        if (satisfy) {
            end++;
        } else {
            break;
        }
    }
    // 窗口收缩条件
    // 更新i的状态，窗口内数据更新
}
```

## 树
## 二叉树
1、层序遍历
- 获取二叉树的最大高度：622

2、其他
- 从前序与中序遍历序列构造二叉树：105

## 图与二维矩阵：
1、DFS的模板
```groovy
int[][] root = new int[5][5];
boolean[] visited = new boolean[root.length];

public void dfs(int[][] root, boolean[] visited, int currentNode) {
    // 将当前节点置为已访问
    visited[currentNode] = true;
    // 以当前节点为跟节点，对其他节点进行访问
    int[] values = root[currentNode];
    // 开始递归遍历
    for (int i = 0; i < root.length; i++) {
        // currentNode -> i 有边时，且i还未被访问
        if (root[currentNode][i] == 1 && !visited[i]) {
            dfs(root, visited, i);
        }
    }
}
```
2、需要掌握的方法
- 图中求联通分量

3、图的表示
- 二维矩阵
- 邻接表

4、思考

一般都是将图转换成二维矩阵、邻接表来处理。
- DFS：二维矩阵
- BFS：邻接表（使用队列，一般就不用去除访问标记）
  - 图的二维矩阵，也可以认为是邻接表？？？547

note：二维矩阵也是一种特殊的数据结构
二维矩阵BFS 很多都需要转换point

## DFS
1、相关方法
DFS -> 回溯法 -> 记忆化搜索
2、涉及的数据结构
- 二叉树、一维数组
- 图、二维数组

## BFS
树、图、二维矩阵

## 思路：
- 分治法

## 动态规划
1、四步骤设计
- 定义状态：dp[n]：
- 状态转移：dp[n] = dp[n-1] + ...
- 初始条件：dp[0]
- 求最优解：

## 排序
- 一般排序算法    
  - 插入排序、冒泡排序、快速排序、归并排序、堆排序
- 特殊排序算法
  - 计数排序、桶排序
> 最常考：快速排序、归并排序、插入排序、冒泡排序



相关资料：
- 一个YouTuber分享的解题思路：https://www.youtube.com/playlist?list=PLwdV8xC1EWHrtgsYCcDTXIMVaHSlsnLzL

后期待做：
- 使用Gradle
- 做一个插件来收集每题的标签？  

