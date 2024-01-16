package gr.aueb.cf.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENTS")
public class Student extends AbstractEntity {

    @Column(name = "FIRSTNAME", length = 256, nullable = false)
    private String firstname;

    @Column(name = "LASTNAME", length = 256, nullable = false)
    private String lastname;

    @ManyToMany
    @JoinTable(name = "STUDENTS_SEMINARS",
            joinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "SEMINAR_ID", referencedColumnName = "ID"))
    private List<Seminar> seminars = new ArrayList<>();


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }
}
