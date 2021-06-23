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
import javax.persistence.TypedQuery;

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
    
    public List<EstudianteEntity> findByNombre(String nombre) {
        TypedQuery query = em.createQuery("Select e From EstudianteEntity e where e.nombre like :nombre", EstudianteEntity.class);
        query = query.setParameter("nombre", "%" + nombre + "%");
        
        List<EstudianteEntity> encontrados = query.getResultList();
        return encontrados;
    }
    
    public EstudianteEntity findByCorreo(String correo) {
        TypedQuery query = em.createQuery("Select e From EstudianteEntity e where e.correo = :correo", EstudianteEntity.class);
        query = query.setParameter("correo", correo);
        
        List<EstudianteEntity> encontrados = query.getResultList();
        EstudianteEntity resultado;
        if (encontrados == null) {
            resultado = null;
        } else if (encontrados.isEmpty()) {
            resultado = null;
        } else {
            resultado = encontrados.get(0);
        }
        return resultado;
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
