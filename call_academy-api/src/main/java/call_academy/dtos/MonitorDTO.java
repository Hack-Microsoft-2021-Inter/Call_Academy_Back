/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.MonitorEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitorDTO implements Serializable{
    
    private Long id;
    
    private int calificacion;
    
     private String nombre;
    
    private String correo;
    
    private String contrasena;
    
    private UniversidadDTO universidad;
    
    
     public MonitorDTO() {
    }
    
    public MonitorDTO(MonitorEntity monitorEntity) {
        if (monitorEntity != null) {
            this.id = monitorEntity.getId();
            this.nombre = monitorEntity.getNombre();
            this.correo = monitorEntity.getCorreo();
            this.contrasena = monitorEntity.getContrasena();
            this.calificacion = monitorEntity.getCalificacion();
            if (monitorEntity.getUniversidad() != null) {
                this.universidad = new UniversidadDTO(monitorEntity.getUniversidad());
            } else {
                this.universidad = null;
            }
        }
    }

    public MonitorEntity toEntity() {
        MonitorEntity monitorEntity = new MonitorEntity();
        monitorEntity.setId(this.id);
        monitorEntity.setNombre(this.nombre);
        monitorEntity.setCorreo(this.correo);
        monitorEntity.setContrasena(this.contrasena);
        monitorEntity.setCalificacion(this.calificacion);
        if (this.universidad != null) {
            monitorEntity.setUniversidad(this.universidad.toEntity());
        }
        return monitorEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public UniversidadDTO getUniversidad() {
        return universidad;
    }

    public void setUniversidad(UniversidadDTO universidad) {
        this.universidad = universidad;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
