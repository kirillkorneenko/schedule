package dao.daoImpl;

import dao.entity.SubjectEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectImpl implements SubjectDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSubject(SubjectEntity subjectEntity) {
        Session session= this.sessionFactory.getCurrentSession();
        session.persist(subjectEntity);
    }

    @Override
    public void deleteSubject(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        SubjectEntity subjectEntity= (SubjectEntity) session.load(SubjectEntity.class, new Integer(id));
        if(subjectEntity!=null){
            session.delete(subjectEntity);
        }
    }

    @Override
    public SubjectEntity getSubjectById(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        SubjectEntity subjectEntity= (SubjectEntity) session.load(SubjectEntity.class, new Integer(id));
        return subjectEntity;
    }

    @Override
    public List<SubjectEntity> getListSubject() {
        Session session= this.sessionFactory.getCurrentSession();
        List<SubjectEntity> subjectEntities= session.createQuery("from dao.entity.SubjectEntity").list();
        return subjectEntities;
    }
}
