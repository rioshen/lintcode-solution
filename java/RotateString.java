public class RotateString {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        if (A == null || A.length == 0) {
            return A;
        }

        int len = A.length;
        offset = offset % len;
        if (offset == 0) {
            return A;
        }

        reverse(A, 0, len - 1);
        reverse(A, 0, offset - 1);
        reverse(A, offset, len - 1);
        return A;
    }

    void reverse(char[] A, int i, int j) {
        while (i < j) {
            char t = A[i];
            A[i] = A[j];
            A[j] = t;
            i++;
            j--;
        }
    }
}
