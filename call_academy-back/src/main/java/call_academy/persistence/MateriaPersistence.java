/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.persistence;

import call_academy.entities.MateriaEntity;
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
public class MateriaPersistence {
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    @PersistenceContext(unitName = "CallAcademyPU")
    protected EntityManager em;
    
    //////////////////////////// MÉTODOS ////////////////////////////
    
    public MateriaEntity create(MateriaEntity materia) {
        em.persist(materia);
        return materia;
    }
    
    public List<MateriaEntity> findAll() {
        Query query = em.createQuery("select u from MateriaEntity u");
        List<MateriaEntity> result = (List<MateriaEntity>) query.getResultList();
        return result;
    }
    
    public MateriaEntity find(Long id) {
        MateriaEntity result = em.find(MateriaEntity.class, id);
        return result;
    }
    
    public MateriaEntity findByNombre(String nombre) {
        TypedQuery query = em.createQuery("Select e From MateriaEntity e where e.nombre = :nombre", MateriaEntity.class);
        query = query.setParameter("nombre", nombre);
        
        List<MateriaEntity> encontrados = query.getResultList();
        MateriaEntity resultado;
        if (encontrados == null) {
            resultado = null;
        } else if (encontrados.isEmpty()) {
            resultado = null;
        } else {
            resultado = encontrados.get(0);
        }
        return resultado;
    }
    
    public MateriaEntity update(MateriaEntity materia) {
        MateriaEntity result = em.merge(materia);
        return result;
    }
    
    public void delete(Long id) {
        MateriaEntity materia = em.find(MateriaEntity.class, id);
        em.remove(materia);
    }
}
