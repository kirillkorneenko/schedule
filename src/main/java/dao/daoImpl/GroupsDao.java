package dao.daoImpl;

import dao.entity.GroupsEntity;

import java.util.List;

public interface GroupsDao {
    public void addGroup(GroupsEntity groupsEntity);

    public void deleteGroup(int id);

    public GroupsEntity getGroupById(int id);

    public List<GroupsEntity> getListGroup();
}
