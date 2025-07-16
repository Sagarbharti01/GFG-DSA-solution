// Java program to decode a string recursively encoded
// as count followed substring Using Single Stack

import java.util.Stack;

class decodetheString {
    
    static String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        
        // Traverse the input string
        for (int i = 0; i < s.length(); i++) {
            // Push characters into the stack until ']' is encountered
            if (s.charAt(i) != ']') {
                st.push(s.charAt(i));
            } 
            // Decode when ']' is found
            else {
                StringBuilder temp = new StringBuilder();
                
                // Pop characters until '[' is found
                while (!st.isEmpty() && st.peek() != '[') {
                    temp.append(st.pop());
                }
                temp.reverse(); // Reverse extracted string
                // Remove '[' from the stack
                st.pop(); 

                StringBuilder num = new StringBuilder();
                // Extract the number (repetition count) from the stack
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.insert(0, st.pop());
                }
                
                // Convert extracted number to integer
                int number = Integer.parseInt(num.toString()); 
                StringBuilder repeat = new StringBuilder();
                
                // Repeat the extracted string 'number' times
                for (int j = 0; j < number; j++)
                    repeat.append(temp);
                
                // Push the expanded string back onto the stack
                for (char c : repeat.toString().toCharArray())
                    st.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        // Pop all characters from stack to form the final result
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        
        // Reverse to get the correct order
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "3[b2[ca]]";
        System.out.println(decodeString(str));
    }
}