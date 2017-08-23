package dao.daoImpl;

import dao.entity.TeacherEntity;

import java.util.List;

public interface TeacherDao {
    public void addTeacher(TeacherEntity teacherEntity);

    public void deleteTeacher(int id);

    public TeacherEntity getTeacherById(int id);

    public List<TeacherEntity> getListTeacher();
}
