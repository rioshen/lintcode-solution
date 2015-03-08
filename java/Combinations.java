import java.util.*;

public class Combinations {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		if (n < 0) {
		    throw new IllegalArgumentException();
		}

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        combination(n, k, 1, solution, result);
        return result;
    }

    private void combination(int n,
                             int k,
                             int pos,
                             List<Integer> sol,
                             List<List<Integer>> res)
    {
        if (sol.size() == k) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }

        for (int i = pos; i <= n; i++) {
            sol.add(i);
            combination(n, k, i + 1, sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}
