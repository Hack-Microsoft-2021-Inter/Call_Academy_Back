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
import javax.persistence.OneToMany;

/**
 * @author Julián Andrés 
 */
@Entity
public class MonitorEntity extends EstudianteEntity implements Serializable{
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    private int calificacion;
    
    /////////////////////////// RELACIONES ///////////////////////////

    @ManyToMany
    private List<MateriaEntity> materias;
    
    @OneToMany
    private List<MonitoriaEntity> monitorias;

    //////////////////////////// MÈTODOS ////////////////////////////
    
    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public List<MateriaEntity> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaEntity> materias) {
        this.materias = materias;
    }

    public List<MonitoriaEntity> getMonitorias() {
        return monitorias;
    }

    public void setMonitorias(List<MonitoriaEntity> monitorias) {
        this.monitorias = monitorias;
    }

}
