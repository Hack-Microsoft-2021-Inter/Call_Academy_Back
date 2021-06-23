/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.MonitorEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.MonitorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;



/**
 *
 * @author Julian Andres Mendez
 */
@Stateless
public class MonitorLogic {
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    @Inject
    private MonitorPersistence persistence;
    
    //////////////////////////// MÉTODOS ////////////////////////////
    
    public MonitorEntity createMonitor(MonitorEntity monitor) throws BusinessLogicException {
        if (monitor.getNombre() == null || monitor.getNombre().isEmpty())
            throw new BusinessLogicException("El nombre está vacío");
        if (persistence.findByCorreo(monitor.getCorreo()) != null)
            throw new BusinessLogicException("El correo ya existe.");
        if (!(monitor.getCalificacion()>=0 && monitor.getCalificacion()<=0))
            throw new BusinessLogicException("La calificación es incorrecta");
        
        monitor = persistence.create(monitor);
        return monitor;
    }
    
    public List<MonitorEntity> findAllMonitor() {
        List<MonitorEntity> resultado = persistence.findAll();
        return resultado;
    }
    
    public MonitorEntity findMonitor(Long id) {
        MonitorEntity monitor = persistence.find(id);
        return monitor;
    }
    
    public List<MonitorEntity> findMonitorByNombre(String nombre) {
        List<MonitorEntity> resultado = persistence.findByNombre(nombre);
        return resultado;
    }
    
    public MonitorEntity updateMonitor(MonitorEntity monitor) throws BusinessLogicException {
        if (monitor.getNombre() == null || monitor.getNombre().isEmpty())
            throw new BusinessLogicException("El nombre está vacío");
        if (persistence.findByCorreo(monitor.getCorreo()) != null)
            throw new BusinessLogicException("El correo ya existe.");
        if (!(monitor.getCalificacion()>=0 && monitor.getCalificacion()<=0))
            throw new BusinessLogicException("La calificación es incorrecta");
        
        monitor = persistence.update(monitor);
        return monitor;
    }
    
    public void deleteMonitor(Long id) {
        persistence.delete(id);
    }
}