public class CombinationSumII {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }

        Arrays.sort(num);
        List<Integer> path = new ArrayList<Integer>();
        helper(num, target, 0, path, result);

        return result;
    }

    private void helper(int[] nums, int target, int pos,
        List<Integer> path, List<List<Integer>> res)
    {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            int num = nums[i];
            if (target - num < 0 || (i > pos && nums[i] == nums[i - 1])) {
                continue;
            }
            path.add(num);
            helper(nums, target - num, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
