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
 * @author Juan Jose
 */
@Entity
public class TagEntity extends BaseEntity implements Serializable{
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    private String nombre; 
    
    /////////////////////////// RELACIONES ///////////////////////////
    
    @ManyToMany
    private List<MonitoriaEntity> monitorias;

    @ManyToMany
    private List<ArchivoEntity> archivos; 
  
    //////////////////////////// MÉTODOS ////////////////////////////
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<MonitoriaEntity> getMonitorias() {
        return monitorias;
    }

    public void setMonitorias(List<MonitoriaEntity> monitorias) {
        this.monitorias = monitorias;
    }

    public List<ArchivoEntity> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<ArchivoEntity> archivos) {
        this.archivos = archivos;
    }
        
}
