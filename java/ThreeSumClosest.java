public class ThreeSumClosest {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        if (numbers == null || numbers.length < 3) return 0;
        
        Arrays.sort(numbers);
        int closest = Integer.MAX_VALUE / 10;
        for (int i = 0; i < numbers.length - 2; i++) {
            int j = i + 1, k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
                closest = Math.abs(closest - target) > Math.abs(sum - target) ? sum : closest;
            }
        }
        
        return closest;
    }
}