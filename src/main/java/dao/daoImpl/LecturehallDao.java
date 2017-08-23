package dao.daoImpl;

import dao.entity.LecturehallEntity;

import java.util.List;

public interface LecturehallDao {
    public void addLecture(LecturehallEntity lecturehallEntity);

    public void deleteLecture(int id);

    public LecturehallEntity getLectureById(int id);

    public List<LecturehallEntity> getListLecture();
}
