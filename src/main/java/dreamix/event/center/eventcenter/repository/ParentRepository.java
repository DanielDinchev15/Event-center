package dreamix.event.center.eventcenter.repository;

import dreamix.event.center.eventcenter.modules.Event;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public abstract class ParentRepository<T> {
    @PersistenceContext
    private EntityManager entityManager;
    public abstract  Class<T> getEntityName();
    public List<T> findAll(){
        return entityManager.createQuery("from " + getEntityName().getSimpleName()).getResultList();
    }
    public T findById(Long id){
        return entityManager.find(getEntityName(), id);
    }
    @Transactional
    public T create(T object){
        try {
            entityManager.persist(object);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }
    @Transactional
    public void delete(Long id) {
        try{
            entityManager.createQuery("delete from :type where id = :id")
                    .setParameter("type", getEntityName().getSimpleName())
                    .setParameter("id", id)
                    .executeUpdate();
        }
        catch (Exception e) {
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