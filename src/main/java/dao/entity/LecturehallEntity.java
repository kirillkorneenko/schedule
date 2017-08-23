package dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "lecturehall", schema = "schedule", catalog = "")
public class LecturehallEntity {
    private int id;
    private String housing;

    public LecturehallEntity() {
        super();
    }

    public LecturehallEntity(int id, String housing) {
        this.id = id;
        this.housing = housing;
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
    @Column(name = "housing", nullable = true, length = 50)
    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LecturehallEntity that = (LecturehallEntity) o;

        if (id != that.id) return false;
        if (housing != null ? !housing.equals(that.housing) : that.housing != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (housing != null ? housing.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LecturehallEntity{" +
                "id=" + id +
                ", housing='" + housing + '\'' +
                '}';
    }
}
