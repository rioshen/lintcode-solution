public class SearchIn2DMatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        int count = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return count;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int r = rows - 1, c = 0;
        while (r >= 0 && c < cols) {
            int cell = matrix[r][c];
            if (cell == target) {
                count++;
                c++;
                r--;
            } else if (cell < target) {
                c++;
            } else {
                r--;
            }
        }

        return count;
    }
}
