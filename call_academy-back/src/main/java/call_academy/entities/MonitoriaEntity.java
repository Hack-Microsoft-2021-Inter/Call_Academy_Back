/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaEntity {

//Relaciones
    @ManyToMany
    private List<TagEntity> tags;

    @ManyToOne
    private MateriaEntity materia;

    /**
     * @ManyToOne private MonitorEntity monitor;
     */
//Atreibutos de la clase
    private long id;

    private Date fecha;

    private Integer duracionHoras;

    private Integer duracionMinutos;

    private Boolean esVirtual;

    private String lugar;

    private Integer precio;

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

//Getters y Setter
    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return duracionHoras
     */
    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    /**
     * @param duracionHoras the duracionHoras to set
     */
    public void setDuracionHoras(Integer duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    /**
     * @return duracionMinutos
     */
    public Integer getDuracionMinutos() {
        return duracionMinutos;
    }

    /**
     * @param duracionMinutos the duracionMinutos to set
     */
    public void setDuracionMinutos(Integer duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    /**
     * @return esVirtual
     */
    public Boolean getEsVirtual() {
        return esVirtual;
    }

    /**
     * @param esVirtual the esVirtual to set
     */
    public void setEsVirtual(Boolean esVirtual) {
        this.esVirtual = esVirtual;
    }

    /**
     * @return lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}
