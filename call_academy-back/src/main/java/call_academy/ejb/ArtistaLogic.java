/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cassettes.ejb;

import co.edu.uniandes.csw.cassettes.entities.ArtistaEntity;
import co.edu.uniandes.csw.cassettes.entities.UsuarioEntity;
import co.edu.uniandes.csw.cassettes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.cassettes.persistence.ArtistaPersistence;
import co.edu.uniandes.csw.cassettes.persistence.UsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author David Santiago Suarez
 */
@Stateless
public class ArtistaLogic 
{
    
    @Inject
    private ArtistaPersistence persistence;
    
    @Inject
    private UsuarioPersistence usuarioPersistence;
    
    /**
     * 
     * @param usuarioId Id del usuario 
     * @param artistaId Id del artista 
     * @return El artista creado
     */
    public ArtistaEntity addUsuario(Long usuarioId, Long artistaId)
    {
        ArtistaEntity artista = persistence.find(artistaId);
        UsuarioEntity usuario = usuarioPersistence.find(usuarioId);
        artista.setUsuario(usuario);
        return artista;
    }
    
    /**
     * Crean un artista dentro de la base de datos
     * 
     * @param artista Objeto de ArtistaEntity con los datos nuevos
     * @return objeto de ArtistaEntity con los datos nuevos y su ID
     * @throws BusinessLogicException 
     */
    public ArtistaEntity createArtista( ArtistaEntity artista ) throws BusinessLogicException
    {
        if(artista.getNombre() == null)
        {
            throw new BusinessLogicException("El nombre del artista está vacío");
        }
        
        artista = persistence.create(artista);
        return artista;
    }
    
    /**
     * Obtiene una lista de los registros de Artista
     * 
     * @return Coleccion de objetos de tipo ArtistaEntity
     */
    public List<ArtistaEntity> getArtistas()
    {
        List<ArtistaEntity> lista = persistence.findAll();
        return lista;
    }
    
    /**
     * Obtiene los datos de una instancia de Artista a partir de su ID
     * 
     * @param artistaId Identificador de la instancia a consultar
     * @return Instancia de ArtistaEntity con los datos del artista consultado
     */
    public ArtistaEntity getArtista(Long artistaId)
    {
        ArtistaEntity artistaEntity = persistence.find(artistaId);
        return artistaEntity;
    }
    
    /**
     * Actualiza la informacion de una instancia de Artista
     * 
     * @param artistaEntity Instancia de ArtistaEntity con los nuevos datos
     * @return Instancia de ArtistaEntity con los datos actualizados
     */
    public ArtistaEntity updateArtista(ArtistaEntity artistaEntity)
    {
        ArtistaEntity newArtistaEntity = persistence.update(artistaEntity);
        return newArtistaEntity;
    }
    
    /**
     * Elimina una instancia de Artista en la base de datos
     * 
     * @param artistaId Identificador de la instancia a eliminar
     */
    public void deleteArtista(Long artistaId)
    {
        persistence.delete(artistaId);
    }
}
