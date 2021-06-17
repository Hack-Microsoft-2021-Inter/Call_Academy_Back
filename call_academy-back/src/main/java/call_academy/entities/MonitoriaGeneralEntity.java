/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.util.List;
import javax.persistence.ManyToMany;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaGeneralEntity extends MonitoriaEntity {

//Relaciones
    @ManyToMany
    private List<EstudianteEntity> estuciantes;

//Atributos
    private String descripcion;

//Getters  y Setters
    /**
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//Getters  y Setters Relaciones
    /**
     * @return estudiantes
     */
    public List<EstudianteEntity> getEstuciantes() {
        return estuciantes;
    }

    /**
     * @param estudiantes the estudiantes to set
     */
    public void setEstuciantes(List<EstudianteEntity> estuciantes) {
        this.estuciantes = estuciantes;
    }

}
