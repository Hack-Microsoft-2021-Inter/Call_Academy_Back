/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.persistence;

import call_academy.entities.MonitoriaIndividualEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaIndividualPersistence {
    
    @PersistenceContext(unitName = "CallAcademyPU")
    protected EntityManager em;
    
    private static final Logger LOGGER = Logger.getLogger(MonitoriaIndividualPersistence.class.getName());
    
    public MonitoriaIndividualEntity create(MonitoriaIndividualEntity monitoria) {
        em.persist(monitoria);
        return monitoria;
    }
    
    public List<MonitoriaIndividualEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las monitorias");
        Query q = em.createQuery("select m from MonitoriaIndividualEntity m");
        return q.getResultList();
    }
    
    public MonitoriaIndividualEntity find(Long monitoriaId) {
        LOGGER.log(Level.INFO, "Consultando la monitoria con id={0}", monitoriaId);
        return em.find(MonitoriaIndividualEntity.class, monitoriaId);
    }
    
    public void delete(Long monitoriaId) {
        LOGGER.log(Level.INFO, "Borrando la monitoria con id={0}", monitoriaId);
        MonitoriaIndividualEntity monitoriaEntity = em.find(MonitoriaIndividualEntity.class, monitoriaId);
        em.remove(monitoriaEntity);
    }
    
    public MonitoriaIndividualEntity update(MonitoriaIndividualEntity monitoriaEntity) {
        LOGGER.log(Level.INFO, "Actualizando monitoria con id = {0}", monitoriaEntity.getId());
        LOGGER.log(Level.INFO, "Saliendo de actualizar la monitoria con id = {0}", monitoriaEntity.getId());
        return em.merge(monitoriaEntity);
    }
}
