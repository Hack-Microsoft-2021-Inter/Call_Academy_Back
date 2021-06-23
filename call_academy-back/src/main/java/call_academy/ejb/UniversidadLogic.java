/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.UniversidadEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.UniversidadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Juan Pablo
 */
@Stateless
public class UniversidadLogic {
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    @Inject
    private UniversidadPersistence persistence;
    
    //////////////////////////// MÉTODOS ////////////////////////////
    
    public UniversidadEntity createUniversidad(UniversidadEntity uni) throws BusinessLogicException {
        if (uni.getNombre() == null || uni.getNombre().isEmpty())
            throw new BusinessLogicException("El nombre está vacío");
        
        List<UniversidadEntity> findNombre = persistence.findByNombre(uni.getNombre());
        if (findNombre != null && !uniqueNombre(findNombre, uni.getNombre()))
            throw new BusinessLogicException("Una universidad con este nombre ya existe");
        
        uni = persistence.create(uni);
        return uni;
    }
    
    public List<UniversidadEntity> findAllUniversidad() {
        List<UniversidadEntity> resultado = persistence.findAll();
        return resultado;
    }
    
    public UniversidadEntity findUniversidad(Long id) {
        UniversidadEntity uni = persistence.find(id);
        return uni;
    }
    
    public List<UniversidadEntity> findUniversidadByNombre(String nombre) {
        List<UniversidadEntity> resultado = persistence.findByNombre(nombre);
        return resultado;
    }
    
    public UniversidadEntity updateUniversidad(UniversidadEntity uni) throws BusinessLogicException {
        if (uni.getNombre() == null || uni.getNombre().isEmpty())
            throw new BusinessLogicException("El nombre está vacío");
        
        List<UniversidadEntity> findNombre = persistence.findByNombre(uni.getNombre());
        if (findNombre != null && !uniqueNombre(findNombre, uni.getNombre()))
            throw new BusinessLogicException("Una universidad con este nombre ya existe");
        
        uni = persistence.update(uni);
        return uni;
    }
    
    public void deleteUniversidad(Long id) {
        persistence.delete(id);
    }
    
    private boolean uniqueNombre(List<UniversidadEntity> list, String nombre) {
        for (UniversidadEntity u : list) {
            if (u.getNombre().equals(nombre))
                return false;
        }
        return true;
    }
}
