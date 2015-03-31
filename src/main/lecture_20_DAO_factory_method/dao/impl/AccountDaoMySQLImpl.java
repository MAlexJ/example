package dao.impl;

import dao.AccountDao;
import database.DBConnection;
import entity.Account;

import java.util.List;

/**
 * class RdbDAO1
 */

public class AccountDaoMySQLImpl implements AccountDao {

    // JDBC dependency -> pom.xml
    //DBConnection dbConnection = new DBConnection();

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
        //DataSource
        //  dbConnection.deleteDicsepline(id);
        return true;
    }
}
