// Java program to calculate power 
// Using builtin methods

class power {
    static double findPower(double b, int e) {
        return Math.pow(b, e);
    }

    public static void main(String[] args) {
        double b = 3.0;
        int e = 5;
        System.out.println(findPower(b, e));
    }
}