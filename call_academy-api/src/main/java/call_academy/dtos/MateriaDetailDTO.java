/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.ArchivoEntity;
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
public class MateriaDetailDTO extends MateriaDTO implements Serializable{

    private List<MonitorDTO> monitores;

    private List<ArchivoDTO> archivos;

    private List<MonitoriaDTO> monitorias;
    
     public MateriaDetailDTO() {
        super();
    }
    
    public MateriaDetailDTO(MateriaEntity materiaEntity) {
        super(materiaEntity);
        if (materiaEntity.getMonitores()!= null) {
            monitores = new ArrayList<>();
            for (MonitorEntity entityMonitor : materiaEntity.getMonitores()) {
                monitores.add(new MonitorDTO(entityMonitor));
            }
        }
        if (materiaEntity.getArchivos()!= null) {
            archivos = new ArrayList<>();
            for (ArchivoEntity entityArchivo : materiaEntity.getArchivos()) {
                archivos.add(new ArchivoDTO(entityArchivo));
            }
        }
        if (materiaEntity.getMonitorias()!= null) {
            monitorias = new ArrayList<>();
            for (MonitoriaEntity entityMonitoria : materiaEntity.getMonitorias()) {
                monitorias.add(new MonitoriaDTO(entityMonitoria));
            }
        }
    }
    
    @Override
    public MateriaEntity toEntity() {
        MateriaEntity materiaEntity = super.toEntity();
        if (monitores != null) {
            List<MonitorEntity> monitorEntity = new ArrayList<>();
            for (MonitorDTO dtoMonitor : getMonitores()) {
                monitorEntity.add(dtoMonitor.toEntity());
            }
            materiaEntity.setMonitores(monitorEntity);
        }
        if (archivos != null) {
            List<ArchivoEntity> archivoEntity = new ArrayList<>();
            for (ArchivoDTO dtoArchivo : getArchivos()) {
                archivoEntity.add(dtoArchivo.toEntity());
            }
            materiaEntity.setArchivos(archivoEntity);
        }
        if (monitorias != null) {
            List<MonitoriaEntity> monitorEntity = new ArrayList<>();
            for (MonitoriaDTO dtoMonitoria : getMonitorias()) {
                monitorEntity.add(dtoMonitoria.toEntity());
            }
            materiaEntity.setMonitorias(monitorEntity);
        }
        return materiaEntity;
    }

    public List<MonitorDTO> getMonitores() {
        return monitores;
    }

    public void setMonitores(List<MonitorDTO> monitores) {
        this.monitores = monitores;
    }

    public List<ArchivoDTO> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<ArchivoDTO> archivos) {
        this.archivos = archivos;
    }

    public List<MonitoriaDTO> getMonitorias() {
        return monitorias;
    }

    public void setMonitorias(List<MonitoriaDTO> monitorias) {
        this.monitorias = monitorias;
    }
    
    
    
}
