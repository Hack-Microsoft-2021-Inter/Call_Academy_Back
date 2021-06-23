/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.persistence;

import call_academy.entities.UniversidadEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juan Pablo
 */
@Stateless
public class UniversidadPersistence {
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    @PersistenceContext(unitName = "CallAcademyPU")
    protected EntityManager em;
    
    //////////////////////////// MÉTODOS ////////////////////////////
    
    public UniversidadEntity create(UniversidadEntity estudiante) {
        em.persist(estudiante);
        return estudiante;
    }
    
    public List<UniversidadEntity> findAll() {
        Query query = em.createQuery("select u from UniversidadEntity u");
        List<UniversidadEntity> result = (List<UniversidadEntity>) query.getResultList();
        return result;
    }
    
    public UniversidadEntity find(Long id) {
        UniversidadEntity result = em.find(UniversidadEntity.class, id);
        return result;
    }
    
    public List<UniversidadEntity> findByNombre(String nombre) {
        TypedQuery query = em.createQuery("Select e From UniversidadEntity e where e.nombre like :nombre", UniversidadEntity.class);
        query = query.setParameter("nombre", "%" + nombre + "%");
        
        List<UniversidadEntity> encontrados = query.getResultList();
        return encontrados;
    }
    
    public UniversidadEntity update(UniversidadEntity universidad) {
        UniversidadEntity result = em.merge(universidad);
        return result;
    }
    
    public void delete(Long id) {
        UniversidadEntity universidad = em.find(UniversidadEntity.class, id);
        em.remove(universidad);
    }
}
