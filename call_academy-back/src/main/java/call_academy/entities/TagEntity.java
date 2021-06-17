/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.io.Serializable;
import javax.persistence.Entity;
/**
 *
 * @author juanj
 */
@Entity
public class TagEntity extends BaseEntity implements Serializable{
    
    private String nombre; 

    /**
     * 
     * @return obtiene el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre set the nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
       
    
}
