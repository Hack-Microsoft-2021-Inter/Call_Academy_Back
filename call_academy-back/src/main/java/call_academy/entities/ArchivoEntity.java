/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Julián Méndez 
 */
@Entity
public class ArchivoEntity extends BaseEntity implements Serializable{
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    private String archivo;
    
    /////////////////////////// RELACIONES ///////////////////////////
    
    @ManyToMany
    private List<TagEntity> tags;
    
    @ManyToOne
    private EstudianteEntity creador;
    
    @ManyToOne
    private MateriaEntity materia;

    //////////////////////////// METODOS ////////////////////////////
    
    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    public EstudianteEntity getCreador() {
        return creador;
    }

    public void setCreador(EstudianteEntity creador) {
        this.creador = creador;
    }

    public MateriaEntity getMateria() {
        return materia;
    }

    public void setMateria(MateriaEntity materia) {
        this.materia = materia;
    }

       
}
