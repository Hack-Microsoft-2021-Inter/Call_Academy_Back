/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.EstudianteEntity;
import call_academy.entities.MonitoriaIndividualEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.EstudiantePersistence;
import call_academy.persistence.MonitoriaIndividualPersistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaIndividualEstudiante {
    
    private static final Logger LOGGER = Logger.getLogger(MonitoriaIndividualEstudiante.class.getName());

    @Inject
    private MonitoriaIndividualPersistence monitoriaIndividualPersistence;

    @Inject
    private EstudiantePersistence estudiantePersistence;

    public MonitoriaIndividualEntity addMonitoriaIndividualEstudiante(Long estudiantesId, Long monitoriaIndividualId) throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle una monitoria Individual a estudiante con id = {0}", estudiantesId);
        
        EstudianteEntity estudianteEntity = estudiantePersistence.find(estudiantesId);
        MonitoriaIndividualEntity monitoriaIndividualEntity = monitoriaIndividualPersistence.find(monitoriaIndividualId);
        
        if(estudianteEntity == null || monitoriaIndividualEntity == null){
            throw new BusinessLogicException("El monitoriaIndividualo o estudiante estan vacios");
        }
        
        estudianteEntity.getMonitoriasIndividuales().add(monitoriaIndividualEntity);
        monitoriaIndividualEntity.setEstudiante(estudianteEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoria Individual a estudiante con id = {0}", estudiantesId);
        return monitoriaIndividualEntity;
    }

    public EstudianteEntity addEstudianteMonitoriaIndividual(Long estudiantesId, Long monitoriaIndividualId) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle un monitoria Individual al estudiante con id = {0}", estudiantesId);
        EstudianteEntity estudianteEntity = estudiantePersistence.find(estudiantesId);
        MonitoriaIndividualEntity monitoriaIndividualEntity = monitoriaIndividualPersistence.find(monitoriaIndividualId);
        if(estudianteEntity == null || monitoriaIndividualEntity == null){
            throw new BusinessLogicException("El monitoria Individual o estudiante estan vacios");
        }
        estudianteEntity.getMonitoriasIndividuales().add(monitoriaIndividualEntity);
        monitoriaIndividualEntity.setEstudiante(estudianteEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoria Individual a estudiante con id = {0}", estudiantesId);
        return estudianteEntity;
    }

    public EstudianteEntity getEstudiante(Long monitoriaIndividualId, Long estudianteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el estudiante con id = {0} del monitoriaIndividual con id = " + estudianteId, monitoriaIndividualId);
        EstudianteEntity estudiante = monitoriaIndividualPersistence.find(monitoriaIndividualId).getEstudiante();
        EstudianteEntity estudianteWanted = estudiantePersistence.find(estudianteId);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el estudiante con id = {0} del monitoriaIndividual con id = " + estudianteId, monitoriaIndividualId);
        if (estudiante.equals(estudianteWanted)) {
            return estudiante;
        }
        throw new BusinessLogicException("El monitoriaIndividualo no está asociado al estudiante");
    }

    public EstudianteEntity replaceEstudiantes(Long monitoriaIndividualId, EstudianteEntity replace){
        LOGGER.log(Level.INFO, "Inicia proceso de remplazarlos estudiantes del monitoria Individual con id = {0}", monitoriaIndividualId);
        MonitoriaIndividualEntity monitoriaIndividual = monitoriaIndividualPersistence.find(monitoriaIndividualId);
        monitoriaIndividual.setEstudiante(replace);
        LOGGER.log(Level.INFO, "Termina proceso de remplazarlos estudiantes del monitoria Individual con id = {0}", monitoriaIndividualId);
        return monitoriaIndividual.getEstudiante();
        
    }
}
