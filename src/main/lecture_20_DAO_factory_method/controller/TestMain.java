package controller;


import dao.AccountDao;
import dao.DisciplineDAO;
import dao.FactoryDao;
import dao.impl.FactoryDaoMySQLImpl;
import dao.impl.FactoryDaoPSQLImpl;

public class TestMain {

    public static void main(String[] args) {

        // DataBase -> MySQL
        FactoryDao factoryDaoMySQL = new FactoryDaoMySQLImpl();
        createEntityDao(factoryDaoMySQL);

        // DataBase -> PSQL
        FactoryDao factoryDaoPSQL = new FactoryDaoPSQLImpl();
        createEntityDao(factoryDaoPSQL);

    }


    public static void createEntityDao(FactoryDao factoryDao) {

        AccountDao accountDao = factoryDao.createAccountDao();
        System.out.println("deleteeAccount(1): " + accountDao.deleteeAccount(1));
//        accountDao.addAccount();
//        accountDao.getAccountById(2);
//        accountDao.updateAccount();

        DisciplineDAO disciplineDAO = factoryDao.createDisciplineDAO();
        System.out.println("deleteeDiscipline(1): " + disciplineDAO.deleteeDiscipline(2));
//        disciplineDAO.getDisciplines();
//        disciplineDAO.getDisciplineById(1)
//        disciplineDAO.addDiscipline(Discipline);


    }


}
