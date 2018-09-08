package com.tecsoluction.azar.framework;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Cleberson on 04/07/2016.
 *
 * @version 1.0
 */
// @Component
public abstract class AbstractEntityService<Entity> {

    // @PersistenceContext
    // protected EntityManager manager;

    private Class<Entity> entityClass;

    private String entityAlias;

    protected abstract JpaRepository<Entity, Long> getDao();

    public AbstractEntityService(Class<Entity> entityClass, String entityAlias) {

        this.entityClass = entityClass;
        this.entityAlias = entityAlias;
    }

    public List<Entity> findAll() {
        return getDao().findAll();
    }

    public Entity findOne(long id) {
        return getDao().findOne(id);
    }

    public Entity save(Entity post) {
        validateSave(post);
        return getDao().saveAndFlush(post);
    }

    protected abstract void validateSave(Entity post);

    public Entity edit(Entity post) {
        validateEdit(post);
        return getDao().saveAndFlush(post);
    }

    protected abstract void validateEdit(Entity post);

    public void delete(long id) {
        validateDelete(id);
        getDao().delete(id);
    }

    protected abstract void validateDelete(long id);

}
