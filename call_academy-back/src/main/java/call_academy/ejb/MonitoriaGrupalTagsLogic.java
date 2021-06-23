/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.MonitoriaGrupalEntity;
import call_academy.entities.TagEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.MonitoriaGrupalPersistence;
import call_academy.persistence.TagPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Juan Charry Gavilan
 */
public class MonitoriaGrupalTagsLogic {
        
    private static final Logger LOGGER = Logger.getLogger(MonitoriaGrupalTagsLogic.class.getName());

    @Inject
    private MonitoriaGrupalPersistence monitoriaGrupalPersistence;

    @Inject
    private TagPersistence tagPersistence;

    public MonitoriaGrupalEntity addMonitoriaGrupalTag(Long tagsId, Long monitoriaGrupalId) throws BusinessLogicException{
        
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle una monitoria Individual a tag con id = {0}", tagsId);
        
        TagEntity tagEntity = tagPersistence.find(tagsId);
        MonitoriaGrupalEntity monitoriaGrupalEntity = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        
        if(tagEntity == null || monitoriaGrupalEntity == null){
            throw new BusinessLogicException("El monitoriaGrupalo o tag estan vacios");
        }
        
        tagEntity.getMonitorias().add(monitoriaGrupalEntity);
        monitoriaGrupalEntity.getTags().add(tagEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoriaGrupalo al tag con id = {0}", tagsId);
        return monitoriaGrupalEntity;
    }

    public TagEntity addTagMonitoriaGrupal(Long tagsId, Long monitoriaGrupalId) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de asociarle un monitoriaGrupalo al tag con id = {0}", tagsId);
        TagEntity tagEntity = tagPersistence.find(tagsId);
        MonitoriaGrupalEntity monitoriaGrupalEntity = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        if(tagEntity == null || monitoriaGrupalEntity == null){
            throw new BusinessLogicException("El monitoriaGrupalo o tag estan vacios");
        }
        tagEntity.getMonitorias().add(monitoriaGrupalEntity);
        monitoriaGrupalEntity.getTags().add(tagEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociarle un monitoriaGrupalo al tag con id = {0}", tagsId);
        return tagEntity;
    }

    public List<TagEntity> getTags(Long monitoriaGrupalId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los tags del monitoriaGrupalo con id = {0}", monitoriaGrupalId);
        MonitoriaGrupalEntity monitoriaGrupal = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        if (monitoriaGrupal == null){
            throw new BusinessLogicException("El monitoriaGrupalo no existe");
        }
        return monitoriaGrupal.getTags();
    }

    public TagEntity getTag(Long monitoriaGrupalId, Long tagId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el tag con id = {0} del monitoriaGrupalo con id = " + tagId, monitoriaGrupalId);
        List<TagEntity> tags = monitoriaGrupalPersistence.find(monitoriaGrupalId).getTags();
        TagEntity tagWanted = tagPersistence.find(tagId);
        int index = tags.indexOf(tagWanted);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el tag con id = {0} del monitoriaGrupalo con id = " + tagId, monitoriaGrupalId);
        if (index >= 0) {
            return tags.get(index);
        }
        throw new BusinessLogicException("El monitoriaGrupalo no está asociado al tag");
    }

    public List<TagEntity> replaceTags(Long monitoriaGrupalId, List<TagEntity> replace){
        LOGGER.log(Level.INFO, "Inicia proceso de remplazarlos tags del monitoriaGrupalo con id = {0}", monitoriaGrupalId);
        MonitoriaGrupalEntity monitoriaGrupal = monitoriaGrupalPersistence.find(monitoriaGrupalId);
        monitoriaGrupal.setTags(replace);
        LOGGER.log(Level.INFO, "Termina proceso de remplazarlos tags del monitoriaGrupalo con id = {0}", monitoriaGrupalId);
        return monitoriaGrupal.getTags();
        
    }

    public void removeMonitoriaGrupal(Long tagsId, Long monitoriaGrupalId) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un monitoriaGrupalo del tag con id = {0}", tagsId);
        TagEntity tagEntity = tagPersistence.find(tagsId);
        MonitoriaGrupalEntity monitoriaGrupalEntity = monitoriaGrupalPersistence.find(monitoriaGrupalId);

        if(tagEntity == null || monitoriaGrupalEntity == null){
            throw new BusinessLogicException("El servicio y el monitoriaGrupalo deben existir y tener un id valido");
        }

        tagEntity.getMonitorias().remove(monitoriaGrupalEntity);
        monitoriaGrupalEntity.getTags().remove(tagEntity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar un monitoriaGrupalo del tag con id = {0}", tagsId);
    }
}
