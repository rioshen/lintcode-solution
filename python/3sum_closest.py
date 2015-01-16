class Solution:
    """
    @param numbers: Give an array numbers of n integer
    @param target : An integer
    @return : return the sum of the three integers, the sum closest target.
    """
    def threeSumClosest(self, numbers, target):
        if not numbers or len(numbers) < 3:
            return 0
        closest = 1 << 31
        numbers.sort()
        for idx, elem in enumerate(numbers):
            lo, hi = idx+1, len(numbers)-1
            while lo < hi:
                sums = elem + numbers[lo] + numbers[hi]
                if sums == target:
                    return target
                elif sums < target:
                    lo += 1
                else:
                    hi -= 1
                if abs(sums - target) < abs(closest - target):
                    closest = sums
        return closest
