package com.malex.lecture_20_DAOfactoryMethod.dao;

/** * Creator interface DAOFactory */
public interface FactoryDao {

  DisciplineDAO createDisciplineDAO();

  AccountDao createAccountDao();
}
