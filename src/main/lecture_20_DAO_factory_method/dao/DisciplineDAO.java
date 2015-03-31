package dao;

import entity.Discipline;

import java.util.List;

/**
 * Product
 * interface  DAO2
 */

public interface DisciplineDAO {

    List<Discipline> getDisciplines();

    Discipline getDisciplineById(int id);

    boolean updateDiscipline(Discipline discipline);

    boolean addDiscipline(Discipline discipline);

    boolean deleteeDiscipline(int id);

}
