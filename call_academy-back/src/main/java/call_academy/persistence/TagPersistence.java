/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.persistence;

import call_academy.entities.TagEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juan José Valencia 
 */
@Stateless
public class TagPersistence {
    @PersistenceContext(unitName = "CallAcademyPU")
    protected EntityManager em;
    
    private static final Logger LOGGER = Logger.getLogger(TagPersistence.class.getName());
    
    public TagEntity create(TagEntity tag){
        em.persist(tag);
        return tag;
    }
    
    public List<TagEntity> findAll(){
        LOGGER.log(Level.INFO, "Consultando todos los tags");
        Query q = em.createQuery("Select u from TagEntity u");
        return q.getResultList();
    }
    
    public TagEntity find(long tagId){
        LOGGER.log(Level.INFO, "Consultando el tag con el id={0}", tagId);
        return em.find(TagEntity.class, tagId);
    }
    
    public void delete(Long tagId){
        LOGGER.log(Level.INFO, "Borrando el tag con id={0}", tagId);
        TagEntity tagEntity = em.find(TagEntity.class, tagId);
        em.remove(tagEntity);
    }
    
    public TagEntity update(TagEntity tagEntity){
        LOGGER.log(Level.INFO, "Actualizando tag con id={0}", tagEntity.getId());
        LOGGER.log(Level.INFO, "Saliendo de actualizar con el tag con if={0}", tagEntity.getId());
        return em.merge(tagEntity);
    }
    
    public List<TagEntity> findByNombre(String nombre) {
        TypedQuery query = em.createQuery("Select e From TagEntity e where e.nombre like :nombre", TagEntity.class);
        query = query.setParameter("nombre", "%" + nombre + "%");
        
        List<TagEntity> encontrados = query.getResultList();
        return encontrados;
    }
    
}