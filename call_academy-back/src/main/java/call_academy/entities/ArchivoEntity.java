/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Generic entity with ID and name fields to inherit from.
 *
 * This entity sets a standar of fields and functions all entities in a project
 * should have. For example, all entities should be compared by ID when not
 * null, otherwise use the object equals method.
 *
 * @author ISIS26036
 */
public class ArchivoEntity extends BaseEntity implements Serializable{
    
    private String archivo;

//    @ManyToMany
//    (
//            mappedBy = "archivo",
//            fetch = FetchType.LAZY
//    )
//    private List<TagEntity> tags;
//    @ManyToone
//    (
//            mappedBy = "archivo",
//            fetch = FetchType.LAZY
//    )
//    private List<EstudianteEntity> creador;
//    @ManyToone
//    (
//            mappedBy = "archivo",
//            fetch = FetchType.LAZY
//    )      
//    private List<MateriaEntity> materia;
    
    /**
     * 
     * @return archivo 
     */
    public String getArchivo() {
        return archivo;
    }

    /**
     * 
     * @param archivo Archivo nuevo
     */
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
       
//    public List<MateriaEntity> getMaterias() {
//        return materias;
//    }
//
//    public void setMaterias(List<MateriaEntity> materias) {
//        this.materias = materias;
//    }

//    public List<MonitoriaEntity> getMonitorias() {
//        return monitorias;
//    }

//    public void setMonitorias(List<MonitoriaEntity> monitorias) {
//        this.monitorias = monitorias;
//    }

//        public void setMateria(List<MateriaEntity> materia) {
//        this.materia = materia;
//    }
//    
//        public List<MateriaEntity> getMateria() {
//        return materia;
//    }
        
}
