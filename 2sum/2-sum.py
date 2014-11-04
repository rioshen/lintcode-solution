#!/usr/bin/env/python
#-*-coding: utf-8-*-


def twosum(nums, target):
    if not nums:
        raise ValueError("nums is none.")
    nums = sorted(nums)
    lo, hi = 0, len(nums)-1
    while lo < hi:
        result = nums[lo] + nums[hi]
        if result == target:
            return nums[lo], nums[hi]
        elif result < target:
            lo += 1
        else:
            hi -= 1
    return -1, -1
