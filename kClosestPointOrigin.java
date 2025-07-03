// Java program to find k closest points to 
// origin using max heap.
import java.util.*;

class kClosestPointOrigin {

    // Function to calculate squared distance from the origin
    static int squaredDis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    // Function to find k closest points to the origin
    static int[][] kClosest(int[][] points, int k) {
        // Max heap to store points with their squared distances
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> squaredDis(b) - squaredDis(a));

        // Iterate through each point
        for (int[] point : points) {
            if (maxHeap.size() < k) {
                // If the heap size is less than k, insert the point
                maxHeap.offer(point);
            } else {
                // If the heap size is k, compare with the top element
                if (squaredDis(point) < squaredDis(maxHeap.peek())) {
                    // Replace the top element if the current point is closer
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }

        // Take the k closest points from the heap
        int[][] res = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            res[index][0] = point[0];
            res[index][1] = point[1];
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, -1}, {3, 2}, {1, 1}};
        int k = 3;

        int[][] res = kClosest(points, k);

        for (int i = 0; i < res.length; i++) {
            System.out.print("[" + res[i][0] + ", " + res[i][1] + "] ");
        }
    }
}