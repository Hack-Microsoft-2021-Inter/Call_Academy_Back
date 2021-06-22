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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Mario Ruiz
 */
@Entity
public class MateriaEntity extends BaseEntity implements Serializable {
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    private String nombre;
    
    /////////////////////////// RELACIONES ///////////////////////////
    
    @ManyToMany (
        mappedBy = "materias"
    )
    private List<MonitorEntity> monitores;
    
    @OneToMany (
        mappedBy = "materia",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY,
        orphanRemoval = true
    )
    private List<ArchivoEntity> archivos;
    
    @OneToMany (
        mappedBy = "materia",
        cascade = CascadeType.PERSIST,
        fetch = FetchType.LAZY,
        orphanRemoval = true
    )
    private List<MonitoriaEntity> monitorias;

    //////////////////////////// MÈTODOS ////////////////////////////
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<MonitorEntity> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<MonitorEntity> monitores) {
        this.monitores = monitores;
    }

    public List<ArchivoEntity> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<ArchivoEntity> archivos) {
        this.archivos = archivos;
    }

    public List<MonitoriaEntity> getMonitorias() {
        return monitorias;
    }

    public void setMonitorias(List<MonitoriaEntity> monitorias) {
        this.monitorias = monitorias;
    }
}
