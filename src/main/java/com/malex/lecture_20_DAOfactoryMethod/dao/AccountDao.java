package com.malex.lecture_20_DAOfactoryMethod.dao;

import com.malex.lecture_20_DAOfactoryMethod.entity.Account;
import java.util.List;

/** Product interface DAO1 */
public interface AccountDao {

  List<Account> getAccounts();

  Account getAccountById(int id);

  boolean updateAccount(Account discipline);

  boolean addAccount(Account discipline);

  boolean deleteAccount(int id);
}
