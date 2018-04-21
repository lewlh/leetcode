package me.lewlh.leetcode.problemset;

/**
 * 最小窗口子字符串
 * 
 * 给定一个字符串 S 和一个字符串 T，找到 S 中的最小窗口，它将包含复杂度为 O(n) 的 T 中的所有字符。
 * 
 * 示例： S = "ADOBECODEBANC" T = "ABC" 最小窗口是 "BANC". 注意事项: 如果 S 中没有覆盖 T
 * 中所有字符的窗口，则返回空字符串 ""。 如果有多个这样的窗口，你将会被保证在 S 中总是只有一个唯一的最小窗口。
 * 
 * @author lewlh
 *
 */
public class MinWindow {
	public String minWindow(String s, String t) {
		if (s == null || s.equals("") || t == null || t.equals("")) {
			return "";
		}
		int ss_l = s.length();
		char[] chars = t.toCharArray();
		int ts_l = chars.length;
		int min = ss_l;
		String tmp = "";
		for (int i = 0; i < ss_l; i++) {
			for (int j = ts_l + i; j < ss_l + 1; j++) {
				String sub = s.substring(i, j);
				boolean r = this.isWindow(sub, chars);
				if (r) {
					int subLength = sub.length();
					if (subLength <= min) {
						min = subLength;
						tmp = sub;
					}
					// System.out.println("i=[" + i + "],j=[" + j + "],子串为[" +
					// sub + "],是否是窗口[" + r + "]");
				}
			}
		}
		return tmp;
	}

	private boolean isWindow(String sub, char[] chars) {
		int l = chars.length;
		boolean[] tag = new boolean[l];
		char[] sub_c = sub.toCharArray();

		// for (int i = 0; i < sub_c.length; i++) {
		// for (int j = 0; j < l; j++) {
		// if (chars[j] == sub_c[i] && !tag[j]) {
		// sub_c[i] = ' ';
		// tag[j] = true;
		// if (j + 1 < l) {
		// j++;
		// }
		// }
		// }
		// }

		for (int j = 0; j < l; j++) {
			if (!tag[j]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		MinWindow m = new MinWindow();
		System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(m.minWindow("a", "a"));
		System.out.println(m.minWindow("acbbaca", "aba"));// baca
		System.out.println(m.minWindow(
				"wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon",
				"ozgzyywxvtublcl"));
	}
}
