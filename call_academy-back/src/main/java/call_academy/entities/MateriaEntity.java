/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.io.Serializable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Juan Pablo
 */
public class MateriaEntity extends BaseEntity implements Serializable {
    
    private String nombre;
    
//    @ManyToMany
//    private List<MonitorEntity> monitores;
//    
//    @OneToMany
//    private List<ArchivoEntity> archivos;
//    
//    @OneToMany
//    private List<MonitoriaEntity> monitorias;

    
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
    
    
}
