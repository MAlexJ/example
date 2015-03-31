package dao.impl;

import dao.AccountDao;
import dao.DisciplineDAO;
import dao.FactoryDao;

/**
 * class RsdFactory
 */

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
