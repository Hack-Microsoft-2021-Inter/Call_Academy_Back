/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.EstudianteEntity;
import call_academy.entities.MonitoriaIndividualEntity;
import call_academy.entities.TagEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaIndividualDetailDTO extends MonitoriaDTO implements Serializable {
    
    private List<TagDTO> tags;
    
    public MonitoriaIndividualDetailDTO() {
        super();
    }
    
    public MonitoriaIndividualDetailDTO(MonitoriaIndividualEntity monitoriaIndividualEntity) {
        super(monitoriaIndividualEntity);
        if (monitoriaIndividualEntity.getTags() != null) {
            tags = new ArrayList<>();
            for (TagEntity entityTag : monitoriaIndividualEntity.getTags()) {
                tags.add(new TagDTO(entityTag));
            }
        }
    }

    @Override
    public MonitoriaIndividualEntity toEntity() {
        MonitoriaIndividualEntity monitoriaIndividualEntity = (MonitoriaIndividualEntity) super.toEntity();
        if (tags != null) {
            List<TagEntity> tagsEntity = new ArrayList<>();
            for (TagDTO dtoTag : getTags()) {
                tagsEntity.add(dtoTag.toEntity());
            }
            monitoriaIndividualEntity.setTags(tagsEntity);
        }
        return monitoriaIndividualEntity;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

}
