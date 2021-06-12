/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cassettes.dtos;

import co.edu.uniandes.csw.cassettes.entities.ArtistaEntity;
import co.edu.uniandes.csw.cassettes.entities.GeneroEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Santiago Suarez
 */
public class ArtistaDetailDTO extends ArtistaDTO implements Serializable
{
    private List<GeneroDTO> generos;
    
    public ArtistaDetailDTO ()
    {
        super();
    }
    
    /**
     * Constructor para transformar un Entity en un DTO
     * @param artistaEntity La entidad de la cual se construye el DTO
     */
    public ArtistaDetailDTO(ArtistaEntity artistaEntity)
    {
        super(artistaEntity);
        if (artistaEntity != null)
        {
            generos = new ArrayList<>();
            for (GeneroEntity entityGenero : artistaEntity.getGeneros())
            {
                generos.add(new GeneroDTO());
            }
        }
    }
    
    /**
     * Transforma el DTO en una entidad 
     * @return La entidad que representa el Artista
     */
     public ArtistaEntity toEntity()
    {
        ArtistaEntity artistaEntity = super.toEntity();
        
        if (getGeneros() != null)
        {
            List<GeneroEntity> generoEntity = new ArrayList<>();
            for (GeneroDTO dtoGenero : getGeneros())
            {
                generoEntity.add(dtoGenero.toEntity());
            }
            artistaEntity.setGeneros(generoEntity);
        }
        
        return artistaEntity;
    }

    /**
     * @return the generos
     */
    public List<GeneroDTO> getGeneros() {
        return generos;
    }

    /**
     * @param generos the generos to set
     */
    public void setGeneros(List<GeneroDTO> generos) {
        this.generos = generos;
    }
}
