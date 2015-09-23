import java.util.Scanner;


public class VigenereCipher {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String chosen_password;
		String key = "VIGENERECIPHER";
		
		System.out.println("Jong Woo Lee\nBronco ID:008313006\n");
		System.out.println("The chosen password: ");
		chosen_password = scanner.nextLine();
		
		String cipher_text = cipher(key, chosen_password);
		System.out.println("\nThe ciphered text is: " + cipher_text);
		
		String decipher_text = decrypt(key, cipher_text);
		System.out.println("The deciphered text is: " + decipher_text);
	}
	
	//Cipher method takes in key and the chosen password
	public static String cipher(String key, String password){
		String s = "";
		//Upper case the password
		password = password.toUpperCase();
		for(int i = 0, j = 0; i < password.length(); i++){
			char letter = password.charAt(i);
			if(letter == ' '){
				s += " ";
				continue;
			}
			//Move onto the next iteration if letter less than A or greater than Z
			if(letter < 'A' || letter > 'Z'){
				continue;
			}
			//String the characters together after encryption
			s += (char)((letter + key.charAt(j) - 2 * 'A') % 26 + 'A');
			j = ++j % key.length();
		}
		return s;
	}
	
	//Decipher method which takes in the key along with the ciphered password
	public static String decrypt(String key, String password){
		String s = "";
		password = password.toUpperCase();
		for(int i = 0, j = 0; i < password.length(); i++){
			char letter = password.charAt(i);
			if(letter == ' '){
				s += " ";
			}
			//Move onto the next iteration if letter less than A or greater than Z
			if(letter < 'A' || letter > 'Z'){
				continue;
			}
			//String the characters together for decryption
			s += (char)((letter - key.charAt(j) + 26) % 26 + 'A');
			j = ++j % key.length();
		}
		
		return s;
	}
	
		
}
