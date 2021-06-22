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
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * @author Juan Charry 
 */
@Entity
public class MonitoriaEntity extends BaseEntity implements Serializable{

    /////////////////////////// RELACIONES ///////////////////////////
    
    @PodamExclude
    @ManyToMany(mappedBy = "monitorias")
    private List<TagEntity> tags;
    
    @PodamExclude
    @ManyToOne
    private MateriaEntity materia;
    
    @PodamExclude
    @ManyToOne
    private MonitorEntity monitor;
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    private Integer duracionHoras;

    private Integer duracionMinutos;

    private Boolean esVirtual;

    private String lugar;

    private Integer precio;
    
    //////////////////////////// MÉTODOS RELACIONES ////////////////////////////
    
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
    
    //////////////////////////// MÉTODOS ATRIBUTOS ////////////////////////////

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
}
