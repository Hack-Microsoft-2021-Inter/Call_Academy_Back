/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.TagEntity;
import call_academy.exception.BusinessLogicException; 
import call_academy.persistence.TagPersistence; 
import java.until.List; 
import javax.ejb.Stateless; 
import javax.inject.Inject; 


/**
 *
 * @author juanj
 */
@Stateless
public class TagLogic {
    
    
    //////////////////////////////// Atrubutos ////////////////////////
    @Inject
    private TagPersistence persistence; 
    
  
    //////////////////////////////// Métodos ////////////////////////
    
    public TagEntity createTag(TagEntity tag) throws BusinessLogicException {
           if(tag.getNombre() == null || tag.getNombre().isEmpty())
               throw new BusinessLogicException("El nombre está vacío");
           
           List<TagEntity> findNombre = persistence.findByNombre(tag.getNombre()); 
           if(findNombre != null && !uniqueNombre(findNombre, tag.getNombre()))
               throw new BusinessLogicException("Ya existe un tag con este ombre");
                       
                       
            tag = persistence.create(tag); 
            return tag;      
    }
    

    public List<TagEntity> finAllTags(){ 
        List<TagEntity> resultado = persistence.findAll(); 
        return resultado; 
    }
    
    public TagEntity finTag(Long id) { 
        TagEntity tag = persistence.find(id); 
        return tag; 
    }
    

    public List<TagEntity> findTagByNombre (String nombre) { 
        List<TagEntity> resultado = persistence.findByNombre(nombre); 
        return resultado; 
    }
    
    
    public TagEntity updateTag(TagEntity tag) throws BusinessLogicException {
        if (tag.getNombre()== null || tag.getNombre().isEmpty())
            throw new BusinessLogicException("El nombre está vacío");
        
        List<TagEntity> findNombre = persistence.findByNombre(tag.getNombre());
        if(findNombre != null && !uniqueNombre(findNombre, tag.getNombre()))
            throw new BusinessLogicException("Un tag con este nombre ya existe");
        
        tag = persistence.update(tag); 
        return tag; 
        
                    
    } 


    public void deleteTag(Long id) { 
        persistence.delete(id);
    }
        
    private boolean uniqueNombre(List<TagEntitty>)List, String nombre) { 
        for(TagEntity t: list) { 
            if(t.getNombre().equals(nombre))
                return false; 
        }
        
        return true; 
    }
    