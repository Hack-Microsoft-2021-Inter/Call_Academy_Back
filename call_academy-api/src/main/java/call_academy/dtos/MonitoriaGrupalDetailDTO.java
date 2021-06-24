/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.EstudianteEntity;
import call_academy.entities.MonitoriaGrupalEntity;
import call_academy.entities.TagEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaGrupalDetailDTO extends MonitoriaGrupalDTO implements Serializable{
    
    private List<TagDTO> tags;
    private List<EstudianteDTO> estudiantes;
    
    public MonitoriaGrupalDetailDTO() {
        super();
    }
    
    public MonitoriaGrupalDetailDTO(MonitoriaGrupalEntity monitoriaGrupalEntity) {
        super(monitoriaGrupalEntity);
        if (monitoriaGrupalEntity.getEstudiantes() != null) {
            estudiantes = new ArrayList<>();
            for (EstudianteEntity entityEstudiante : monitoriaGrupalEntity.getEstudiantes()) {
                estudiantes.add(new EstudianteDTO(entityEstudiante));
            }
        }
        if (monitoriaGrupalEntity.getTags() != null) {
            tags = new ArrayList<>();
            for (TagEntity entityTag : monitoriaGrupalEntity.getTags()) {
                tags.add(new TagDTO(entityTag));
            }
        }
    }

    @Override
    public MonitoriaGrupalEntity toEntity() {
        MonitoriaGrupalEntity monitoriaGrupalEntity = super.toEntity();
        if (estudiantes != null) {
            List<EstudianteEntity> estudianteEntity = new ArrayList<>();
            for (EstudianteDTO dtoEstudiante : getEstudiantes()) {
                estudianteEntity.add(dtoEstudiante.toEntity());
            }
            monitoriaGrupalEntity.setEstudiantes(estudianteEntity);
        }
        if (tags != null) {
            List<TagEntity> tagsEntity = new ArrayList<>();
            for (TagDTO dtoTag : getTags()) {
                tagsEntity.add(dtoTag.toEntity());
            }
            monitoriaGrupalEntity.setTags(tagsEntity);
        }
        return monitoriaGrupalEntity;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

    public List<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
}
