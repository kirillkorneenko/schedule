
package thread;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Schedule_ {

    @SerializedName("weekNumber")
    @Expose
    private List<Integer> weekNumber = null;
    @SerializedName("studentGroup")
    @Expose
    private List<String> studentGroup = null;
    @SerializedName("numSubgroup")
    @Expose
    private Integer numSubgroup;
    @SerializedName("auditory")
    @Expose
    private List<String> auditory = null;
    @SerializedName("lessonTime")
    @Expose
    private String lessonTime;
    @SerializedName("startLessonTime")
    @Expose
    private String startLessonTime;
    @SerializedName("endLessonTime")
    @Expose
    private String endLessonTime;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("lessonType")
    @Expose
    private String lessonType;
    @SerializedName("employee")
    @Expose
    private List<Employee> employee = null;
    @SerializedName("zaoch")
    @Expose
    private Boolean zaoch;

    public List<Integer> getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(List<Integer> weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Schedule_ withWeekNumber(List<Integer> weekNumber) {
        this.weekNumber = weekNumber;
        return this;
    }

    public List<String> getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(List<String> studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Schedule_ withStudentGroup(List<String> studentGroup) {
        this.studentGroup = studentGroup;
        return this;
    }

    public Integer getNumSubgroup() {
        return numSubgroup;
    }

    public void setNumSubgroup(Integer numSubgroup) {
        this.numSubgroup = numSubgroup;
    }

    public Schedule_ withNumSubgroup(Integer numSubgroup) {
        this.numSubgroup = numSubgroup;
        return this;
    }

    public List<String> getAuditory() {
        return auditory;
    }

    public void setAuditory(List<String> auditory) {
        this.auditory = auditory;
    }

    public Schedule_ withAuditory(List<String> auditory) {
        this.auditory = auditory;
        return this;
    }

    public String getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(String lessonTime) {
        this.lessonTime = lessonTime;
    }

    public Schedule_ withLessonTime(String lessonTime) {
        this.lessonTime = lessonTime;
        return this;
    }

    public String getStartLessonTime() {
        return startLessonTime;
    }

    public void setStartLessonTime(String startLessonTime) {
        this.startLessonTime = startLessonTime;
    }

    public Schedule_ withStartLessonTime(String startLessonTime) {
        this.startLessonTime = startLessonTime;
        return this;
    }

    public String getEndLessonTime() {
        return endLessonTime;
    }

    public void setEndLessonTime(String endLessonTime) {
        this.endLessonTime = endLessonTime;
    }

    public Schedule_ withEndLessonTime(String endLessonTime) {
        this.endLessonTime = endLessonTime;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Schedule_ withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Schedule_ withNote(String note) {
        this.note = note;
        return this;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public Schedule_ withLessonType(String lessonType) {
        this.lessonType = lessonType;
        return this;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Schedule_ withEmployee(List<Employee> employee) {
        this.employee = employee;
        return this;
    }

    public Boolean getZaoch() {
        return zaoch;
    }

    public void setZaoch(Boolean zaoch) {
        this.zaoch = zaoch;
    }

    public Schedule_ withZaoch(Boolean zaoch) {
        this.zaoch = zaoch;
        return this;
    }

}
