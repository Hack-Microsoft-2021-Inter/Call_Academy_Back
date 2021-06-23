/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.MonitoriaIndividualEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.EstudiantePersistence;
import call_academy.persistence.MateriaPersistence;
import call_academy.persistence.MonitoriaIndividualPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Juan Charry Gavilan
 */
@Stateless
public class MonitoriaIndividualLogic {
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    private static final Logger LOGGER = Logger.getLogger(MonitoriaIndividualLogic.class.getName());
    
    @Inject
    private MonitoriaIndividualPersistence persistence;
    
    @Inject
    private EstudiantePersistence estudiantePersistence;
    
    @Inject
    private MateriaPersistence materiaPersistence;
    
    /////////////////////////// MÉTODOS ////////////////////////////
    
    public MonitoriaIndividualEntity createmonitoriaIndividual (MonitoriaIndividualEntity monitoria) throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia proceso de crear monitoria individual con id = {0}", monitoria.getId());
        
        //Si es antes del dia de hoy se revisa en el front
        if (monitoria.getFecha() == null)
            throw new BusinessLogicException("La fecha no puede ser nula");
        
        if (monitoria.getDuracionHoras() < 0 || monitoria.getDuracionMinutos() < 0)
            throw new BusinessLogicException("Las horas o minutos no pueden ser menores a cero");
        
        if (monitoria.getDuracionHoras() == 0 && monitoria.getDuracionMinutos() == 0)
            throw new BusinessLogicException ("La moitaria no puede durar 0 horas y 0 minutos");
        
        if (monitoria.getLugar().equals("") || monitoria.getLugar().isEmpty())
            throw new BusinessLogicException("Debe especificarse un lugar");
        
        if (monitoria.getPrecio() < 0)
            throw new BusinessLogicException("La monitaria no puede tener un precio menor a cero");
        
        if (monitoria.getEstudiante() == null || estudiantePersistence.find(monitoria.getEstudiante().getId()) == null)
            throw new BusinessLogicException("El estudiante no puede ser nulo");
        
        if (monitoria.getMateria() == null || materiaPersistence.find(monitoria.getMateria().getId()) == null )
            throw new BusinessLogicException("La monitoria debe tener una materia valida");
        
        monitoria = persistence.create(monitoria);
        
        LOGGER.log(Level.INFO, "Finaliza el proceso de crear una monitoria individual con id = {0}", monitoria.getId());
        
        return monitoria;
    }
    
    public List<MonitoriaIndividualEntity> findAllMonitoriaIndividual() {
        List<MonitoriaIndividualEntity> resultado = persistence.findAll();
        return resultado;
    }
    
    public MonitoriaIndividualEntity findMonitoriaIndividual(Long id) {
        MonitoriaIndividualEntity monitoria = persistence.find(id);
        return monitoria;
    }
    
    public MonitoriaIndividualEntity updateMonitoriaIndividual(MonitoriaIndividualEntity monitoria) throws BusinessLogicException {
        
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar monitoria individual con id = {0}", monitoria.getId());
        
        if (monitoria.getFecha() == null)
            throw new BusinessLogicException("La fecha no puede ser nula");
        
        if (monitoria.getDuracionHoras() < 0 || monitoria.getDuracionMinutos() < 0)
            throw new BusinessLogicException("Las horas o minutos no pueden ser menores a cero");
        
        if (monitoria.getDuracionHoras() == 0 && monitoria.getDuracionMinutos() == 0)
            throw new BusinessLogicException ("La moitaria no puede durar 0 horas y 0 minutos");
        
        if (monitoria.getLugar().equals("") || monitoria.getLugar().isEmpty())
            throw new BusinessLogicException("Debe especificarse un lugar");
        
        if (monitoria.getPrecio() < 0)
            throw new BusinessLogicException("La monitaria no puede tener un precio menor a cero");
        
        if (monitoria.getEstudiante() == null || estudiantePersistence.find(monitoria.getEstudiante().getId()) == null)
            throw new BusinessLogicException("El estudiante no puede ser nulo");
        
        if (monitoria.getMateria() == null || materiaPersistence.find(monitoria.getMateria().getId()) == null )
            throw new BusinessLogicException("La monitoria debe tener una materia valida");
        
        LOGGER.log(Level.INFO, "Finaliza proceso de actualizar monitoria individual con id = {0}", monitoria.getId());
        
        monitoria = persistence.update(monitoria);
        return monitoria;
    } 
    
    public void deleteMonitoriaIndividual(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la monitoria individualcon id = {0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar la monitoria individual con id = {0}", id);
    }
}
