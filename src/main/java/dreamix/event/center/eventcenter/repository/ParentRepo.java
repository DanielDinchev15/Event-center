package dreamix.event.center.eventcenter.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public abstract class ParentRepo<T> {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    protected String type;

    public List<T> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from " + type).getResultList();
    }

    @Transactional
    public void create(T object) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.persist(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void delete(long id) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.createQuery("delete from :table where id = :id")
                    .setParameter("table", type)
                    .setParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}