import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KthLargestElement {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    // This solution run time is O(nlogn)
    public int kthLargestElementNaive(int k, ArrayList<Integer> numbers) {
        Collections.sort(numbers, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        k = (k - 1) % numbers.size();
        return numbers.get(k);
    }

    public int kthLargestElement(int k, ArrayList<Integer> numbers) {

    }
}
