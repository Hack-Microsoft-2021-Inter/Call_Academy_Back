/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.EstudianteEntity;
import call_academy.entities.MonitoriaGrupalEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.EstudiantePersistence;
import call_academy.persistence.MonitoriaGrupalPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaGrupalEstudiantes {
    
    private static final Logger LOGGER = Logger.getLogger(MonitoriaGrupalEstudiantes.class.getName());

    @Inject
    private MonitoriaGrupalPersistence monitoriaGrupalPersistence;

    @Inject
    private EstudiantePersistence estudiantePersistence;

    public MonitoriaGrupalEntity addMonitoriaGrupalEstudiante(Long estudiantesId, Long monitoriaGrupalId) throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle una monitoria Individual a estudiante con id = {0}", estudiantesId);
        
        EstudianteEntity estudianteEntity = estudiantePersistence.find(estudiantesId);
        MonitoriaGrupalEntity monitoriaGrupalEntity = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        
        if(estudianteEntity == null || monitoriaGrupalEntity == null){
            throw new BusinessLogicException("El monitoriaGrupalo o estudiante estan vacios");
        }
        
        estudianteEntity.getMonitoriasGrupales().add(monitoriaGrupalEntity);
        monitoriaGrupalEntity.getEstuciantes().add(estudianteEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoriaGrupalo al estudiante con id = {0}", estudiantesId);
        return monitoriaGrupalEntity;
    }

    public EstudianteEntity addEstudianteMonitoriaGrupal(Long estudiantesId, Long monitoriaGrupalId) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle un monitoriaGrupalo al estudiante con id = {0}", estudiantesId);
        EstudianteEntity estudianteEntity = estudiantePersistence.find(estudiantesId);
        MonitoriaGrupalEntity monitoriaGrupalEntity = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        if(estudianteEntity == null || monitoriaGrupalEntity == null){
            throw new BusinessLogicException("El monitoriaGrupalo o estudiante estan vacios");
        }
        estudianteEntity.getMonitoriasGrupales().add(monitoriaGrupalEntity);
        monitoriaGrupalEntity.getEstuciantes().add(estudianteEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoriaGrupalo al estudiante con id = {0}", estudiantesId);
        return estudianteEntity;
    }

    public List<EstudianteEntity> getEstudiantes(Long monitoriaGrupalId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los estudiantes del monitoriaGrupalo con id = {0}", monitoriaGrupalId);
        MonitoriaGrupalEntity monitoriaGrupal = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        if (monitoriaGrupal == null){
            throw new BusinessLogicException("El monitoriaGrupalo no existe");
        }
        return monitoriaGrupal.getEstuciantes();
    }

    public EstudianteEntity getEstudiante(Long monitoriaGrupalId, Long estudianteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el estudiante con id = {0} del monitoriaGrupalo con id = " + estudianteId, monitoriaGrupalId);
        List<EstudianteEntity> estudiantes = monitoriaGrupalPersistence.find(monitoriaGrupalId).getEstuciantes();
        EstudianteEntity estudianteWanted = estudiantePersistence.find(estudianteId);
        int index = estudiantes.indexOf(estudianteWanted);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el estudiante con id = {0} del monitoriaGrupalo con id = " + estudianteId, monitoriaGrupalId);
        if (index >= 0) {
            return estudiantes.get(index);
        }
        throw new BusinessLogicException("El monitoriaGrupalo no está asociado al estudiante");
    }

    public List<EstudianteEntity> replaceEstudiantes(Long monitoriaGrupalId, List<EstudianteEntity> replace){
        LOGGER.log(Level.INFO, "Inicia proceso de remplazarlos estudiantes del monitoriaGrupalo con id = {0}", monitoriaGrupalId);
        MonitoriaGrupalEntity monitoriaGrupal = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        monitoriaGrupal.setEstuciantes(replace);
        LOGGER.log(Level.INFO, "Termina proceso de remplazarlos estudiantes del monitoriaGrupalo con id = {0}", monitoriaGrupalId);
        return monitoriaGrupal.getEstuciantes();
        
    }

    public void removeMonitoriaGrupal(Long estudiantesId, Long monitoriaGrupalId) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un monitoriaGrupalo del estudiante con id = {0}", estudiantesId);
        EstudianteEntity estudianteEntity = estudiantePersistence.find(estudiantesId);
        MonitoriaGrupalEntity monitoriaGrupalEntity = monitoriaGrupalPersistence.find(monitoriaGrupalId);

        if(estudianteEntity == null || monitoriaGrupalEntity == null){
            throw new BusinessLogicException("El servicio y el monitoriaGrupalo deben existir y tener un id valido");
        }

        estudianteEntity.getMonitoriasGrupales().remove(monitoriaGrupalEntity);
        monitoriaGrupalEntity.getEstuciantes().remove(estudianteEntity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar un monitoriaGrupalo del estudiante con id = {0}", estudiantesId);
    }
}
