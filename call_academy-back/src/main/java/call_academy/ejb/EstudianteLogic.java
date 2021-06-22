/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package call_academy.ejb;

import call_academy.entities.EstudianteEntity;
import call_academy.entities.UniversidadEntity;
import call_academy.exceptions.BusinessLogicException;
import call_academy.persistence.EstudiantePersistence;
import call_academy.persistence.UniversidadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Juan Pablo
 */
@Stateless
public class EstudianteLogic {
    
    /////////////////////////// ATRIBUTOS ////////////////////////////
    
    @Inject
    private EstudiantePersistence persistence;
    
    @Inject
    private UniversidadPersistence universidadPersistence;
    
    //////////////////////////// MÉTODOS ////////////////////////////
    
    public EstudianteEntity createEstudiante(EstudianteEntity estudiante) throws BusinessLogicException {
        if (estudiante.getNombre() == null || estudiante.getNombre().isEmpty())
            throw new BusinessLogicException("El nombre está vacío");
        if (persistence.findByCorreo(estudiante.getCorreo()) != null)
            throw new BusinessLogicException("El correo ya existe.");
        
        estudiante = persistence.create(estudiante);
        return estudiante;
    }
    
    public List<EstudianteEntity> findAllEstudiante() {
        List<EstudianteEntity> resultado = persistence.findAll();
        return resultado;
    }
    
    public EstudianteEntity findEstudiante(Long id) {
        EstudianteEntity estudiante = persistence.find(id);
        return estudiante;
    }
    
    public List<EstudianteEntity> findEstudianteByNombre(String nombre) {
        List<EstudianteEntity> resultado = persistence.findByNombre(nombre);
        return resultado;
    }
    
    public EstudianteEntity updateEstudiante(EstudianteEntity estudiante) throws BusinessLogicException {
        if (estudiante.getNombre() == null || estudiante.getNombre().isEmpty())
            throw new BusinessLogicException("El nombre está vacío");
        if (persistence.findByCorreo(estudiante.getCorreo()) != null)
            throw new BusinessLogicException("El correo ya existe.");
        estudiante = persistence.update(estudiante);
        return estudiante;
    }
    
    public void deleteEstudiante(Long id) {
        persistence.delete(id);
    }
    
    public EstudianteEntity addUniversidad(Long idEstudiante, Long idUni) throws BusinessLogicException {        
        EstudianteEntity estudianteEntity = persistence.find(idEstudiante);
        UniversidadEntity uniEntity = universidadPersistence.find(idUni);
        
        if (uniEntity.getEstudiantes().contains(estudianteEntity))
            throw new BusinessLogicException("La universidad ya tiene el estudiante con ID = " + estudianteEntity.getId() + " registrado");
        
        estudianteEntity.setUniversidad(uniEntity);
        
        List<EstudianteEntity> ests = uniEntity.getEstudiantes();
        ests.add(estudianteEntity);
        uniEntity.setEstudiantes(ests);
        
        universidadPersistence.update(uniEntity);
        
        return persistence.update(estudianteEntity);
    }
    
    public void removeUniversidad(Long idEstudiante, Long idUni) {
        EstudianteEntity estudianteEntity = persistence.find(idEstudiante);
        UniversidadEntity uniEntity = universidadPersistence.find(idUni);
        
        List<EstudianteEntity> ests = uniEntity.getEstudiantes();
        ests.remove(estudianteEntity);
        uniEntity.setEstudiantes(ests);
        
        estudianteEntity.setUniversidad(null);
        
        persistence.update(estudianteEntity);
        universidadPersistence.update(uniEntity);
    }
}
