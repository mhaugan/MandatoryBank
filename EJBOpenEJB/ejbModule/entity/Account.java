package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Account")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column (name = "Balance")
	private double balance;
	
	@Column (name = "Account_Number", length = 11)
	private String accountNumber;

	@Column (name = "customerId")
	private String customerId;
	
	@Column (name = "Withdraw")
	private int withdraw;
	
	@Column (name = "Deposit")
	private int deposit;
	
	@Column (name ="transfer")
	private int transfer;
	
	public Account() {
	}
	
	public Account(double balance, String accountNumber, String customerId) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.customerId = customerId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId){
		this.customerId = customerId;
	}
	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getTransfer() {
		return transfer;
	}

	public void setTransfer(int transfer) {
		this.transfer = transfer;
	}
}
