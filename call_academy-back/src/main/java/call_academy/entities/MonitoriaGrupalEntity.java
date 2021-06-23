/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * @author Juan Charry Gavilan
 */
@Entity
public class MonitoriaGrupalEntity extends MonitoriaEntity implements Serializable{

    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    private String descripcion;

    /////////////////////////// RELACIONES ///////////////////////////
    
    @ManyToMany
    private List<EstudianteEntity> estudiantes;
    
    //////////////////////////// MÉTODOS ////////////////////////////
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<EstudianteEntity> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteEntity> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
