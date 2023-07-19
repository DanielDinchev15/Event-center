package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.IdSubClass;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.List;

@Repository
public abstract class ParentRepository<T> {
    @PersistenceContext
    private EntityManager entityManager;
    public abstract Class<T> getEntityClass();


    public List<T> findAll() {
        return entityManager.createQuery("from " + getEntityClass().getSimpleName()).getResultList();
    }

    public T findById(Long id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Transactional
    public T create(T entity) {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Transactional
    public void delete(Long id) {
        String jpql = " where id = :id";
        try {
            entityManager.createQuery("delete from " + getEntityClass().getSimpleName() + jpql)
                    .setParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Transactional
    public T update(T object) {
        try {
            entityManager.merge(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

}