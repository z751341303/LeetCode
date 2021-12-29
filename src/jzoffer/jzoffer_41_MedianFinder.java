package jzoffer;

import java.util.PriorityQueue;
import java.util.Queue;

public class jzoffer_41_MedianFinder {

}

class MedianFinder {

    Queue<Integer> big, small;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        big = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if(small.size() != big.size()) {
            small.add(num);
            big.add(small.poll());
        } else {
            big.add(num);
            small.add(big.poll());
        }
    }

    public double findMedian() {
        return small.size() != big.size() ? small.peek() : (small.peek() + big.peek()) / 2.0;
    }
}