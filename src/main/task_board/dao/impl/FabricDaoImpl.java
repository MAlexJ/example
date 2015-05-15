package dao.impl;

import dao.EntityDao;
import dao.FabricDao;

/**
 * Created by Alex on 14.05.2015.
 */
public class FabricDaoImpl implements FabricDao {
    private BoardFileEntityDaoImpl boardFileEntityDao;
    private BoardJsonEntityDaoImpl boardJsonEntityDao;
    private ContextFileEntityDaoImpl contextFileEntityDao;
    private ContextJsonEntityDaoImpl contextJsonEntityDao;
    private UserFileEntityDaoImpl userFileEntityDao;
    private UserJsonEntityDaoImpl userJsonEntityDao;


    @Override
    public boolean openConnection(EntityDao entityDao) {
        return false;
    }

    @Override
    public boolean closeConnection(EntityDao entityDao) {
        return false;
    }

    @Override
    public EntityDao dataSource(EntityDao entityDao) {
        return entityDao;
    }
}
