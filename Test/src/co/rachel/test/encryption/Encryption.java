package co.rachel.test.encryption;



public class Encryption {

	public String encrypto(String str) {
		String encStr = "A+=";
		char[] cs = new char[20];
		for(int i = 0; i<str.length();i++) {
			cs[i] = str.charAt(i);
		}
		for(char c: cs) {
				if(c != 0) {
					encStr += c >> 3;//비트이동
				}
		}
		encStr += "-@#%f";
		return encStr;
	}

}
