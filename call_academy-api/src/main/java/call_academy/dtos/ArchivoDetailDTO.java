/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.ArchivoEntity;
import call_academy.entities.TagEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Charry Gavilan
 */
public class ArchivoDetailDTO extends ArchivoDTO implements Serializable {
    
    private List<TagDTO> tags;
    
    public ArchivoDetailDTO() {
        super();
    }

    
    public ArchivoDetailDTO(ArchivoEntity archivoEntity) {
        super(archivoEntity);
        if (archivoEntity.getTags()!= null) {
            tags = new ArrayList<>();
            for (TagEntity entityTag : archivoEntity.getTags()) {
                tags.add(new TagDTO(entityTag));
            }
        }
    }
    
    @Override
    public ArchivoEntity toEntity() {
        ArchivoEntity archivoEntity = super.toEntity();
        if (tags != null) {
            List<TagEntity> tagEntity = new ArrayList<>();
            for (TagDTO dtoTag : getTags()) {
                tagEntity.add(dtoTag.toEntity());
            }
            archivoEntity.setTags(tagEntity);
        }
        return archivoEntity;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }
    
    
    
}
