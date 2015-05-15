package dao.impl;

import dao.EntityDao;
import entity.AbstractEntity;

import java.util.List;

public class BoardFileEntityDaoImpl implements EntityDao {
    @Override
    public List<AbstractEntity> select() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(AbstractEntity entity) {
        return false;
    }

    @Override
    public boolean update(AbstractEntity entity) {
        return false;
    }
}
