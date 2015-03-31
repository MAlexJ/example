package dao;

/**
 ** Creator
 * interface DAOFactory
 */

public interface FactoryDao {

    public DisciplineDAO createDisciplineDAO();

    public AccountDao createAccountDao();

}
