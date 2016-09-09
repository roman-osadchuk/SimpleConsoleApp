package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	private final static Scanner SC = new Scanner(System.in);
	private static AccountManagement AM = new AccountManagement();
	private final static EnterLogInAndPassword LG = new EnterLogInAndPassword();
	private final static FileManager FM = new FileManager();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//AccountManagement.addAll();
		boolean isRun = true;
		while(isRun){
			System.out.println("Enter 1 to create an account");
			System.out.println("Enter 2 to show all accounts");
			System.out.println("Enter 3 to change information in account");
			System.out.println("Enter 4 to delete account");
			System.out.println("Enter 5 to get sorted information in accounts");
			System.out.println("Enter 6 to save some information to the file");
			System.out.println("Enter 7 to get information from file");
			System.out.println("Enter 0 to exit");
			switch (SC.next()) {
			case "1":{
				createAccount();
				break;
			}
			case "2":{
				showAccounts();
				break;
			}
			case "3":{
				changeInformation();
				break;
			}
			case "4":{
				deleteAccount();
				break;
			}
			case "5":{
				sortInformation();
				break;
			}
			case "6":{
				saveToFile();
				break;
			}
			case "7":{
				readFromFile();
				break;
			}
			case "0":{
				isRun = false;
				break;
			}
			default:{
				defaultMethod();
				break;
			}
		  }//switch
	   }//while
	}//main	


	private static void createAccount() {
		LG.enter();
		String login = LG.getLogin();
		String password1 = LG.getPassword1();
		String password2 = LG.getPassword2();
		System.out.println("enter your first name");	
		String first_name = SC.next();
		System.out.println("enter your last name");
		String last_name = SC.next();
		System.out.println("enter your occupation");
		String occupation = SC.next();
		System.out.println("enter your age");
		int age = SC.nextInt();
		System.out.println("enter amount of your capital funds");
		int capital = SC.nextInt();
		AM.createAccount(login, password1, password2, first_name, last_name, occupation, age, capital);
		System.out.println(AM.getAccountMainteiner());
	}

	
	private static void showAccounts() {
		AM.showAllInformationInAccounts();
	}

	
	private static void changeInformation() {
		System.out.println("enter login to your account");
		String login = SC.next();
		System.out.println("enter password to your account");
		String password = SC.next();
		if(AM.checkInformation(login, password)){
			boolean isRun = true;
			do {
			System.out.println("enter 1 if you want to change your first name");
			System.out.println("enter 2 if you want to change your last name");
			System.out.println("enter 3 if you want to change your occupation");
			System.out.println("enter 4 if you want to change your age");
			System.out.println("enter 5 if you want to change your capital funds");
			System.out.println("enter 6 to get back to previous menu");
			switch(SC.next()){
			case "1":{
				String getField = "first_name";
				System.out.println("your current first name is " + AM.getField(login, password, getField));
				System.out.println("enter your new first name");
				String first_name = SC.next();
				String setField = first_name;
				AM.setField(login, password, getField, setField);
				break;
			}
			case "2":{
				String getField = "last_name";
				System.out.println("your current last name is " + AM.getField(login, password, getField));
				System.out.println("enter your new last name");
				String last_name = SC.next();
				String setField = last_name;
				AM.setField(login, password, getField, setField);
				break;
			}
			case "3":{
				String getField = "occupation";
				System.out.println("your current occupation is " + AM.getField(login, password, getField));
				System.out.println("enter your new occupation");
				String occupation = SC.next();
				String setField = occupation;
				AM.setField(login, password, getField, setField);
				break;
			}
			case "4":{
				String getField = "age";
				System.out.println("your current age is " + AM.getFieldInt(login, password, getField));
				System.out.println("enter your new age");
				int age = SC.nextInt();
				int setFieldInt = age;
				AM.setFieldInt(login, password, getField, setFieldInt);
				break;
			}
			case "5":{
				String getField = "capital";
				System.out.println("your current capital funds is " + AM.getFieldInt(login, password, getField));
				System.out.println("enter your new capital funds");
				int capital = SC.nextInt();
				int setFieldInt = capital;
				AM.setFieldInt(login, password, getField, setFieldInt);
				break;
			}
			case "6":{
				isRun = false;
				break;
			}
			default :{
				System.out.println("you entered unknown command");
			}
		  }//switch
		}//do
		while (isRun);
		  //System.out.println(AM.getAccountMainteiner());
		}//if
		else{
			System.out.println("you entered wrong login or password");
		}
	}//method
	
	
	private static void deleteAccount() {
		System.out.println("enter login to your account");
		String login = SC.next();
		System.out.println("enter password to your account");
		String password = SC.next();
		if(AM.checkInformation(login, password)) {
			AM.deleteAccount(login, password);
		}
	}

	
	private static void sortInformation() {
		boolean isRun = true;
		while(isRun){
			System.out.println("Enter 1 to sort first names");
			System.out.println("Enter 2 to sort last names");
			System.out.println("Enter 3 to sort occupations");
			System.out.println("Enter 4 to sort age");
			System.out.println("Enter 5 to sort capital funds");
			System.out.println("Enter 6 to get back to urevious menu");
			switch (SC.next()) {
			case "1":{
				int number = 1;
				AM.comparator(number);
				break;
			}
			case "2":{
				int number = 2;
				AM.comparator(number);
				break;
			}
			case "3":{
				int number = 3;
				AM.comparator(number);
				break;
			}
			case "4":{
				int number = 4;
				AM.comparator(number);
				break;
			}
			case "5":{
				int number = 5;
				AM.comparator(number);
				break;
			}
			case "6":{
				isRun = false;
				break;
			}
			default:{
				defaultMethod();
				break;
			}
		  }//switch
	   }//while
	}//method
	
	
	private static void saveToFile() throws IOException, ClassNotFoundException {
		System.out.println("enter information which you wanna save to file");
		String message = SC.next();
		FM.writeToFile(message);
		//FM.fileOutputStream();
		//FM.fileInputStream();
	}
	
	
	private static void readFromFile() throws FileNotFoundException {
		FM.readFromFile();
	}


	private static void defaultMethod() {
		System.out.println("you entered unknown command");
	}
	
}

