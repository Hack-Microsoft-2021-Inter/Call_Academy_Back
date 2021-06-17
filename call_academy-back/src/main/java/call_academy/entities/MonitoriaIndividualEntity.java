/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Juan Charry 
 */
@Entity
public class MonitoriaIndividualEntity extends MonitoriaEntity implements Serializable{

    /////////////////////////// RELACIONES ///////////////////////////
    
    @ManyToOne
    private EstudianteEntity estudiante;
    
    //////////////////////////// MÉTODOS ////////////////////////////

    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }
    
}
