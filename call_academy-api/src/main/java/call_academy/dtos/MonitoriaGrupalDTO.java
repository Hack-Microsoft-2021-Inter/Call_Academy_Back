/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.dtos;
import call_academy.entities.MonitoriaGrupalEntity;
import java.io.Serializable;
/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaGrupalDTO extends MonitoriaDTO implements Serializable {
    
    private String descripcion;
    
    public MonitoriaGrupalDTO(){
    }
    
    public MonitoriaGrupalDTO(MonitoriaGrupalEntity entity) {
        super(entity);
        this.descripcion = entity.getDescripcion();
    }

    public MonitoriaGrupalEntity toEntity() {
        
        MonitoriaGrupalEntity entity = (MonitoriaGrupalEntity) super.toEntity();
        entity.setDescripcion(this.descripcion);
        return entity;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
