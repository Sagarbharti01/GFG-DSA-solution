public class rotateMatrix90 {
    static void rotateby90(int mat[][]) {
        // code here
        int n = mat.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n-i-1; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][n-1-i];
                mat[j][n-1-i] = mat[n-1-i][n-1-j];
                mat[n-1-i][n-1-j] = mat[n-1-j][i];
                mat[n-1-j][i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        rotateby90(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
