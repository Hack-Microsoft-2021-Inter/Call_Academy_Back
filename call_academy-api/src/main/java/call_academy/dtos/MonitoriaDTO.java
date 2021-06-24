/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.MonitoriaEntity;
import co.edu.uniandes.csw.cassettes.adapters.DateAdapter;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaDTO implements Serializable {
    
    private Long id;
    
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fecha;

    private Integer duracionHoras;

    private Integer duracionMinutos;

    private Boolean esVirtual;

    private String lugar;
        
    private MateriaDTO materia;
    
    private MonitorDTO monitor;
    
    public MonitoriaDTO(){
    }
    
    public MonitoriaDTO(MonitoriaEntity entity){
        if (entity != null) {
            this.id = entity.getId();
            this.fecha = entity.getFecha();
            this.duracionHoras = entity.getDuracionHoras();
            this.duracionMinutos = entity.getDuracionMinutos();
            this.esVirtual = entity.getEsVirtual();
            this.lugar = entity.getLugar();
            
            if (entity.getMateria() != null) {
                this.materia = new MateriaDTO(entity.getMateria());
            } else {
                this.materia = null;
            }
            if (entity.getMonitor()!= null) {
                this.monitor = new MonitorDTO(entity.getMonitor());
            } else {
                this.monitor = null;
            }
        }
    }
    
    public MonitoriaEntity toEntity() {
        MonitoriaEntity entity = new MonitoriaEntity();
        entity.setId(this.id);
        entity.setDuracionHoras(this.duracionHoras);
        entity.setDuracionMinutos(this.duracionMinutos);
        entity.setEsVirtual(this.esVirtual);
        entity.setFecha(this.fecha);
        entity.setLugar(this.lugar);
        entity.setPrecio(this.duracionHoras);
        
        if (this.materia != null) {
            entity.setMateria(this.materia.toEntity());
        }
        if (this.monitor != null) {
            entity.setMonitor(this.monitor.toEntity());
        }
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public MateriaDTO getMateria() {
        return materia;
    }

    public void setMateria(MateriaDTO materia) {
        this.materia = materia;
    }

    public MonitorDTO getMonitor() {
        return monitor;
    }

    public void setMonitor(MonitorDTO monitor) {
        this.monitor = monitor;
    }
    
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
