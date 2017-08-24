package dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "shedule", schema = "schedule", catalog = "")
public class SheduleEntity {
    private int id;
    private String weekNumber;
    private DaysweekEntity daysweekByCodDayWeek;
    private CallsEntity callsByLessonNumber;
    private LecturehallEntity lecturehallByCodeAudience;
    private GroupsEntity groupsByCodeGroup;
    private UserEntity userByCodeUserId;
    private SubjectEntity subjectByCodeDiscipline;
    private TeacherEntity teacherByCodeTeacher;

    public SheduleEntity() {
        super();
    }

    public SheduleEntity(int id) {
        this.id = id;
    }

    public SheduleEntity(int id, String weekNumber, DaysweekEntity daysweekByCodDayWeek, CallsEntity callsByLessonNumber, LecturehallEntity lecturehallByCodeAudience, GroupsEntity groupsByCodeGroup, UserEntity userByCodeUserId, SubjectEntity subjectByCodeDiscipline, TeacherEntity teacherByCodeTeacher) {
        this.id = id;
        this.weekNumber = weekNumber;
        this.daysweekByCodDayWeek = daysweekByCodDayWeek;
        this.callsByLessonNumber = callsByLessonNumber;
        this.lecturehallByCodeAudience = lecturehallByCodeAudience;
        this.groupsByCodeGroup = groupsByCodeGroup;
        this.userByCodeUserId = userByCodeUserId;
        this.subjectByCodeDiscipline = subjectByCodeDiscipline;
        this.teacherByCodeTeacher = teacherByCodeTeacher;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "weekNumber", nullable = true, length = 50)
    public String getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SheduleEntity that = (SheduleEntity) o;

        if (id != that.id) return false;

        if (weekNumber != null ? !weekNumber.equals(that.weekNumber) : that.weekNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (weekNumber != null ? weekNumber.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codDayWeek", referencedColumnName = "id", nullable = false)
    public DaysweekEntity getDaysweekByCodDayWeek() {
        return daysweekByCodDayWeek;
    }

    public void setDaysweekByCodDayWeek(DaysweekEntity daysweekByCodDayWeek) {
        this.daysweekByCodDayWeek = daysweekByCodDayWeek;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lessonNumber", referencedColumnName = "id", nullable = false)
    public CallsEntity getCallsByLessonNumber() {
        return callsByLessonNumber;
    }

    public void setCallsByLessonNumber(CallsEntity callsByLessonNumber) {
        this.callsByLessonNumber = callsByLessonNumber;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeAudience", referencedColumnName = "id", nullable = false)
    public LecturehallEntity getLecturehallByCodeAudience() {
        return lecturehallByCodeAudience;
    }

    public void setLecturehallByCodeAudience(LecturehallEntity lecturehallByCodeAudience) {
        this.lecturehallByCodeAudience = lecturehallByCodeAudience;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeGroup", referencedColumnName = "id", nullable = false)
    public GroupsEntity getGroupsByCodeGroup() {
        return groupsByCodeGroup;
    }

    public void setGroupsByCodeGroup(GroupsEntity groupsByCodeGroup) {
        this.groupsByCodeGroup = groupsByCodeGroup;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByCodeUserId() {
        return userByCodeUserId;
    }

    public void setUserByCodeUserId(UserEntity userByCodeUserId) {
        this.userByCodeUserId = userByCodeUserId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeDiscipline", referencedColumnName = "id", nullable = false)
    public SubjectEntity getSubjectByCodeDiscipline() {
        return subjectByCodeDiscipline;
    }

    public void setSubjectByCodeDiscipline(SubjectEntity subjectByCodeDiscipline) {
        this.subjectByCodeDiscipline = subjectByCodeDiscipline;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codeTeacher", referencedColumnName = "id", nullable = false)
    public TeacherEntity getTeacherByCodeTeacher() {
        return teacherByCodeTeacher;
    }

    public void setTeacherByCodeTeacher(TeacherEntity teacherByCodeTeacher) {
        this.teacherByCodeTeacher = teacherByCodeTeacher;
    }

    @Override
    public String toString() {
        return "SheduleEntity{" +
                "id=" + id +
                ", weekNumber='" + weekNumber + '\'' +
                ", daysweekByCodDayWeek=" + daysweekByCodDayWeek +
                ", callsByLessonNumber=" + callsByLessonNumber +
                ", lecturehallByCodeAudience=" + lecturehallByCodeAudience +
                ", groupsByCodeGroup=" + groupsByCodeGroup +
                ", userByCodeUserId=" + userByCodeUserId +
                ", subjectByCodeDiscipline=" + subjectByCodeDiscipline +
                ", teacherByCodeTeacher=" + teacherByCodeTeacher +
                '}';
    }
}
