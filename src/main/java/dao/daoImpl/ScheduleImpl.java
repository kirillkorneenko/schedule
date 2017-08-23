package dao.daoImpl;

import dao.entity.SheduleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleImpl implements ScheduleDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addSchedule(SheduleEntity sheduleEntity) {
        Session session= this.sessionFactory.getCurrentSession();
        session.persist(sheduleEntity);
    }

    @Override
    public void deleteShedule(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        SheduleEntity subjectEntity= (SheduleEntity) session.load(SheduleEntity.class, new Integer(id));
        if(subjectEntity!=null){
            session.delete(subjectEntity);
        }
    }

    @Override
    public SheduleEntity getSheduleById(int id) {
            Session session= this.sessionFactory.getCurrentSession();
        SheduleEntity sheduleEntity= (SheduleEntity) session.load(SheduleEntity.class, new Integer(id));
            return sheduleEntity;
    }

    @Override
    public List<SheduleEntity> getListShedule() {
            Session session= this.sessionFactory.getCurrentSession();
            List<SheduleEntity> sheduleEntities= session.createQuery("from dao.entity.SheduleEntity").list();
            return sheduleEntities;
    }
}
