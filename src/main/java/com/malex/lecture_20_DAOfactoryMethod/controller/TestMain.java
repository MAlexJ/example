package com.malex.lecture_20_DAOfactoryMethod.controller;

import com.malex.lecture_20_DAOfactoryMethod.dao.AccountDao;
import com.malex.lecture_20_DAOfactoryMethod.dao.DisciplineDAO;
import com.malex.lecture_20_DAOfactoryMethod.dao.FactoryDao;
import com.malex.lecture_20_DAOfactoryMethod.dao.impl.FactoryDaoMySQLImpl;
import com.malex.lecture_20_DAOfactoryMethod.dao.impl.FactoryDaoPSQLImpl;
import lombok.extern.java.Log;

@Log
public class TestMain {

  public static void main(String[] args) {

    // DataBase -> MySQL
    FactoryDao factoryDaoMySQL = new FactoryDaoMySQLImpl();
    findEntity(factoryDaoMySQL, 2);

    // DataBase -> PSQL
    FactoryDao factoryDaoPSQL = new FactoryDaoPSQLImpl();
    findEntity(factoryDaoPSQL, 3);
  }

  private static void findEntity(FactoryDao factoryDao, int id) {

    AccountDao accountDao = factoryDao.createAccountDao();
    log.info("find Account: " + accountDao.deleteAccount(id));

    DisciplineDAO disciplineDAO = factoryDao.createDisciplineDAO();
    log.info("find Discipline: " + disciplineDAO.deleteeDiscipline(id));
  }
}
