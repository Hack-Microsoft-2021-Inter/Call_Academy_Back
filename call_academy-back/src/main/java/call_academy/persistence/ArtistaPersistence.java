/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cassettes.persistence;

import co.edu.uniandes.csw.cassettes.entities.ArtistaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author David Santiago Suarez
 */
@Stateless
public class ArtistaPersistence 
{
    @PersistenceContext(unitName = "cassettesPU")
    protected EntityManager em;
    
    
    /**
     * Crea un artista en la base de datos
     * @param artistaEntity objeto artista que se creara en la base de datos
     * @return devuelve la entidad creada con un id dada por la base de datos
     */
    public ArtistaEntity create (ArtistaEntity artistaEntity)
    {
        em.persist(artistaEntity);
        return artistaEntity;
    }
    
    /**
     * Devuelve todos los artistas de la base de datos
     * @return una lista con todos los artistas que encuentre en la base de datos
     */
    public List<ArtistaEntity> findAll()
    {
        TypedQuery query = em.createQuery("Select u from ArtistaEntity u", ArtistaEntity.class);
        return query.getResultList();
    }
    
    /**
     * Busca si hay algun artista con el id dado
     * @param artistaId id correspondiente al artista buscado
     * @return un artista
     */
    public ArtistaEntity find (long artistaId)
    {
        return em.find(ArtistaEntity.class, artistaId);
    }
    
    /**
     * Actualiza un artista
     * @param artistaEntity El artista que viene con los nuevos cambios 
     * @return un artista con los cambios aplicados
     */
    public ArtistaEntity update (ArtistaEntity artistaEntity)
    {
        return em.merge(artistaEntity);
    }
    
    /**
     * Borra un artista de la base de datos
     * @param artistaId Id del artista que se desea borrar
     */
    public void delete (long artistaId)
    {
        ArtistaEntity artista = em.find(ArtistaEntity.class, artistaId);
        em.remove(artista);
    }
}
