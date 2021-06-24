/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.MateriaEntity;
import call_academy.entities.MonitorEntity;
import call_academy.entities.MonitoriaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitorDetailDTO extends MonitorDTO implements Serializable{

    private List<MateriaDTO> materias;

    private List<MonitoriaDTO> monitorias;
    
    public MonitorDetailDTO() {
        super();
    }

    
    public MonitorDetailDTO(MonitorEntity monitorEntity) {
        super(monitorEntity);
        if (monitorEntity.getMaterias() != null) {
            materias = new ArrayList<>();
            for (MateriaEntity entityMateria : monitorEntity.getMaterias()) {
                materias.add(new MateriaDTO(entityMateria));
            }
        }
        if (monitorEntity.getMonitorias() != null) {
            monitorias = new ArrayList<>();
            for (MonitoriaEntity entityMonitoria : monitorEntity.getMonitorias()) {
                monitorias.add(new MonitoriaDTO(entityMonitoria));
            }
        }
    }

    @Override
    public MonitorEntity toEntity() {
        MonitorEntity monitorEntity = super.toEntity();
        if (materias != null) {
            List<MateriaEntity> materiaEntity = new ArrayList<>();
            for (MateriaDTO dtoMateria : getMaterias()) {
                materiaEntity.add(dtoMateria.toEntity());
            }
            monitorEntity.setMaterias(materiaEntity);
        }
        if (monitorias != null) {
            List<MonitoriaEntity> monitoriasEntity = new ArrayList<>();
            for (MonitoriaDTO dtoMonitoria : getMonitorias()) {
                monitoriasEntity.add(dtoMonitoria.toEntity());
            }
            monitorEntity.setMonitorias(monitoriasEntity);
        }
        return monitorEntity;
    }

    public List<MateriaDTO> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaDTO> materias) {
        this.materias = materias;
    }

    public List<MonitoriaDTO> getMonitorias() {
        return monitorias;
    }

    public void setMonitorias(List<MonitoriaDTO> monitorias) {
        this.monitorias = monitorias;
    }
    
    
}
