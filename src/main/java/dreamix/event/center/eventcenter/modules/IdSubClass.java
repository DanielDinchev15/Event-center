package dreamix.event.center.eventcenter.modules;


import javax.persistence.*;


@MappedSuperclass
public class IdSubClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}
