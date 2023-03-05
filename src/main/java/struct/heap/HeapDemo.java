package struct.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapDemo {
    public static void main(String[] args) {
        // 默认是最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(3);
        heap.offer(13);
        heap.offer(10);
        heap.offer(7);
        heap.offer(5);
        heap.offer(8);

        // 打印堆数组
        System.out.println("Min heap output: " + heap.toString());
        // 获取堆顶最小值 expected： 3
        int min = heap.peek();
        System.out.println("The min value of heap : " + min);
        // 删除堆顶元素
        Integer element = heap.poll();
        System.out.println("The element to delete: " + element);
        // Expected: 5
        System.out.println("The size of removing: " + heap.size());
        System.out.println("Min heap output: " + heap);

        System.out.println("Is empty? " + heap.isEmpty());

        // 实现最大堆
        Queue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
    }
}
