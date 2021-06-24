/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.resources;

import call_academy.dtos.UniversidadDTO;
import call_academy.ejb.UniversidadLogic;
import call_academy.entities.UniversidadEntity;
import call_academy.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Juan Charry Gavilan
 */

@Path("universidades")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class UniversidadResource {
    
    private static final Logger LOGGER = Logger.getLogger(UniversidadResource.class.getName());
    
    @Inject 
    private UniversidadLogic universidadLogic;
     
    @POST
    public UniversidadDTO createUniversidad(UniversidadDTO universidad) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "newUniversidadDTO createUniversidad: input: {0}", universidad);
        UniversidadDTO newUniversidadDTO = new UniversidadDTO(universidadLogic.createUniversidad(universidad.toEntity()));
        LOGGER.log(Level.INFO, "newUniversidadDTO createUniversidad: output: {0}", newUniversidadDTO);
        return newUniversidadDTO;
    }
    
    @GET
    public List<UniversidadDTO> getUniversidads() {
        LOGGER.log(Level.INFO,"PrizeResource getUniversidads: input: void");
        List<UniversidadDTO> listaUniversidads = listEntity2DTO(universidadLogic.findAllUniversidad());
        LOGGER.log(Level.INFO, "PrizeResource getUniversidads: output: {0}", listaUniversidads);
        return listaUniversidads;
    }
    
    @GET
    @Path("{universidadId: \\d+}")
    public UniversidadDTO getUniversidad(@PathParam("universidadId") Long universidadId) {
        LOGGER.log(Level.INFO,"UniversidadResource getUniversidad: input: {0}", universidadId);
        UniversidadEntity universidadEntity = universidadLogic.findUniversidad(universidadId);
        if(universidadEntity == null)
        {
            throw new WebApplicationException("El recurso /universidads/"+ universidadId +" no existe",404);
        }
        UniversidadDTO universidadDTO= new UniversidadDTO(universidadEntity);
        LOGGER.log(Level.INFO,"UniversidadResource getUniversidad: output: {0}", universidadDTO);
        return universidadDTO;
    }
    
    @PUT
    @Path("{universidadId: \\d+}")
    public UniversidadDTO updateUniversidad(@PathParam("universidadId") Long universidadId, UniversidadDTO universidad) throws BusinessLogicException {
        LOGGER.log(Level.INFO,"UniversidadResource updateUniversidad: input: universidadId{0}, universidad{1}", new Object[]{universidadId, universidad});
        universidad.setId(universidadId);
        if(universidadLogic.findUniversidad(universidadId) == null)
        {
            throw new WebApplicationException("El recurso /universidads/"+ universidadId +" no existe",404);
        }
        UniversidadDTO universidadDTO = new UniversidadDTO(universidadLogic.updateUniversidad(universidad.toEntity()));
        LOGGER.log(Level.INFO,"UniversidadResource updateUniversidad: output: {0}", universidadDTO);
        return universidadDTO;
    }
    
    @DELETE
    @Path("{universidadId: \\d+}")
    public void deleteUniversidad(@PathParam("universidadId") Long universidadId)
    {
        LOGGER.log(Level.INFO, "UniversidadResource deleteUniversidad: input: {0}", universidadId);
        if (universidadLogic.findUniversidad(universidadId) == null) {
            throw new WebApplicationException("El recurso /universidads/" + universidadId + " no existe.", 404);
        }
        universidadLogic.deleteUniversidad(universidadId);
        LOGGER.info("UniversidadResource UniversidadPrize: output: void");  
    }
    
    private List<UniversidadDTO> listEntity2DTO(List<UniversidadEntity> entityList) {
        List<UniversidadDTO> list = new ArrayList<UniversidadDTO>();
        for (UniversidadEntity entity : entityList) {
            list.add(new UniversidadDTO(entity));
        }
        return list;
    }
}
