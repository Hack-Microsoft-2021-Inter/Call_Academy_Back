/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.resources;

import call_academy.dtos.MonitoriaIndividualDTO;
import call_academy.ejb.MonitoriaIndividualLogic;
import call_academy.entities.MonitoriaIndividualEntity;
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
@Path("monitoriaIndividuals")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MonitoriaIndividualResource{
    
    private static final Logger LOGGER = Logger.getLogger(MonitoriaIndividualResource.class.getName());
    
    @Inject 
    private MonitoriaIndividualLogic monitoriaIndividualLogic;
     
    @POST
    public MonitoriaIndividualDTO createMonitoriaIndividual(MonitoriaIndividualDTO monitoriaIndividual) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "newMonitoriaIndividualDTO createMonitoriaIndividual: input: {0}", monitoriaIndividual);
        MonitoriaIndividualDTO newMonitoriaIndividualDTO = new MonitoriaIndividualDTO(monitoriaIndividualLogic.createmonitoriaIndividual(monitoriaIndividual.toEntity()));
        LOGGER.log(Level.INFO, "newMonitoriaIndividualDTO createMonitoriaIndividual: output: {0}", newMonitoriaIndividualDTO);
        return newMonitoriaIndividualDTO;
    }
    
    @GET
    public List<MonitoriaIndividualDTO> getMonitoriaIndividuals() {
        LOGGER.log(Level.INFO,"PrizeResource getMonitoriaIndividuals: input: void");
        List<MonitoriaIndividualDTO> listaMonitoriaIndividuals = listEntity2DTO(monitoriaIndividualLogic.findAllMonitoriaIndividual());
        LOGGER.log(Level.INFO, "PrizeResource getMonitoriaIndividuals: output: {0}", listaMonitoriaIndividuals);
        return listaMonitoriaIndividuals;
    }
    
    @GET
    @Path("{monitoriaIndividualId: \\d+}")
    public MonitoriaIndividualDTO getMonitoriaIndividual(@PathParam("monitoriaIndividualId") Long monitoriaIndividualId) {
        LOGGER.log(Level.INFO,"MonitoriaIndividualResource getMonitoriaIndividual: input: {0}", monitoriaIndividualId);
        MonitoriaIndividualEntity monitoriaIndividualEntity = monitoriaIndividualLogic.findMonitoriaIndividual(monitoriaIndividualId);
        if(monitoriaIndividualEntity == null)
        {
            throw new WebApplicationException("El recurso /monitoriaIndividuals/"+ monitoriaIndividualId +" no existe",404);
        }
        MonitoriaIndividualDTO monitoriaIndividualDTO= new MonitoriaIndividualDTO(monitoriaIndividualEntity);
        LOGGER.log(Level.INFO,"MonitoriaIndividualResource getMonitoriaIndividual: output: {0}", monitoriaIndividualDTO);
        return monitoriaIndividualDTO;
    }
    
    @PUT
    @Path("{monitoriaIndividualId: \\d+}")
    public MonitoriaIndividualDTO updateMonitoriaIndividual(@PathParam("monitoriaIndividualId") Long monitoriaIndividualId, MonitoriaIndividualDTO monitoriaIndividual) throws BusinessLogicException {
        LOGGER.log(Level.INFO,"MonitoriaIndividualResource updateMonitoriaIndividual: input: monitoriaIndividualId{0}, monitoriaIndividual{1}", new Object[]{monitoriaIndividualId, monitoriaIndividual});
        monitoriaIndividual.setId(monitoriaIndividualId);
        if(monitoriaIndividualLogic.findMonitoriaIndividual(monitoriaIndividualId) == null)
        {
            throw new WebApplicationException("El recurso /monitoriaIndividuals/"+ monitoriaIndividualId +" no existe",404);
        }
        MonitoriaIndividualDTO monitoriaIndividualDTO = new MonitoriaIndividualDTO(monitoriaIndividualLogic.updateMonitoriaIndividual(monitoriaIndividual.toEntity()));
        LOGGER.log(Level.INFO,"MonitoriaIndividualResource updateMonitoriaIndividual: output: {0}", monitoriaIndividualDTO);
        return monitoriaIndividualDTO;
    }
    
    @DELETE
    @Path("{monitoriaIndividualId: \\d+}")
    public void deleteMonitoriaIndividual(@PathParam("monitoriaIndividualId") Long monitoriaIndividualId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "MonitoriaIndividualResource deleteMonitoriaIndividual: input: {0}", monitoriaIndividualId);
        if (monitoriaIndividualLogic.findMonitoriaIndividual(monitoriaIndividualId) == null) {
            throw new WebApplicationException("El recurso /monitoriaIndividuals/" + monitoriaIndividualId + " no existe.", 404);
        }
        monitoriaIndividualLogic.deleteMonitoriaIndividual(monitoriaIndividualId);
        LOGGER.info("MonitoriaIndividualResource MonitoriaIndividualPrize: output: void");  
    }
    
    private List<MonitoriaIndividualDTO> listEntity2DTO(List<MonitoriaIndividualEntity> entityList) {
        List<MonitoriaIndividualDTO> list = new ArrayList<MonitoriaIndividualDTO>();
        for (MonitoriaIndividualEntity entity : entityList) {
            list.add(new MonitoriaIndividualDTO(entity));
        }
        return list;
    }
}