package com.malex.lecture_20_DAOfactoryMethod.dao.impl;

import com.malex.lecture_20_DAOfactoryMethod.dao.DisciplineDAO;
import com.malex.lecture_20_DAOfactoryMethod.entity.Discipline;
import java.util.List;
import lombok.extern.log4j.Log4j;

@Log4j
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
    log.debug("MySQL" + id + "  ");
    return true;
  }
}
