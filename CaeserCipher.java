import java.util.Scanner;

public class CaeserCipher {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("This program encrypts and decrypts messages using the Caeser Cipher.");
		System.out.print("Would you like to encode or decode a message? ");
		String option = input.nextLine();
		if (!(option.equals("encode") || option.equals("decode"))) {
			System.out.println("The only valid options are \"encode\" or \"decode\". Exiting.");
			input.close();
			return;
		}
		System.out.print("Enter the string to " + option + ": ");
		String inputText = input.nextLine();
		input.close();
		
		for (int i = 0; i < inputText.length(); i++) {
			char currentChar = inputText.charAt(i);
			if (currentChar < 'a' || currentChar > 'z') {
				System.out.println("Your string contains a character outside of the range a-z. Exiting.");
				return;
			}
		}
		
		
		caeser(inputText, option.equals("encode"));
		
	}
	
	static void caeser (String inputText, boolean encode) {
		for (int n = 0; n < 26; n++) {
			char[] n_ciphered = new char[inputText.length()];
			if (encode)
				for (int i = 0; i < n_ciphered.length; i++) 
					n_ciphered[i] = (char) ((((inputText.charAt(i) - 'a') + n) % 26) + 'a');
			else
				for (int i = 0; i < n_ciphered.length; i++) 
					n_ciphered[i] = (char) (((inputText.charAt(i) - 'a' - n + 26) % 26) + 'a');
			System.out.println("n = " + n + ": " + new String(n_ciphered));
		}
		return;
	}

}
