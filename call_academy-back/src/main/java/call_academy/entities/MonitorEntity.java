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
public class MonitorEntity extends BaseEntity implements Serializable{
    
    private int calificacion;

//    @ManyToMany
//    (
//            mappedBy = "monitor",
//            fetch = FetchType.LAZY
//    )
//    private List<MateriaEntity> materias;
    
//    @OneToMany
//    (
//            mappedBy = "monitor",
//            fetch = FetchType.LAZY
//    )
//    private List<MonitoriaEntity> monitorias;

    
    /**
     * 
     * @return Calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * 
     * @param calificacion Calificación nueva
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
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
    
}
