package servise;

import dao.entity.*;

import java.util.List;

public interface Servise {
    public void addCall(CallsEntity call);

    public void deleteCall(int id);

    public CallsEntity getCallById(int id);

    public List<CallsEntity> getListCall();

    public void addDay(DaysweekEntity daysweekEntity);

    public void deleteDay(int id);

    public DaysweekEntity getDayById(int id);

    public List<DaysweekEntity> getListDay();

    public void addGroup(GroupsEntity groupsEntity);

    public void deleteGroup(int id);

    public GroupsEntity getGroupById(int id);

    public List<GroupsEntity> getListGroup();

    public void addLecture(LecturehallEntity lecturehallEntity);

    public void deleteLecture(int id);

    public LecturehallEntity getLectureById(int id);

    public List<LecturehallEntity> getListLecture();

    public void addSchedule(SheduleEntity sheduleEntity);

    public void deleteShedule(int id);

    public SheduleEntity getSheduleById(int id);

    public List<SheduleEntity> getListShedule();

    public void addSubject(SubjectEntity subjectEntity);

    public void deleteSubject(int id);

    public SubjectEntity getSubjectById(int id);

    public List<SubjectEntity> getListSubject();

    public void addTeacher(TeacherEntity teacherEntity);

    public void deleteTeacher(int id);

    public TeacherEntity getTeacherById(int id);

    public List<TeacherEntity> getListTeacher();

    public void addUser(UserEntity userEntity);

    public void deleteUser(int id);

    public UserEntity getUserById(int id);

    public List<UserEntity> getListUser();

    public UserEntity authorization(UserEntity userEntity);
}
