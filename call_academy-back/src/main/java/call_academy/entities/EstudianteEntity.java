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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Juan Pablo
 */
@Entity
public class EstudianteEntity extends BaseEntity implements Serializable {
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    private String nombre;
    
    private String correo;
    
    private String contrasena;

    /////////////////////////// RELACIONES ///////////////////////////
    
    @ManyToOne
    private UniversidadEntity universidad;
    
    @OneToMany
    private List<ArchivoEntity> archivos;
    
    @OneToMany
    private List<MonitoriaIndividualEntity> monitoriasIndividivuales;
    
    @ManyToMany
    private List<MonitoriaGrupalEntity> monitoriasGrupales;
    
    //////////////////////////// MÈTODOS ////////////////////////////
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UniversidadEntity getUniversidad() {
        return universidad;
    }

    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
    }

    public List<ArchivoEntity> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<ArchivoEntity> archivos) {
        this.archivos = archivos;
    }

    public List<MonitoriaIndividualEntity> getMonitoriasIndividivuales() {
        return monitoriasIndividivuales;
    }

    public void setMonitoriasIndividivuales(List<MonitoriaIndividualEntity> monitoriasIndividivuales) {
        this.monitoriasIndividivuales = monitoriasIndividivuales;
    }

    public List<MonitoriaGrupalEntity> getMonitoriasGrupales() {
        return monitoriasGrupales;
    }

    public void setMonitoriasGrupales(List<MonitoriaGrupalEntity> monitoriasGrupales) {
        this.monitoriasGrupales = monitoriasGrupales;
    }
    
    

}
