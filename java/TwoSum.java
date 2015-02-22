import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{-1, -1};
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int value = target - numbers[i];
            if (!table.containsKey(value)) {
                table.put(numbers[i], i);
            } else {
                result[0] = Math.min(table.get(value) + 1, i + 1);
                result[1] = Math.max(table.get(value) + 1, i + 1);
                return result;
            }
        }

        return result;
    }
}