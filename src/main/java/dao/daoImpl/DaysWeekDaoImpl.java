package dao.daoImpl;

import dao.entity.DaysweekEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaysWeekDaoImpl implements DaysWeekDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDay(DaysweekEntity daysweekEntity) {
        Session session= this.sessionFactory.getCurrentSession();
        session.persist(daysweekEntity);
    }

    @Override
    public void deleteDay(int id) {
        Session session= this.sessionFactory.getCurrentSession();
       DaysweekEntity daysweekEntity= (DaysweekEntity) session.load(DaysweekEntity.class, new Integer(id));
        if(daysweekEntity!=null){
            session.delete(daysweekEntity);
        }

    }

    @Override
    public DaysweekEntity getDayById(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        DaysweekEntity daysweekEntity= (DaysweekEntity) session.load(DaysweekEntity.class, new Integer(id));
        return daysweekEntity;
    }

    @Override
    public List<DaysweekEntity> getListDay() {
        Session session= this.sessionFactory.getCurrentSession();
        List<DaysweekEntity> daysweekEntities= session.createQuery("from dao.entity.DaysweekEntity").list();

        return daysweekEntities;
    }
}
