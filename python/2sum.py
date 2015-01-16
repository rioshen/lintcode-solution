class Solution:
    """
    @param numbers : An array of Integer
    @param target : target = numbers[index1] + numbers[index2]
    @return : [index1 + 1, index2 + 1] (index1 < index2)
    """
    def twoSum(self, numbers, target):
        idx1 = idx2 = -1
        if not numbers:
            return [idx1, idx2]
        table = {}
        for idx, val in enumerate(numbers):
            if val not in table:
                table[target - val] = idx
            else:
                idx1, idx2 = idx+1, table[val]+1
                return [min(idx1, idx2), max(idx1, idx2)]
        return [idx1, idx2]
