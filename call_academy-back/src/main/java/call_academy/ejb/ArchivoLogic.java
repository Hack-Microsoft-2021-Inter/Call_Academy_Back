/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.ArchivoEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.ArchivoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Julian Andrés
 */
@Stateless
public class ArchivoLogic {
    /////////////////// Atributos ///////////////////
    
    @Inject 
    private ArchivoPersistence persistence;
    
    /////////////////// Métodos ///////////////////
    
    public ArchivoEntity createArchivo(ArchivoEntity arch) throws BusinessLogicException{
        if(arch.getArchivo() == null || arch.getArchivo().isEmpty())
            throw new BusinessLogicException("El nombre está vacío");
        
        List<ArchivoEntity> findArchivo = persistence.findByArchivo(arch.getArchivo());
        if(findArchivo != null && !uniqueArchivo(findArchivo, arch.getArchivo()))
            throw new BusinessLogicException("Un archivo ya existe con este nombre");
        
        arch = persistence.create(arch);
        return arch;
    }
    
    public List<ArchivoEntity> findAllArchivos(){
        List<ArchivoEntity> resultado = persistence.findAll();
        return resultado; 
    }
    
    public ArchivoEntity findArchivo(Long id){
        ArchivoEntity arch = persistence.find(id);
        return arch; 
    }
    
    public List<ArchivoEntity> findArchivoByNombre(String archivo){
        List<ArchivoEntity> resultado = persistence.findByArchivo(archivo);
        return resultado; 
    }
    
    public ArchivoEntity updateArchivo(ArchivoEntity arch) throws BusinessLogicException{
        if(arch.getArchivo() == null || arch.getArchivo().isEmpty())
            throw new BusinessLogicException("El archivo está vacío");
        
        List<ArchivoEntity> findArchivo = persistence.findByArchivo(arch.getArchivo());
        if(findArchivo != null && !uniqueArchivo(findArchivo, arch.getArchivo()))
            throw new BusinessLogicException("Un archivo ya existe con este nombre");
        
        arch = persistence.update(arch);
        return arch;
        
    }
    
    public void deleteArchivo(Long id){
        persistence.delete(id);
    }
    
    private boolean uniqueArchivo(List<ArchivoEntity> list, String archivo){
        for(ArchivoEntity a : list){
            if(a.getArchivo().equals(archivo))
                return false;
        }
        return true; 
    }
}
