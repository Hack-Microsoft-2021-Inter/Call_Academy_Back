/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.ArchivoEntity;
import call_academy.entities.MonitoriaEntity;
import call_academy.entities.TagEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Charry Gavilan
 */
public class TagDetailDTO extends TagDTO implements Serializable{
    

    private List<MonitoriaDTO> monitorias;
    
    private List<ArchivoDTO> archivos; 
    
    
    public TagDetailDTO() {
        super();
    }

    
    public TagDetailDTO(TagEntity tagEntity) {
        super(tagEntity);
        if (tagEntity.getMonitorias() != null) {
            monitorias = new ArrayList<>();
            for (MonitoriaEntity entityMonitoria : tagEntity.getMonitorias()) {
                monitorias.add(new MonitoriaDTO(entityMonitoria));
            }
        }
        if (tagEntity.getArchivos() != null) {
            archivos = new ArrayList<>();
            for (ArchivoEntity entityArchivo : tagEntity.getArchivos()) {
                archivos.add(new ArchivoDTO(entityArchivo));
            }
        }
    }

    @Override
    public TagEntity toEntity() {
        TagEntity tagEntity = super.toEntity();
        if (monitorias != null) {
            List<MonitoriaEntity> monitoriaEntity = new ArrayList<>();
            for (MonitoriaDTO dtoMonitoria : getMonitorias()) {
                monitoriaEntity.add(dtoMonitoria.toEntity());
            }
            tagEntity.setMonitorias(monitoriaEntity);
        }
        if (archivos != null) {
            List<ArchivoEntity> archivosEntity = new ArrayList<>();
            for (ArchivoDTO dtoArchivo : getArchivos()) {
                archivosEntity.add(dtoArchivo.toEntity());
            }
            tagEntity.setArchivos(archivosEntity);
        }
        return tagEntity;
    }

    public List<MonitoriaDTO> getMonitorias() {
        return monitorias;
    }

    public void setMonitorias(List<MonitoriaDTO> monitorias) {
        this.monitorias = monitorias;
    }

    public List<ArchivoDTO> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<ArchivoDTO> archivos) {
        this.archivos = archivos;
    }
    
    
}
