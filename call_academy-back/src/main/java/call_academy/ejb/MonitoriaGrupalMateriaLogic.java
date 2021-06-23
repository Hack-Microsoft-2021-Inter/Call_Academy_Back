/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.MateriaEntity;
import call_academy.entities.MonitoriaGrupalEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.MateriaPersistence;
import call_academy.persistence.MonitoriaGrupalPersistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaGrupalMateriaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(MonitoriaGrupalMateriaLogic.class.getName());

    @Inject
    private MonitoriaGrupalPersistence monitoriaGrupalPersistence;

    @Inject
    private MateriaPersistence materiaPersistence;

    public MonitoriaGrupalEntity addMonitoriaGrupalMateria(Long materiasId, Long monitoriaGrupalId) throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle una monitoria Grupal a materia con id = {0}", materiasId);
        
        MateriaEntity materiaEntity = materiaPersistence.find(materiasId);
        MonitoriaGrupalEntity monitoriaGrupalEntity = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        
        if(materiaEntity == null || monitoriaGrupalEntity == null){
            throw new BusinessLogicException("El monitoriaGrupalo o materia estan vacios");
        }
        
        materiaEntity.getMonitorias().add(monitoriaGrupalEntity);
        monitoriaGrupalEntity.setMateria(materiaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoria Grupal a materia con id = {0}", materiasId);
        return monitoriaGrupalEntity;
    }

    public MateriaEntity addMateriaMonitoriaGrupal(Long materiasId, Long monitoriaGrupalId) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle un monitoria Grupal al materia con id = {0}", materiasId);
        MateriaEntity materiaEntity = materiaPersistence.find(materiasId);
        MonitoriaGrupalEntity monitoriaGrupalEntity = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        if(materiaEntity == null || monitoriaGrupalEntity == null){
            throw new BusinessLogicException("El monitoria Grupal o materia estan vacios");
        }
        materiaEntity.getMonitorias().add(monitoriaGrupalEntity);
        monitoriaGrupalEntity.setMateria(materiaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoria Grupal a materia con id = {0}", materiasId);
        return materiaEntity;
    }

    public MateriaEntity getMateria(Long monitoriaGrupalId, Long materiaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el materia con id = {0} del monitoriaGrupal con id = " + materiaId, monitoriaGrupalId);
        MateriaEntity materia = monitoriaGrupalPersistence.find(monitoriaGrupalId).getMateria();
        MateriaEntity materiaWanted = materiaPersistence.find(materiaId);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el materia con id = {0} del monitoriaGrupal con id = " + materiaId, monitoriaGrupalId);
        if (materia.equals(materiaWanted)) {
            return materia;
        }
        throw new BusinessLogicException("El monitoriaGrupalo no está asociado al materia");
    }

    public MateriaEntity replaceMaterias(Long monitoriaGrupalId, MateriaEntity replace){
        LOGGER.log(Level.INFO, "Inicia proceso de remplazarlos materias del monitoria Grupal con id = {0}", monitoriaGrupalId);
        MonitoriaGrupalEntity monitoriaGrupal = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        monitoriaGrupal.setMateria(replace);
        LOGGER.log(Level.INFO, "Termina proceso de remplazarlos materias del monitoria Grupal con id = {0}", monitoriaGrupalId);
        return monitoriaGrupal.getMateria();
        
    }
}
