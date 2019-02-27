package com.malex.lecture_20_DAOfactoryMethod.dao.impl;

import com.malex.lecture_20_DAOfactoryMethod.dao.AccountDao;
import com.malex.lecture_20_DAOfactoryMethod.dao.DisciplineDAO;
import com.malex.lecture_20_DAOfactoryMethod.dao.FactoryDao;

/** class RsdFactory */
public class FactoryDaoMySQLImpl implements FactoryDao {

  @Override
  public DisciplineDAO createDisciplineDAO() {
    return new DisciplineMySQLDaoImpl();
  }

  @Override
  public AccountDao createAccountDao() {
    return new AccountDaoMySQLImpl();
  }
}
