/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import javax.persistence.ManyToOne;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaIndividualEntity extends MonitoriaEntity {

    @ManyToOne
    private EstudianteEntity estudiante;

//Getters y Setters relaciones
    /**
     * @return estudiante
     */
    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    /**
     * @param estudiante the estudiante to set
     */
    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }
    
    
}
