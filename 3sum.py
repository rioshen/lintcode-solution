class Solution:
    """
    @param numbersbers : Give an array numbersbers of n integer
    @return : Find all unique triplets in the array which gives the sum of zero.
    """
    def threeSum(self, numbers):
        if not numbers or len(numbers) < 3:
            return set()
        numbers.sort()
        triplets = []
        seen = set()
        for idx, val in enumerate(numbers):
            lo, hi = idx+1, len(numbers)-1
            while lo < hi:
                sol = (val, numbers[lo], numbers[hi])
                sums = sum(sol)
                if sums == 0 and sol not in seen:
                    triplets.append(sol)
                    seen.add(sol)
                elif sums < 0:
                    lo += 1
                else:
                    hi -= 1
        return triplets
