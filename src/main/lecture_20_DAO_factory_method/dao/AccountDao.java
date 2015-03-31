package dao;

import entity.Account;

import java.util.List;

/**
 * Product
 * interface  DAO1
 */

public interface AccountDao {

    List<Account> getAccounts();

    Account getAccountById(int id);

    boolean updateAccount(Account discipline);

    boolean addAccount(Account discipline);

    boolean deleteeAccount(int id);
}
