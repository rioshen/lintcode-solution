public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[j] == 0) {
                    res.add(i);
                    res.add(j);
                    return res;
                } else if (nums[j] == 0) {
                    res.add(j);
                    res.add(j);
                    return res;
                } else {
                    target -= nums[j];
                }
            }
        }
        res.add(0);
        res.add(0);
        return res;
    }

     /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        if (nums == null || nums.lengh == 0) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> res=  new ArrayList<Integer>();
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        table.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!table.containsKey(sum)) {
                table.put(sum, i);
            } else {
                res.add(table.get(sum) + 1);
                res.add(i);
                return res;
            }
        }

        return res;
    }
}
