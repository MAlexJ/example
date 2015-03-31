package dao.impl;

import dao.DisciplineDAO;
import entity.Discipline;

import java.util.List;

/**
 * class RdbDAO2
 */

public class DisciplineMySQLDaoImpl implements DisciplineDAO {
    @Override
    public List<Discipline> getDisciplines() {
        return null;
    }

    @Override
    public Discipline getDisciplineById(int id) {
        return null;
    }

    @Override
    public boolean updateDiscipline(Discipline discipline) {
        return false;
    }

    @Override
    public boolean addDiscipline(Discipline discipline) {
        return false;
    }

    @Override
    public boolean deleteeDiscipline(int id) {
        System.out.print("MySQL" + id + "  ");
        return true;
    }
}
