/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.persistence;

import call_academy.entities.ArchivoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Uniandes
 */
@Stateless
public class ArchivoPersistence {
   @PersistenceContext(unitName = "CallAcademyPU")
    protected EntityManager em;
    
    private static final Logger LOGGER = Logger.getLogger(ArchivoPersistence.class.getName());
    
    public ArchivoEntity create(ArchivoEntity archivo){
        em.persist(archivo);
        return archivo;
    }
    
    public List<ArchivoEntity> findAll(){
        LOGGER.log(Level.INFO, "Consultando todos los archivos");
        Query q = em.createQuery("Select u from ArchivoEntity u");
        return q.getResultList();
    }
    
    public ArchivoEntity find(long archivoId){
        LOGGER.log(Level.INFO, "Consultando el archivo con el id={0}", archivoId);
        return em.find(ArchivoEntity.class, archivoId);
    }
    
    public void delete(Long archivoId){
        LOGGER.log(Level.INFO, "Borrando el archivo con id={0}", archivoId);
        ArchivoEntity archivoEntity = em.find(ArchivoEntity.class, archivoId);
        em.remove(archivoEntity);
    }
    
    public ArchivoEntity update(ArchivoEntity archivoEntity){
        LOGGER.log(Level.INFO, "Actualizando archivo con id={0}", archivoEntity.getId());
        LOGGER.log(Level.INFO, "Saliendo de actualizar con el archivo con id={0}", archivoEntity.getId());
        return em.merge(archivoEntity);
    }  
}
