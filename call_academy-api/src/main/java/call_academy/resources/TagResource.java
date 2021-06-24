/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.resources;

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
import javax.ws.rs.core.MediaType;

import call_academy.dtos.TagDTO;
import call_academy.dtos.TagDetailDTO;
import call_academy.ejb.TagLogic;
import call_academy.entities.TagEntity;
import call_academy.exceptions.BusinessLogicException;

/**
 *
 * @author Juan Charry Gavilan
 */
@Path("tags")
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
@RequestScoped
public class TagResource {
    
    @Inject
    private TagLogic logic;
    
    @POST
    public TagDTO createTag( TagDTO tag ) throws BusinessLogicException {
       TagDTO tagDTO = new TagDTO( logic.createTag( tag.toEntity() ) );
       return tagDTO;
    }
    
    @GET
    @Path( "{tagId: \\d+}" )
    public TagDetailDTO getTag( @PathParam( "tagId" ) Long tagId ) {
        TagEntity tag = logic.finTag( tagId );
        if ( tag == null ) {
            throw new WebApplicationException( "El recurso /tags/" + tagId + " no existe.", 404 );
        }
        TagDetailDTO detailDTO = new TagDetailDTO( tag );
        return detailDTO;
    }
    
    @GET
    public List<TagDetailDTO> getTags() {
        List<TagDetailDTO> list = listEntity2DTO( logic.finAllTags() );
        return list;
    }
    
    @PUT
    @Path( "{tagId: \\d+}" )
    public TagDetailDTO updateTag( @PathParam( "tagId" ) Long tagId, TagDetailDTO tag ) throws BusinessLogicException {
        tag.setId( tagId );
        if ( logic.finTag( tagId ) == null) {
            throw new WebApplicationException( "El recurso /tags/" + tagId + " no existe.", 404 );
        }
        TagDetailDTO tagDTO = new TagDetailDTO( logic.updateTag( tag.toEntity() ) );
        return tagDTO;
    }
    
    @DELETE
    @Path( "{tagId: \\d+}" )
    public void deleteTag( @PathParam("tagId") Long tagId ) throws BusinessLogicException {
        if ( logic.finTag( tagId ) == null) {
            throw new WebApplicationException( "El recurso /tags/" + tagId + " no existe.", 404 );
        }
        logic.deleteTag( tagId );
    }
   
    
    private List<TagDetailDTO> listEntity2DTO( List<TagEntity> entityList ) {
        List<TagDetailDTO> list = new ArrayList<>();
        for ( TagEntity entity : entityList ) {
            list.add(new TagDetailDTO(entity) );
        }
        return list;
    }
}
