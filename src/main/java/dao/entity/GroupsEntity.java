package dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "groups", schema = "schedule", catalog = "")
public class GroupsEntity {
    private int id;
    private Integer course;
    private String name;
    private Integer facultyId;
    private Integer specialityDepartmentEducationFormId;
    private String calendarId;

    public GroupsEntity() {
        super();
    }

    public GroupsEntity(int id) {
        this.id = id;
    }

    public GroupsEntity(int id, Integer course, String name, Integer facultyId, Integer specialityDepartmentEducationFormId, String calendarId) {
        this.id = id;
        this.course = course;
        this.name = name;
        this.facultyId = facultyId;
        this.specialityDepartmentEducationFormId = specialityDepartmentEducationFormId;
        this.calendarId = calendarId;
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
    @Column(name = "course", nullable = true)
    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "facultyId", nullable = true)
    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    @Basic
    @Column(name = "specialityDepartmentEducationFormId", nullable = true)
    public Integer getSpecialityDepartmentEducationFormId() {
        return specialityDepartmentEducationFormId;
    }

    public void setSpecialityDepartmentEducationFormId(Integer specialityDepartmentEducationFormId) {
        this.specialityDepartmentEducationFormId = specialityDepartmentEducationFormId;
    }

    @Basic
    @Column(name = "calendarId", nullable = true, length = 250)
    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupsEntity that = (GroupsEntity) o;

        if (id != that.id) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (facultyId != null ? !facultyId.equals(that.facultyId) : that.facultyId != null) return false;
        if (specialityDepartmentEducationFormId != null ? !specialityDepartmentEducationFormId.equals(that.specialityDepartmentEducationFormId) : that.specialityDepartmentEducationFormId != null)
            return false;
        if (calendarId != null ? !calendarId.equals(that.calendarId) : that.calendarId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (facultyId != null ? facultyId.hashCode() : 0);
        result = 31 * result + (specialityDepartmentEducationFormId != null ? specialityDepartmentEducationFormId.hashCode() : 0);
        result = 31 * result + (calendarId != null ? calendarId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupsEntity{" +
                "id=" + id +
                ", course=" + course +
                ", name='" + name + '\'' +
                ", facultyId=" + facultyId +
                ", specialityDepartmentEducationFormId=" + specialityDepartmentEducationFormId +
                ", calendarId='" + calendarId + '\'' +
                '}';
    }
}
