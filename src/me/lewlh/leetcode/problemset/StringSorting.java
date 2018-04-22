package mycode;

public class StringSorting {
	static String example = "adgaADccleZQaIImmwq";

	/**
	 * 处理一串字符串，按照原来的次序，把小写的放在字符前面，把大写的放在字符后面:adgaADccleZQaIImmwq --
	 * adgaccleammwqADZQII
	 * 
	 * @param str
	 * @return
	 */
	public String deal(String str) {
		char[] cs = str.toCharArray();
		for (int i = cs.length - 1; i >= 0; i--) {
			char nowChar = cs[i];
			if (!Character.isLowerCase(nowChar)) {
				if (i == cs.length - 1) {

				} else {
					for (int j = i + 1; j < cs.length; j++) {
						if (Character.isLowerCase(cs[j])) {
							cs[j - 1] = cs[j];
							cs[j] = nowChar;
						} else {
							cs[j] = nowChar;
						}
						System.out.println(String.valueOf(cs));
					}
				}
			}
		}	
		
		return String.valueOf(cs);
	}

	private void sss(int now_tag, char[] data) {
		if (now_tag >= data.length - 1) {
			return;
		}
		

	}

	public static void main(String args[]) {
		StringSorting q = new StringSorting();
		System.out.println(q.deal(example));
	}

}
