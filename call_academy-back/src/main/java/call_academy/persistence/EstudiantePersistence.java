/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.persistence;

import call_academy.entities.EstudianteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juan Pablo
 */
@Stateless
public class EstudiantePersistence {
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    @PersistenceContext(unitName = "CallAcademyPU")
    protected EntityManager em;
    
    //////////////////////////// MÉTODOS ////////////////////////////
    
    public EstudianteEntity create(EstudianteEntity estudiante) {
        em.persist(estudiante);
        return estudiante;
    }
    
    public List<EstudianteEntity> findAll() {
        Query query = em.createQuery("select u from EstudianteEntity u");
        List<EstudianteEntity> result = (List<EstudianteEntity>) query.getResultList();
        return result;
    }
    
    public EstudianteEntity find(Long id) {
        EstudianteEntity result = em.find(EstudianteEntity.class, id);
        return result;
    }
    
    public EstudianteEntity update(EstudianteEntity estudiante) {
        EstudianteEntity result = em.merge(estudiante);
        return result;
    }
    
    public void delete(Long id) {
        EstudianteEntity estudiante = em.find(EstudianteEntity.class, id);
        em.remove(estudiante);
    }
}
