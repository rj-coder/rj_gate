package rj.gate;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class EncryptionJav {

	public static void main(String[] args) throws IOException {
		File f= new File("a.txt");
		
		CipherInputStream cf = new CipherInputStream(, Cipher.getInstance("AES"));
		
		
	}

}
