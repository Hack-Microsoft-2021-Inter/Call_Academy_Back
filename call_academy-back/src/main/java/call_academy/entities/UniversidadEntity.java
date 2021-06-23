/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author Juan Pablo
 */
@Entity
public class UniversidadEntity extends BaseEntity implements Serializable {

    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    private String nombre;
    
    /////////////////////////// RELACIONES ///////////////////////////

    @OneToMany (
        mappedBy = "universidad",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY
    )
    private List<EstudianteEntity> estudiantes;
    
    //////////////////////////// MÉTODOS ////////////////////////////
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EstudianteEntity> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteEntity> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
}
