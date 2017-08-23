package dao.daoImpl;

import dao.entity.DaysweekEntity;

import java.util.List;

public interface DaysWeekDao {

    public void addDay(DaysweekEntity daysweekEntity);

    public void deleteDay(int id);

    public DaysweekEntity getDayById(int id);

    public List<DaysweekEntity> getListDay();

}
