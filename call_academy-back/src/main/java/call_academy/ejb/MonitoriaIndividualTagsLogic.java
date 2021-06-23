/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.MonitoriaIndividualEntity;
import call_academy.entities.TagEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.MonitoriaIndividualPersistence;
import call_academy.persistence.TagPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaIndividualTagsLogic {
    
    private static final Logger LOGGER = Logger.getLogger(MonitoriaIndividualTagsLogic.class.getName());

    @Inject
    private MonitoriaIndividualPersistence monitoriaIndividualPersistence;

    @Inject
    private TagPersistence tagPersistence;

    public MonitoriaIndividualEntity addMonitoriaIndividualTag(Long tagsId, Long monitoriaIndividualId) throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle una monitoria Individual a tag con id = {0}", tagsId);
        
        TagEntity tagEntity = tagPersistence.find(tagsId);
        MonitoriaIndividualEntity monitoriaIndividualEntity = monitoriaIndividualPersistence.find(monitoriaIndividualId);
        
        if(tagEntity == null || monitoriaIndividualEntity == null){
            throw new BusinessLogicException("El monitoriaIndividualo o tag estan vacios");
        }
        
        tagEntity.getMonitorias().add(monitoriaIndividualEntity);
        monitoriaIndividualEntity.getTags().add(tagEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoriaIndividualo al tag con id = {0}", tagsId);
        return monitoriaIndividualEntity;
    }

    public TagEntity addTagMonitoriaIndividual(Long tagsId, Long monitoriaIndividualId) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle un monitoriaIndividualo al tag con id = {0}", tagsId);
        TagEntity tagEntity = tagPersistence.find(tagsId);
        MonitoriaIndividualEntity monitoriaIndividualEntity = monitoriaIndividualPersistence.find(monitoriaIndividualId);
        if(tagEntity == null || monitoriaIndividualEntity == null){
            throw new BusinessLogicException("El monitoriaIndividualo o tag estan vacios");
        }
        tagEntity.getMonitorias().add(monitoriaIndividualEntity);
        monitoriaIndividualEntity.getTags().add(tagEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoriaIndividualo al tag con id = {0}", tagsId);
        return tagEntity;
    }

    public List<TagEntity> getTags(Long monitoriaIndividualId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los tags del monitoriaIndividualo con id = {0}", monitoriaIndividualId);
        MonitoriaIndividualEntity monitoriaIndividual = monitoriaIndividualPersistence.find(monitoriaIndividualId);
        if (monitoriaIndividual == null){
            throw new BusinessLogicException("El monitoriaIndividualo no existe");
        }
        return monitoriaIndividual.getTags();
    }

    public TagEntity getTag(Long monitoriaIndividualId, Long tagId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el tag con id = {0} del monitoriaIndividualo con id = " + tagId, monitoriaIndividualId);
        List<TagEntity> tags = monitoriaIndividualPersistence.find(monitoriaIndividualId).getTags();
        TagEntity tagWanted = tagPersistence.find(tagId);
        int index = tags.indexOf(tagWanted);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el tag con id = {0} del monitoriaIndividualo con id = " + tagId, monitoriaIndividualId);
        if (index >= 0) {
            return tags.get(index);
        }
        throw new BusinessLogicException("El monitoriaIndividualo no está asociado al tag");
    }

    public List<TagEntity> replaceTags(Long monitoriaIndividualId, List<TagEntity> replace){
        LOGGER.log(Level.INFO, "Inicia proceso de remplazarlos tags del monitoriaIndividualo con id = {0}", monitoriaIndividualId);
        MonitoriaIndividualEntity monitoriaIndividual = monitoriaIndividualPersistence.find(monitoriaIndividualId);
        monitoriaIndividual.setTags(replace);
        LOGGER.log(Level.INFO, "Termina proceso de remplazarlos tags del monitoriaIndividualo con id = {0}", monitoriaIndividualId);
        return monitoriaIndividual.getTags();
        
    }

    public void removeMonitoriaIndividual(Long tagsId, Long monitoriaIndividualId) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un monitoriaIndividualo del tag con id = {0}", tagsId);
        TagEntity tagEntity = tagPersistence.find(tagsId);
        MonitoriaIndividualEntity monitoriaIndividualEntity = monitoriaIndividualPersistence.find(monitoriaIndividualId);

        if(tagEntity == null || monitoriaIndividualEntity == null){
            throw new BusinessLogicException("El servicio y el monitoriaIndividualo deben existir y tener un id valido");
        }

        tagEntity.getMonitorias().remove(monitoriaIndividualEntity);
        monitoriaIndividualEntity.getTags().remove(tagEntity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar un monitoriaIndividualo del tag con id = {0}", tagsId);
    }
}
