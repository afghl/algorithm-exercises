# mypy --ignore-missing-imports
# 给定线性序集中n个元素和一个整数k，1≤k≤n，要求找出这n个元素中第k小的元素
# Median of Medians

from typing import List


def select_kth_smallest(arr, k):
    """
    在数组 arr 中查找第 k 小元素（k 从 1 开始计）。
    最坏情况下的时间复杂度为 O(n)。
    """
    if not 1 <= k <= len(arr):
        raise ValueError("k 超出数组范围。")
    # 调用递归函数，在索引范围内查找第 k 小
    return _select(arr, 0, len(arr) - 1, k - 1)  # k-1 转成 0-based 索引


def _select(arr, left, right, k_index):
    """
    在子区间 arr[left..right] 中查找第 k_index (0-based) 小的元素。
    """
    while True:
        # 如果区间只有一个元素，直接返回即可
        if left == right:
            return arr[left]

        # 选取枢轴索引 (median of medians)
        pivot_index = _median_of_medians(arr, left, right)

        # 将 pivot 放到分区后应处的位置，并获取该位置
        pivot_index = _partition(arr, left, right, pivot_index)

        if pivot_index == k_index:
            return arr[pivot_index]
        elif pivot_index > k_index:
            right = pivot_index - 1
        else:
            left = pivot_index + 1


def _median_of_medians(arr, left, right):
    """
    在 arr[left..right] 之间选出一个枢轴索引 (pivot_index)，
    利用分组、找中位数的中位数的思想，以保证最坏情况 O(n)。
    """
    # 如果当前片段长度 <= 5，直接用简单排序取中位数
    if right - left < 5:
        return _partition5(arr, left, right)

    # 将区间 [left..right] 分成若干组，每组 5 个元素
    # 并将每组的中位数放到前面位置，最后递归找这些中位数的中位数
    sub_left = left
    for i in range(left, right + 1, 5):
        sub_right = i + 4
        if sub_right > right:
            sub_right = right

        # 获取小组中位数下标
        median5_index = _partition5(arr, i, sub_right)

        # 将该组中位数放到 sub_left 位置 (相当于收集到前面)
        arr[sub_left], arr[median5_index] = arr[median5_index], arr[sub_left]
        sub_left += 1

    # 现在 [left..sub_left-1] 存放了各组的中位数
    # 递归调用，在这些中位数里找出真正的中位数
    mid = (sub_left - 1 + left) // 2
    return _select(arr, left, sub_left - 1, mid)


def _partition5(arr, left, right):
    """
    对 arr[left..right] 区间（长度 <= 5）进行排序，
    并返回该区间中位数的索引。
    """
    # 简单的插入排序 / 直接 sort 都可以，这里直接使用内置排序
    arr[left : right + 1] = sorted(arr[left : right + 1])
    mid = (left + right) // 2
    return mid


def _partition(arr, left, right, pivot_index):
    """
    根据 arr[pivot_index] 进行分区，
    分区完成后返回 pivot_index 在分区后应在的位置。
    """
    pivot_value = arr[pivot_index]
    # 先把 pivot 移到 right 位置
    arr[pivot_index], arr[right] = arr[right], arr[pivot_index]
    store_index = left

    # 分区：小于 pivot_value 的往左放
    for i in range(left, right):
        if arr[i] < pivot_value:
            arr[store_index], arr[i] = arr[i], arr[store_index]
            store_index += 1

    # 最后将 pivot 放回正确位置
    arr[store_index], arr[right] = arr[right], arr[store_index]
    return store_index
