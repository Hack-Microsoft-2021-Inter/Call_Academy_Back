/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.ArchivoEntity;
import call_academy.entities.EstudianteEntity;
import call_academy.entities.MonitoriaGrupalEntity;
import call_academy.entities.MonitoriaIndividualEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Charry Gavilan
 */
public class EstudianteDetailDTO extends EstudianteDTO implements Serializable{
    
    private List<ArchivoDTO> archivos;

    private List<MonitoriaIndividualDTO> monitoriasIndividuales;

    private List<MonitoriaGrupalDTO> monitoriasGrupales;

    public EstudianteDetailDTO() {
        super();
    }
    
    public EstudianteDetailDTO(EstudianteEntity estudianteEntity) {
        super(estudianteEntity);
        if (estudianteEntity.getArchivos() != null) {
            archivos = new ArrayList<>();
            for (ArchivoEntity entityArchivo : estudianteEntity.getArchivos()) {
                archivos.add(new ArchivoDTO(entityArchivo));
            }
        }
        if (estudianteEntity.getMonitoriasIndividuales() != null) {
            monitoriasIndividuales = new ArrayList<>();
            for (MonitoriaIndividualEntity entityMonitoriasIndividuales : estudianteEntity.getMonitoriasIndividuales()) {
                monitoriasIndividuales.add(new MonitoriaIndividualDTO(entityMonitoriasIndividuales));
            }
        }
        if (estudianteEntity.getMonitoriasGrupales() != null) {
            monitoriasGrupales = new ArrayList<>();
            for (MonitoriaGrupalEntity entityMonitroiasGrupales : estudianteEntity.getMonitoriasGrupales()) {
                monitoriasGrupales.add(new MonitoriaGrupalDTO(entityMonitroiasGrupales));
            }
        }
    }

    @Override
    public EstudianteEntity toEntity() {
        EstudianteEntity estudianteEntity = super.toEntity();
        if (archivos != null) {
            List<ArchivoEntity> archivoEntity = new ArrayList<>();
            for (ArchivoDTO dtoArchivo : getArchivos()) {
                archivoEntity.add(dtoArchivo.toEntity());
            }
            estudianteEntity.setArchivos(archivoEntity);
        }
        if (monitoriasIndividuales != null) {
            List<MonitoriaIndividualEntity> monitoriasIndividualesEntity = new ArrayList<>();
            for (MonitoriaIndividualDTO dtoMonitoriasIndividuales : getMonitoriasIndividuales()){
                monitoriasIndividualesEntity.add(dtoMonitoriasIndividuales.toEntity());
            }
            estudianteEntity.setMonitoriasIndividuales(monitoriasIndividualesEntity);
        }
        if (monitoriasGrupales != null) {
            List<MonitoriaGrupalEntity> monitoriasGrupalesEntity = new ArrayList<>();
            for (MonitoriaGrupalDTO dtoMonitroiasGrupales : getMonitoriasGrupales()) {
                monitoriasGrupalesEntity.add(dtoMonitroiasGrupales.toEntity());
            }
            estudianteEntity.setMonitoriasGrupales(monitoriasGrupalesEntity);
        }
        return estudianteEntity;
    }

    public List<ArchivoDTO> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<ArchivoDTO> archivos) {
        this.archivos = archivos;
    }

    public List<MonitoriaIndividualDTO> getMonitoriasIndividuales() {
        return monitoriasIndividuales;
    }

    public void setMonitoriasIndividuales(List<MonitoriaIndividualDTO> monitoriasIndividuales) {
        this.monitoriasIndividuales = monitoriasIndividuales;
    }

    public List<MonitoriaGrupalDTO> getMonitoriasGrupales() {
        return monitoriasGrupales;
    }

    public void setMonitoriasGrupales(List<MonitoriaGrupalDTO> monitoriasGrupales) {
        this.monitoriasGrupales = monitoriasGrupales;
    }
    
    
    
    
}
