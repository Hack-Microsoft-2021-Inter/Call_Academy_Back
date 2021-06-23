/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.MateriaEntity;
import call_academy.entities.MonitoriaIndividualEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.MateriaPersistence;
import call_academy.persistence.MonitoriaIndividualPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaIndividualMateriaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(MonitoriaIndividualMateriaLogic.class.getName());

    @Inject
    private MonitoriaIndividualPersistence monitoriaIndividualPersistence;

    @Inject
    private MateriaPersistence materiaPersistence;

    public MonitoriaIndividualEntity addMonitoriaIndividualMateria(Long materiasId, Long monitoriaIndividualId) throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle una monitoria Individual a materia con id = {0}", materiasId);
        
        MateriaEntity materiaEntity = materiaPersistence.find(materiasId);
        MonitoriaIndividualEntity monitoriaIndividualEntity = monitoriaIndividualPersistence.find(monitoriaIndividualId);
        
        if(materiaEntity == null || monitoriaIndividualEntity == null){
            throw new BusinessLogicException("El monitoria Individualo o materia estan vacios");
        }
        
        materiaEntity.getMonitorias().add(monitoriaIndividualEntity);
        monitoriaIndividualEntity.setMateria(materiaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoria Individualo a materia con id = {0}", materiasId);
        return monitoriaIndividualEntity;
    }

    public MateriaEntity addMateriaMonitoriaIndividual(Long materiasId, Long monitoriaIndividualId) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle un monitoria Individualo al materia con id = {0}", materiasId);
        MateriaEntity materiaEntity = materiaPersistence.find(materiasId);
        MonitoriaIndividualEntity monitoriaIndividualEntity = monitoriaIndividualPersistence.find(monitoriaIndividualId);
        if(materiaEntity == null || monitoriaIndividualEntity == null){
            throw new BusinessLogicException("El monitoria Individualo o materia estan vacios");
        }
        materiaEntity.getMonitorias().add(monitoriaIndividualEntity);
        monitoriaIndividualEntity.setMateria(materiaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoria Individualo a materia con id = {0}", materiasId);
        return materiaEntity;
    }

    public MateriaEntity getMateria(Long monitoriaIndividualId, Long materiaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el materia con id = {0} del monitoria Individualo con id = " + materiaId, monitoriaIndividualId);
        MateriaEntity materia = monitoriaIndividualPersistence.find(monitoriaIndividualId).getMateria();
        MateriaEntity materiaWanted = materiaPersistence.find(materiaId);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el materia con id = {0} del monitoria Individualo con id = " + materiaId, monitoriaIndividualId);
        if (materia.equals(materiaWanted)) {
            return materia;
        }
        throw new BusinessLogicException("El monitoriaIndividualo no está asociado al materia");
    }

    public MateriaEntity replaceMaterias(Long monitoriaIndividualId, MateriaEntity replace){
        LOGGER.log(Level.INFO, "Inicia proceso de remplazarlos materias del monitoria Individual con id = {0}", monitoriaIndividualId);
        MonitoriaIndividualEntity monitoriaIndividual = monitoriaIndividualPersistence.find(monitoriaIndividualId);
        monitoriaIndividual.setMateria(replace);
        LOGGER.log(Level.INFO, "Termina proceso de remplazarlos materias del monitoria Individual con id = {0}", monitoriaIndividualId);
        return monitoriaIndividual.getMateria();
        
    }
}
