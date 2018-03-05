/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.UsuarioEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.UsuarioPersistence;
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
public class UsuarioLogic {
  //Constantes
    private static final Logger LOGGER = Logger.getLogger(UsuarioLogic.class.getName());
    //Atributos
    @Inject
    private UsuarioPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /**
     * Devuelve todos los usuarios que hay en la base de datos.
     * @return Lista de entidades de tipo usuarios.
     */
    public List<UsuarioEntity> getUsuarios() {
        LOGGER.info("Inicia proceso de consultar todos los usuarios");
        List<UsuarioEntity> usuarios = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los usuarios");
        return usuarios;
    }
    /**
     * Busca un usuario por ID
     * @param id El id del usuario a buscar
     * @return El usuario encontrado, null si no lo encuentra.
     */
    public UsuarioEntity getUsuario(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar ususario con id={0}", id);
        UsuarioEntity usuario = persistence.find(id);
        if (usuario == null) {
            LOGGER.log(Level.SEVERE, "El usuario con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar usuario"
                + " con id={0}", id);
        return usuario;
    }
    /**
     * Eliminar un Usuario
     * @param id El ID del usuario a eliminar
     */
    public void deleteUsuario(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar usuario con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar usuario con id={0}", id);
    }
    /**
     * Guardar un nuevo Usuario
     * @param entity La entidad de tipo Usuario del nuevo Usuario a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el nombre 
     */
    public UsuarioEntity createUsuario(UsuarioEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de un usuario");
        if (!validateNombreUsuario(entity.getNombre())|| !validateCedula(entity.getCedula())) {
            throw new BusinessLogicException("El nombre o cedula no pueden ser vacios");
        }
        if(persistence.find(entity.getId())!= null)
        {
            throw new BusinessLogicException("No pueden existir dos usuarios con el mismo id");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de usuario");
        return entity;
    }
    /**
     * Actualizar un usuario por ID
     * @param id El ID del usuario a actualizar
     * @param entity La entidad del usuario con los cambios deseados
     * @return La entidad del usuario luego de actualizarla
     * @throws BusinessLogicException Si el nombrecedula nulos o estaban vacios o se intento cambiar el id.
     */
    public UsuarioEntity updateUsuario(Long id, UsuarioEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar pse con id={0}", id);
        if (!validateNombreUsuario(entity.getNombre())||!validateCedula(entity.getCedula())) {
            throw new BusinessLogicException("El nombre o la cedula no pueden ser vacios");
        }
        if(id!= entity.getId())
        {
            throw new BusinessLogicException("No se puede cambiar el id del usuario");
        }
        UsuarioEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar reclamo con id={0}", entity.getId());
        return newEntity;
    }
    /**
     * Retorna true si el nombre del usuario es un string válido, false de lo contrario.
     * @param nombreCliente nombre del usuario
     * @return true si el nombre del usuario es un string válido, false de lo contrario.
     */
    private boolean validateNombreUsuario( String nombreCliente ){
        return (nombreCliente != null && !nombreCliente.isEmpty());
    }
    
     /**
     * Retorna true si el cedula es un string válido, false de lo contrario.
     * @param cedula cedula del usuario
     * @return true si el cedula es un string válido, false de lo contrario.
     */
    private boolean validateCedula( String cedula ){
        return ( cedula != null && !cedula.isEmpty());
    }
      
}
