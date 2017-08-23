package dao.daoImpl;

import dao.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserImpl implements UserDao {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(UserEntity userEntity) {
        Session session= this.sessionFactory.getCurrentSession();
        session.persist(userEntity);
    }

    @Override
    public void deleteUser(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        UserEntity userEntity= (UserEntity) session.load(UserEntity.class, new Integer(id));
        if(userEntity!=null){
            session.delete(userEntity);
        }
    }

    @Override
    public UserEntity getUserById(int id) {
        Session session= this.sessionFactory.getCurrentSession();
        UserEntity userEntity= (UserEntity) session.load(UserEntity.class, new Integer(id));
        return userEntity;
    }

    @Override
    public List<UserEntity> getListUser() {
        Session session= this.sessionFactory.getCurrentSession();
        List<UserEntity> userEntities= session.createQuery("from dao.entity.UserEntity").list();
        return userEntities;
    }

    @Override
    public UserEntity authorization(UserEntity userEntity) {
        Session session= this.sessionFactory.getCurrentSession();
        List<UserEntity> userEntities= session.createQuery("from dao.entity.UserEntity").list();
        for(int i = 0; i<userEntities.size();i++){
            UserEntity us= userEntities.get(i);
            if (us.getLogin().equals(userEntity.getLogin())){
                if (us.getPassword().equals(userEntity.getPassword())) return us;
            }
        }
        return null;
    }
}
