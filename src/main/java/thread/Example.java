
package thread;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("employee")
    @Expose
    private Object employee;
    @SerializedName("studentGroup")
    @Expose
    private StudentGroup studentGroup;
    @SerializedName("schedules")
    @Expose
    private List<Schedule> schedules = null;
    @SerializedName("examSchedules")
    @Expose
    private List<Object> examSchedules = null;
    @SerializedName("todayDate")
    @Expose
    private String todayDate;
    @SerializedName("todaySchedules")
    @Expose
    private List<Object> todaySchedules = null;
    @SerializedName("tomorrowDate")
    @Expose
    private String tomorrowDate;
    @SerializedName("tomorrowSchedules")
    @Expose
    private List<Object> tomorrowSchedules = null;
    @SerializedName("currentWeekNumber")
    @Expose
    private Integer currentWeekNumber;

    public Object getEmployee() {
        return employee;
    }

    public void setEmployee(Object employee) {
        this.employee = employee;
    }

    public Example withEmployee(Object employee) {
        this.employee = employee;
        return this;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Example withStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
        return this;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Example withSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
        return this;
    }

    public List<Object> getExamSchedules() {
        return examSchedules;
    }

    public void setExamSchedules(List<Object> examSchedules) {
        this.examSchedules = examSchedules;
    }

    public Example withExamSchedules(List<Object> examSchedules) {
        this.examSchedules = examSchedules;
        return this;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

    public Example withTodayDate(String todayDate) {
        this.todayDate = todayDate;
        return this;
    }

    public List<Object> getTodaySchedules() {
        return todaySchedules;
    }

    public void setTodaySchedules(List<Object> todaySchedules) {
        this.todaySchedules = todaySchedules;
    }

    public Example withTodaySchedules(List<Object> todaySchedules) {
        this.todaySchedules = todaySchedules;
        return this;
    }

    public String getTomorrowDate() {
        return tomorrowDate;
    }

    public void setTomorrowDate(String tomorrowDate) {
        this.tomorrowDate = tomorrowDate;
    }

    public Example withTomorrowDate(String tomorrowDate) {
        this.tomorrowDate = tomorrowDate;
        return this;
    }

    public List<Object> getTomorrowSchedules() {
        return tomorrowSchedules;
    }

    public void setTomorrowSchedules(List<Object> tomorrowSchedules) {
        this.tomorrowSchedules = tomorrowSchedules;
    }

    public Example withTomorrowSchedules(List<Object> tomorrowSchedules) {
        this.tomorrowSchedules = tomorrowSchedules;
        return this;
    }

    public Integer getCurrentWeekNumber() {
        return currentWeekNumber;
    }

    public void setCurrentWeekNumber(Integer currentWeekNumber) {
        this.currentWeekNumber = currentWeekNumber;
    }

    public Example withCurrentWeekNumber(Integer currentWeekNumber) {
        this.currentWeekNumber = currentWeekNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Example{" +
                "employee=" + employee +
                ", studentGroup=" + studentGroup +
                ", schedules=" + schedules +
                ", examSchedules=" + examSchedules +
                ", todayDate='" + todayDate + '\'' +
                ", todaySchedules=" + todaySchedules +
                ", tomorrowDate='" + tomorrowDate + '\'' +
                ", tomorrowSchedules=" + tomorrowSchedules +
                ", currentWeekNumber=" + currentWeekNumber +
                '}';
    }
}
