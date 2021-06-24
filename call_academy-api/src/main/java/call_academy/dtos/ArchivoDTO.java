/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;

import call_academy.entities.ArchivoEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Juan Charry Gavilan
 */
public class ArchivoDTO implements Serializable{
    
    private Long id;
    
    private String archivo;
    
    private EstudianteDTO creador;
    
    private MateriaDTO materia;
    
    public ArchivoDTO(ArchivoEntity archivoEntity) {
        if (archivoEntity != null) {
            this.id = archivoEntity.getId();
            this.archivo = archivoEntity.getArchivo();
            
            if (archivoEntity.getCreador() != null) {
                this.creador = new EstudianteDTO(archivoEntity.getCreador());
            } else {
                this.creador = null;
            }
            if (archivoEntity.getMateria()!= null) {
                this.materia = new MateriaDTO(archivoEntity.getMateria());
            } else {
                this.materia = null;
            }
        }
    }

    public ArchivoDTO() {
    }

    public ArchivoEntity toEntity() {
        ArchivoEntity archivoEntity = new ArchivoEntity();
        archivoEntity.setId(this.id);
        archivoEntity.setArchivo(this.archivo);
        
        if (this.materia != null) {
            archivoEntity.setMateria(this.materia.toEntity());
        }
        if (this.creador != null) {
            archivoEntity.setCreador(this.creador.toEntity());
        }
        return archivoEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public EstudianteDTO getCreador() {
        return creador;
    }

    public void setCreador(EstudianteDTO creador) {
        this.creador = creador;
    }

    public MateriaDTO getMateria() {
        return materia;
    }

    public void setMateria(MateriaDTO materia) {
        this.materia = materia;
    }
    
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
