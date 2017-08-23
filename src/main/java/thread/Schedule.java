
package thread;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Schedule {

    @SerializedName("weekDay")
    @Expose
    private String weekDay;
    @SerializedName("schedule")
    @Expose
    private List<Schedule_> schedule = null;

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Schedule withWeekDay(String weekDay) {
        this.weekDay = weekDay;
        return this;
    }

    public List<Schedule_> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule_> schedule) {
        this.schedule = schedule;
    }

    public Schedule withSchedule(List<Schedule_> schedule) {
        this.schedule = schedule;
        return this;
    }

}
