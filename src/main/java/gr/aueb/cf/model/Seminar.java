package gr.aueb.cf.model;

import jakarta.persistence.*;

import javax.sound.midi.Track;
import java.util.List;

@Entity
@Table(name = "SEMINARS")
public class Seminar extends AbstractEntity {

    @Column(name = "TITLE", length = 256, nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", length = 512, nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID", nullable = false)
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "SEMINARS_STUDENTS",
    joinColumns = @JoinColumn(name = "SEMINAR_ID", referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"))
    private List<Student> students;

    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SCHEDULING_ID", nullable = false)
    private SchedulingPeriod schedulingPeriod;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public SchedulingPeriod getSchedulingPeriod() {
        return schedulingPeriod;
    }

    public void setSchedulingPeriod(SchedulingPeriod schedulingPeriod) {
        this.schedulingPeriod = schedulingPeriod;
    }
}
