/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.resources;

import call_academy.dtos.MonitorDTO;
import call_academy.ejb.MonitorLogic;
import call_academy.entities.MonitorEntity;
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
@Path("monitores")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MonitorResource{
    
    private static final Logger LOGGER = Logger.getLogger(MonitorResource.class.getName());
    
    @Inject 
    private MonitorLogic monitorLogic;
     
    @POST
    public MonitorDTO createMonitor(MonitorDTO monitor) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "newMonitorDTO createMonitor: input: {0}", monitor);
        MonitorDTO newMonitorDTO = new MonitorDTO(monitorLogic.createMonitor(monitor.toEntity()));
        LOGGER.log(Level.INFO, "newMonitorDTO createMonitor: output: {0}", newMonitorDTO);
        return newMonitorDTO;
    }
    
    @GET
    public List<MonitorDTO> getMonitors() {
        LOGGER.log(Level.INFO,"PrizeResource getMonitors: input: void");
        List<MonitorDTO> listaMonitors = listEntity2DTO(monitorLogic.findAllMonitor());
        LOGGER.log(Level.INFO, "PrizeResource getMonitors: output: {0}", listaMonitors);
        return listaMonitors;
    }
    
    @GET
    @Path("{monitorId: \\d+}")
    public MonitorDTO getMonitor(@PathParam("monitorId") Long monitorId) {
        LOGGER.log(Level.INFO,"MonitorResource getMonitor: input: {0}", monitorId);
        MonitorEntity monitorEntity = monitorLogic.findMonitor(monitorId);
        if(monitorEntity == null)
        {
            throw new WebApplicationException("El recurso /monitors/"+ monitorId +" no existe",404);
        }
        MonitorDTO monitorDTO= new MonitorDTO(monitorEntity);
        LOGGER.log(Level.INFO,"MonitorResource getMonitor: output: {0}", monitorDTO);
        return monitorDTO;
    }
    
    @PUT
    @Path("{monitorId: \\d+}")
    public MonitorDTO updateMonitor(@PathParam("monitorId") Long monitorId, MonitorDTO monitor) throws BusinessLogicException {
        LOGGER.log(Level.INFO,"MonitorResource updateMonitor: input: monitorId{0}, monitor{1}", new Object[]{monitorId, monitor});
        monitor.setId(monitorId);
        if(monitorLogic.findMonitor(monitorId) == null)
        {
            throw new WebApplicationException("El recurso /monitors/"+ monitorId +" no existe",404);
        }
        MonitorDTO monitorDTO = new MonitorDTO(monitorLogic.updateMonitor(monitor.toEntity()));
        LOGGER.log(Level.INFO,"MonitorResource updateMonitor: output: {0}", monitorDTO);
        return monitorDTO;
    }
    
    @DELETE
    @Path("{monitorId: \\d+}")
    public void deleteMonitor(@PathParam("monitorId") Long monitorId)
    {
        LOGGER.log(Level.INFO, "MonitorResource deleteMonitor: input: {0}", monitorId);
        if (monitorLogic.findMonitor(monitorId) == null) {
            throw new WebApplicationException("El recurso /monitors/" + monitorId + " no existe.", 404);
        }
        monitorLogic.deleteMonitor(monitorId);
        LOGGER.info("MonitorResource MonitorPrize: output: void");  
    }
    
    private List<MonitorDTO> listEntity2DTO(List<MonitorEntity> entityList) {
        List<MonitorDTO> list = new ArrayList<MonitorDTO>();
        for (MonitorEntity entity : entityList) {
            list.add(new MonitorDTO(entity));
        }
        return list;
    }
}
