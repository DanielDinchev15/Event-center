package dreamix.event.center.eventcenter.modules;


import javax.persistence.*;


@MappedSuperclass
public class IdSubClass {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
}
