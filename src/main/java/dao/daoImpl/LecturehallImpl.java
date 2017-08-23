package dao.daoImpl;

import dao.entity.LecturehallEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LecturehallImpl implements LecturehallDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addLecture(LecturehallEntity lecturehallEntity) {
        Session session= this.sessionFactory.getCurrentSession();
        session.persist(lecturehallEntity);
    }

    @Override
    public void deleteLecture(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        LecturehallEntity lecturehallEntity= (LecturehallEntity) session.load(LecturehallEntity.class, new Integer(id));
        if(lecturehallEntity!=null){
            session.delete(lecturehallEntity);
        }
    }

    @Override
    public LecturehallEntity getLectureById(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        LecturehallEntity lecturehallEntity= (LecturehallEntity) session.load(LecturehallEntity.class, new Integer(id));
        return lecturehallEntity;
    }

    @Override
    public List<LecturehallEntity> getListLecture() {
        Session session= this.sessionFactory.getCurrentSession();
        List<LecturehallEntity> lecturehallEntities= session.createQuery("from dao.entity.LecturehallEntity").list();
        return lecturehallEntities;
    }
}
