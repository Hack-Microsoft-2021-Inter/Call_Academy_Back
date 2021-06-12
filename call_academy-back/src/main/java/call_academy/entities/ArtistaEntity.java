/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cassettes.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author David Santiago Suarez
 */
@Entity
public class ArtistaEntity extends BaseEntity implements Serializable
{
    private String nombre;
    
    @PodamExclude
    @ManyToMany()
    private Collection<CassetteEntity> cassettes;
    
    @PodamExclude
    @ManyToOne()
    private UsuarioEntity usuario;
    
    @PodamExclude
    @ManyToMany ( mappedBy = "artistas" ) 
    private Collection<GeneroEntity> generos;
    
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

    /**
     * @return the cassettes
     */
    public Collection<CassetteEntity> getCassettes() {
        return cassettes;
    }

    /**
     * @param cassettes the cassettes to set
     */
    public void setCassettes(Collection<CassetteEntity> cassettes) {
        this.cassettes = cassettes;
    }

    /**
     * @return the usuario
     */
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the generos
     */
    public Collection<GeneroEntity> getGeneros() {
        return generos;
    }

    /**
     * @param generos the generos to set
     */
    public void setGeneros(Collection<GeneroEntity> generos) {
        this.generos = generos;
    }
    
    
}
