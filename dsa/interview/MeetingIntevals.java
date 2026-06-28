package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingIntevals {
    public int mergeIntervals(int[][] meetings){
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int[] meeting : meetings){
            if (!heap.isEmpty() && heap.peek() <= meeting[0]){
                heap.poll();
            }
            heap.offer(meeting[1]);
        }
        return heap.size();
    }

    public static void main(String[] args) {
        //Input:  [[0,30],[5,10],[15,20]]
        //Output: 2
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        MeetingIntevals mi = new MeetingIntevals();
        int ans = mi.mergeIntervals(meetings);
        System.out.println(ans);
    }
}
