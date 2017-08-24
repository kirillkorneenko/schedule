package dao.daoImpl;


import dao.entity.UserEntity;

import java.util.List;

public interface UserDao {
    public void addUser(UserEntity userEntity);

    public void deleteUser(int id);

    public UserEntity getUserById(int id);

    public List<UserEntity> getListUser();

    public UserEntity authorization(UserEntity userEntity);

    public void updateUser(UserEntity userEntity);
}
