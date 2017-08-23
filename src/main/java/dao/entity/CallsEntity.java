package dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "calls", schema = "schedule", catalog = "")
public class CallsEntity {
    private int id;
    private String start;
    private String end;

    public CallsEntity(int id) {
        this.id = id;
    }

    public CallsEntity() {
        super();
    }

    public CallsEntity(int id, String start, String end) {
        this.id = id;
        this.start = start;
        this.end = end;
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
    @Column(name = "start", nullable = true, length = 50)
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Basic
    @Column(name = "end", nullable = true, length = 50)
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallsEntity that = (CallsEntity) o;

        if (id != that.id) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CallsEntity{" +
                "id=" + id +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
