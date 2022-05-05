package com.malex.lecture_20_DAOfactoryMethod.dao.impl;

import com.malex.lecture_20_DAOfactoryMethod.dao.AccountDao;
import com.malex.lecture_20_DAOfactoryMethod.entity.Account;

import java.util.List;
import lombok.extern.java.Log;

@Log
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
    public boolean deleteAccount(int id) {
        log.info("PSQL" + id + "  ");
        return false;
    }
}
