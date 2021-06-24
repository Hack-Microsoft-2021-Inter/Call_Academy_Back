/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.persistence;

import call_academy.entities.MonitoriaEntity;
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
public class MonitoriaPersistence {

    /**
     * El entity manager ayuda a subir cosas a la base de datos. Maneja las
     * entidades en la base de datos.
     */
    @PersistenceContext(unitName = "CallAcademyPU")
    protected EntityManager em;
    /**
     * El log siempre se usa para mantener propiedades importantes en la base de
     * datos.
     */
    private static final Logger LOGGER = Logger.getLogger(MonitoriaPersistence.class.getName());

//Propiedades CRUD (Create, Read, Update, Delete)  de los datos
    /**
     * Metodo para crear
     *
     * @param monitoria
     * @return monitoria
     */
    public MonitoriaEntity create(MonitoriaEntity monitoria) {
        em.persist(monitoria);
        return monitoria;
    }

    /**
     * Metodo para encontrar todas las monitorias.
     *
     * @return Lista de todas las monitorias
     */
    public List<MonitoriaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las monitorias");
        Query q = em.createQuery("select m from MonitoriaEntity m");
        return q.getResultList();
    }

    /**
     * Metodo para encontrar una monitoria especifica.
     *
     * @param monitoriaId
     * @return La monitoria buscada
     */
    public MonitoriaEntity find(Long monitoriaId) {
        LOGGER.log(Level.INFO, "Consultando la monitoria con id={0}", monitoriaId);
        return em.find(MonitoriaEntity.class, monitoriaId);
    }

    /**
     * Metodo para eliminar una monitoria encontrandola por id.
     *
     * @param monitoriaId
     */
    public void delete(Long monitoriaId) {
        LOGGER.log(Level.INFO, "Borrando la monitoria con id={0}", monitoriaId);
        MonitoriaEntity monitoriaEntity = em.find(MonitoriaEntity.class, monitoriaId);
        em.remove(monitoriaEntity);
    }

    /**
     * Metodo para actualizar una monitoria.
     *
     * @param monitoriaEntity
     * @return La monitoria actualizada
     */
    public MonitoriaEntity update(MonitoriaEntity monitoriaEntity) {
        LOGGER.log(Level.INFO, "Actualizando monitoria con id = {0}", monitoriaEntity.getId());
        LOGGER.log(Level.INFO, "Saliendo de actualizar la monitoria con id = {0}", monitoriaEntity.getId());
        return em.merge(monitoriaEntity);
    }
}
