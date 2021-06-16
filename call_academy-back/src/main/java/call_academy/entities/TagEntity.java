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
public class TagEntity {
    
    private String id; 
    private String nombre; 

    
    
    
   /**
    * 
    * @return otiene el id 
    */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id set the id 
     */
    public void setId(String id) {
        this.id = id;
    }

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
