package dao.impl;

import dao.AccountDao;
import entity.Account;

import java.util.List;

/**
 * Created by admin on 31.03.2015.
 */
public class AccountDaoPSQLImpl implements AccountDao {
    @Override
    public List<Account> getAccounts() {
        return null;
    }

    @Override
    public Account getAccountById(int id) {
        return null;
    }

    @Override
    public boolean updateAccount(Account discipline) {
        return false;
    }

    @Override
    public boolean addAccount(Account discipline) {
        return false;
    }

    @Override
    public boolean deleteeAccount(int id) {
        System.out.print("PSQL" + id + "  ");
        return false;
    }
}
