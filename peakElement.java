public class peakElement {
    public int findPeakElement(int [] nums) {
            int n = nums.length;
            
            if (n == 1) return 0; // Special case: single element is always a peak
    
            int low = 0, high = n - 1;
    
            while (low <= high) {
                int mid = low + (high - low) / 2;
    
                int left = (mid == 0) ? Integer.MIN_VALUE : nums[mid - 1];
                int right = (mid == n - 1) ? Integer.MIN_VALUE : nums[mid + 1];
    
                if (nums[mid] > left && nums[mid] > right) {
                    return mid;
                } else if (nums[mid] < right) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
    
            return -1; // This line should not be reached
        }
        public static void main(String[] args){
            int[] nums1 = {1, 2, 4, 5, 7, 8, 3}; // Output: 5 (value 8)
int[] nums2 = {10, 20, 15, 2, 23, 90, 80}; // Output: 1 or 5 (value 20 or 90)

peakElement sol = new peakElement();
int index1 = sol.findPeakElement(nums1);
System.out.println("Peak at index: " + index1 + ", Value: " + nums1[index1]);

int index2 = sol.findPeakElement(nums2);
System.out.println("Peak at index: " + index2 + ", Value: " + nums2[index2]);

        }
    }
    
