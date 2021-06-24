/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.resources;

import call_academy.dtos.ArchivoDTO;
import call_academy.ejb.ArchivoLogic;
import call_academy.entities.ArchivoEntity;
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
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
/**
 *
 * @author Juan Charry Gavilan
 */
@Path("archivos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ArchivoResource {
    
    private static final Logger LOGGER = Logger.getLogger(ArchivoResource.class.getName());
    
    @Inject 
    private ArchivoLogic archivoLogic;
     
    @POST
    public ArchivoDTO createArchivo(ArchivoDTO archivo) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "newArchivoDTO createArchivo: input: {0}", archivo);
        ArchivoDTO newArchivoDTO = new ArchivoDTO(archivoLogic.createArchivo(archivo.toEntity()));
        LOGGER.log(Level.INFO, "newArchivoDTO createArchivo: output: {0}", newArchivoDTO);
        return newArchivoDTO;
    }
    
    @GET
    public List<ArchivoDTO> getArchivos() {
        LOGGER.log(Level.INFO,"PrizeResource getArchivos: input: void");
        List<ArchivoDTO> listaArchivos = listEntity2DTO(archivoLogic.findAllArchivos());
        LOGGER.log(Level.INFO, "PrizeResource getArchivos: output: {0}", listaArchivos);
        return listaArchivos;
    }
    
    @GET
    @Path("{archivoId: \\d+}")
    public ArchivoDTO getArchivo(@PathParam("archivoId") Long archivoId) {
        LOGGER.log(Level.INFO,"ArchivoResource getArchivo: input: {0}", archivoId);
        ArchivoEntity archivoEntity = archivoLogic.findArchivo(archivoId);
        if(archivoEntity == null)
        {
            throw new WebApplicationException("El recurso /archivos/"+ archivoId +" no existe",404);
        }
        ArchivoDTO archivoDTO= new ArchivoDTO(archivoEntity);
        LOGGER.log(Level.INFO,"ArchivoResource getArchivo: output: {0}", archivoDTO);
        return archivoDTO;
    }
    
    @PUT
    @Path("{archivoId: \\d+}")
    public ArchivoDTO updateArchivo(@PathParam("archivoId") Long archivoId, ArchivoDTO archivo) throws BusinessLogicException {
        LOGGER.log(Level.INFO,"ArchivoResource updateArchivo: input: archivoId{0}, archivo{1}", new Object[]{archivoId, archivo});
        archivo.setId(archivoId);
        if(archivoLogic.findArchivo(archivoId) == null)
        {
            throw new WebApplicationException("El recurso /archivos/"+ archivoId +" no existe",404);
        }
        ArchivoDTO archivoDTO = new ArchivoDTO(archivoLogic.updateArchivo(archivo.toEntity()));
        LOGGER.log(Level.INFO,"ArchivoResource updateArchivo: output: {0}", archivoDTO);
        return archivoDTO;
    }
    
    @DELETE
    @Path("{archivoId: \\d+}")
    public void deleteArchivo(@PathParam("archivoId") Long archivoId)
    {
        LOGGER.log(Level.INFO, "ArchivoResource deleteArchivo: input: {0}", archivoId);
        if (archivoLogic.findArchivo(archivoId) == null) {
            throw new WebApplicationException("El recurso /archivos/" + archivoId + " no existe.", 404);
        }
        archivoLogic.deleteArchivo(archivoId);
        LOGGER.info("ArchivoResource ArchivoPrize: output: void");  
    }
    
    private List<ArchivoDTO> listEntity2DTO(List<ArchivoEntity> entityList) {
        List<ArchivoDTO> list = new ArrayList<ArchivoDTO>();
        for (ArchivoEntity entity : entityList) {
            list.add(new ArchivoDTO(entity));
        }
        return list;
    }
}
