package test;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
	

	//saving information to the file
	public void writeToFile(String message) {
		
		 File file = new File("test.txt");
		 try {
			PrintWriter output = new PrintWriter(file);
			output.println(message);
			output.flush();
			output.close();
		} catch (IOException e) {
			System.out.println("Error : " + e);
		}
	}
	
	//reading from the file
	public void readFromFile() throws FileNotFoundException {
		File file = new File("test.txt");
		Scanner input = new Scanner(file);
		String word = input.nextLine();
		input.close();
		
		System.out.println("The file contains : " + word);
		
	}
	
	//serialize (object to disk) the collection of accounts
	public void fileOutputStream() throws IOException {
		File file = new File("accounts.txt");
		List<AccountMainteiner> accounts = new ArrayList<>();
		accounts.add(new AccountMainteiner("rom1", "pass1", "pass1", "Roman", "Osadchuk", "progr", 22, 800));
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream output = new ObjectOutputStream(fos);
		for(AccountMainteiner ac : accounts) {
			output.writeObject(ac);
		}
		output.close();
		fos.close();
	}

	//deserialize file back to the collection
	public void fileInputStream() throws IOException, ClassNotFoundException {
		File file = new File("accounts.txt");
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream input = new ObjectInputStream(fi);
		List<AccountMainteiner> accounts2 = new ArrayList<>();
		try {
			while(true) {
				AccountMainteiner ac = (AccountMainteiner) input.readObject();
				accounts2.add(ac);
			}
		} catch (EOFException e) {
			System.out.println("End of file Exception!");
		}
		for(AccountMainteiner ac : accounts2) {
			System.out.println(ac);
		}
		
	}
	
	
	
}
