/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author Juan Pablo
 */
@Entity
public class UniversidadEntity extends BaseEntity implements Serializable {

    private String nombre;
    
//    @OneToMany(
//            mappedBy = "universidad",
//            fetch = FetchType.LAZY
//    )
//    private List<EstudianteEntity> estudiantes;
    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estudiantes
     */
//    public List<EstudianteEntity> getEstudiantes() {
//        return estudiantes;
//    }
//
//    /**
//     * @param estudiantes the estudiantes to set
//     */
//    public void setEstudiantes(List<EstudianteEntity> estudiantes) {
//        this.estudiantes = estudiantes;
//    }
}
