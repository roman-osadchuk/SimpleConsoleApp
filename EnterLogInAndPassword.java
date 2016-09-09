package test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

	public class EnterLogInAndPassword {
	
	static Scanner sc = new Scanner(System.in);
	
	private String login;
	private String password1;
	private String password2;
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password) {
		this.password1 = password;
	}
	
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}



	protected void enter(){
		//asking user to enter his login
		boolean isValidLogin = false;
		do {
			System.out.println("Enter your login (it should starts from a letter and contain from 3 to 15 symbols)");
			login = sc.nextLine();
			if(testLogin(login)){
				isValidLogin = true;
				System.out.println("login is valid");
			}
			else{
				System.out.println("Please check your login and re-enter your login");
			}
		} while (!isValidLogin);
		
		//asking user to enter his password
		boolean isValidPassword = false;
		do {
			System.out.println("Enter your password (it should starts from a number and contain less than 10 chars)");
			password1 = sc.nextLine();
			if(testPassword(password1)){
				isValidPassword = true;
				System.out.println("password is valid");
			}
			else{
				System.out.println("Your password is not correct. Please re-check it");
			}
		} while (!isValidPassword);
		
		//asking user to re-enter his password
		isValidPassword = false;
		do {
			System.out.println("Re-enter your password");
			password2 = sc.nextLine();
			if(password1.equals(password2)){
				isValidPassword = true;
				System.out.println("passwords matches");
			}
			else{
				System.out.println("passwords are not equal. re-enter your password!");
			}
		} while (!isValidPassword);
		
		
	}//enter();
		
	
	
	public boolean testLogin(String testLog) throws PatternSyntaxException {
			Pattern pattern = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z\\d]{2,14}$");
			Matcher matcher = pattern.matcher(testLog);
			if(matcher.matches()) return true;
		return false;
	}
		
	public boolean testPassword(String testPass) throws PatternSyntaxException {
			Pattern pattern = Pattern.compile("^\\d{1}[a-zA-Z\\d]{2,9}$");
			Matcher matcher = pattern.matcher(testPass);
			if(matcher.matches()) return true;
		return false;
		
	}
	
	
	public boolean checkForString(String ifString) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(ifString);
		if(matcher.matches()) return true;
		return false;
	}
	
	public boolean checkForInteger(CharSequence ifInt) {	
		Pattern pattern = Pattern.compile("^\\d+$");
		Matcher matcher = pattern.matcher(ifInt);
		if(matcher.matches()) return true;
		return false;
	}
	
	
	
}
