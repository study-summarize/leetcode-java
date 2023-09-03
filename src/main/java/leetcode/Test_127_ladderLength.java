package leetcode;

import java.util.*;

/**
 * @author jwang55
 */
public class Test_127_ladderLength {

    /**
     * 使用双向BFS解决
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
