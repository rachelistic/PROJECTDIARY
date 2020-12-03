import co.rachel.test.encryption.Encryption;

public class mainApp {

	public static void main(String[] args) {
		Encryption en = new Encryption();
		String str = "ABa21A";
		String encStr = en.encrypto(str);
		System.out.println("초기 데이터  " + str);
		System.out.println("암호화 데이터  " + encStr);

				
	}

}
