package dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "daysweek", schema = "schedule", catalog = "")
public class DaysweekEntity {
    private int id;
    private String dayWeek;

    public DaysweekEntity() {
        super();
    }

    public DaysweekEntity(int id) {
        this.id = id;
    }

    public DaysweekEntity(int id, String dayWeek) {
        this.id = id;
        this.dayWeek = dayWeek;
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
    @Column(name = "dayWeek", nullable = true, length = 50)
    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DaysweekEntity that = (DaysweekEntity) o;

        if (id != that.id) return false;
        if (dayWeek != null ? !dayWeek.equals(that.dayWeek) : that.dayWeek != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dayWeek != null ? dayWeek.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DaysweekEntity{" +
                "id=" + id +
                ", dayWeek='" + dayWeek + '\'' +
                '}';
    }
}
