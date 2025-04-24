import java.util.Arrays;

public class nonOverlapIntervals {
    static int minRemoval(int intervals[][]){
        int count = 0;
        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);
        
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < end){
                count++;
                end = Math.min(intervals[i][1], end);
            }
            else
                end = intervals[i][1];
        }
        return count;

    }
    public static void main(String args[]){
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(minRemoval(intervals));
    }
}
