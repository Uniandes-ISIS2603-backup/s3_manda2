/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.EmpleadoEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.EmpleadoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author n.bello
 */
@Stateless
public class EmpleadoLogic {
    //Constantes
    private static final Logger LOGGER = Logger.getLogger(EmpleadoLogic.class.getName());
    //Atributos
    @Inject
    private EmpleadoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /**
     * Devuelve todos los empleados que hay en la base de datos.
     * @return Lista de entidades de tipo empleados.
     */
    public List<EmpleadoEntity> getEmpleados() {
        LOGGER.info("Inicia proceso de consultar todos los usuarios");
        List<EmpleadoEntity> empleados = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los usuarios");
        return empleados;
    }
    /**
     * Busca un empleado por ID
     * @param id El id del empleado a buscar
     * @return El empleado encontrado, null si no lo encuentra.
     */
    public EmpleadoEntity getEmpleado(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar empleado con id={0}", id);
        EmpleadoEntity empleado = persistence.find(id);
        if (empleado == null) {
            LOGGER.log(Level.SEVERE, "El usuario con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar empleado"
                + " con id={0}", id);
        return empleado;
    }
    /**
     * Eliminar un empleado
     * @param id El ID del empleado a eliminar
     */
    public void deleteEmpleado(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar empleado con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar empleado con id={0}", id);
    }
    /**
     * Guardar un nuevo empleado
     * @param entity La entidad de tipo empleadoempleado del nuevo Usuario a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el nombre 
     */
    public EmpleadoEntity createEmpleado(EmpleadoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de un empleado");
        if (!validateNombreEmpleado(entity.getNombre())|| !validateCedula(entity.getCedula())) {
            throw new BusinessLogicException("El nombre o cedula no pueden ser vacios");
        }
        if(persistence.find(entity.getId())!= null)
        {
            throw new BusinessLogicException("No pueden existir dos empleado con el mismo id");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de empleado");
        return entity;
    }
    /**
     * Actualizar un empleado por ID
     * @param id El ID del empleado a actualizar
     * @param entity La entidad del empleado con los cambios deseados
     * @return La entidad del empleado luego de actualizarla
     * @throws BusinessLogicException Si el nombrecedula nulos o estaban vacios o se intento cambiar el id.
     */
    public EmpleadoEntity updateEmpleado(Long id, EmpleadoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar empleado con id={0}", id);
        if (!validateNombreEmpleado(entity.getNombre())||!validateCedula(entity.getCedula())) {
            throw new BusinessLogicException("El nombre o la cedula no pueden ser vacios");
        }
        if(id!= entity.getId())
        {
            throw new BusinessLogicException("No se puede cambiar el id del empleado");
        }
        EmpleadoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar pse con id={0}", entity.getId());
        return newEntity;
    }
    /**
     * Retorna true si el nombre del empleado es un string válido, false de lo contrario.
     * @param nombreCliente nombre del empleado
     * @return true si el nombre del empleado es un string válido, false de lo contrario.
     */
    private boolean validateNombreEmpleado( String nombreCliente ){
        return (nombreCliente != null && !nombreCliente.isEmpty());
    }
    
     /**
     * Retorna true si el cedula es un string válido, false de lo contrario.
     * @param cedula cedula del empleado
     * @return true si el cedula es un string válido, false de lo contrario.
     */
    private boolean validateCedula( String cedula ){
        return ( cedula != null && !cedula.isEmpty());
    }
    
}
