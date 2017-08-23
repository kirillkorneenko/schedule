package dao.daoImpl;

import dao.entity.SheduleEntity;

import java.util.List;

public interface ScheduleDao {

    public void addSchedule(SheduleEntity sheduleEntity);

    public void deleteShedule(int id);

    public SheduleEntity getSheduleById(int id);

    public List<SheduleEntity> getListShedule();
}
