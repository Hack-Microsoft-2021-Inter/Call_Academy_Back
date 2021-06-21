/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Juan Charry 
 */
@Entity
public class MonitoriaEntity extends BaseEntity implements Serializable{

<<<<<<< HEAD
//Relaciones
    @ManyToMany
    private List<TagEntity> tags;

    @ManyToOne
    private MateriaEntity materia;
    
    @ManyToOne
    private MonitorEntity monitor;
    
//Atreibutos de la clase
    private long id;
=======
    /////////////////////////// ATRIBUTOS ////////////////////////////
>>>>>>> 0887168ef992034b6b8625a046734a400872086e

    private Date fecha;

    private Integer duracionHoras;

    private Integer duracionMinutos;

    private Boolean esVirtual;

    private String lugar;

    private Integer precio;
    
    /////////////////////////// RELACIONES ///////////////////////////
    
    @ManyToMany
    private List<TagEntity> tags;

<<<<<<< HEAD
//Getters y setter Relaciones
    /**
     * @return tags
     */
    public List<TagEntity> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    /**
     * @return materia
     */
    public MateriaEntity getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(MateriaEntity materia) {
        this.materia = materia;
    }
    
    /**
     * @return monitor
     */
    public MonitorEntity getMonitor() {
        return monitor;
    }
    
    /**
     * @param monitor the monitor to set
     */
    public void setMonitor(MonitorEntity monitor) {
        this.monitor = monitor;
    }
    
    
=======
    @ManyToOne
    private MateriaEntity materia;
>>>>>>> 0887168ef992034b6b8625a046734a400872086e

    @ManyToOne 
    private MonitorEntity monitor;

    //////////////////////////// MÉTODOS ////////////////////////////

    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Integer duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }
    
    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Boolean getEsVirtual() {
        return esVirtual;
    }

    public void setEsVirtual(Boolean esVirtual) {
        this.esVirtual = esVirtual;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    public MateriaEntity getMateria() {
        return materia;
    }

    public void setMateria(MateriaEntity materia) {
        this.materia = materia;
    }

    public MonitorEntity getMonitor() {
        return monitor;
    }

    public void setMonitor(MonitorEntity monitor) {
        this.monitor = monitor;
    }
    
    
}
