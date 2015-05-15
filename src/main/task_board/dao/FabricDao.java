package dao;

/**
 * Created by Alex on 14.05.2015.
 */
public interface FabricDao {

    boolean openConnection(EntityDao entityDao);

    boolean closeConnection(EntityDao entityDao);

    EntityDao dataSource(EntityDao entityDao);

}
