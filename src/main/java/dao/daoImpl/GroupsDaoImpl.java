package dao.daoImpl;

import dao.entity.GroupsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupsDaoImpl implements GroupsDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addGroup(GroupsEntity groupsEntity) {
        Session session= this.sessionFactory.getCurrentSession();
        session.persist(groupsEntity);
    }

    @Override
    public void deleteGroup(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        GroupsEntity groupsEntity= (GroupsEntity) session.load(GroupsEntity.class, new Integer(id));
        if(groupsEntity!=null){
            session.delete(groupsEntity);
        }
    }

    @Override
    public GroupsEntity getGroupById(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        GroupsEntity groupsEntity= (GroupsEntity) session.load(GroupsEntity.class, new Integer(id));
        return groupsEntity;
    }

    @Override
    public List<GroupsEntity> getListGroup() {
        Session session= this.sessionFactory.getCurrentSession();
        List<GroupsEntity> groupsEntity= session.createQuery("from dao.entity.GroupsEntity").list();
        return groupsEntity;
    }
}
