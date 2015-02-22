public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<Integer>();
        helper(candidates, target, 0, path, result);

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

            if (target - num < 0) {
                continue;
            }
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(num);
            helper(nums, target - num, i, path, res);
            path.remove(path.size() - 1);
        }
    }
}