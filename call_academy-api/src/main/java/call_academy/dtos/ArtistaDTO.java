/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cassettes.dtos;

import co.edu.uniandes.csw.cassettes.entities.ArtistaEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author David Santiago Suarez
 */
public class ArtistaDTO implements Serializable
{
    private Long id;
    private String nombre;
    
    /**
     * Constructor por defecto
     */
    public ArtistaDTO ()
    {
        
    }
    
    /**
     * Constructor a partir de la entidad 
     * @param artistaEntity la entidad del artista
     */
    public ArtistaDTO(ArtistaEntity artistaEntity)
    {
        if (artistaEntity != null)
        {
            this.id = artistaEntity.getId();
            this.nombre = artistaEntity.getNombre();
        }
    }
    
    /**
     * Metodo para transformar el DTO en una entidad 
     * @return La entidad del artista asocidado
     */
    public ArtistaEntity toEntity()
    {
        ArtistaEntity artistaEntity = new ArtistaEntity();
        artistaEntity.setId(this.getId());
        artistaEntity.setNombre(this.getNombre());
        return artistaEntity;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
