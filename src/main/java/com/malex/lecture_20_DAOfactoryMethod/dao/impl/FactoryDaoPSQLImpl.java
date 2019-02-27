package com.malex.lecture_20_DAOfactoryMethod.dao.impl;

import com.malex.lecture_20_DAOfactoryMethod.dao.AccountDao;
import com.malex.lecture_20_DAOfactoryMethod.dao.DisciplineDAO;
import com.malex.lecture_20_DAOfactoryMethod.dao.FactoryDao;

public class FactoryDaoPSQLImpl implements FactoryDao {
  @Override
  public DisciplineDAO createDisciplineDAO() {
    return new DisciplinePSQLDaoImpl();
  }

  @Override
  public AccountDao createAccountDao() {
    return new AccountDaoPSQLImpl();
  }
}
