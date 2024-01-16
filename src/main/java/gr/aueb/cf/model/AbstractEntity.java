package gr.aueb.cf.model;

import jakarta.persistence.*;

@MappedSuperclass
public class AbstractEntity implements IEntity{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
