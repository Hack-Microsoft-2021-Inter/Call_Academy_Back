/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.persistence;

import call_academy.entities.MonitoriaGrupalEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juan Charry Gavilan
 */
@Stateless
public class MonitoriaGrupalPersistence {
    
    @PersistenceContext(unitName = "CallAcademyPU")
    protected EntityManager em;
    
    private static final Logger LOGGER = Logger.getLogger(MonitoriaGrupalPersistence.class.getName());
    
    public MonitoriaGrupalEntity create(MonitoriaGrupalEntity monitoria) {
        em.persist(monitoria);
        return monitoria;
    }
    
    public List<MonitoriaGrupalEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las monitorias");
        Query q = em.createQuery("select m from MonitoriaGrupalEntity m");
        return q.getResultList();
    }
    
    public MonitoriaGrupalEntity find(Long monitoriaId) {
        LOGGER.log(Level.INFO, "Consultando la monitoria con id={0}", monitoriaId);
        return em.find(MonitoriaGrupalEntity.class, monitoriaId);
    }
    
    public void delete(Long monitoriaId) {
        LOGGER.log(Level.INFO, "Borrando la monitoria con id={0}", monitoriaId);
        MonitoriaGrupalEntity monitoriaEntity = em.find(MonitoriaGrupalEntity.class, monitoriaId);
        em.remove(monitoriaEntity);
    }
    
    public MonitoriaGrupalEntity update(MonitoriaGrupalEntity monitoriaEntity) {
        LOGGER.log(Level.INFO, "Actualizando monitoria con id = {0}", monitoriaEntity.getId());
        LOGGER.log(Level.INFO, "Saliendo de actualizar la monitoria con id = {0}", monitoriaEntity.getId());
        return em.merge(monitoriaEntity);
    }
    
}
