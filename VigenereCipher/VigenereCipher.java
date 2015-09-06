import java.util.Scanner;

public class VigenereCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher.");
		System.out.print("Would you like to encode or decode a message? ");
		String option = input.nextLine();
		if (!(option.equals("encode") || option.equals("decode"))) {
			System.out.println("The only valid options are \"encode\" or \"decode\". Exiting.");
			input.close();
			return;
		}
		System.out.print("Enter the string to " + option + ": ");
		String inputText = input.nextLine();
		if (! isValidString(inputText)) {
			System.out.println("Your string contains a character outside of the range a-z. Exiting.");
			input.close();
			return;
		}
		
		System.out.print("Enter the key "+ ": ");
		String inputKey = input.nextLine();
		input.close();
		if (! isValidString(inputKey)) {
			System.out.println("Your key contains a character outside of the range a-z. Exiting.");
			return;
		}

		System.out.println(vigenere(inputText, option.equals("encode"), inputKey));
	}
	
	public static boolean isValidString(String string) {
		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			if (currentChar < 'a' || currentChar > 'z')
				return false;
		}
		return true;
	}
	
	public static String vigenere(String inputText, boolean encode, String inputKey){

		char[] ciphered = new char[inputText.length()];
		if(encode){
			for(int i = 0; i < inputText.length(); i++) {
				char n = (char) (inputKey.charAt(i % inputKey.length()) - 'a');
				ciphered[i] = (char) ((((inputText.charAt(i) - 'a') + n) % 26) + 'a');
			}
		}
		else {
			for(int i = 0; i < inputText.length(); i++) {
				char n = (char) (inputKey.charAt(i % inputKey.length()) - 'a');
				ciphered[i] = (char) ((((inputText.charAt(i) - 'a') + 26 - n) % 26) + 'a');
			}
		}
		return new String(ciphered);
	}

}
