package dao.daoImpl;

import dao.entity.CallsEntity;

import java.util.List;

public interface CallsDao {

    public void addCall(CallsEntity call);

    public void deleteCall(int id);

    public CallsEntity getCallById(int id);

    public List<CallsEntity> getListCall();

}
