/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.ejb;

import co.edu.uniandes.csw.manda2.entities.ClienteEntity;
import co.edu.uniandes.csw.manda2.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.manda2.persistence.ClientePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author na.caceres
 */
@Stateless
public class ClienteLogic {
    //Constantes
    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());
    //Atributos
    @Inject
    private ClientePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /**
     * Devuelve todos los clientes que hay en la base de datos.
     * @return Lista de entidades de tipo cliente.
     */
    public List<ClienteEntity> getClientes() {
        LOGGER.info("Inicia proceso de consultar todas los clientes");
        List<ClienteEntity> clientes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los clientes");
        return clientes;
    }
    /**
     * Busca un cliente por ID
     * @param id El id del cl  a buscar
     * @return El cliente encontrado, null si no lo encuentra.
     */
    public ClienteEntity getClienteCredito(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar cliente de credito con id={0}", id);
        ClienteEntity cliente = persistence.find(id);
        if (cliente == null) {
            LOGGER.log(Level.SEVERE, "La cliente con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar cliente con id={0}", id);
        return cliente;
    }
    /**
     * Eliminar una cliente
     * @param id El ID del cliente a eliminar
     */
    public void deleteCliente(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar cliente con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar cliente con id={0}", id);
    }
    /**
     * Guardar un nuevo cliente
     * @param entity La entidad de tipo cliente del nuevo cliente a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException Si el nombre o el link son nulos o estaban vacios. 
     */
    public ClienteEntity createCliente(ClienteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación del cliente");
        if (!validateNombreCliente(entity.getNombre())||!validateCedula(entity.getCedula())) {
            throw new BusinessLogicException("El nombre o la cedula no pueden ser vacios");
        }
        if(persistence.findByCedula(entity.getCedula())!= null)
        {
            throw new BusinessLogicException("No pueden existir dos clientes con la misma cedula");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación del cliente");
        return entity;
    }
    /**
     * Actualizar un cliente por ID
     * @param id El ID del cliente a actualizar
     * @param entity La entidad del cliente con los cambios deseados
     * @return La entidad del clienteluego de actualizarla
     * @throws BusinessLogicException Si el nombre o la cedula son nulos o estaban vacios, se intento cambiar el id o 
     *         la cedula que se iba a cambiar ya estaba en el sistema.
     */
    public ClienteEntity updateCliente(Long id, ClienteEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar cliente con id={0}", id);
        if (!validateNombreCliente(entity.getNombre())||!validateCedula(entity.getCedula())) {
            throw new BusinessLogicException("El nombre o la cedula no pueden ser vacios");
        }
        if(id!= entity.getId())
        {
            throw new BusinessLogicException("No se puede cambiar el id del cliente");
        }
        ClienteEntity clienteAntes = persistence.find(id);
        if(clienteAntes != null)
        {
            if(!clienteAntes.getCedula().equals(entity.getCedula()))
            {
                if(persistence.findByCedula(entity.getCedula())!= null)
                {
                    throw new BusinessLogicException("No se puede cambiar la cedula a una ya existente");
                }
            }
        }
        ClienteEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar cliente con id={0}", entity.getId());
        return newEntity;
    }
    /**
     * Retorna true si el nombre del cliente es un string válido, false de lo contrario.
     * @param nombreCliente nombre del cliente
     * @return true si el nombre del cliente es un string válido, false de lo contrario.
     */
    private boolean validateNombreCliente( String nombreCliente ){
        return (nombreCliente != null && !nombreCliente.isEmpty());
    }
    
     /**
     * Retorna true si la cedula del cliente es un string válido, false de lo contrario.
     * @param cedula cedula del cliente
     * @return true si la cedula del cliente es un string válido, false de lo contrario.
     */
    private boolean validateCedula( String cedula ){
        return ( cedula != null && !cedula.isEmpty());
    }
}
