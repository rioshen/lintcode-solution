public class MergeSortedArray {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                result.add(A.get(i++));
            } else {
                result.add(B.get(j++));
            }
        }
        while (i < A.size()) {
            result.add(A.get(i++));
        }
        while (j < B.size()) {
            result.add(B.get(j++));
        }
        
        return result;
    }
}