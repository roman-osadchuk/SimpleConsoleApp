package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AccountManagement {
	
	AccountMainteiner am = new AccountMainteiner();
	
	private AccountMainteiner accountmainteiner;
	
	public AccountMainteiner getAccountmainteiner() {
		return accountmainteiner;
	}

	public void setAccountmainteiner(AccountMainteiner accountmainteiner) {
		this.accountmainteiner = accountmainteiner;
	}

	private static final List<AccountMainteiner> accounts = new ArrayList<>();
	
	
	public List<AccountMainteiner> getAccountMainteiner(){
		return accounts;
	}
	
	//displays logins of all available accounts
	public void showAccounts(){
		int count = 0;
		for(AccountMainteiner acc : accounts){
			System.out.println("account number(" + count + ") - login = " + acc.getLogin());
			count++;
		}
	}
	
	
	public void showAllInformationInAccounts() {
		for(AccountMainteiner ac : accounts) {
			System.out.println(ac);
		}
	}
	
	//creating an account
	public void createAccount(String login, String password1, String password2, String first_name, 
			String last_name, String occupation, int age, int capital){
		accounts.add(new AccountMainteiner(login, password1, password2, first_name, last_name, occupation, age, capital));
	}
	
	static AccountMainteiner acc1 = new AccountMainteiner("rom1", "pass1", "pass1", "Roman", "Osadchuk", "progr", 22, 900);
	static AccountMainteiner acc2 = new AccountMainteiner("rom2", "pass2", "pass2", "Igor", "Petrenko", "lawyer", 23, 100);
	static AccountMainteiner acc3 = new AccountMainteiner("rom3", "pass3", "pass3", "Petro", "Yatsuk", "econom", 19, 300);
	static AccountMainteiner acc4 = new AccountMainteiner("rom4", "pass4", "pass4", "Stepan", "Snihur", "build", 28, 250);
	static AccountMainteiner acc5 = new AccountMainteiner("rom5", "pass5", "pass5", "Mykola", "Zozylya", "manag", 25, 600);
	
	
	protected static void addAll() {
		accounts.addAll(Arrays.asList(acc1, acc2, acc3, acc4, acc5));
		System.out.println(accounts.size());
	}

	
	public void changeInformation(String login, String password){
		
	}

	//checking if login and password corresponds to certain account
	public boolean checkInformation(String login, String password) {
		for(AccountMainteiner ac : accounts){
			if((ac.getLogin().equals(login)) && ac.getPassword1().equals(password)) {
				System.out.println("login and password are valid");
				return true;
			}
		}
		System.out.println("login or password are invalid");
		return false;
	}

	//obtaining String value of String field
	public String getField(String login, String password, String getField) {
		for(AccountMainteiner ac : accounts){
			if((ac.getLogin().equals(login)) && ac.getPassword1().equals(password)){
				if(getField.equals("first_name")) {
					return ac.getFirst_name();
				}
				if(getField.equals("last_name")) {
					return ac.getLast_name();
				}
				if(getField.equals("occupation")) {
					return ac.getOccupation();
				}
		//		
			}
		}
		return "Field wasn't set up";
	}
	
	//obtaining integer value of integer field
	public int getFieldInt(String login, String password, String getField) {
		for(AccountMainteiner ac : accounts){
			if((ac.getLogin().equals(login)) && ac.getPassword1().equals(password)){
				if(getField.equals("age")) {
					return ac.getAge();
				}
				if(getField.equals("capital")) {
					return ac.getCapital();
				}
			}
		}
		return 0;
	}
	
	//setting new String field due to login, password and obtained field which should be changed
	public void setField(String login, String password, String getField, String setField) {
		for(AccountMainteiner ac : accounts){
			if((ac.getLogin().equals(login)) && ac.getPassword1().equals(password)){
				if(getField.equals("first_name")) {
					ac.setFirst_name(setField);
				}
				if(getField.equals("last_name")) {
					ac.setLast_name(setField);
				}
				if(getField.equals("occupation")) {
					ac.setOccupation(setField);
				}
			}
		}
	}
	
	//setting new integer field due to login, password and obtained field which should be changed
	public void setFieldInt(String login, String password, String getField, int setFieldInt) {
		for(AccountMainteiner ac : accounts){
			if((ac.getLogin().equals(login)) && ac.getPassword1().equals(password)){
				if(getField.equals("age")) {
					ac.setAge(setFieldInt);
				}
				if(getField.equals("capital")) {
					ac.setCapital(setFieldInt);
				}
			}
		}
	}
	
	//deleting account due to login and password
	public void deleteAccount(String login, String password) {
		Iterator<AccountMainteiner> iter = accounts.iterator();
		while(iter.hasNext()) {
			AccountMainteiner temp = iter.next();
			if((temp.getLogin().equals(login)) && temp.getPassword1().equals(password)){
				iter.remove();
				System.out.println("your account (" + login + ") was successfully deleted");
			}
		}
	}
	
	public void comparator(int number) {
			if(number == 1) {
				Collections.sort(accounts, new FirstNameComparator());
				for(AccountMainteiner acc : accounts) {
					System.out.println(acc.getFirst_name());
				}
			}
			if(number == 2) {
				Collections.sort(accounts, new LastNameComparator());
				for(AccountMainteiner acc : accounts) {
					System.out.println(acc.getLast_name());
				}
			}
			if(number == 3) {
				Collections.sort(accounts, new OccupationComparator());
				for(AccountMainteiner acc : accounts) {
					System.out.println(acc.getOccupation());
				}
			}
			if(number == 4) {
				Collections.sort(accounts, new AgeComparator());
				for(AccountMainteiner acc : accounts) {
					System.out.println(acc.getAge());
				}
			}
			if(number == 5) {
				Collections.sort(accounts, new CapitalComparator());
				for(AccountMainteiner acc : accounts) {
					System.out.println(acc.getCapital());
				}
			}
		}

	
	
	
}
