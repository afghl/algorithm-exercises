from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def bi_search(left: int = 0, right: int = len(nums) - 1) -> int:
            if left > right:
                return -1
            mid = left + (right - left) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] < target:
                return bi_search(mid + 1, right)
            else:
                return bi_search(left, mid - 1)

        return bi_search()
