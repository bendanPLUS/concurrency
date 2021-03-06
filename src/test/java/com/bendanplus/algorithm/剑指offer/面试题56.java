package com.bendanplus.algorithm.剑指offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。
 * 传送门:https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13
 * &tqId=11193&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 思路:
 * 两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
 */
public class 面试题56 {
	public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
		if (nums == null || nums.length <= 0) {
			return;
		}
		int diff = 0;
		for (int i = 0; i < nums.length; i++) {
			diff ^= nums[i];
		}
		int index = diff & (-diff);
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & index) == 0) {
				num1[0] ^= nums[i];
			} else {
				num2[0] ^= nums[i];
			}
		}
	}
}
