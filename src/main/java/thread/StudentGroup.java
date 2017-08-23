
package thread;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentGroup {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("facultyId")
    @Expose
    private Integer facultyId;
    @SerializedName("specialityDepartmentEducationFormId")
    @Expose
    private Integer specialityDepartmentEducationFormId;
    @SerializedName("course")
    @Expose
    private Integer course;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("calendarId")
    @Expose
    private String calendarId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentGroup withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    public StudentGroup withFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
        return this;
    }

    public Integer getSpecialityDepartmentEducationFormId() {
        return specialityDepartmentEducationFormId;
    }

    public void setSpecialityDepartmentEducationFormId(Integer specialityDepartmentEducationFormId) {
        this.specialityDepartmentEducationFormId = specialityDepartmentEducationFormId;
    }

    public StudentGroup withSpecialityDepartmentEducationFormId(Integer specialityDepartmentEducationFormId) {
        this.specialityDepartmentEducationFormId = specialityDepartmentEducationFormId;
        return this;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public StudentGroup withCourse(Integer course) {
        this.course = course;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentGroup withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public StudentGroup withCalendarId(String calendarId) {
        this.calendarId = calendarId;
        return this;
    }

}
