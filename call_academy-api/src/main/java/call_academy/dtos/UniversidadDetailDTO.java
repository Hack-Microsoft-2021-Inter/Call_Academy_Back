/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.EstudianteEntity;
import call_academy.entities.UniversidadEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Charry Gavilan
 */
public class UniversidadDetailDTO extends UniversidadDTO implements Serializable{
    
    private List<EstudianteDTO> estudiantes;
    
    public UniversidadDetailDTO() {
        super();
    }

    
    public UniversidadDetailDTO(UniversidadEntity universidadEntity) {
        super(universidadEntity);

        if (universidadEntity.getEstudiantes() != null) {
            estudiantes = new ArrayList<>();
            for (EstudianteEntity entityEstudiante : universidadEntity.getEstudiantes()) {
                estudiantes.add(new EstudianteDTO(entityEstudiante));
            }
        }
    }

    @Override
    public UniversidadEntity toEntity() {
        UniversidadEntity universidadEntity = super.toEntity();
        if (estudiantes != null) {
            List<EstudianteEntity> estudiantesEntity = new ArrayList<>();
            for (EstudianteDTO dtoEstudiante : getEstudiantes()) {
                estudiantesEntity.add(dtoEstudiante.toEntity());
            }
            universidadEntity.setEstudiantes(estudiantesEntity);
        }
        return universidadEntity;
    }

    public List<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
}
