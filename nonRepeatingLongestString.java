class nonRepeatingLongestString {

    static int longestUniqueSubstr(String s) {
        int n = s.length();
        int res = 0;

        // last index of all characters is initialized as -1
        int[] lastIndex = new int[26];
        for (int i = 0; i < 26; i++) {
            lastIndex[i] = -1;
        }

        // Initialize start of current window
        int start = 0;

        // Move end of current window
        for (int end = 0; end < n; end++) {

            // Find the last index of s[end]
            // Update starting index of current window as
            // maximum of current value of end and last index + 1
            start = Math.max(start, lastIndex[s.charAt(end) - 'a'] + 1);

            // Update result if we get a larger window
            res = Math.max(res, end - start + 1);

            // Update last index of s[end]
            lastIndex[s.charAt(end) - 'a'] = end;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstr(s));
    }
}