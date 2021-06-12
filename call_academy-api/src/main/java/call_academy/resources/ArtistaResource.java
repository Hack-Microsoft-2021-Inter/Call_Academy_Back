/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.cassettes.resources;

import co.edu.uniandes.csw.cassettes.dtos.ArtistaDTO;
import co.edu.uniandes.csw.cassettes.dtos.ArtistaDetailDTO;
import co.edu.uniandes.csw.cassettes.ejb.ArtistaLogic;
import co.edu.uniandes.csw.cassettes.entities.ArtistaEntity;
import co.edu.uniandes.csw.cassettes.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author David Santiago Suarez
 */
@Path("artistas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ArtistaResource 
{
    @Inject
    private ArtistaLogic artistaLogic;
    
    @POST
    public ArtistaDTO createArtista(ArtistaDTO artista) throws BusinessLogicException 
    {
        ArtistaDTO nuevoDTO = new ArtistaDTO(artistaLogic.createArtista(artista.toEntity()));
        return nuevoDTO;
    }
    
    @GET
    public List<ArtistaDetailDTO> getArtistas() 
    {
        List<ArtistaDetailDTO> lista = listEntity2DetailDTO(artistaLogic.getArtistas());
        return lista;
    }
    
    @GET
    @Path("{artistasId: \\d+}")
    public ArtistaDetailDTO getArtista(@PathParam("artistasId") Long artistasId) throws WebApplicationException 
    {
        ArtistaEntity entity = artistaLogic.getArtista(artistasId);
        if (entity == null)
        {
            throw new WebApplicationException("El recurso /artistas/" + artistasId + " no existe.", 404);
        }
        ArtistaDetailDTO detailDTO = new ArtistaDetailDTO(entity);
        return detailDTO;
    }
    
    @PUT
    @Path("{artistasId: \\d+}")
    public ArtistaDetailDTO updateArtista(@PathParam("artistasId") Long artistasId, ArtistaDetailDTO artista) throws WebApplicationException, BusinessLogicException 
    {
        artista.setId(artistasId);
        if (artistaLogic.getArtista(artistasId) == null)
        {
            throw new WebApplicationException("El recurso /artistas/" + artistasId + " no existe.", 404);
        }
        ArtistaDetailDTO detailDTO = new ArtistaDetailDTO(artistaLogic.updateArtista(artista.toEntity()));
        return detailDTO;
    }
    
    @DELETE
    @Path("{artistasId: \\d+}")
    public void deleteArtista(@PathParam("artistasId") Long artistasId) throws BusinessLogicException 
    {
        ArtistaEntity entity = artistaLogic.getArtista(artistasId);
        if (entity == null)
        {
            throw new WebApplicationException("El recurso /artistas/" + artistasId + " no existe.", 404);
        }
        artistaLogic.deleteArtista(artistasId);
    }
    
    private List<ArtistaDetailDTO> listEntity2DetailDTO(List<ArtistaEntity> entityList)
    {
        List<ArtistaDetailDTO> list = new ArrayList<>();
        for (ArtistaEntity entity : entityList)
        {
            list.add(new ArtistaDetailDTO(entity));
        }
        return list;
    }
}
