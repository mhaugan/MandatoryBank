package sessionBeans;

import java.util.List;

import javax.ejb.Remote;

import entity.Account;

@Remote
public interface AccountsRemote {
	public void add(Account account) throws Exception;
	public void remove(Account account) throws Exception;
	public List<Account> list() throws Exception;
}
