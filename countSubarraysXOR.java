// Java Program to count all subarrays having
// XOR of elements as given value K
class countSubarraysXOR {
  
    // Function to find count of subarrays of arr 
  	// with XOR value equals to K
    static int subarrayXor(int[] arr, int k) {
        int res = 0;

        // Pick starting point i of subarrays
        for (int i = 0; i < arr.length; i++) {
            int prefXOR = 0;

            // Pick ending point j of subarray for each i
            for (int j = i; j < arr.length; j++) {
                // calculate prefXOR for subarray arr[i ... j]
                prefXOR = prefXOR ^ arr[j];

                // If prefXOR is equal to given value, increase res by 1
                if (prefXOR == k)
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int k = 6;

        System.out.println(subarrayXor(arr, k));
    }
}