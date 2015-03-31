package dao.impl;

import dao.AccountDao;
import dao.DisciplineDAO;
import dao.FactoryDao;

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
