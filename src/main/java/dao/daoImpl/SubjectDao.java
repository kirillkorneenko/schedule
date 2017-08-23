package dao.daoImpl;

import dao.entity.SubjectEntity;

import java.util.List;

public interface SubjectDao {

    public void addSubject(SubjectEntity subjectEntity);

    public void deleteSubject(int id);

    public SubjectEntity getSubjectById(int id);

    public List<SubjectEntity> getListSubject();
}
