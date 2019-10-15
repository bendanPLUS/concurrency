package com.bendanplus.algorithm.剑指offer;

/**
 * 翻转单词顺序列
 * Input:
 * "I am a student."
 * <p>
 * Output:
 * "student. a am I"
 * 思路 :
 * 题目应该有一个隐含条件，就是不能用额外的空间。虽然 Java 的题目输入参数为 String 类型，需要先创建一个字符数组使得空间复杂度为 O(N)，但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
 * 传送门:https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class 面试题58 {

	public String ReverseSentence(String str) {
		if (str == null || str.trim().length() == 0) {
			return str;
		}
		final char[] chars = str.toCharArray();
		reverse(chars, 0, chars.length - 1);
		int left = -1;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				reverse(chars, left + 1, i - 1);
				left = i;
			}
		}
		if (chars[chars.length - 1] != ' ') {
			reverse(chars, left + 1, chars.length - 1);
		}
		return new String(chars);
	}

	private void reverse(char[] chars, int left, int right) {
		if (chars == null || chars.length == 0) {
			return;
		}
		while (left < right) {
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}
	}


}
