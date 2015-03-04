import java.util.*;

public class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return res;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        Collections.sort(nums);
        boolean[] visited = new boolean[nums.size()];
        helper(nums, visited, path, res);

        return res;
    }

    public void helper(ArrayList<Integer> nums, boolean[] visited, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (path.size() == nums.size()) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            path.add(num);
            helper(nums, visited, path, res);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
