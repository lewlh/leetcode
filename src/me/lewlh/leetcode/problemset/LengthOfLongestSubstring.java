package me.lewlh.leetcode.problemset;

/**
 * 给定一个字符串，找出不含有重复字符的 最长子串 的长度。
 * 
 * 示例： 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。 给定 "bbbbb" ，最长的子串就是 "b"
 * ，长度是1。 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
 * 
 * @author lewlh
 * @url https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int longest = 0;
		if (s == null || s.length() == 0) {
			return longest;
		}
		int length = s.length();
		String subStr = "";
		for (int i = 0; i < length; i++) {
			String c = s.charAt(i) + "";
			if (subStr.contains(c)) {

				int l = subStr.length();
				if (l > longest) {
					longest = l;
				}
				int index = subStr.indexOf(c);
				// System.out.println(subStr + "，长度为" + l + "，包含" + c + ",位置在" +
				// index);
				subStr = subStr.substring(index + 1, l);
			}
			subStr += c;
		}
		int l = subStr.length();
		if (l > longest) {
			return l;
		}
		return longest;
	}

	public static void main(String[] args) {
		LengthOfLongestSubstring n = new LengthOfLongestSubstring();
		System.out.println(n.lengthOfLongestSubstring("dvdf"));
		System.out.println(n.lengthOfLongestSubstring("aab"));
		System.out.println(n.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(n.lengthOfLongestSubstring("bbbbb"));
		System.out.println(n.lengthOfLongestSubstring("pwwkew"));
	}
}
