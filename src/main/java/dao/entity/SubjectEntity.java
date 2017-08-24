package dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "subject", schema = "schedule", catalog = "")
public class SubjectEntity {
    private int id;
    private String nameSubject;
    private String type;

    public SubjectEntity() { super(); }
    public SubjectEntity(int id) {
        this.id = id;
    }

    
    public SubjectEntity(int id, String nameSubject, String type) {
        this.id = id;
        this.nameSubject = nameSubject;
        this.type = type;
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
    @Column(name = "nameSubject", nullable = true, length = 50)
    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectEntity that = (SubjectEntity) o;

        if (id != that.id) return false;
        if (nameSubject != null ? !nameSubject.equals(that.nameSubject) : that.nameSubject != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameSubject != null ? nameSubject.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id=" + id +
                ", nameSubject='" + nameSubject + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
