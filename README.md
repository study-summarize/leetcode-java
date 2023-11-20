<a href="https://codecov.io/gh/wangjie-fourth/leetcode-java/branch/main"><img src="https://img.shields.io/codecov/c/github/wangjie-fourth/leetcode-java/main?logo=codecov&logoColor=white" alt="Coverage Status"></a>
<a href="https://github.com/wangjie-fourth/leetcode-java/actions/workflows/build_and_test.yaml">
    <img src="https://img.shields.io/github/actions/workflow/status/wangjie-fourth/leetcode-java/build_and_test.yaml?branch=main&logo=github&logoColor=white&label=fast ci" alt="Github Workflow Build Status">
</a>
<a href="https://github.com/wangjie-fourth/leetcode-java"><img src="https://img.shields.io/github/repo-size/wangjie-fourth/leetcode-java" alt="GitHub repo size"></a>
<a href="https://github.com/wangjie-fourth/leetcode-java/issues"><img src="https://img.shields.io/github/issues/wangjie-fourth/leetcode-java" alt="GitHub issues"></a>
<a href="https://github.com/wangjie-fourth/leetcode-java/graphs/contributors"><img src="https://img.shields.io/github/contributors/wangjie-fourth/leetcode-java" alt="GitHub Contributors"></a>
<a href="https://github.com/wangjie-fourth/leetcode-java/stargazers"><img src="https://img.shields.io/github/stars/wangjie-fourth/leetcode-java" alt="GitHub Stars"></a>
<a href="https://github.com/wangjie-fourth/leetcode-java/fork"><img src="https://img.shields.io/github/forks/wangjie-fourth/leetcode-java" alt="GitHub Forks"></a>


# leetcode-java
数组：
- 数组中swap俩个位置的数字（为了省空间）
- 字符串中字符统计技巧？？？
- 前缀和模板
(1)一维数组动态和
```groovy
int[] prefixSum = new int[nums.length + 1];
for(int i = 0; i < nums.length ; i++) {
    prefixSum[i + 1] = prefixSum[i] + nums[i];
}

// 求nums中下标2～5的值
interval[2, 5] = prefixSum[6] - prefixSum[2];
```
(2)二维数组动态和
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

栈和队列：

链表：
- 求链表中点
- 合并俩个有序链表

二分搜索：

树：

图与二维矩阵：

思路：
- 分治法

相关资料：
- 一个YouTuber分享的解题思路：https://www.youtube.com/playlist?list=PLwdV8xC1EWHrtgsYCcDTXIMVaHSlsnLzL

后期待做：
- 使用Gradle
- 做一个插件来收集每题的标签？  
- 测试类名应该以LeetCode开头

