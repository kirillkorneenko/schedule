package dao.daoImpl;

import dao.entity.TeacherEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherImpl implements TeacherDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTeacher(TeacherEntity teacherEntity) {
        Session session= this.sessionFactory.getCurrentSession();
        session.persist(teacherEntity);
    }

    @Override
    public void deleteTeacher(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        TeacherEntity teacherEntity= (TeacherEntity) session.load(TeacherEntity.class, new Integer(id));
        if(teacherEntity!=null){
            session.delete(teacherEntity);
        }
    }

    @Override
    public TeacherEntity getTeacherById(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        TeacherEntity teacherEntity= (TeacherEntity) session.load(TeacherEntity.class, new Integer(id));
        return teacherEntity;
    }

    @Override
    public List<TeacherEntity> getListTeacher() {
        Session session= this.sessionFactory.getCurrentSession();
        List<TeacherEntity> teacherEntities= session.createQuery("from dao.entity.TeacherEntity").list();
        return teacherEntities;
    }
}
