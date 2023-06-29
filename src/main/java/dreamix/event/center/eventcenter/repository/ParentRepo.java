package dreamix.event.center.eventcenter.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public abstract class ParentRepo<T> {
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
    public void create(T object){
        try {
            entityManager.persist(object);
        }
        catch (Exception e){
            e.printStackTrace();
        }
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
    public void update(T object) {
        try {
            entityManager.merge(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}