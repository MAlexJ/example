package dao;


import entity.AbstractEntity;

import java.util.List;

public interface EntityDao {

    List<AbstractEntity> select();

    boolean delete(int id);

    boolean insert(AbstractEntity entity);

    boolean update(AbstractEntity entity);

}
