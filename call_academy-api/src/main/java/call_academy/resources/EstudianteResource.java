/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.resources;

import call_academy.dtos.EstudianteDTO;
import call_academy.ejb.EstudianteLogic;
import call_academy.entities.EstudianteEntity;
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
@Path("estudiantes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EstudianteResource {
    
    private static final Logger LOGGER = Logger.getLogger(EstudianteResource.class.getName());
    
    @Inject 
    private EstudianteLogic estudianteLogic;
     
    @POST
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "newEstudianteDTO createEstudiante: input: {0}", estudiante);
        EstudianteDTO newEstudianteDTO = new EstudianteDTO(estudianteLogic.createEstudiante(estudiante.toEntity()));
        LOGGER.log(Level.INFO, "newEstudianteDTO createEstudiante: output: {0}", newEstudianteDTO);
        return newEstudianteDTO;
    }
    
    @GET
    public List<EstudianteDTO> getEstudiantes() {
        LOGGER.log(Level.INFO,"PrizeResource getEstudiantes: input: void");
        List<EstudianteDTO> listaEstudiantes = listEntity2DTO(estudianteLogic.findAllEstudiante());
        LOGGER.log(Level.INFO, "PrizeResource getEstudiantes: output: {0}", listaEstudiantes);
        return listaEstudiantes;
    }
    
    @GET
    @Path("{estudianteId: \\d+}")
    public EstudianteDTO getEstudiante(@PathParam("estudianteId") Long estudianteId) {
        LOGGER.log(Level.INFO,"EstudianteResource getEstudiante: input: {0}", estudianteId);
        EstudianteEntity estudianteEntity = estudianteLogic.findEstudiante(estudianteId);
        if(estudianteEntity == null)
        {
            throw new WebApplicationException("El recurso /estudiantes/"+ estudianteId +" no existe",404);
        }
        EstudianteDTO estudianteDTO= new EstudianteDTO(estudianteEntity);
        LOGGER.log(Level.INFO,"EstudianteResource getEstudiante: output: {0}", estudianteDTO);
        return estudianteDTO;
    }
    
    @PUT
    @Path("{estudianteId: \\d+}")
    public EstudianteDTO updateEstudiante(@PathParam("estudianteId") Long estudianteId, EstudianteDTO estudiante) throws BusinessLogicException {
        LOGGER.log(Level.INFO,"EstudianteResource updateEstudiante: input: estudianteId{0}, estudiante{1}", new Object[]{estudianteId, estudiante});
        estudiante.setId(estudianteId);
        if(estudianteLogic.findEstudiante(estudianteId) == null)
        {
            throw new WebApplicationException("El recurso /estudiantes/"+ estudianteId +" no existe",404);
        }
        EstudianteDTO estudianteDTO = new EstudianteDTO(estudianteLogic.updateEstudiante(estudiante.toEntity()));
        LOGGER.log(Level.INFO,"EstudianteResource updateEstudiante: output: {0}", estudianteDTO);
        return estudianteDTO;
    }
    
    @DELETE
    @Path("{estudianteId: \\d+}")
    public void deleteEstudiante(@PathParam("estudianteId") Long estudianteId)
    {
        LOGGER.log(Level.INFO, "EstudianteResource deleteEstudiante: input: {0}", estudianteId);
        if (estudianteLogic.findEstudiante(estudianteId) == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + estudianteId + " no existe.", 404);
        }
        estudianteLogic.deleteEstudiante(estudianteId);
        LOGGER.info("EstudianteResource EstudiantePrize: output: void");  
    }
    
    private List<EstudianteDTO> listEntity2DTO(List<EstudianteEntity> entityList) {
        List<EstudianteDTO> list = new ArrayList<EstudianteDTO>();
        for (EstudianteEntity entity : entityList) {
            list.add(new EstudianteDTO(entity));
        }
        return list;
    }
}
