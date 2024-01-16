package gr.aueb.cf.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROOMS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Room extends AbstractEntity {

    @Column(name = "TITLE", length = 256, nullable = false)
    private String title;

    @OneToMany(mappedBy = "room")
    private List<Seminar> seminars = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }
}
