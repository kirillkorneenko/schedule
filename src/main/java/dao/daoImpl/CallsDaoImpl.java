package dao.daoImpl;

import dao.entity.CallsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CallsDaoImpl implements CallsDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCall(CallsEntity call) {
        Session session= this.sessionFactory.getCurrentSession();
        session.persist(call);
    }

    @Override
    public void deleteCall(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        CallsEntity callsEntity = (CallsEntity) session.load(CallsEntity.class, new Integer(id));
        if(callsEntity!=null){
            session.delete(callsEntity);
        }

    }

    @Override
    public CallsEntity getCallById(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        CallsEntity callsEntity = (CallsEntity) session.load(CallsEntity.class, new Integer(id));
        return callsEntity;
    }

    @Override
    public List<CallsEntity> getListCall() {
        Session session= this.sessionFactory.getCurrentSession();
        List<CallsEntity> callsEntityList= session.createQuery("from dao.entity.CallsEntity").list();

        return callsEntityList;
    }

}
