public class Subsets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.size() == 0) {
            return res;
        }

        Collections.sort(S);
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(S, 0, path, res);
        return res;
    }

    private void helper(ArrayList<Integer> nums, int pos,
        ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res)
    {
        res.add(new ArrayList<Integer>(path));

        for (int i = pos; i < nums.size(); i++) {
            int num = nums.get(i);
            path.add(num);
            helper(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
