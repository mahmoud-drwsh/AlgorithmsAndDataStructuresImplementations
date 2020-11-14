import random

from searching_algorithms.binary_search import binary_search
from sorting_algorithms.merge_sort import mergeSort

if __name__ == '__main__':
    i = 99
    nums = random.sample(range(0, i ** 2), i)

    nums.sort(reverse=True)

    print(nums)

    mergeSort(nums)

    print(nums[binary_search(nums, i, 0, len(nums) - 1)])

    print(nums)
