package servise;

import dao.daoImpl.*;
import dao.entity.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiseImpl implements Servise {
    private CallsDao callsDao;
    private DaysWeekDao daysWeekDao;
    private GroupsDao groupsDao;
    private LecturehallDao lecturehallDao;
    private  ScheduleDao scheduleDao;
    private SubjectDao subjectDao;
    private TeacherDao teacherDao;
    private UserDao userDao;

    public void setCallsDao(CallsDao callsDao) { this.callsDao = callsDao; }

    public void setDaysWeekDao(DaysWeekDao daysWeekDao) {
        this.daysWeekDao = daysWeekDao;
    }

    public void setGroupsDao(GroupsDao groupsDao) {
        this.groupsDao = groupsDao;
    }

    public void setLecturehallDao(LecturehallDao lecturehallDao) {
        this.lecturehallDao = lecturehallDao;
    }

    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addCall(CallsEntity call) {
        this.callsDao.addCall(call);
    }

    @Override
    @Transactional
    public void deleteCall(int id) {
        this.callsDao.deleteCall(id);
    }

    @Override
    @Transactional
    public CallsEntity getCallById(int id) {
        return this.callsDao.getCallById(id);
    }

    @Override
    @Transactional
    public List<CallsEntity> getListCall() {
        return this.callsDao.getListCall();
    }

    @Override
    @Transactional
    public void addDay(DaysweekEntity daysweekEntity) {
        this.daysWeekDao.addDay(daysweekEntity);
    }

    @Override
    @Transactional
    public void deleteDay(int id) {
        this.daysWeekDao.deleteDay(id);
    }

    @Override
    @Transactional
    public DaysweekEntity getDayById(int id) {
        return this.daysWeekDao.getDayById(id);
    }

    @Override
    @Transactional
    public List<DaysweekEntity> getListDay() {
        return this.daysWeekDao.getListDay();
    }

    @Override
    @Transactional
    public void addGroup(GroupsEntity groupsEntity) {
        this.groupsDao.addGroup(groupsEntity);
    }

    @Override
    @Transactional
    public void deleteGroup(int id) {
        this.groupsDao.deleteGroup(id);
    }

    @Override
    @Transactional
    public GroupsEntity getGroupById(int id) {
        return this.groupsDao.getGroupById(id);
    }

    @Override
    @Transactional
    public List<GroupsEntity> getListGroup() {
        return this.groupsDao.getListGroup();
    }

    @Override
    @Transactional
    public void addLecture(LecturehallEntity lecturehallEntity) {
        this.lecturehallDao.addLecture(lecturehallEntity);
    }

    @Override
    @Transactional
    public void deleteLecture(int id) {
        this.lecturehallDao.deleteLecture(id);
    }

    @Override
    @Transactional
    public LecturehallEntity getLectureById(int id) {
        return this.lecturehallDao.getLectureById(id);
    }

    @Override
    @Transactional
    public List<LecturehallEntity> getListLecture() {
        return this.lecturehallDao.getListLecture();
    }

    @Override
    @Transactional
    public void addSchedule(SheduleEntity sheduleEntity) {
        this.scheduleDao.addSchedule(sheduleEntity);
    }

    @Override
    @Transactional
    public void deleteShedule(int id) {
        this.scheduleDao.deleteShedule(id);
    }

    @Override
    @Transactional
    public SheduleEntity getSheduleById(int id) {
        return this.scheduleDao.getSheduleById(id);
    }

    @Override
    @Transactional
    public List<SheduleEntity> getListShedule() {
        return this.scheduleDao.getListShedule();
    }

    @Override
    @Transactional
    public void addSubject(SubjectEntity subjectEntity) {
        this.subjectDao.addSubject(subjectEntity);
    }

    @Override
    @Transactional
    public void deleteSubject(int id) {
        this.subjectDao.deleteSubject(id);
    }

    @Override
    @Transactional
    public SubjectEntity getSubjectById(int id) {
        return this.subjectDao.getSubjectById(id);
    }

    @Override
    @Transactional
    public List<SubjectEntity> getListSubject() {
        return this.subjectDao.getListSubject();
    }

    @Override
    @Transactional
    public void addTeacher(TeacherEntity teacherEntity) {
        this.teacherDao.addTeacher(teacherEntity);
    }

    @Override
    @Transactional
    public void deleteTeacher(int id) {
        this.teacherDao.deleteTeacher(id);
    }

    @Override
    @Transactional
    public TeacherEntity getTeacherById(int id) {
        return this.teacherDao.getTeacherById(id);
    }

    @Override
    @Transactional
    public List<TeacherEntity> getListTeacher() {
        return this.teacherDao.getListTeacher();
    }

    @Override
    @Transactional
    public void addUser(UserEntity userEntity) {
        this.userDao.addUser(userEntity);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        this.userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public UserEntity getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<UserEntity> getListUser() {
        return this.userDao.getListUser();
    }

    @Override
    @Transactional
    public UserEntity authorization(UserEntity userEntity) {
        return this.userDao.authorization(userEntity);
    }

    @Override
    @Transactional
    public void updateUser(UserEntity userEntity) {
        this.userDao.updateUser(userEntity);
    }
}
