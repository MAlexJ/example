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
        deleteEntityDao(factoryDaoMySQL, 2);

        // DataBase -> PSQL
       FactoryDao factoryDaoPSQL = new FactoryDaoPSQLImpl();
       deleteEntityDao(factoryDaoPSQL, 3);

    }

    //Account
    //Method getAccountByIdDao(FactoryDao factoryDao);
    //Method addAccountDao(FactoryDao factoryDao);
    //Method updateAccountDao(FactoryDao factoryDao);

    //Discipline
    //Method getDisciplineByIdDao(FactoryDao factoryDao);
    //Method addDisciplineDao(FactoryDao factoryDao);
    //Method updateDisciplineDao(FactoryDao factoryDao);

    public static void deleteEntityDao(FactoryDao factoryDao, int id) {

        AccountDao accountDao = factoryDao.createAccountDao();
        System.out.println("deleteeAccount(1): " + accountDao.deleteeAccount(id));
//        accountDao.addAccount();
//        accountDao.getAccountById(2);
//        accountDao.updateAccount();

        DisciplineDAO disciplineDAO = factoryDao.createDisciplineDAO();
        System.out.println("deleteeDiscipline(1): " + disciplineDAO.deleteeDiscipline(id));
//        disciplineDAO.getDisciplines();
//        disciplineDAO.getDisciplineById(1)
//        disciplineDAO.addDiscipline(Discipline);


    }


}
