package atm;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import entity.Account;
import entity.Person;

public class ATMMachine {

	private String location;
	private int Id, deposit, withdraw, transferMoney;
	private boolean validCard;
	private double balance;
	
	public ATMMachine() {
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to bank\nEnter your birtdate and password to verify: ");
	}
}