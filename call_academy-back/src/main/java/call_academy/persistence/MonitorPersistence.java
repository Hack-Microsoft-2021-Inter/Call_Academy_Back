/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.persistence;

import call_academy.entities.MonitorEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Uniandes
 */
@Stateless
public class MonitorPersistence {
    @PersistenceContext(unitName = "callacademyPU")
    protected EntityManager em;
    
    private static final Logger LOGGER = Logger.getLogger(MonitorPersistence.class.getName());
    
    public MonitorEntity create(MonitorEntity monitor){
        em.persist(monitor);
        return monitor;
    }
    
    public List<MonitorEntity> findAll(){
        LOGGER.log(Level.INFO, "Consultando todos los monitores");
        Query q = em.createQuery("Select u from MonitorEntity u");
        return q.getResultList();
    }
    
    public MonitorEntity find(long monitorId){
        LOGGER.log(Level.INFO, "Consultando el monitor con el id={0}", monitorId);
        return em.find(MonitorEntity.class, monitorId);
    }
    
    public void delete(Long monitorId){
        LOGGER.log(Level.INFO, "Borrando el monitor con id={0}", monitorId);
        MonitorEntity monitorEntity = em.find(MonitorEntity.class, monitorId);
        em.remove(monitorEntity);
    }
    
    public MonitorEntity update(MonitorEntity monitorEntity){
        LOGGER.log(Level.INFO, "Actualizando monitor con id={0}", monitorEntity.getId());
        LOGGER.log(Level.INFO, "Saliendo de actualizar con el monitor con id={0}", monitorEntity.getId());
        return em.merge(monitorEntity);
    } 
}
