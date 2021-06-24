/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.TagEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Juan Charry Gavilan
 */
public class TagDTO implements Serializable {

    private Long id;

    private String nombre;

    public TagDTO(TagEntity tagEntity) {
        if (tagEntity != null) {
            this.id = tagEntity.getId();
            this.nombre = tagEntity.getNombre();
        }
    }

    public TagDTO() {
    }

    public TagEntity toEntity() {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setId(this.id);
        tagEntity.setNombre(this.nombre);
        return tagEntity;
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
