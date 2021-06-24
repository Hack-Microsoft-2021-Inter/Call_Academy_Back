/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.resources;

import call_academy.dtos.MonitoriaGrupalDTO;
import call_academy.ejb.MonitoriaGrupalLogic;
import call_academy.entities.MonitoriaGrupalEntity;
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
@Path("monitoriaGrupals")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MonitoriaGrupalResource{
    
    private static final Logger LOGGER = Logger.getLogger(MonitoriaGrupalResource.class.getName());
    
    @Inject 
    private MonitoriaGrupalLogic monitoriaGrupalLogic;
     
    @POST
    public MonitoriaGrupalDTO createMonitoriaGrupal(MonitoriaGrupalDTO monitoriaGrupal) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "newMonitoriaGrupalDTO createMonitoriaGrupal: input: {0}", monitoriaGrupal);
        MonitoriaGrupalDTO newMonitoriaGrupalDTO = new MonitoriaGrupalDTO(monitoriaGrupalLogic.createMonitoriaGrupal(monitoriaGrupal.toEntity()));
        LOGGER.log(Level.INFO, "newMonitoriaGrupalDTO createMonitoriaGrupal: output: {0}", newMonitoriaGrupalDTO);
        return newMonitoriaGrupalDTO;
    }
    
    @GET
    public List<MonitoriaGrupalDTO> getMonitoriaGrupals() {
        LOGGER.log(Level.INFO,"PrizeResource getMonitoriaGrupals: input: void");
        List<MonitoriaGrupalDTO> listaMonitoriaGrupals = listEntity2DTO(monitoriaGrupalLogic.findAllMonitoriaGrupal());
        LOGGER.log(Level.INFO, "PrizeResource getMonitoriaGrupals: output: {0}", listaMonitoriaGrupals);
        return listaMonitoriaGrupals;
    }
    
    @GET
    @Path("{monitoriaGrupalId: \\d+}")
    public MonitoriaGrupalDTO getMonitoriaGrupal(@PathParam("monitoriaGrupalId") Long monitoriaGrupalId) {
        LOGGER.log(Level.INFO,"MonitoriaGrupalResource getMonitoriaGrupal: input: {0}", monitoriaGrupalId);
        MonitoriaGrupalEntity monitoriaGrupalEntity = monitoriaGrupalLogic.findMonitoriaGrupal(monitoriaGrupalId);
        if(monitoriaGrupalEntity == null)
        {
            throw new WebApplicationException("El recurso /monitoriaGrupals/"+ monitoriaGrupalId +" no existe",404);
        }
        MonitoriaGrupalDTO monitoriaGrupalDTO= new MonitoriaGrupalDTO(monitoriaGrupalEntity);
        LOGGER.log(Level.INFO,"MonitoriaGrupalResource getMonitoriaGrupal: output: {0}", monitoriaGrupalDTO);
        return monitoriaGrupalDTO;
    }
    
    @PUT
    @Path("{monitoriaGrupalId: \\d+}")
    public MonitoriaGrupalDTO updateMonitoriaGrupal(@PathParam("monitoriaGrupalId") Long monitoriaGrupalId, MonitoriaGrupalDTO monitoriaGrupal) throws BusinessLogicException {
        LOGGER.log(Level.INFO,"MonitoriaGrupalResource updateMonitoriaGrupal: input: monitoriaGrupalId{0}, monitoriaGrupal{1}", new Object[]{monitoriaGrupalId, monitoriaGrupal});
        monitoriaGrupal.setId(monitoriaGrupalId);
        if(monitoriaGrupalLogic.findMonitoriaGrupal(monitoriaGrupalId) == null)
        {
            throw new WebApplicationException("El recurso /monitoriaGrupals/"+ monitoriaGrupalId +" no existe",404);
        }
        MonitoriaGrupalDTO monitoriaGrupalDTO = new MonitoriaGrupalDTO(monitoriaGrupalLogic.updateMonitoriaGrupal(monitoriaGrupal.toEntity()));
        LOGGER.log(Level.INFO,"MonitoriaGrupalResource updateMonitoriaGrupal: output: {0}", monitoriaGrupalDTO);
        return monitoriaGrupalDTO;
    }
    
    @DELETE
    @Path("{monitoriaGrupalId: \\d+}")
    public void deleteMonitoriaGrupal(@PathParam("monitoriaGrupalId") Long monitoriaGrupalId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "MonitoriaGrupalResource deleteMonitoriaGrupal: input: {0}", monitoriaGrupalId);
        if (monitoriaGrupalLogic.findMonitoriaGrupal(monitoriaGrupalId) == null) {
            throw new WebApplicationException("El recurso /monitoriaGrupals/" + monitoriaGrupalId + " no existe.", 404);
        }
        monitoriaGrupalLogic.deleteMonitoriaGrupal(monitoriaGrupalId);
        LOGGER.info("MonitoriaGrupalResource MonitoriaGrupalPrize: output: void");  
    }
    
    private List<MonitoriaGrupalDTO> listEntity2DTO(List<MonitoriaGrupalEntity> entityList) {
        List<MonitoriaGrupalDTO> list = new ArrayList<MonitoriaGrupalDTO>();
        for (MonitoriaGrupalEntity entity : entityList) {
            list.add(new MonitoriaGrupalDTO(entity));
        }
        return list;
    }
}
