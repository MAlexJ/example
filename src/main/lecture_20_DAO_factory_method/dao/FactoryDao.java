package dao;

/**
 * interface DAOFactory
 */

public interface FactoryDao {

    public DisciplineDAO createDisciplineDAO();

    public AccountDao createAccountDao();

}
