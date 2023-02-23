package com.dsa.striver30daysSheet.d12_Heaps;


import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    static class MedianFinder {
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        public MedianFinder() {
            min = new PriorityQueue<>(Collections.reverseOrder());
            max = new PriorityQueue<>();
        }

        public void addNum(int num) {
            min.offer(num);
            if (min.peek() != null && max.peek() != null) {
                if (min.peek() > max.peek()) {
                    max.offer(min.poll());
                }
            }
            if (min.size() > max.size() + 1) {
                max.offer(min.poll());
            } else if (max.size() > min.size() + 1) {
                min.offer(max.poll());
            }
        }

        public double findMedian() {
            if (min.size() > max.size()){
                return min.peek();
            }else if (min.size() < max.size()){
                return max.peek();
            }else {
                return (min.peek() + max.peek())/2.0 ;
            }

        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }

}
