/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.MateriaEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MateriaDTO implements Serializable{
    
    private Long id;
    
    private String nombre;
    
    public MateriaDTO() {
    }

    public MateriaDTO(MateriaEntity materia) {
        if (materia != null) {
            this.id = materia.getId();
            this.nombre = materia.getNombre();
        }
    }

    public MateriaEntity toEntity() {
        MateriaEntity materiaEntity = new MateriaEntity();
        materiaEntity.setId(this.id);
        materiaEntity.setNombre(this.nombre);
        return materiaEntity;
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
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
