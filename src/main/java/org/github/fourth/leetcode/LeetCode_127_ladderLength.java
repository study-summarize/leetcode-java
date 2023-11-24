package org.github.fourth.leetcode;

import java.util.*;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * - 每一对相邻的单词只差一个字母。
 * - 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * - sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 */
public class LeetCode_127_ladderLength {

    /**
     * 使用双向BFS解决
     * 时间复杂度：
     * 空间复杂度：
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }

        Set<String> dict = new HashSet<>(wordList);
        // corn case
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (!dict.contains(endWord)) {
            return 0;
        }

        Set<String> beginToEndSet = new HashSet<>();
        Set<String> endToBeginSet = new HashSet<>();

        Queue<String> beginToEndQueue = new LinkedList<>();
        Queue<String> endToBeginQueue = new LinkedList<>();
        // BFS：begin -> end
        beginToEndQueue.offer(beginWord);
        beginToEndSet.add(beginWord);
        // BFS：end -> begin
        endToBeginQueue.offer(endWord);
        endToBeginSet.add(endWord);

        int beginToEndCount = 1;
        int endToBeginCount = 1;
        while (!beginToEndQueue.isEmpty() && !endToBeginQueue.isEmpty()) {
            // 不能用=号：有一个case是-"hog","cog",["cog"]
            if (beginToEndQueue.size() > endToBeginQueue.size()) {
                // 扩展endToBeginQueue
                if (update(dict, endToBeginQueue, endToBeginSet, beginToEndSet)) {
                    // 俩个BFS已经相遇，得到答案
                    return beginToEndCount + endToBeginCount;
                }
                endToBeginCount++;
            } else {
                // 扩展beginToEndQueue
                if (update(dict, beginToEndQueue, beginToEndSet, endToBeginSet)) {
                    // 俩个BFS已经相遇，得到答案
                    return beginToEndCount + endToBeginCount;
                }
                beginToEndCount++;
            }
        }
        return 0;
    }

    private boolean update(Set<String> dict, Queue<String> queueToUpdate,
                           Set<String> visited, Set<String> anotherVisited) {
        // 层级遍历
        int size = queueToUpdate.size();
        for (int i = 0; i < size; i++) {
            String curWord = queueToUpdate.poll();
            // 以curWord为圆心画圆，求邻接节点；邻接节点：构造出来的新单词在dict里面
            List<String> adjWords = getNextWords(curWord, dict);
            for (String adjWord : adjWords) {
                if (!visited.contains(adjWord)) {
                    // 返回条件：俩个BFS相遇
                    if (anotherVisited.contains(adjWord)) {
                        return true;
                    }
                    queueToUpdate.offer(adjWord);
                    visited.add(adjWord);
                }
            }
        }
        return false;
    }


    /**
     * 使用单向BFS解决
     * 时间复杂度：
     * 空间复杂度：
     */
    public int ladderLengthWithSingleBfs(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return 0;
        }

        Set<String> dict = new HashSet<>(wordList);
        // corn case
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (!dict.contains(endWord)) {
            return 0;
        }

        // 双向BFS时，需要把beginWord加入；否则可能会找不到答案

        dict.add(beginWord);

        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            // 层级遍历
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                // 以curWord为圆心画圆，求邻接节点；邻接节点：构造出来的新单词在dict里面
                List<String> adjWords = getNextWords(curWord, dict);
                for (String adjWord : adjWords) {
                    if (!visited.contains(adjWord)) {
                        if (adjWord.equals(endWord)) {
                            return level;
                        }
                        queue.offer(adjWord);
                        visited.add(adjWord);
                    }
                }
            }
        }
        return 0;
    }

    public List<String> getNextWords(String word, Set<String> dict) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            // ch -> a-z
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ch) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    result.add(nextWord);
                }
            }
        }
        return result;
    }

    private String replace(String word, int index, char c) {
        char[] chs = word.toCharArray();
        chs[index] = c;
        return new String(chs);
    }

}
