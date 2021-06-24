/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.EstudianteEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Juan Charry Gavilan
 */
public class EstudianteDTO {
    
    private Long id;
    
    private String nombre;
    
    private String correo;
    
    private String contrasena;

    private UniversidadDTO universidad;
    
    public EstudianteDTO() {
    }
    
    public EstudianteDTO(EstudianteEntity estudianteEntity) {
        if (estudianteEntity != null) {
            this.id = estudianteEntity.getId();
            this.nombre = estudianteEntity.getNombre();
            this.correo = estudianteEntity.getCorreo();
            this.contrasena = estudianteEntity.getContrasena();
            if (estudianteEntity.getUniversidad() != null) {
                this.universidad = new UniversidadDTO(estudianteEntity.getUniversidad());
            } else {
                this.universidad = null;
            }
        }
    }

    public EstudianteEntity toEntity() {
        EstudianteEntity estudianteEntity = new EstudianteEntity();
        estudianteEntity.setId(this.id);
        estudianteEntity.setNombre(this.nombre);
        estudianteEntity.setCorreo(this.correo);
        estudianteEntity.setContrasena(this.contrasena);
        if (this.universidad != null) {
            estudianteEntity.setUniversidad(this.universidad.toEntity());
        }
        return estudianteEntity;
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
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
