package dao.impl;

import dao.DisciplineDAO;
import entity.Discipline;

import java.util.List;

/**
 * Created by admin on 31.03.2015.
 */
public class DisciplinePSQLDaoImpl implements DisciplineDAO {
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
        System.out.print("PSQL" + id + "  ");
        return false;
    }
}
