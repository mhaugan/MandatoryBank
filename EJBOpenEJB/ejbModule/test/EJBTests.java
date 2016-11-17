package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import entity.Account;
import entity.Person;
import sessionBeans.AccountsRemote;
import sessionBeans.PersonerRemote;

public class EJBTests {

	
	@EJB
	PersonerRemote personer;
	AccountsRemote accounts;
	Context context;

	@Before
	public void setUp() throws Exception {
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.openejb.client.RemoteInitialContextFactory");
		p.put("BankDBDatasource","new://Resource?type=DataSource");
		p.put("BankDBDatasource.JdbcDriver","org.hsqldb.jdbcDriver");
		p.put("BankDBDatasource.JdbcUrl","jdbc:hsqldb:file:data/bankdb/hsqldb");
		p.put("Unmanaged_BankDBDataSource","new://Resource?type=DataSource");
		p.put("Unmanaged_BankDBDataSource.JdbcDriver","org.hsqldb.jdbcDriver");
		p.put("Unmanaged_BankDBDataSource.JdbcUrl","jdbc:hsqldb:file:data/bankdb/hsqldb");
		p.put("Unmanaged_BankDBDataSource.JtaManaged","false");
		context = new InitialContext(p);
		personer = (PersonerRemote)context.lookup("PersonerRemote");
		accounts = (AccountsRemote)context.lookup("AccountsRemote");
	}
	
//	String socialSecurityNumber, String name, String password, String pin
//	double balance, int accountNumber, int customerId
	@Test
	public void add_Person_expectTrue() {
		Person person = new Person("080591", "Mats", "passord", "1234");
		List<Person> list = new ArrayList<>();
		list.add(person);
		int result = list.size();
		
		assertThat(1, equalTo(result));
		
		System.out.println("Name: " + person.getNavn() + 
				"\nSSN: " + person.getFodselsnummer() + 
				"\nPW: "+ person.getPassord() + 
				"\nPiN: " + person.getPIN_kode() + 
				"\nId: " + person.getId());
	}
	
	@Test
	public void add_Account_expectTrue() {
		Account acc = new Account(1000, "5555 444 6666", "080591");
		List<Account> list = new ArrayList<>();
		list.add(acc);
		
		int result = list.size();
		
		assertThat(1, equalTo(result));
		
		System.out.println("Balance: " + acc.getBalance() +
				"\nCardNr: " + acc.getAccountNumber() + 
				"\nId: " + acc.getCustomerId());
	}
}
