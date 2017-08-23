
package thread;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employee {

    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("photoLink")
    @Expose
    private Object photoLink;
    @SerializedName("calendarId")
    @Expose
    private String calendarId;
    @SerializedName("academicDepartment")
    @Expose
    private List<String> academicDepartment = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("fio")
    @Expose
    private String fio;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Employee withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Employee withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Employee withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Employee withRank(String rank) {
        this.rank = rank;
        return this;
    }

    public Object getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(Object photoLink) {
        this.photoLink = photoLink;
    }

    public Employee withPhotoLink(Object photoLink) {
        this.photoLink = photoLink;
        return this;
    }

    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public Employee withCalendarId(String calendarId) {
        this.calendarId = calendarId;
        return this;
    }

    public List<String> getAcademicDepartment() {
        return academicDepartment;
    }

    public void setAcademicDepartment(List<String> academicDepartment) {
        this.academicDepartment = academicDepartment;
    }

    public Employee withAcademicDepartment(List<String> academicDepartment) {
        this.academicDepartment = academicDepartment;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Employee withFio(String fio) {
        this.fio = fio;
        return this;
    }

}
