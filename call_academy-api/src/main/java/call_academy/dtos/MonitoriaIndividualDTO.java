/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.MonitoriaIndividualEntity;
import java.io.Serializable;
/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaIndividualDTO extends MonitoriaDTO implements Serializable{
    
    private EstudianteDTO estudiante;
    
    public MonitoriaIndividualDTO(){
        super();
    }
    
    public MonitoriaIndividualDTO(MonitoriaIndividualEntity entity) {
        super(entity);
        this.estudiante = new EstudianteDTO(entity.getEstudiante());
    }

    public MonitoriaIndividualEntity toEntity() {
        
        MonitoriaIndividualEntity entity = (MonitoriaIndividualEntity) super.toEntity();
        entity.setEstudiante(estudiante.toEntity());
        return entity;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    
}
