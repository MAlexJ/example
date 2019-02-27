package com.malex.lecture_20_DAOfactoryMethod.dao.impl;

import com.malex.lecture_20_DAOfactoryMethod.dao.AccountDao;
import com.malex.lecture_20_DAOfactoryMethod.entity.Account;
import java.util.List;
import lombok.extern.log4j.Log4j;

@Log4j
public class AccountDaoMySQLImpl implements AccountDao {

  // JDBC dependency -> pom.xml
  // DBConnection dbConnection = new DBConnection();

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
  public boolean deleteAccount(int id) {
    // DataSource
    //  dbConnection.deleteDicsepline(id);
    return true;
  }
}
